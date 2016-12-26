package radishevsky;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Vladislav on 23.12.2016.
 */
public interface Sorter {

    /**
     * Метод осуществляет сортировку исходного файла по возрастанию длин строк и помещает результат в конечный файл
     * @param source исходный файл
     * @param distance конечный файл
     */
    void sort(File source, File distance) throws IOException;
}
