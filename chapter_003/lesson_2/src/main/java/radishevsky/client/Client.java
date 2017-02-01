package radishevsky.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;


/**
 * Клиент сетевого менеджера
 *
 * @author Vlad Radishevsky
 * @since 1.02.2017
 * @version 1.1
 */
public class Client {

    protected final String host;
    protected final int port;

    public Client() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\app.properties"));
        this.host = properties.getProperty("client.host");
        this.port = Integer.parseInt(properties.getProperty("client.port"));
    }

    public void start() {
        System.out.println(String.format("Подключение к серверу: %s:%s", this.host, this.port));
        try (Socket socket = new Socket(this.host, this.port);
             DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
             DataOutputStream outputForServer = new DataOutputStream(socket.getOutputStream());
             Scanner console = new Scanner(System.in))
        {
            String messageFromServer, messageToServer;
            String[] params;
            System.out.println(inputFromServer.readUTF());
            System.out.println("q - отключиться от сервера");
            while (socket.isConnected()) {
                messageToServer = console.nextLine();
                if (messageToServer.equalsIgnoreCase("q")) {
                    outputForServer.writeUTF("bye");
                    socket.close();
                    break;
                }
                params = messageToServer.split(" ");

                if (params[0].equals("download")) {
                    // Осуществить загрузку с сервера
                    outputForServer.writeUTF(messageToServer);//отправить команду на сервер
                    messageFromServer = inputFromServer.readUTF();//получить ответ от сервера

                    if (messageFromServer.equalsIgnoreCase("OK")) {
                        long fileLength = inputFromServer.readLong();
                        downloadFile(socket.getInputStream(), params[2], fileLength);
                        System.out.println(inputFromServer.readUTF());
                    } else {
                        System.out.println(messageFromServer);
                    }

                } else if (params[0].equals("upload")) {
                    // Осуществить отправку на сервер

                    try {
                        File file = new File(params[1]);
                        outputForServer.writeUTF(
                                String.format("%s %s %s %s", params[0], params[1], params[2], file.length())
                        );//отправить команду на сервер

                        outputForServer.writeUTF("OK");//write
                        outputForServer.flush();

                        uploadFile(socket.getOutputStream(), file);//write file
                        System.out.println(inputFromServer.readUTF());

                    } catch (Exception exc) {
                        outputForServer.writeUTF(exc.getMessage());
                        System.out.println(exc.getStackTrace());
                    }

                } else {
                    outputForServer.writeUTF(messageToServer);//отправить команду на сервер
                    messageFromServer = inputFromServer.readUTF();//получить ответ от сервера
                    System.out.println(messageFromServer);
                }

            }

        } catch (UnknownHostException e1) {
            System.out.println("Адрес хоста не может быть определен");
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    public void downloadFile(InputStream fromServer, String clientPath, long fileLength) {
        File file = new File(clientPath);
        try (FileOutputStream toFile = new FileOutputStream(file);
        ) {
            if (file.createNewFile()) {
                throw new IOException(String.format("Файл %s не был создан", clientPath));
            }
            byte[] byteBuffer = new byte[1024];
            int readBytes;
            while (fileLength > 0) {
                readBytes = fromServer.read(byteBuffer);
                toFile.write(byteBuffer, 0, readBytes);
                toFile.flush();
                fileLength -= readBytes;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void uploadFile(OutputStream toServer, File file) throws IOException {
        try (InputStream fromFile = new FileInputStream(file)) {
            byte[] bufferArray = new byte[1024];
            int readBytes;

            while ((readBytes = fromFile.read(bufferArray)) > 0) {
                toServer.write(bufferArray, 0, readBytes);
                toServer.flush();
            }

        }
    }


    public static void main(String[] args) {
        try {
            new Client().start();
        } catch (FileNotFoundException fnf) {
            System.out.println("Файл настроек app.properties не найден");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
