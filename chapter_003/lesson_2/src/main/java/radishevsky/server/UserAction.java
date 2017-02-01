package radishevsky.server;

import java.io.IOException;

/**
 * interface UserAction
 * @author vladradishevsky
 * @since 04.01.2017
 * @version 1.0
 */
public abstract class UserAction {

    private final String COMMAND;
    private final String INFO;

    protected UserAction(String command, String info) {
        this.COMMAND = command;
        this.INFO = info;
    }

    /**
     * Ключевое слово, по которому инициализируется выполнение данное действие
     **/
    public String command() {
        return this.COMMAND;
    }

    /**
     * Информация о данном действии
     */
    public String info() {
        return this.INFO;
    }

    /**
     * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
     **/
    abstract void execute(String... args) throws IOException;

}
