package radishevsky;

/**
 * Created by Vladislav on 19.12.2016.
 */
public class SimpleCar implements Car {

    @Override
    public int getPrice() {
        return 100000;
    }

    @Override
    public String getDescription() {
        return "Самый простой автомобиль";
    }
}
