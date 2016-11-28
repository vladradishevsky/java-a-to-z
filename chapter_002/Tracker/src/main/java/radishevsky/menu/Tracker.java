package radishevsky.menu;
import radishevsky.models.*;

import java.util.Random;

/**
 * class Tracker implements storage of items
 * and manage them
 *
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 */
public class Tracker {
    private Item[] items = new Item[0];
    private final Random generator = new Random();

    /**
     * Add Item to the array "items"
     * @param item to be added
     */
    public void addItem(Item item) {
        Item[] result = new Item[this.items.length + 1];
        System.arraycopy(this.items, 0, result, 0, this.items.length);
        item.setId(generator.nextInt());
        result[this.items.length] = item;
        this.items = result;
    }

    /**
     * Delete item from array "items"
     * @param id of item to be deleted
     */
    public void deleteItem(int id) {
        Item itemToDelete = getItemById(id);

        for (int index=0; index<this.items.length; index++) {
            if (this.items[index].equals(itemToDelete)) {
                removeItemByIndex(index);
                break;
            }
        }
    }

    /**
     * Get all Items
     * @return the array "items"
     */
    public Item[] getAllItems() {
        return this.items;
    }

    /**
     * This method returns item by id
     * @param id of item
     * @return item if exist or null
     * @throws NumberFormatException
     */
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

    /**
     * This method remove item from "items" by index
     * @param index of item in array "items"
     */
    private void removeItemByIndex(int index) {
        Item[] result = new Item[this.items.length - 1];
        System.arraycopy(this.items, 0, result, 0, index);
        System.arraycopy(this.items, index+1, result, index, result.length-index);
        this.items = result;
    }
}
