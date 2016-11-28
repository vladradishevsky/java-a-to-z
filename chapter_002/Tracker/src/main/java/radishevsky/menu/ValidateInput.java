package radishevsky.menu;

import radishevsky.exceptions.IdDontExistException;
import radishevsky.exceptions.MenuOutException;

/**
 * class ValidateInput for check input data
 *
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 **/
public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter validate data again.");
            } catch (MenuOutException moe) {
                // moe.printStackTrace();
                System.out.println("Please, select key from menu.");
            }

        } while(invalid);
        return value;
    }

    public int askId(Tracker tracker) {
        boolean invalid = true;
        int id = -1;
        do {
            try {
                id = super.askId(tracker);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter valid number again!");
            } catch (IdDontExistException ndee) {
                throw ndee;
            }
        } while(invalid);
        return id;
    }
}
