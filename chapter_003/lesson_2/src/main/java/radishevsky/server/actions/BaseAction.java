package radishevsky.server.actions;

import radishevsky.server.FileManager;
import radishevsky.server.UserAction;

/**
 * Created by Vladislav on 06.01.2017.
 */
public abstract class BaseAction implements UserAction {

    /**
     * Здесь содержится команда и ее опиание
     */
    private final String COMMAND;
    private final String INFO;

    public BaseAction(String command, String info) {
        this.COMMAND = command;
        this.INFO = info;
    }

    /**
     * Ключевое слово, по которому инициализируется выполнение данное действие
     **/
    @Override
    public String command() {
        return this.COMMAND;
    }

    /**
     * Информация о данном действии
     */
    @Override
    public String info() {
        return this.INFO;
    }

    /**
     * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
     * @param fileManager
     */
    @Override
    public abstract void execute(FileManager fileManager, String... args);
}
