package radishevsky;

import org.omg.CORBA.UserException;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Vladislav on 02.01.2017.
 */
public class ChatBot {

    public static void main(String[] args) {

        try {
            new ChatBot().init();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Конец программы");
    }

    public void init() throws Exception {

        String message;
        RandomMessenger messenger = new RandomMessenger();
        boolean isPause = false, isQuit = false;
        do {
            message = messenger.ask("Вы: ");
            switch (message.toLowerCase()) {
                case "стоп": {
                    isPause = true;
                    break;
                }case "закончить": {
                    isQuit = true;
                    break;
                }case "продолжить": {
                    isPause = false;
                } default: {
                    if (!isPause) messenger.answer();
                    break;
                }
            }

        } while (!isQuit);
    }
}
class RandomMessenger {

    Scanner scanner;
    // FileInputStream answers;
    FileOutputStream log;
    RandomAccessFile answers;
    int answersLength;

    RandomMessenger() throws Exception {
        this.scanner = new Scanner(System.in);
        this.answers = new RandomAccessFile(new File("D:\\answers.txt"), "r");
        this.log = new FileOutputStream("D:\\log.txt");
        this.answersLength = getCountOfLinesInFile(this.answers);
        if (this.answersLength == 0) throw new Exception("File of answers is empty");
    }

    public String ask(String question) throws IOException {
        System.out.print(question);
        String message = this.scanner.nextLine();
        // log.write(message.getBytes("UTF-8"));
        this.log.write((String.format("[%s]User: %s\n", new Date(), message)).getBytes("UTF-8"));

        return message;
    }
    public void answer() throws UnsupportedEncodingException, IOException {
        String message = this.getRandomStringFromAnswers();
        this.log.write((String.format("[%s]Bot: %s\n", new Date(), message)).getBytes("UTF-8"));
        System.out.println(message);
    }

    private String getRandomStringFromAnswers() throws IOException {

        String result = "";
        int randomInt = 1 + Math.round((float)Math.random() * (this.answersLength - 1));

        System.out.println("randomInt: " + randomInt);
        // System.out.println("random int is " + randomInt);

        for (int index = 0; index < randomInt; index++) {

            result = this.answers.readLine();
            if (result == null) {
                this.answers.seek(0L);
                result = this.answers.readLine();
            }
        }
        return result;
    }

    private int getCountOfLinesInFile(RandomAccessFile randomAccessFile) throws IOException {
        int result = 0;
        try {
            while (randomAccessFile.readLine() != null) {
                result++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        randomAccessFile.seek(0L);
        return result;
    }
}