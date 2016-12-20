package radishevsky;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class NumberChecker для проверки байтового потока
 * @author vladradishevsky
 * @since 21.12.2016
 * @version 1.0
 **/
public class NumberChecker {

    /**
     * Метод проверяет наличие четного числа в байтовом потоке
     * @param in InputStream
     * @return true если содержится четное число, иначе false
     */
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
}
