package radishevsky;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for InteractCalc.
 * @author vladradishevsky
 * @since 17/02/2016
 * @version 1.0
 **/
public class InteractCalcTest {

    /**
     * Line separator.
     */
    private final String lineSeparator = System.lineSeparator();

    /**
     * Sequence of command to send.
     */
    private final ArrayList<String> commandSequence = new ArrayList<String>();

    /**
     * Check addition scenario.
     */
    @Test
    public void whenCheckAdditionThenReturnsCorrectResult() {

        this.commandSequence.clear();
        Collections.addAll(this.commandSequence, /*add*/"1", "5", "5", /*quit*/"5");
        String messages = String.join(this.lineSeparator, this.commandSequence);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(messages.getBytes());
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            System.setIn(bis);
            System.setOut(new PrintStream(bos, true));
            new Start().currentProperties().init();

            assertThat(bos.toString().contains("Результат: 10.0"), is(true));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Check subtraction scenario.
     */
    @Test
    public void whenCheckSubtractionThenReturnsCorrectResult() {

        this.commandSequence.clear();
        Collections.addAll(this.commandSequence, /*sub*/"2", "5.5", "5.5", /*quit*/"5");
        String messages = String.join(this.lineSeparator, this.commandSequence);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(messages.getBytes());
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            System.setIn(bis);
            System.setOut(new PrintStream(bos, true));
            new Start().currentProperties().init();

            assertThat(bos.toString().contains("Результат: 0.0"), is(true));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Check multiplication scenario.
     */
    @Test
    public void whenMultiplicationThenReturnsCorrectResult() {

        this.commandSequence.clear();
        Collections.addAll(this.commandSequence, /*mult*/"3", "5", "5", /*quit*/"5");
        String messages = String.join(this.lineSeparator, this.commandSequence);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(messages.getBytes());
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            System.setIn(bis);
            System.setOut(new PrintStream(bos, true));
            new Start().currentProperties().init();

            assertThat(bos.toString().contains("Результат: 25.0"), is(true));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Check division scenario.
     */
    @Test
    public void whenDivisionThenReturnsCorrectResult() {

        this.commandSequence.clear();
        Collections.addAll(this.commandSequence, /*div*/"4", "5", "5", /*quit*/"5");
        String messages = String.join(this.lineSeparator, this.commandSequence);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(messages.getBytes());
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            System.setIn(bis);
            System.setOut(new PrintStream(bos, true));
            new Start().currentProperties().init();

            assertThat(bos.toString().contains("Результат: 1.0"), is(true));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Check division by zero scenario.
     */
    @Test
    public void whenDivisionByZeroThenReturnsWarning() {

        this.commandSequence.clear();
        Collections.addAll(this.commandSequence, /*div*/"4", "10", /*div by 0*/"0", "5", /*quit*/"5");
        String messages = String.join(this.lineSeparator, this.commandSequence);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(messages.getBytes());
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            System.setIn(bis);
            System.setOut(new PrintStream(bos, true));
            new Start().currentProperties().init();
            boolean result = bos.toString().contains("Результат: 2.0")
                          && bos.toString().contains("Нельзя делить на нуль.");

            assertThat(result, is(true));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Check repeat addition scenario.
     */
    @Test
    public void whenRepeatedActionThenReturnsCorrectResult() {

        this.commandSequence.clear();
        Collections.addAll(this.commandSequence, /*add*/"1", "10", "10", /*repeat*/"0", "10", /*quit*/"5");
        String messages = String.join(this.lineSeparator, this.commandSequence);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(messages.getBytes());
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            System.setIn(bis);
            System.setOut(new PrintStream(bos, true));
            new Start().currentProperties().init();

            assertThat(bos.toString().contains("Результат: 30.0"), is(true));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}