package radishevsky.FileFilters;

import java.io.FileFilter;
import java.io.IOException;

/**
 * Класс Param для работы с параметрами поиска.
 *
 * @author Vlad Radishevsky
 * @since 15.02.2017
 * @version 1.0
 */
public class Param {

    /**
     * Возвращает объекты FileFilter в зависимост от ключевого слова.
     * 
     * @param key - ключ, в зависимости от которого метод вернет необходимый класс для поиска:
     *            -f FullMatch - поиск по полному совпадению;
     *            -m MaskFind - поиск по маске;
     *            -r RegexFind - поиск по регулярному выражению.
     * @param phrase - фраза для поиска.
     * @return объект наследник от FileFilter.
     * @throws IOException в слечае, если ключевое слово не подошло.
     */
    public FileFilter getFileFilter(String key, String phrase) throws IOException {
        switch (key) {
            case ("-f"): {
                return new FullMatch(phrase);
            }
            case ("-m"): {
                return new MaskFind(phrase);
            }
            case ("-r"): {
                return new RegexFind(phrase);
            }
            default:
                throw new IOException("Некорректный параметр поиска: используйте -f, -m или -r");
        }
    }
    
}
