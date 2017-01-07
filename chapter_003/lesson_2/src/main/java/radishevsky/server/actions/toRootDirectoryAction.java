package radishevsky.server.actions;

import radishevsky.server.FileManager;

/**
 * Created by Vladislav on 06.01.2017.
 */
public class toRootDirectoryAction extends BaseAction {

    /**
     * Конструкторы
     * @param command команда
     * @param info описание команды
     */
    public toRootDirectoryAction(String command, String info) {
        super(command, info);
    }
    public toRootDirectoryAction() {
        super("root", "переместиться в корневую директорию");
    }

    /**
     * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
     *
     * @param fileManager
     * param args
     */
    @Override
    public void execute(FileManager fileManager, String... args) {
        fileManager.setCurrentDirectory(fileManager.getRootDirectory());
    }
}
