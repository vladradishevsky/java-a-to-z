package radishevsky.client;

import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

/**
 * Created by Vladislav on 06.01.2017.
 */
public class Client {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src\\main\\resources\\app.properties");
            Properties properties = new Properties();
            properties.load(fis);
            String adress = properties.getProperty("client.host");
            int port = valueOf(properties.getProperty("client.port"));

            Socket socket = new Socket(adress, port);

            InputStream socketInStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStream);
            DataOutputStream out = new DataOutputStream(socketOutStream);

            String temp;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                temp = in.readUTF();
                System.out.print(temp);

                out.writeUTF(scanner.nextLine());
            }

            /*
            while ((temp = ) != null) {

            }*/



        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
