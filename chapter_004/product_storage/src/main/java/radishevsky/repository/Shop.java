package radishevsky.repository;
import radishevsky.food.Food;

/**
 * Class Shop to store products for sale.
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public class Shop extends StorageArea {

    /**
     * Default constructor.
     * @param maxSize maximum size.
     */
    public Shop(int maxSize) {
        super(maxSize);
    }

    /**
     * Checking the ability to add food into storage.
     * @param food food to check.
     * @return true if it's possibly, else false.
     */
    public boolean canAddThisFood(Food food) {
        return !super.isStorageFull()
                && food.getConsumptionExpiry() >= 0.25d
                && food.getConsumptionExpiry() <= 1d;
    }

    /**
     * Add food to current repository.
     *
     * @param food food to add.
     */
    public void addFood(Food food) {
        if (food.getConsumptionExpiry() >= 0.75d) {
            food.setDiscount(food.getPrice() * 0.5d);
        }
        super.addFood(food);
    }
}
