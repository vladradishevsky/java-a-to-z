package radishevsky;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Vladislav on 02.01.2017.
 */
public class ChatInOutTest {

    @Test
    public void chatTest() throws Exception {

        String separator = System.getProperty("line.separator");

         File ans_file = new File("D:\\java-a-to-z\\chapter_003\\lesson_1\\src\\main\\resources\\equal_answers.txt");
         File log_file = new File("D:\\java-a-to-z\\chapter_003\\lesson_1\\src\\main\\resources\\log.txt");

        InputStream input = new ByteArrayInputStream(
                String.format("%s%s%s%s%s%s%s%s%s%s%s",
                        "123", separator,
                        "стоп", separator,
                        "456", separator,
                        "продолжить", separator,
                        "789", separator,
                        "закончить").getBytes()
        );

        ChatInOut chat = new ChatInOut(input, ans_file, log_file);
        ChatBot chatBot = new ChatBot(chat);
        chatBot.init();

        String[] expectedResult = new String[]{
                "User: 123",
                "Bot: ANSWER",
                "User: стоп",
                "User: 456",
                "User: продолжить",
                "Bot: ANSWER",
                "User: 789",
                "Bot: ANSWER",
                "User: закончить"
        };

        String[] currentResult = new String[9];

        try (Scanner scanner = new Scanner(log_file)) {

            for (int index = 0; index < currentResult.length; index++) {
                currentResult[index] = scanner.nextLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertThat(currentResult, is(expectedResult));
    }

}