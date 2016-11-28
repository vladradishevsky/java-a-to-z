package radishevsky.menu;

import radishevsky.exceptions.IdDontExistException;
import radishevsky.exceptions.MenuOutException;
import radishevsky.models.Item;

import java.util.Scanner;

/**
 * class ConsoleInput for get input data from console
 *
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 **/
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }

    @Override
    public int askId(Tracker tracker) throws IdDontExistException, NumberFormatException {
        int id;
        Item item = null;
        try {
            id = Integer.parseInt(this.ask("Please, enter the task's id: "));
            item = tracker.getItemById(id);
            if (item == null) throw new IdDontExistException(String.format("id: %s doesn't exist. Try again", id));

        } catch (NumberFormatException nfe) {
            throw nfe;
        }
        return id;
    }

}
