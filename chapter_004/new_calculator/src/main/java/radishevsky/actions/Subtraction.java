package radishevsky.actions;

import radishevsky.Calculator;
import radishevsky.input.Input;

/**
 * class Subtraction for implement subtraction of 2 numbers.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public class Subtraction extends UserAction {

    /**
     * Default constructor.
     * @param input - Input to ask data from user.
     * @param calculator - Calculator which implements arithmetic operations.
     * @param info - Name of this UserAction to display the main menu.
     */
    public Subtraction(final Input input, final Calculator calculator, final String info) {
        super(input, calculator, info);
    }

    /**
     * Execute subtraction in Calculator.
     * @param params - arguments that may be required for the arithmetic operation.
     * @return result of subtraction.
     */
    public double execute(double... params) {
        params = super.getTwoCorrectParams("уменьшаемое", "вычитаемое", params);
        this.getCalculator().subtract(params[0], params[1]);
        return this.getCalculator().getResult();
    }
}