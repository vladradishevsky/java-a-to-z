package radishevsky.server.start;
import radishevsky.server.*;
import radishevsky.server.actions.*;
import radishevsky.server.exceptions.ActionException;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.net.FileNameMap;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

import static java.lang.Integer.valueOf;

/**
 * Created by Vladislav on 06.01.2017.
 */
public class Server {

    private String SEPARATOR = System.lineSeparator();
    private /*final*/ FileManager manager;
    private final ArrayList<UserAction> menu = new ArrayList<UserAction>();
    private int port;
    private File rootDir;
    DataInputStream in;
    DataOutputStream out;

    public Server() throws IOException {

        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream("src\\main\\resources\\app.properties");

            properties.load(fis);
            this.port = valueOf(properties.getProperty("server.port"));
            String rootDirPath = properties.getProperty("server.rootDirectory");
            this.rootDir = new File(rootDirPath);

    }

    private void init() {
        fillMenu();
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            Socket socket = serverSocket.accept();
            // Ожидаем подключение пользователя
            System.out.println(String.format("Подключение состоялось: %s", socket.getInetAddress()));

            // Получаем in && out потоки
            InputStream socketInStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            this.in = new DataInputStream(socketInStream);
            this.out = new DataOutputStream(socketOutStream);

            this.manager = new SimpleFileManager(this.rootDir, socketInStream, socketOutStream);



            // Поздороваемся и отправим меню
            this.out.writeUTF("Привет клиент" + this.SEPARATOR + menu());
            this.out.flush();
            // Ждем ответа
            String receivedMessage;
            String[] receivedWords;
            StringBuilder sentMessage;
            boolean isCommandFounded;

            while (true) {
                receivedMessage = this.in.readUTF();
                receivedWords = receivedMessage.split(" ", 2);
                sentMessage = new StringBuilder();
                isCommandFounded = false;

                for (UserAction action : this.menu) {
                    if (action.command().equalsIgnoreCase(receivedWords[0])) {
                        try {
                            if (receivedWords.length > 1) {
                                action.execute(this.manager, receivedWords[1]);
                            } else {
                                action.execute(this.manager);
                            }
                            // Добавить случаи для загрузки и отправки файла !( крч тут надо переделывать

                            sentMessage.append(this.manager.toString());
                        } catch (ActionException ae) {
                            sentMessage.append(ae.getMessage()).append(this.SEPARATOR);
                        }
                        isCommandFounded = true;
                        break;
                    }
                }
                if (!isCommandFounded) {
                    sentMessage.append("Неизвестная команда").append(this.SEPARATOR);
                }
                this.out.writeUTF(sentMessage.toString());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private String menu() throws IOException {

        StringBuilder sb = new StringBuilder();
        for (UserAction action : this.menu) {
            sb.append(String.format("%s %s;%s", action.command(), action.info(), this.SEPARATOR));
        }

        return sb.toString();
    }

    private void fillMenu() {
        this.menu.add(new toRootDirectoryAction());
        this.menu.add(new changeDirectoryAction());
    }

    public static void main(String[] args) {

        try {
            Server server = new Server();
            server.init();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
