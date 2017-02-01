package radishevsky.server;

import java.io.*;
import java.util.Properties;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Vlad Radishevsky
 * @since 1.02.2017
 * @version 1.1
 */
public class Server {

    /**
     * Серверный порт
     */
    private final int port;

    /**
     * Корневая директория
     */
    private final File rootDirectory;

    public Server() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\app.properties"));
        this.port = Integer.parseInt(properties.getProperty("server.port"));
        this.rootDirectory = new File (properties.getProperty("server.rootDirectory"));
    }

    /**
     * Запуск сервера
     */
    public void start() {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(this.port)) {

            socket = serverSocket.accept();
            System.out.println(String.format("Клиент %s подключился", socket.getInetAddress()));
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            ActionTracker actionTracker = new ActionTracker(socket, this.rootDirectory);
            actionTracker.welcome();
            String message;
            while (socket.isConnected()) {
                message = inputFromClient.readUTF();
                System.out.println(String.format("Сообщение от [%s]: %s", socket.getInetAddress(), message));
                actionTracker.exec(message);
            }
            System.out.println("Клиент отключился");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

}