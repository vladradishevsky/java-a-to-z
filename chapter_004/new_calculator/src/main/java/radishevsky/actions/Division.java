package radishevsky.actions;

import radishevsky.Calculator;
import radishevsky.input.Input;

/**
 * class Division for implement division of 2 numbers.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public class Division extends UserAction {

    /**
     * Default constructor.
     * @param input - Input to ask data from user.
     * @param calculator - Calculator which implements arithmetic operations.
     * @param info - Name of this UserAction to display the main menu.
     */
    public Division(Input input, Calculator calculator, String info) {
        super(input, calculator, info);
    }

    /**
     * Execute division in Calculator.
     * @param params - arguments that may be required for the arithmetic operation.
     * @return result.
     */
    public double execute(double... params) {
        params = super.getTwoCorrectParams("делимое", "делитель", params);
        while (params[1] == 0D) {
            params[1] = this.getInput().askDouble("Нельзя делить на нуль. Введите делитель: ");
        }
        this.getCalculator().div(params[0], params[1]);
        return this.getCalculator().getResult();
    }
}
