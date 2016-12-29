package radishevsky;

/**
 * Created by Vladislav on 19.12.2016.
 */
public class Conditioner extends CarDecorator {

    public Conditioner(Car car) {
        super(car);
    }

    public int getPrice() {
        return car.getPrice() + 20000;
    }

    public String getDescription() {
        return car.getDescription() + "доп. опция кондиционер";
    }
}
