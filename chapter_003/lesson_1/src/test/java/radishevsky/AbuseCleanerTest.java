package radishevsky;

import java.io.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 22.12.2016.
 */
public class AbuseCleanerTest {
    final AbuseCleaner abuseCleaner = new AbuseCleaner();

    @Test
    public void whenOneWordNeedsToBeDeletedThenDelIt() throws Exception {

        String source = "Hello pig!", expect = "Hello !";
        String[] abuse = new String[]{"pig", "knave"};
        OutputStream out = new ByteArrayOutputStream();
        this.abuseCleaner.dropAbuses(new ByteArrayInputStream(source.getBytes()), out, abuse);

        assertThat(out.toString(), is(expect));
    }

    @Test
    public void whenAllWordsNeedsToBeDeletedThenDelThem() throws Exception {

        String source = "pigkurwaknave", expect = "";
        String[] abuse = new String[]{"pig", "knave", "kurwa"};
        OutputStream out = new ByteArrayOutputStream();
        this.abuseCleaner.dropAbuses(new ByteArrayInputStream(source.getBytes()), out, abuse);

        assertThat(out.toString(), is(expect));
    }

    @Test
    public void whenNoWordsNeedsToBeDeletedThenReturnSourceString() throws Exception {

        String source = "Hello world", expect = "Hello world";
        String[] abuse = new String[]{"pig", "knave", "kurwa"};
        OutputStream out = new ByteArrayOutputStream();
        this.abuseCleaner.dropAbuses(new ByteArrayInputStream(source.getBytes()), out, abuse);

        assertThat(out.toString(), is(expect));
    }

}