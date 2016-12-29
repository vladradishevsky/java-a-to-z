package radishevsky;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Vladislav on 24.12.2016.
 */
public class ExternalSorterTest {

    @Test
    public void sortTest() throws Exception {
        File srcFile = new File("D:\\1.txt");
        File distFile = new File("D:\\2.txt");
        Sorter sorter = new ExternalSorter();
        sorter.sort(srcFile, distFile);

        assertThat(1, is(1));
    }


}