package radishevsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vladislav on 19.12.2016.
 */
public class BufReadExample  {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вводите символы, 'q' для выхода");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
