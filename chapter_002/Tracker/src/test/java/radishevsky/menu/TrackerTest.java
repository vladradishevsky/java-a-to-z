package radishevsky.menu;

import org.junit.Test;
import radishevsky.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Vladislav on 20.11.2016.
 */
public class TrackerTest {

    final Item item_0 = new Item("name 0", "desc 0");
    final Item item_1 = new Item("name 1", "desc 1");
    final Item item_2 = new Item("name 2", "desc 2");

    @Test
    public void checkAddItem() {
        Tracker tracker = new Tracker();
        tracker.addItem(item_0);
        tracker.addItem(item_1);
        Item[] checked = {item_0, item_1};

        assertThat(tracker.getAllItems(), is(checked));
    }

    @Test
    public void checkDeleteItem() {
        Tracker tracker = new Tracker();
        tracker.addItem(item_0);
        tracker.addItem(item_1);
        tracker.addItem(item_2);
        tracker.deleteItem(item_0.getId());
        tracker.deleteItem(item_2.getId());

        Item[] checked = {item_1};
        assertThat(tracker.getAllItems(), is(checked));
    }

    @Test
    public void checkGetAllItems() {
        Tracker tracker = new Tracker();
        tracker.addItem(item_0);
        tracker.addItem(item_1);
        tracker.addItem(item_2);

        Item[] checked = {item_0, item_1, item_2};
        assertThat(tracker.getAllItems(), is(checked));
    }

    @Test
    public void checkGetItemById() {
        Tracker tracker = new Tracker();
        tracker.addItem(item_0);
        tracker.addItem(item_1);
        tracker.addItem(item_2);

        Item checked = item_1;
        assertThat(tracker.getItemById(item_1.getId()), is(checked));
    }

}