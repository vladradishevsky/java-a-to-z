package radishevsky;

/**
 * ChatBot берет случайную фразу из текстового файла и выводит в ответ
 * Программа замолкает если пользователь вводит слово «стоп».
 * Если пользователь вводит слово «продолжить» , программа снова начинает отвечать.
 * При вводе слова «закончить» программа прекращает работу.
 * Запись диалога включая, слова-команды стоп/продолжить/закончить записать в текстовый лог
 *
 * @author vladradishevsky
 * @since 02.01.2016
 * @version 1.1
 **/
public class ChatBot {

    /**
     * Сообщения-команды для бота (использовать нижний регистр!)
     */
    private final String PAUSE_KEY = "стоп";
    private final String CONTINUE_KEY = "продолжить";
    private final String QUIT_KEY = "закончить";

    /**
     * Объект класса ChatInOut, который осществляет взаимодействие
     * с консолью и файлом лога и файлом с ответами
     */
    private final ChatInOut chat;

    /**
     * Default constructor
     */
    public ChatBot(ChatInOut chat) {
        this.chat = chat;
    }

    /**
     * Initialize program
     * @throws Exception
     */
    public void init() throws Exception {

        String message;
        boolean isPause = false, isQuit = false;
        do {
            message = this.chat.ask("Вы: ");
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
                        this.chat.answer();
                    }
                    break;
                }
            }

        } while (!isQuit);
    }
}