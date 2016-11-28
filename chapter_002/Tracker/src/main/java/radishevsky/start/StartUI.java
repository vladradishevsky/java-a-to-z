package radishevsky.start;

import radishevsky.menu.*;

/**
 * Created by Vladislav on 04.11.2016.
 */
public class StartUI {

    private Input input;
    private int[] ranges;
    private StartUI(Input input) {
        this.input = input;
    }

    /**
     *
     * @param menu
     * @return array int[] numbers of alloyed actions
     */
    private int[] getValidateRanges(MenuTracker menu) {
        int[] result = new int[menu.getMenuSize()];
        for(int index=0; index<menu.getMenuSize(); index++) {
            result[index] = index;
        }
        return result;
    }

    /**
     * initialize the program
     */
    private void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        this.ranges = getValidateRanges(menu);
        Integer currentSelect, exitSelect = menu.getMenuSize() - 1;
        do {
            menu.show();
            currentSelect = menu.select(input.ask("Select: ", this.ranges));
        } while(!currentSelect.equals(exitSelect));
    }

    public static void main(String[] args) {

        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}
