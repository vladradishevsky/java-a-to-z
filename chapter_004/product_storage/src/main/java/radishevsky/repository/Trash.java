package radishevsky.repository;
import radishevsky.food.Food;

/**
 * Class trash to store spoiled products.
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public class Trash extends StorageArea {

    /**
     * Default constructor.
     * @param maxSize maximum size.
     */
    public Trash(int maxSize) {
        super(maxSize);
    }

    /**
     * Checking the ability to add food into storage.
     * @param food food to check.
     * @return true if it's possibly, else false.
     */
    @Override
    public boolean canAddThisFood(Food food) {
        return food.getConsumptionExpiry() >= 1d;
    }
}
