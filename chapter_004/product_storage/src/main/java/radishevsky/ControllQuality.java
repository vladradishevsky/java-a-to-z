package radishevsky;
import radishevsky.food.Food;
import radishevsky.repository.Shop;
import radishevsky.repository.StorageArea;
import radishevsky.repository.Trash;
import radishevsky.repository.Warehouse;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for manage the food distribution into areas.
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public class ControllQuality {

    /**
     * Areas for distribution.
     */
    private final ArrayList<StorageArea> areas;

    /**
     * Default constructor.
     */
    public ControllQuality() {
        this.areas = new ArrayList<StorageArea>();
    }

    /**
     * Filling areas of default repositories.
     */
    public void fillAreas() {
        this.addArea(new Warehouse(100));
        this.addArea(new Shop(100));
        this.addArea(new Trash(1000));
    }

    /**
     * Add own are.
     * @param area area to add in ControllQuality.
     */
    public void addArea(StorageArea area) {
        this.areas.add(area);
    }

    /**
     * Get all areas.
     * @return areas.
     */
    public ArrayList<StorageArea> getAreas() {
        return this.areas;
    }

    /**
     * Distribute food into areas.
     * @param food food to distribute.
     */
    public void distributeFood(Food food) {
        for (StorageArea area : this.areas) {
            if (area.canAddThisFood(food)) {
                area.addFood(food);
                break;
            }
        }
    }
    /**
     * Distribute food into areas.
     * @param foods List of food to distribute.
     */
    public void distributeFood(List<Food> foods) {
        for (Food food : foods) {
            this.distributeFood(food);
        }
    }
}
