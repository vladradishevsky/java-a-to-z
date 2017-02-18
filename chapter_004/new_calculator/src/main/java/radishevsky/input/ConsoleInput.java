package radishevsky.input;

import java.util.Scanner;

/**
 * interface Input for ask data from user from the console.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public class ConsoleInput implements Input {

    /**
     * Scanner to get data.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Ask user for a new line.
     *
     * @param question - message to user that will be shown.
     * @return - text line from the user.
     */
    public String askLine(String question) {
        System.out.println(question);

        return this.scanner.nextLine();
    }

    /**
     * Ask user for a new double.
     *
     * @param question - message to user that will be shown.
     * @return - double form the user.
     */
    public double askDouble(String question) {
        double result = 0;
        boolean wasException;
        do {
            try {
                result = Double.valueOf(this.askLine(question));
                wasException = false;
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                wasException = true;
            }
        } while (wasException);

        return result;
    }

    /**
     * Ask user for a new integer.
     *
     * @param question - message to user that will be shown.
     * @return - integer form the user.
     */
    public int askInt(String question) {
        int result = 0;
        boolean wasException;
        do {
            try {
                result = Integer.valueOf(this.askLine(question));
                wasException = false;
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                wasException = true;
            }
        } while (wasException);

        return result;
    }

}
