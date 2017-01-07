package radishevsky.server.actions;

import radishevsky.server.FileManager;
import radishevsky.server.exceptions.ActionException;

import java.io.File;

/**
 * Created by Vladislav on 07.01.2017.
 */
public class changeDirectoryAction extends BaseAction {

    public changeDirectoryAction(String command, String info) {
        super(command, info);
    }
    public changeDirectoryAction() {
        super("to", "<имя папки> - переместиться в данную директорию, <..> - вернуться назад");
    }

    /**
     * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
     *
     * @param fileManager
     */
    @Override
    public void execute(FileManager fileManager, String... args) {
        File currentDir = fileManager.getCurrentDirectory();
        File[] currentDirList = currentDir.listFiles();

        if (args.length == 0) {
            throw new ActionException(this.command() + " " + this.info());
        }
        if (args[0].equalsIgnoreCase("..")
                && !currentDir.equals(fileManager.getRootDirectory())) {
            File ParentDir = currentDir.getParentFile();
            // temp
            System.out.println("Родитель: " + ParentDir.getPath());
            fileManager.setCurrentDirectory(ParentDir);
            return;
        }
        boolean isSuccessfully = false;
        for (File file : currentDirList) {
            System.out.println(String.format("Сравниваю: %s и %s", file.getName(), args[0]));
            if (file.getName().equals(args[0]) && file.isDirectory()) {
                fileManager.setCurrentDirectory(file);
                isSuccessfully = true;
                break;
            }
        }
        if (!isSuccessfully) {
            throw new ActionException("Нет такой папки");
        }
    }
}
