package radishevsky.actions;

import radishevsky.Calculator;
import radishevsky.input.Input;

/**
 * class Multiplication for implement multiplication of 2 numbers.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public class Multiplication extends UserAction {

    /**
     * Default constructor.
     * @param input - Input to ask data from user.
     * @param calculator - Calculator which implements arithmetic operations.
     * @param info - Name of this UserAction to display the main menu.
     */
    public Multiplication(Input input, Calculator calculator, String info) {
        super(input, calculator, info);
    }

    /**
     * Execute multiplication in Calculator
     *
     * @param params - arguments that may be required for the arithmetic operation
     */
    public double execute(double... params) {
        params = super.getTwoCorrectParams("первый множитель", "второй множитель", params);
        this.CALCULATOR.multiple(params[0], params[1]);
        return this.CALCULATOR.getResult();
    }
}
