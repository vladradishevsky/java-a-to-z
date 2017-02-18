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
    private final Calculator calculator;

    /**
     * Key for menu numbering.
     */
    private int key;

    /**
     * Naming to display in the menu.
     */
    private final String info;

    /**
     * Input for requests users choice.
     */
    private final Input input;

    /**
     * Default constructor.
     * @param input - Input to ask data from user.
     * @param calculator - Calculator which implements arithmetic operations.
     * @param info - Name of this UserAction to display the main menu.
     */
    public UserAction(final Input input, final Calculator calculator, final String info) {
        this.input = input;
        this.calculator = calculator;
        this.info = info;
    }

    /**
     * Execute something in Calculator.
     * @param params - arguments that may be required for the arithmetic operation.
     * @return - result of arithmetic operation.
     */
    public abstract double execute(double... params);

    /**
     * Getter for key.
     * @return key.
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
     * @return info.
     */
    public String getInfo() {
        return this.info;
    }

    /**
     * Getter for calculator.
     * @return calculator.
     */
    public Calculator getCalculator() {
        return calculator;
    }

    /**
     * Getter for calculator.
     * @return Input.
     */
    public Input getInput() {
        return input;
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
            result = this.input.askDouble(String.format("Введите %s: ", nameOfParam));
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
        if (params.length == 0) {
            first = this.input.askDouble(String.format("Введите %s: ", nameOfFirst));
            second = this.input.askDouble(String.format("Введите %s: ", nameOfSecond));
        } else if (params.length == 1) {
            first = params[0];
            second = this.input.askDouble(String.format("Введите %s: ", nameOfSecond));
        } else {
            first = params[0];
            second = params[1];
        }
        return new double[]{first, second};
    }
}
