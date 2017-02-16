package radishevsky.actions;

import radishevsky.Calculator;
import radishevsky.input.Input;

/**
 * abstract class for make arithmetic.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public abstract class UserAction {

    /**
     * Calculator to default use.
     */
    protected final Calculator CALCULATOR;

    /**
     * Key for menu numbering.
     */
    protected int key;

    /**
     * Naming to display in the menu.
     */
    protected final String INFO;

    /**
     * Input for requests users choice.
     */
    protected final Input INPUT;

    /**
     * Default constructor.
     * @param input - Input to ask data from user.
     * @param calculator - Calculator which implements arithmetic operations.
     * @param info - Name of this UserAction to display the main menu.
     */
    public UserAction(final Input input, final Calculator calculator, final String info) {
        this.INPUT = input;
        this.CALCULATOR = calculator;
        this.INFO = info;
    }

    /**
     * Execute something in Calculator.
     * @param params - arguments that may be required for the arithmetic operation.
     */
    public abstract double execute(double... params);

    /**
     * Getter for key.
     */
    public int getKey() {
        return this.key;
    }

    /**
     * Setter for key.
     * @param key - new key number to set.
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Getter for info.
     */
    public String getInfo() {
        return this.INFO;
    }

    /**
     * Ask param from the user option if it is not.
     * @param nameOfParam - name of this param to ask.
     * @param params - input params to check.
     * @return - one correct param.
     */
    protected double getOneCorrectParam(String nameOfParam, double... params) {
        double result;
        if (params.length < 1) {
            result = this.INPUT.askDouble(String.format("Введите %s: ", nameOfParam));
        } else {
            result = params[0];
        }
        return result;
    }

    /**
     * Ask params from the user if the parameters are missing.
     * @param nameOfFirst - name of the first param to ask.
     * @param nameOfSecond - name of the second param to ask.
     * @param params - input params to check.
     * @return - array of 2 correct params.
     */
    protected double[] getTwoCorrectParams(String nameOfFirst, String nameOfSecond, double... params) {
        double first, second;
        switch (params.length) {
            case 0: {
                first = this.INPUT.askDouble(String.format("Введите %s: ", nameOfFirst));
                second = this.INPUT.askDouble(String.format("Введите %s: ", nameOfSecond));
                break;
            } case 1: {
                first = params[0];
                second = this.INPUT.askDouble(String.format("Введите %s: ", nameOfSecond));
                break;
            } default: {
                first = params[0];
                second = params[1];
                break;
            }
        }
        return new double[]{first, second};
    }

}
