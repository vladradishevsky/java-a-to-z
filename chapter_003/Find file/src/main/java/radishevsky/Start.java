package radishevsky;

import radishevsky.FileFilters.FullMatch;
import radishevsky.FileFilters.MaskFind;
import radishevsky.FileFilters.Param;
import radishevsky.FileFilters.RegexFind;
import java.io.*;
import java.util.Date;

/**
 * Программа для поиска файлов
 *
 * @author Vlad Radishevsky
 * @since 08.02.2017
 * @version 1.0fix
 */
public class Start {

    /**
     * line Separator
     */
    public static final String LN = System.lineSeparator();

    /**
     * Сообщение-инструкция для вывода при ошибке или некорректных параметрах
     */
    public static final String[] helpMessage =
            {"Для запуска программы поиска файла используйте выражение:",
            "java -jar find.jar -d <path_where_find> -n <text> <-f|-m|-r> -o <log_file>, где",
            "<path_where_find> - путь до папки, где осуществлять поиск",
            "<text> - фраза для поиска: имя файла, маска или регулярное выражение",
            "<-f> - искать по полному совпадению имени, включая формат (напр: 123.txt)",
            "<-m> - искать по маске (конец имени) (напр: .txt)",
            "<-r> - искать по регулярному выражению (документация http://darkraha.com/rus/dic/regexp.php)",
            "<log_filename> - имя файла, для сохранения результата поиска (в одной папке с find.jar)"
            };

    /**
     * Директория для поиска
     */
    private final File DIR;

    /**
     * Ключевое слово для поиска
     */
    private final String KEY_WORD;

    /**
     * Выходной поток для записи результатов работы
     */
    private final FileWriter LOG;

    /**
     * Используемый File Filter
     */
    private final FileFilter FILTER;

    /**
     * Конструктор
     */
    public Start(String[] args) throws IOException, IllegalArgumentException {
        if (!isValidArgs(args)) {
            if (args != null && args.length == 1 && args[0].equals("help")) {
                StringBuilder sb = new StringBuilder();
                for (String text : helpMessage) {
                    sb.append(text);
                    sb.append(LN);
                }
                throw new IllegalArgumentException(sb.toString());
            } else {
                throw new IllegalArgumentException("Неверно указаны аргументы. Смотрите help:");
            }
        }

        this.DIR = new File(args[1]);
        this.KEY_WORD = args[3];
        File logFile = new File(String.format("%s/%s", this.DIR.getPath(), args[6]));

        this.LOG = new FileWriter(logFile, true);

        this.FILTER = new Param().getFileFilter(args[4], args[3]);
    }

    /**
     * Инициализирует рекурсивный поиск файлов и записывает в лог
     */
    public void run() throws IOException {
        this.LOG.write(String.format(
                "[%s] Поиск файлов по %s с %s в папке %s%s",
                new Date(), this.FILTER, this.KEY_WORD, this.DIR, LN
        ));

        this.recursionFind(this.DIR);
        this.LOG.write(LN);
        this.LOG.flush();
        this.LOG.close();
        System.out.println("Поиск выполнен");
    }

    /**
     * Ищет файлы и записывает результат в лог
     * (рекурсивный метод)
     */
    public void recursionFind(File currDir) throws IOException {

        File[] list = currDir.listFiles(this.FILTER);
        if (list != null && list.length > 0) {
            for (File file : list) {
                this.LOG.write(file.getPath().concat(LN));
            }
        }
        File[] result = currDir.listFiles();
        if (result != null && result.length > 0) {
            for (File file : result) {
                if (file.isDirectory()) {
                    this.recursionFind(file);
                }
            }
        }
    }

    /**
     * Проверяет корректность аргументов программы перед исполнением
     */
    private static boolean isValidArgs(String[] args) {
        boolean result = false;
        if (args != null && args.length == 7) {
            File temp = new File(args[1]);

            result = args[0].equals("-d")
                    && (temp.exists())
                    && args[2].equals("-n")
                    && (args[3].length() > 0)
                    && (args[4].equals("-f") || args[4].equals("-m") || args[4].equals("-r"))
                    && args[5].equals("-o")
                    && (args[6].length() > 0);
            temp.delete();
        }

        return result;
    }

    /**
     * Точка входа
     */
    public static void main(String[] args) {
        try {
            new Start(args).run();

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
