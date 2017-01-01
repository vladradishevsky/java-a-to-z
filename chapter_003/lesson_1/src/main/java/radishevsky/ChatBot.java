package radishevsky;

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
    Scanner answers;

    RandomMessenger() throws FileNotFoundException {
        this.scanner = new Scanner(System.in);
        // answers = new FileInputStream("D:\\answers.txt");
        this.answers = new Scanner(new File("D:\\answers.txt"));
        this.log = new FileOutputStream("D:\\log.txt");
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

    private String getRandomStringFromAnswers() {

        String result = "Check answers file, may be it's empty";

        int randomInt = 1 + Math.round((float)Math.random() * 9);

        System.out.println("randomInt: " + randomInt);
        // System.out.println("random int is " + randomInt);

        for (int index = 0; index < randomInt; index++) {
            if (this.answers.hasNext()) {
                result = this.answers.nextLine();
            } else {
                this.answers.reset();
            }
        }
        return result;
    }

}