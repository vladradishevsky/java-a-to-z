package radishevsky.sock_examples.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Vladislav on 03.01.2017.
 */
public class Client {

    public static void main(String[] args) {
        int servPort = 5000;
        // Необходимо указать адрес замыкания
        String interAdress = "127.0.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(interAdress);
            System.out.println(String.format("Подключаемся к серверу: %s:%s", inetAddress, servPort));
            Socket socket = new Socket(inetAddress, servPort);

            // получить входной поток, заодно и выходной
            InputStream socketInStr = socket.getInputStream();
            OutputStream socketOutStr = socket.getOutputStream();

            // Конвертируем потоки в дрйго тип
            DataInputStream in = new DataInputStream(socketInStr);
            DataOutputStream out = new DataOutputStream(socketOutStr);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Строка, кот-ю будем передавать
            String string = null;
            System.out.println("Введите сообщение для передачи серверу: ");

            while (true) {
                string = reader.readLine();
                out.writeUTF(string);
                out.flush();
                // Будем ждать ответа от сервера
                string = in.readUTF(); // Ждем ответ от сервера

                System.out.println("Сервер прислал ответ: " + string);
                System.out.println("Введите следующее сообщение для отправки на сервер: ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
