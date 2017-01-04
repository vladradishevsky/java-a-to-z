package radishevsky.client;

/**
 * interface Input
 *
 * @author vladradishevsky
 * @since 04.01.2017
 * @version 1.0
 **/
public interface Input {

    /**
     * Запросить у пользователя номер действие в меню
     * @param question вопрос
     * @return ответ
     */
    String ask(String question);

}
