package radishevsky;

/**
 * Created by Vladislav on 19.12.2016.
 */
public class WoodInterior extends CarDecorator {
    public WoodInterior(Car car) {
        super(car);
    }

    public int getPrice() {
        return car.getPrice() + 30000;
    }

    public String getDescription() {
        return car.getDescription() + ". Интерьер украшенный из дорогих пород дерева";
    }
}
