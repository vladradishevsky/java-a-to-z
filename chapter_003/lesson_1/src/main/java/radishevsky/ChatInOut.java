package radishevsky;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * ChatInOut осуществляет
 *
 * @author vladradishevsky
 * @since 02.01.2016
 * @version 1.1
 **/
public class ChatInOut {

    /**
     * Сканнер для входящего байтового потока
     */
    private final Scanner scanner;

    /**
     * RandomAccessFile для логирования сообщений и считывания ответов
     */
    private final RandomAccessFile log;
    private final RandomAccessFile answers;

    /**
     * Line separator for current OS
     */
    private final String SEPARATOR = System.getProperty("line.separator");

    /**
     * Конструктор
     * @throws Exception
     */
    public ChatInOut(InputStream input, File answers, File logs) throws Exception {

        this.scanner = new Scanner(input);
        this.answers = new RandomAccessFile(answers, "r");
        this.log = new RandomAccessFile(logs, "rw");

        int answersLength = getCountOfLinesInFile(this.answers);
        if (answersLength == 0) throw new Exception("File of answers is empty");
    }

    /**
     * Запрашивает сообщения у пользователя и записывает его в лог
     * @param question вопрос
     * @return ответ
     * @throws IOException
     */
    public String ask(String question) throws IOException {
        System.out.print(question);
        String message = this.scanner.nextLine();
        this.log.write((String.format("User: %s%s", message, this.SEPARATOR)).getBytes("UTF-8"));

        return message;
    }

    /**
     * Метод берет случайную строку из файла answers, записывает ее в лог и выводит на консоль
     * @throws IOException
     */
    public void answer() throws IOException {
        String message = this.getRandomStringFromAnswers();
        this.log.write((String.format("Bot: %s%s", message, this.SEPARATOR)).getBytes("UTF-8"));
        System.out.println(message);
    }

    /**
     * Возвращает слчаную строку из файла answers
     * @throws IOException
     */
    private String getRandomStringFromAnswers() throws IOException {

        String result = "";
        int randomInt = new Random().nextInt(9) + 1;

        for (int index = 0; index < randomInt; index++) {

            result = this.answers.readLine();
            if (result == null) {
                this.answers.seek(0L);
                result = this.answers.readLine();
            }
        }
        return result;
    }

    /**
     * Возвращает количетсов строк в файле
     * @throws IOException
     */
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
