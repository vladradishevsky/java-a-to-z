package radishevsky;

import radishevsky.actions.Abs;
import radishevsky.actions.Cosinus;
import radishevsky.actions.Exponent;
import radishevsky.actions.Sinus;
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
     * Current Calculator.
     */
    private Calculator calculator;

    /**
     * Current Input.
     */
    private Input input;

    /**
     * Current PrintStream.
     */
    private PrintStream output;

    /**
     * Method create InteractCalc with current properties.
     * @return default InteractCalc.
     */
    public InteractCalc defaultProperties() {
        this.calculator = new Calculator();
        this.input = new ConsoleInput();
        this.output = System.out;

        return new InteractCalc(input, output, calculator);
    }

    /**
     * Method create InteractCalc with advanced properties (sin/cos/abs/exp).
     * @return default InteractCalc.
     */
    public InteractCalc advancedProperties() {

        InteractCalc calc = this.defaultProperties();
        calc.addAction(new Abs(this.input, this.calculator, "модуль"));
        calc.addAction(new Sinus(this.input, this.calculator, "синус"));
        calc.addAction(new Cosinus(this.input, this.calculator, "косинус"));
        calc.addAction(new Exponent(this.input, this.calculator, "экспонента"));

        return calc;
    }

    /**
     * Main method.
     * @param args - program args.
     */
    public static void main(String[] args) {
        new Start().advancedProperties().init();
    }
}
