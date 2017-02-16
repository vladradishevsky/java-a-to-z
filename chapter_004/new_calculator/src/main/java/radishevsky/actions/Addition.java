package radishevsky.actions;

import radishevsky.Calculator;
import radishevsky.input.Input;

/**
 * class Addition for implement addition of 2 numbers.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public class Addition extends UserAction {

    /**
     * Default constructor.
     * @param input - Input to ask data from user.
     * @param calculator - Calculator which implements arithmetic operations.
     * @param info - Name of this UserAction to display the main menu.
     */
    public Addition(final Input input, final Calculator calculator, final String info) {
        super(input, calculator, info);
    }

    /**
     * Execute addition of two numbers
     *
     * @param params arguments that may be required for the arithmetic operation
     */
    public double execute(double... params) {
        params = super.getTwoCorrectParams("первое слагаемое", "второе слагаемое", params);
        this.CALCULATOR.add(params[0], params[1]);
        return this.CALCULATOR.getResult();
    }

}
