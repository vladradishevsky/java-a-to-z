package radishevsky;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Vladislav on 21.12.2016.
 */
public class NumberCheckerTest {

    @Test
    public void WhenEvenNumberThenReturnTrue() throws Exception {
        NumberChecker nc = new NumberChecker();
        String check = "22";
        byte[] byteArray = check.getBytes();

        boolean result = nc.isNumber(new ByteArrayInputStream(byteArray));
        assertThat(true, is(result));
    }

    @Test
    public void WhenOddNumberThenReturnFalse() throws Exception {
        NumberChecker nc = new NumberChecker();
        String check = "1";
        byte[] byteArray = check.getBytes();

        boolean result = nc.isNumber(new ByteArrayInputStream(byteArray));
        assertThat(false, is(result));
    }

    @Test
    public void WhenInputNotNumberThenReturnFalse() throws Exception {
        NumberChecker nc = new NumberChecker();
        String check = "Привет";
        byte[] byteArray = check.getBytes();

        boolean result = nc.isNumber(new ByteArrayInputStream(byteArray));
        assertThat(false, is(result));
    }
}