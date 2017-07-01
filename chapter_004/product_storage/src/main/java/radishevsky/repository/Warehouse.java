package radishevsky.repository;
import radishevsky.food.Food;

/**
 * Class Warehouse to store and waiting.
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public class Warehouse extends StorageArea {

    /**
     * Default constructor.
     * @param maxSize maximum size.
     */
    public Warehouse(int maxSize) {
        super(maxSize);
    }

    /**
     * Checking the ability to add food into storage.
     * @param food food to check.
     * @return true if it's possibly, else false.
     */
    @Override
    public boolean canAddThisFood(Food food) {
        return !super.isStorageFull()
                && food.getConsumptionExpiry() < 0.25d;
    }
}
