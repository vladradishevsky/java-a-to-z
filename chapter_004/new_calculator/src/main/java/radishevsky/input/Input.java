package radishevsky.input;

/**
 * interface Input for ask data from the user.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public interface Input {

    /**
     * Ask user for a new line.
     *
     * @param question - message to user that will be shown.
     * @return - text line from the user.
     */
    String askLine(String question);

    /**
     * Ask user for a new double.
     *
     * @param question - message to user that will be shown.
     * @return - double form the user.
     */
    double askDouble(String question);

    /**
     * Ask user for a new integer.
     *
     * @param question - message to user that will be shown.
     * @return - integer form the user.
     */
    int askInt(String question);
}
