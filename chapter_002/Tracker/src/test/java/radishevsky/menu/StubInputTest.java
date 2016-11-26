package radishevsky.menu;

import org.junit.Test;
import radishevsky.models.Item;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 27.11.2016.
 */
public class StubInputTest {


    @Test
    public void StubInputTesting() {
        Tracker tracker = new Tracker();
        Item startItem = new Item("Vlad", "Rad");
        tracker.addItem(startItem);
        startItem.setId(111);

        String[] answers = {"0", "item's name", "item's desc",                  // Add new Item
                            "1",                                                // Show all
                            "2", "111",                                         // Find by id
                            "3", "111", "new item's name", "new item's desc",   // Edit Item
                            "1",
                            "5", "111", "new comment 1",                        // Add comment
                            "5", "111", "new comment 2",
                            "1",
                            "4", "111",                                         // Delete comment
                            "6"                                                 // Exit
        };
        Input input = new StubInput(answers);
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        int[] ranges = {1,2,3,4,5,6};

        Integer currentSelect, exitSelect = menu.getMenuSize() - 1;
        do {
            menu.show();
            currentSelect = menu.select(input.ask("Select: ", ranges));
        } while(!currentSelect.equals(exitSelect));

    }

}