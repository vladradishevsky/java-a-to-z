package radishevsky;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Vladislav on 23.12.2016.
 */
public class ExternalSorter implements Sorter {

    private RandomAccessFile srcFile;
    private RandomAccessFile distFile;
    private RandomAccessFile firstTmpFile;
    private RandomAccessFile secondTmpFile;
    private long batch;
    private RandomAccessFile currentFile;

    /**
     * Метод осуществляет сортировку исходного файла по возрастанию длин строк и помещает результат в конечный файл
     *
     * @param source   исходный файл
     * @param distance конечный файл
     */
    @Override
    public void sort(File source, File distance) throws IOException {
            this.batch = 1L;
            this.srcFile = new RandomAccessFile(source, "r");
            this.distFile = new RandomAccessFile(distance, "rw");
            this.firstTmpFile = new RandomAccessFile(String.format("%s\\tmp1.txt", distance.getParent()), "rw");
            this.secondTmpFile = new RandomAccessFile(String.format("%s\\tmp2.txt", distance.getParent()), "rw");

            RandomAccessFile toSplit = this.srcFile;
            long srcLength = getLinesCountInSrcFile();

            while (this.batch <= srcLength) {
                // Разделяем исходный файл на 2 временных
                this.split(toSplit);
                // Отчищаем конечный файл перед заполнением
                this.distFile.setLength(0L);
                // Дальше вместо исходного файла будем разделять конечный
                if (toSplit == this.srcFile) toSplit = this.distFile;
                // Делаем слияние
                this.merge();
                // Увеличиваем размер серии в 2 раза
                this.batch *= 2;

                // System.out.println(this.batch);
            }

        this.distFile.writeBytes("Hello!");
    }

    private void split(RandomAccessFile fileToSplit) throws IOException {
        this.firstTmpFile.setLength(0L);
        this.secondTmpFile.setLength(0L);

        String currentStr = "";
        boolean isEndOfFile = false;
        this.currentFile = this.firstTmpFile;
        this.currentFile.seek(0L);

        while (!isEndOfFile) {
            for (long index = 0L; index < this.batch; index++) {
                currentStr = fileToSplit.readLine();
                isEndOfFile = (currentStr == null);
                if (isEndOfFile) break;
                this.currentFile.writeBytes(String.format("%s\n", currentStr));
            }
            this.currentFile = this.currentFile.equals(this.firstTmpFile) ? this.secondTmpFile : this.firstTmpFile;
        }

    }

    private void merge() throws IOException {

        this.firstTmpFile.seek(0L);
        this.secondTmpFile.seek(0L);
        String firstStr = this.firstTmpFile.readLine();
        String secondStr = this.secondTmpFile.readLine();
        boolean isFirstFileEnded = (firstStr == null);
        boolean isSecondFileEnded = (secondStr == null);
        long firstIndex = 0L, secondIndex = 0L;


        // Начало цикла
        while ((firstStr != null) || (secondStr != null)) {

                if ((secondStr == null) || (firstStr.length() < secondStr.length())) {
                    this.distFile.writeBytes(String.format("%s\n", firstStr));
                    firstIndex++;
                    if (firstIndex >= this.batch) {
                        firstStr = null;
                    } else if (firstStr != null) {
                        firstStr = this.firstTmpFile.readLine();
                        isFirstFileEnded = (firstStr == null);
                    }

                } else if ((firstStr == null || (firstStr.length() >= secondStr.length()))) {
                    this.distFile.writeBytes(String.format("%s\n", secondStr));
                    secondIndex++;
                    if (secondIndex >= this.batch) {
                        secondStr = null;
                    } else if (secondStr != null) {
                        secondStr = this.secondTmpFile.readLine();
                        isSecondFileEnded = (secondStr == null);
                    }
                }
        }

    }

    private long getLinesCountInSrcFile() throws IOException {
        long result = 0L;
        try {
            while (this.srcFile.readLine() != null) {
                result++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return result;
    }
}
