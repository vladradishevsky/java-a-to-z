package radishevsky.server;

import java.io.*;
import java.net.Socket;

/**
 * Класс осуществляет управление директорией и основными командами
 *
 * @author Vlad Radishevsky
 * @since 1.02.2017
 * @version 1.1 fixed
 */
public class ActionTracker {

    /**
     * Сокет
     */
    protected Socket socket;

    /**
     * Корневой каталог
     */
    protected File rootDirectory;

    /**
     * Текущий каталог (по умолчанию - корневой)
     */
    protected File currentDirectory;

    /**
     * Массив пользовательских команд
     */
    protected UserAction[] actions;

    /**
     * Входной & выходной поток
     */
    DataOutputStream outputForClient;
    DataInputStream inputFromClient;

    public ActionTracker(Socket socket, File rootDirectory) throws IOException {
        this.socket = socket;
        this.rootDirectory = rootDirectory;
        this.currentDirectory = rootDirectory;
        this.outputForClient = new DataOutputStream(this.socket.getOutputStream());
        this.inputFromClient = new DataInputStream(this.socket.getInputStream());

        this.actions = new UserAction[] {
                new ActionTracker.showDirectory("show", "показать содержимое текущего каталога"),
                new ActionTracker.moveDirectory("to", "<name> для перещения в подкаталог, <..> - вернуться назад"),
                new ActionTracker.sendFileToClient("download", "<server_path> <client_path> - скачать файл с сервера"),
                new ActionTracker.receiveFileFromClient("upload", "<client_path> <server_path> - отправить файл на сервер"),
        };
    }

    /**
     * Приветствие подключившегося клиента
     * @throws IOException
     */
    public void welcome() throws IOException {
        StringBuilder message = new StringBuilder("Привет клиент. Список доступных команд:\n");
        for (UserAction action : this.actions) {
            message.append(String.format("%s %s\n", action.command(), action.info()));
        }

        this.outputForClient.writeUTF(message.toString());
    }

    /**
     * Найти пользовательскую команду по введенному сообщению и выполнить ее
     * @param message
     * @throws IOException
     */
    public void exec(String message) throws IOException {
        String[] args = message.split(" ");
        for (UserAction action : this.actions) {
            if (action.command().equalsIgnoreCase(args[0])) {
                action.execute(args);
                return;
            }
        }
        outputForClient.writeUTF(String.format("Неизвестная команда: %s", message));
    }

    /**
     * Класс, который осуществляет отображение текущей директории
     */
    private class showDirectory extends UserAction {

        protected showDirectory(String command, String info) {
            super(command, info);
        }

        /**
         * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
         */
        @Override
        void execute(String... args) throws IOException {
            StringBuilder message = new StringBuilder(String.format("Текущий каталог: %s\n", currentDirectory.getPath()));

            if (!currentDirectory.equals(rootDirectory)) {
                message.append("[назад] ..\n");
            }
            File[] list = currentDirectory.listFiles();
            if (list != null && list.length > 0) {
                for (File file : list) {
                    if (file.isFile()) {
                        message.append(String.format("[файл] %s\n", file.getName()));
                    } else if (file.isDirectory()) {
                        message.append(String.format("[папка] %s\n", file.getName()));
                    }
                }
            }

            outputForClient.writeUTF(message.toString());
        }
    }

    /**
     * Класс осуществляет навигацию между каталогами
     *  .. - возвращает радительский каталог (до корневого), <название папки> - возвращает подкаталог.
     */
    private class moveDirectory extends UserAction {

        protected moveDirectory(String command, String info) {
            super(command, info);
        }

        /**
         * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
         *
         * @param args
         */
        @Override
        void execute(String... args) throws IOException {
            String arg;
            try {
                arg = args[1]; // args[0] содержит в себе команду 'to'
            } catch (ArrayIndexOutOfBoundsException exc) {
                outputForClient.writeUTF(String.format(
                        "Введите:\n%s <имя папки> для перемещения в подкаталог, либо\n%s .. - вернуться назад",
                        super.command(), super.command())
                );
                return;
            }

            if (arg.equalsIgnoreCase("..")) {
                if (!currentDirectory.equals(rootDirectory)) {
                    currentDirectory = currentDirectory.getParentFile();
                }
            } else {
                currentDirectory = getChildDirectory(arg);
            }

            outputForClient.writeUTF(String.format("Текущий каталог: %s", currentDirectory.getPath()));
        }

        private File getChildDirectory(String name) {
            File result = currentDirectory;
            File[] list = currentDirectory.listFiles();
            if (list != null && list.length > 0) {
                for (File file : list) {
                    if (name.equalsIgnoreCase(file.getName()) && file.isDirectory()) {
                        result = file;
                    }
                }
            }

            return result;
        }
    }


    /**
     * Класс, который осуществляет передачу файла к клиенту от сервера
     */
    private class sendFileToClient extends UserAction {

        protected sendFileToClient(String command, String info) {
            super(command, info);
        }

        /**
         * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
         */
        @Override
        void execute(String... args) throws IOException {
            try {
                File file = getFileFromArg(args);
                //Ключевое сообщение OK, означающее отсутствие ошибки на сервере
                outputForClient.writeUTF("OK");
                try (InputStream fromFile = new FileInputStream(file);
                     ) {
                    outputForClient.writeLong(file.length());
                    byte[] byteBuffer = new byte[1024];
                    int readBytes;
                    while ((readBytes = fromFile.read(byteBuffer)) > 0) {
                        socket.getOutputStream().write(byteBuffer, 0, readBytes);
                        socket.getOutputStream().flush();
                    }
                    outputForClient.writeUTF(String.format("Файл %s успешно скачан", file.getName()));
                }

            } catch (Exception exc) {
                outputForClient.writeUTF(exc.getMessage());
            }

        }

        private File getFileFromArg(String... args) throws Exception {

                File result = new File(args[1]);

                if (result.isDirectory()) {
                    throw new Exception("Ошибка: выбран не файл, а каталог");
                } else if (!result.exists()) {
                    throw new Exception("Файл недоступен");
                } else if (!result.isAbsolute() || !result.canRead()) {
                    throw new Exception("Ошибка: введен не полный путь к файлу");
                } else if (args.length != 3) {
                    throw new Exception("Некорректное сообщение:");
                }

                return result;
        }
    }

    /**
     * Класс осуществляет передачу файла от клиента к серверу
     */
    private class receiveFileFromClient extends UserAction {

        protected receiveFileFromClient(String command, String info) {
            super(command, info);
        }

        /**
         * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
         *
         * @param args
         */
        @Override
        void execute(String... args) throws IOException {
            try {
                File file = new File(args[2]);
                if (!file.createNewFile()) {
                    throw new Exception(String.format("Файл %s не может быть создан", file.getPath()));
                }
                String message = inputFromClient.readUTF();
                if (message.equalsIgnoreCase("OK")) {

                    long fileLength = Long.parseLong(args[3]);
                    downloadFile(file, fileLength);
                    System.out.println(
                            String.format("Получен файл от [%s]: %s, размер %s байт",
                            socket.getInetAddress(),
                            file.getPath(),
                            file.length())
                    );
                } else {
                    System.out.println(
                            String.format("Ошибка у [%s]: %s", socket.getInetAddress(), message)
                    );
                }

            } catch (Exception exc) {
                outputForClient.writeUTF(exc.getMessage());
            }
        }

        /**
         * Скачать файл на сервер от клиента
         * @param file
         * @param fileLength
         * @throws IOException
         */
        private void downloadFile(File file, long fileLength) throws IOException {
            try (OutputStream toFile = new FileOutputStream(file)) {
                byte[] bufferArray = new byte[1024];
                int readBytes;
                while (fileLength > 0) {
                    readBytes = socket.getInputStream().read(bufferArray);
                    toFile.write(bufferArray, 0, readBytes);
                    toFile.flush();
                    fileLength -= readBytes;
                }
                outputForClient.writeUTF(String.format("Файл %s успешно передан", file.getName()));
            } catch (Exception exc) {
                outputForClient.writeUTF(exc.getMessage());
            }

        }
    }
}
