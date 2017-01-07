package radishevsky.sock_examples.server;

import java.io.*;
import java.net.*;
/**
 * Created by Vladislav on 03.01.2017.
 */
public class Server {

    public static void main(String[] args) {
        int port = 5000; // port: 1025 - 65535
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Ждем подключение к серверу");
            Socket socket = serverSocket.accept();
            System.out.println("Подключение состоялось");

            // получить входной поток, заодно и выходной
            InputStream socketInStr = socket.getInputStream();
            OutputStream socketOutStr = socket.getOutputStream();

            // Конвертируем потоки в дрйго тип
            DataInputStream in = new DataInputStream(socketInStr);
            DataOutputStream out = new DataOutputStream(socketOutStr);

            // Будем передавать текстовые сообщения
            String string = null;
            while (true) {
                string = in.readUTF(); // Ждет получения строки от клиента
                System.out.println("Мы получили следующее сообщение: " + string);
                // отправим его обратно
                System.out.println("Отправляем обратно");
                out.writeUTF(string);
                // Закроем поток
                out.flush();

            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
