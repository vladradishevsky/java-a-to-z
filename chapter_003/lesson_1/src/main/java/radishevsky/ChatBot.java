package radishevsky;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * ChatBot берет случайную фразу из текстового файла и выводит в ответ
 * Программа замолкает если пользователь вводит слово «стоп».
 * Если пользователь вводит слово «продолжить» , программа снова начинает отвечать.
 * При вводе слова «закончить» программа прекращает работу.
 * Запись диалога включая, слова-команды стоп/продолжить/закончить записать в текстовый лог
 *
 * @author vladradishevsky
 * @since 02.01.2016
 * @version 1.0
 **/
public class ChatBot {

    private final String PAUSE_KEY = "стоп";
    private final String CONTINUE_KEY = "продолжить";
    private final String QUIT_KEY = "закончить";

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
                case PAUSE_KEY: {
                    isPause = true;
                    break;
                }case QUIT_KEY: {
                    isQuit = true;
                    break;
                }case CONTINUE_KEY: {
                    isPause = false;
                } default: {
                    if (!isPause) {
                        messenger.answer();
                    }
                    break;
                }
            }

        } while (!isQuit);
    }
}
class RandomMessenger {

    private final String SEPARATOR = System.getProperty("line.separator");
    Scanner scanner;
    // тесты должны работать;
    FileOutputStream log;
    RandomAccessFile answers;
    int answersLength;

    /**
     * Конструктор по умолчанию
     * @throws Exception
     */
    RandomMessenger() throws Exception {
        this.scanner = new Scanner(System.in);
        ClassLoader cl = getClass().getClassLoader();

        File ans_file = new File(cl.getResource("answers.txt").getFile());
        File log_file = new File(cl.getResource("log.txt").getFile());

        this.answers = new RandomAccessFile(ans_file, "r");
        this.log = new FileOutputStream(log_file);

        this.answersLength = getCountOfLinesInFile(this.answers);
        if (this.answersLength == 0) throw new Exception("File of answers is empty");

    }

    public String ask(String question) throws IOException {
        System.out.print(question);
        String message = this.scanner.nextLine();
        // log.write(message.getBytes("UTF-8"));
        this.log.write((String.format("[%s]User: %s%s", new Date(), message, this.SEPARATOR)).getBytes("UTF-8"));

        return message;
    }
    public void answer() throws UnsupportedEncodingException, IOException {
        String message = this.getRandomStringFromAnswers();
        this.log.write((String.format("[%s]Bot: %s%s", new Date(), message, this.SEPARATOR)).getBytes("UTF-8"));
        System.out.println(message);
    }

    private String getRandomStringFromAnswers() throws IOException {

        String result = "";
        int randomInt = new Random().nextInt(9) + 1;
        //System.out.println("randomInt: " + randomInt);

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