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

    @Test
    public void firstTest() throws Exception {
        File srcFile = new File("D:\\1.txt");
        File distFile = new File("D:\\2.txt");
        String temp;
        RandomAccessFile src = new RandomAccessFile(srcFile, "rw");
        RandomAccessFile dist = new RandomAccessFile(distFile, "rw");

        dist.writeBytes(String.format("%s\n", src.readLine()));
        dist.writeBytes(String.format("%s\n", src.readLine()));
        dist.writeBytes(String.format("%s\n", src.readLine()));

        assertThat(1, is(1));
    }

}