package radishevsky.menu;
import radishevsky.models.*;

import java.util.Random;

/**
 * Created by Vladislav on 02.11.2016.
 */
public class Tracker {
    private Item[] items = new Item[0];
    private final Random generator = new Random();

    public void addItem(Item item) {
        Item[] result = new Item[this.items.length + 1];
        System.arraycopy(this.items, 0, result, 0, this.items.length);
        item.setId(generator.nextInt());
        result[this.items.length] = item;
        this.items = result;
    }

    public void deleteItem(int id) {
        Item itemToDelete = getItemById(id);

        for (int index=0; index<this.items.length; index++) {
            if (this.items[index].equals(itemToDelete)) {
                removeItemByIndex(index);
                break;
            }
        }
    }

    public Item[] getAllItems() {
        return this.items;
    }

    public Item getItemById(int id) throws NumberFormatException {

        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

    private void removeItemByIndex(int index) {
        Item[] result = new Item[this.items.length - 1];
        System.arraycopy(this.items, 0, result, 0, index);
        System.arraycopy(this.items, index+1, result, index, result.length-index);
        this.items = result;
    }
}
