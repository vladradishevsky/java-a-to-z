package radishevsky;

import java.io.*;

/**
 * Class AbuseCleaner для удаления запрещенных слов
 * @author vladradishevsky
 * @since 22.12.2016
 * @version 1.0
 **/
public class AbuseCleaner {

    /**
     * Метод удаляет из потока InputStream in все слова из abuse и записывает его в OutputStream out
     * @param in входной поток
     * @param out выходной поток
     * @param abuse запрещенные слова
     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out)))
        {
            String text;
            while ((text = br.readLine()) != null) {
                for (String word : abuse) {
                    text = text.replaceAll(word, "");
                }
                bw.write(text);
            }
            bw.flush();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
