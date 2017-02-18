package radishevsky;

import radishevsky.input.ConsoleInput;
import radishevsky.input.Input;
import java.io.PrintStream;

/**
 * Class for starting current program.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public class Start {

    /**
     * Method create InteractCalc with current properties.
     * @return default InteractCalc.
     */
    public InteractCalc currentProperties() {
        Calculator calculator = new Calculator();
        Input input = new ConsoleInput();
        PrintStream output = System.out;

        return new InteractCalc(input, output, calculator);
    }

    /**
     * Main method.
     * @param args - program args.
     */
    public static void main(String[] args) {
        new Start().currentProperties().init();
    }
}
