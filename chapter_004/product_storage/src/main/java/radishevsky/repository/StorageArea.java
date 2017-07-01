package radishevsky.repository;
import radishevsky.food.Food;
import java.util.ArrayList;

/**
 * Class StorageArea (default area).
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public abstract class StorageArea {

    /**
     * Storage of foods.
     */
    private final ArrayList<Food> storage;

    /**
     * Maximum size allowed to fill.
     */
    private final int maxSize;

    /**
     * Default constructor.
     * @param maxSize maximum size.
     */
    public StorageArea(int maxSize) {
        this.maxSize = maxSize;
        this.storage = new ArrayList<Food>();
    }

    /**
     * Checking the ability to add food into storage.
     * @param food food to check.
     * @return true if it's possibly, else false.
     */
    public abstract boolean canAddThisFood(Food food);

    /**
     * Add food to current repository.
     *
     * @param food food to add in storage
     */
    public void addFood(Food food) {
        this.storage.add(food);
    }

    /**
     * Get storage.
     * @return storage
     */
    public ArrayList<Food> getStorage() {
        return storage;
    }

    /**
     * Get maximum size.
     * @return maximum size
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Checking is current storage full.
     * @return true if current storage is full, else false.
     */
    public boolean isStorageFull() {
        return this.storage.size() >= this.maxSize;
    }
}
