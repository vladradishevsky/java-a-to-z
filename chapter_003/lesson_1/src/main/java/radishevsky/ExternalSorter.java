package radishevsky;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ExternalSorter предназначен для сортировки файлов по возрастанию
 * длины строки. Используется внешняя сортировка слиянием
 * @author vladradishevsky
 * @since 29.12.2016
 * @version 1.0
 */
public class ExternalSorter implements Sorter {
    /**
     * Длина серий. Серия (упорядоченный отрезок) – это последовательность элементов,
     * которая упорядочена по ключу (в данном слкчае по возрастанию длины строк).
     */
    private long batch;

    /**
     * Метод осуществляет сортировку исходного файла по возрастанию длин строк и помещает результат в конечный файл
     * @param source   исходный файл
     * @param distance конечный файл
     */
    @Override
    public void sort(File source, File distance) throws IOException {

    try {
            File first = new File(String.format("%s\\temp_file_1.txt", distance.getParent()));
            File second = new File(String.format("%s\\temp_file_2.txt", distance.getParent()));

            try (RandomAccessFile srcFile = new RandomAccessFile(source, "r");
                 RandomAccessFile distFile = new RandomAccessFile(distance, "rw");
                 RandomAccessFile firstTmpFile = new RandomAccessFile(first, "rw");
                 RandomAccessFile secondTmpFile = new RandomAccessFile(second, "rw"))
            {

                this.batch = 1L;
                RandomAccessFile toSplit = srcFile;
                long srcLength = getCountOfLinesInFile(srcFile);

                while (this.batch <= srcLength) {
                    // Разделяем исходный файл на 2 временных
                    toSplit.seek(0L);
                    this.split(toSplit, firstTmpFile, secondTmpFile);
                    // Отчищаем конечный файл перед заполнением
                    distFile.setLength(0L);
                    // Дальше вместо исходного файла будем разделять конечный
                    if (toSplit == srcFile) toSplit = distFile;
                    // Делаем слияние
                    this.merge(firstTmpFile, secondTmpFile, distFile);
                    // Увеличиваем размер серии в 2 раза
                    this.batch *= 2;
                }

            } catch (IOException ioExc) {
                ioExc.printStackTrace();

            } finally {
                first.deleteOnExit();
                second.deleteOnExit();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    /**
     *  Метод разбивает исходный файл на 2 вспомогательных файла по упорядоченным сериям
     * @param fileToSplit исходный файл
     * @param fileFirstDist первый вспомогательный файл
     * @param fileSecondDist второй вспомогательный файл
     * @throws IOException
     */
    private void split(RandomAccessFile fileToSplit, RandomAccessFile fileFirstDist, RandomAccessFile fileSecondDist) throws IOException {

        RandomAccessFile currentFile;
        fileFirstDist.setLength(0L);
        fileSecondDist.setLength(0L);

        String currentStr;
        boolean isEndOfFile = false;
        currentFile = fileFirstDist;
        currentFile.seek(0L);

        while (!isEndOfFile) {
            for (long index = 0L; index < this.batch; index++) {
                currentStr = fileToSplit.readLine();
                isEndOfFile = (currentStr == null);
                if (isEndOfFile) break;
                currentFile.writeBytes(String.format("%s\n", currentStr));
            }
            currentFile = currentFile.equals(fileFirstDist) ? fileSecondDist : fileFirstDist;
        }

    }

    /**
     * Метод производит слияние двух вспомогательный файла в один методом слияния серий
     * @param firstPart первый вспомогательный файл
     * @param secondPart второй вспомогательный файл
     * @param distFile конечный файл
     * @throws IOException
     */
    private void merge(RandomAccessFile firstPart, RandomAccessFile secondPart, RandomAccessFile distFile) throws IOException {

        firstPart.seek(0L);
        secondPart.seek(0L);
        String firstStr = firstPart.readLine();
        String secondStr = secondPart.readLine();

        long firstIndex = 0L, secondIndex = 0L;


        // Начало цикла (переписать)
        while ((firstStr != null) || (secondStr != null)) {

            if (firstIndex >= this.batch && secondIndex >= this.batch) {
                firstIndex = 0L;
                secondIndex = 0L;
            }

            if (secondStr == null) {
                distFile.writeBytes(String.format("%s\n", firstStr));
                firstIndex++;
                firstStr = firstPart.readLine();

            } else if (firstStr == null) {
                distFile.writeBytes(String.format("%s\n", secondStr));
                secondIndex++;
                secondStr = secondPart.readLine();

            } else if (secondIndex >= this.batch) {
                distFile.writeBytes(String.format("%s\n", firstStr));
                firstIndex++;
                firstStr = firstPart.readLine();

            } else if (firstIndex >= this.batch) {
                distFile.writeBytes(String.format("%s\n", secondStr));
                secondIndex++;
                secondStr = secondPart.readLine();

            } else {

                if (firstStr.length() < secondStr.length()) {
                    distFile.writeBytes(String.format("%s\n", firstStr));
                    firstIndex++;
                    firstStr = firstPart.readLine();

                } else {
                    distFile.writeBytes(String.format("%s\n", secondStr));
                    secondIndex++;
                    secondStr = secondPart.readLine();
                }
            }
        }

    }

    /**
     * Возврашает количество строк в файле
     * @param randomAccessFile исходный файл
     * @return кол-во строк
     * @throws IOException
     */
    private long getCountOfLinesInFile(RandomAccessFile randomAccessFile) throws IOException {
        long result = 0L;
        try {
            while (randomAccessFile.readLine() != null) {
                result++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        randomAccessFile.seek(0L);
        return result;
    }
}