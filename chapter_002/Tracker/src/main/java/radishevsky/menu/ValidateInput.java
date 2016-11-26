package radishevsky.menu;

import radishevsky.exceptions.IdDontExistException;
import radishevsky.exceptions.MenuOutException;

/**
 * Created by Vladislav on 08.11.2016.
 */
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
                System.out.println("Please, enter valid id again.");
            } catch (IdDontExistException ndee) {
                System.out.println(ndee.msg);
            }
        } while(invalid);
        return id;
    }
}
