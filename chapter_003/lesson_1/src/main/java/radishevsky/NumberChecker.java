package radishevsky;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Vladislav on 19.12.2016.
 */
public class NumberChecker {


    public boolean isNumber(InputStream in) {
        boolean result = false;
        try(ByteArrayOutputStream message = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                message.write(buffer, 0, length);
            }
            try {
                int number = Integer.parseInt(message.toString("UTF-8"));
                result = (number % 2 == 0);
            } catch (NumberFormatException nfe) {
                System.out.println("It's not a number");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        return result;
    }

    /*
    public static void main(String[] args) throws IOException {
        InputStream in = new ByteArrayInputStream("10".getBytes());
        System.out.println(isNumber(in));
    }
    */
}
