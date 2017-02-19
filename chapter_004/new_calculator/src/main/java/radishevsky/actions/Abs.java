package radishevsky.actions;

import radishevsky.Calculator;
import radishevsky.input.Input;

/**
 * class Abs for computing absolute value of number.
 * @author vladradishevsky
 * @since 19/02/2016
 * @version 1.0
 **/
public class Abs extends UserAction {

    /**
     * Default constructor.
     *
     * @param input      - Input to ask data from user.
     * @param calculator - Calculator which implements arithmetic operations.
     * @param info       - Name of this UserAction to display the main menu.
     */
    public Abs(Input input, Calculator calculator, String info) {
        super(input, calculator, info);
    }

    /**
     * Execute something in Calculator.
     *
     * @param params - arguments that may be required for the arithmetic operation.
     * @return - result of arithmetic operation.
     */
    @Override
    public double execute(double... params) {
        double param = super.getOneCorrectParam("число", params);
        this.getCalculator().setResult(Math.abs(param));
        return this.getCalculator().getResult();
    }
}
