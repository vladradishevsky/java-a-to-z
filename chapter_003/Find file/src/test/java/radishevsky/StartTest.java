package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.*;
import java.util.Scanner;


/**
 * Класс для тестирования программы Find file
 *
 * @author Vlad Radishevsky
 * @since 09.02.2017
 * @version 1.0
 */
public class StartTest {

    private final String LN = System.lineSeparator();

    @Test
    public void whenArgsAreIncorrectThenReturnsWarning() {

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            Start.main(new String[]{"123", "456", "789"});
            String answer = out.toString();

            assertThat(answer, is("Неверно указаны аргументы. Смотрите help:" + this.LN));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenArgsAreNullThenReturnsWarning() {

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            Start.main(null);
            String answer = out.toString();

            assertThat(answer, is("Неверно указаны аргументы. Смотрите help:" + this.LN));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenFullMatchThenReturnsCorrectResult() throws IOException {

        File fileToFind = new File("D:\\test\\current_file.txt");
        fileToFind.createNewFile();
        fileToFind.deleteOnExit();

        Start.main(new String[]
                {"-d", fileToFind.getParentFile().getPath(), "-n", "current_file.txt", "-f", "-o", "log_full.txt"});

        File logFile = new File(String.format("%s/log_full.txt", fileToFind.getParentFile().getPath()));
        logFile.deleteOnExit();
        Scanner log = new Scanner(logFile);

        log.nextLine();
        assertThat(log.nextLine(), is(fileToFind.getPath()));
        log.close();

    }

    @Test
    public void whenMaskFindThenReturnsCorrectResult() throws IOException {

        File fileToFind = new File("D:\\test\\current_file.txt");
        fileToFind.createNewFile();
        fileToFind.deleteOnExit();

        Start.main(new String[]
                {"-d", fileToFind.getParentFile().getPath(), "-n", ".txt", "-m", "-o", "log_mask.txt"});

        File logFile = new File(String.format("%s/log_mask.txt", fileToFind.getParentFile().getPath()));
        logFile.deleteOnExit();
        Scanner log = new Scanner(logFile);

        log.nextLine();
        assertThat(log.nextLine(), is(fileToFind.getPath()));
        log.close();

    }

    @Test
    public void whenRegexFindThenReturnsCorrectResult() throws IOException {

        File fileToFind = new File("D:\\test\\current_file.txt");
        fileToFind.createNewFile();
        fileToFind.deleteOnExit();

        Start.main(new String[]
                {"-d", fileToFind.getParentFile().getPath(), "-n", "([^\\s]+(\\.(?i)(txt))$)", "-r", "-o", "log_regex.txt"});

        File logFile = new File(String.format("%s/log_regex.txt", fileToFind.getParentFile().getPath()));
        logFile.deleteOnExit();
        Scanner log = new Scanner(logFile);

        log.nextLine();
        assertThat(log.nextLine(), is(fileToFind.getPath()));
        log.close();

    }
}