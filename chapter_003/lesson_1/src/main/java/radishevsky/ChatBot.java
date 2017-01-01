package radishevsky;

import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Created by Vladislav on 02.01.2017.
 */
public class ChatBot {

    public static void main(String[] args) {
        new ChatBot().init();
        System.out.println("Конец программы");
    }

    public void init() {

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
    Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    public void answer() {
        System.out.println("Ответ");
    }
}