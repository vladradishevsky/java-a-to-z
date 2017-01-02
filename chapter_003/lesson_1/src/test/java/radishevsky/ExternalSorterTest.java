package radishevsky;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Vladislav on 24.12.2016.
 */
public class ExternalSorterTest {

    @Test
    public void sortTest() throws Exception {

        File srcFile = new File("D:\\java-a-to-z\\chapter_003\\lesson_1\\src\\main\\resources\\beforeSorting.txt");
        File distFile = new File("D:\\java-a-to-z\\chapter_003\\lesson_1\\src\\main\\resources\\afterSorting.txt");

        Sorter sorter = new ExternalSorter();
        sorter.sort(srcFile, distFile);

        String[] expectedResult = new String[]{"1" , "1", "12", "12", "123", "12345"};
        String[] currentResult = new String[6];

        Scanner sc = new Scanner(distFile);
        for (int index = 0; index < currentResult.length; index++) {
            currentResult[index] = sc.nextLine();
        }

        assertThat(currentResult, is(expectedResult));
    }


}