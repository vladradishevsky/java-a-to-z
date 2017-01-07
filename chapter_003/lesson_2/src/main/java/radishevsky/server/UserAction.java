package radishevsky.server;

/**
 * interface UserAction
 * @author vladradishevsky
 * @since 04.01.2017
 * @version 1.0
 */
public interface UserAction {

    /**
     * Ключевое слово, по которому инициализируется выполнение данное действие
     **/
    String command();

    /**
     * Информация о данном действии
     */
    String info();

    /**
     * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
     **/
    void execute(FileManager fileManager, String... args);

}
