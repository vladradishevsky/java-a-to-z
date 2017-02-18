package radishevsky;

import radishevsky.actions.UserAction;
import radishevsky.actions.Addition;
import radishevsky.actions.Division;
import radishevsky.actions.Multiplication;
import radishevsky.actions.Subtraction;
import radishevsky.input.Input;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Class InteractCalc for management of user's menu.
 * @author vladradishevsky
 * @since 15/02/2016
 * @version 1.0
 **/
public class InteractCalc {

    /**
     * Action's storage.
     */
    private ArrayList<UserAction> actions = new ArrayList<UserAction>();

    /**
     * Input to ask data from user.
     */
    private final Input input;

    /**
     * PrintStream to output data to client.
     */
    private final PrintStream out;

    /**
     * Calculator which implements the basic arithmetic operations.
     */
    private final Calculator defaultCalculator;

    /**
     * Action last time used.
     */
    private UserAction lastAction = null;

    /**
     * Key in main menu to quit program.
     */
    private int quitKey;

    /**
     * Default constructor.
     * @param input - Input to ask data from user.
     * @param outputStream - output data to client.
     * @param defaultCalculator - calculator which implements the basic arithmetic operations.
     */
    public InteractCalc(Input input, PrintStream outputStream, Calculator defaultCalculator) {
        this.input = input;
        this.out = outputStream;
        this.defaultCalculator = defaultCalculator;
        this.fillActions();
    }

    /**
     * Fill the storage basic actions.
     */
    private void fillActions() {
        this.addAction(new Addition(this.input, this.defaultCalculator, "сложение"));
        this.addAction(new Subtraction(this.input, this.defaultCalculator, "вычитание"));
        this.addAction(new Multiplication(this.input, this.defaultCalculator, "умножение"));
        this.addAction(new Division(this.input, this.defaultCalculator, "деление"));
    }

    /**
     * Add action to the storage.
     * @param action - action to add.
     */
    public void addAction(UserAction action) {
        this.actions.add(action);
        action.setKey(this.actions.size());
        this.quitKey = this.actions.size() + 1;
    }

    /**
     * Main loop.
     */
    public void init() {

        int currentKey;
        double currentResult = 0d;
        this.showMenu();
        do {
            currentKey = this.input.askInt("Выберите действие: ");
            if (currentKey < 0 || currentKey > this.actions.size()) {
                continue;
            } else if (currentKey == 0 && this.lastAction != null) {
                // repeat last action
                currentResult = this.lastAction.execute(currentResult);
            } else {
                // find and execute action
                for (UserAction action : this.actions) {
                    if (currentKey == action.getKey()) {
                        currentResult = action.execute();
                        lastAction = action;
                    }
                }
            }
            this.out.printf("Результат: %s%n", currentResult);
            this.showMenu();

        } while (currentKey != this.quitKey);

    }

    /**
     * Show main menu for user.
     */
    private void showMenu() {
        if (this.lastAction != null) {
            this.out.printf("[%s]: повторить %s с полученным результатом.%n", 0, this.lastAction.getInfo());
        }
        for (UserAction action: this.actions) {
            this.out.printf("[%s]: %s.%n", action.getKey(), action.getInfo());
        }
        this.out.printf("[%s]: выход из программы.%n", this.quitKey);
    }
}
