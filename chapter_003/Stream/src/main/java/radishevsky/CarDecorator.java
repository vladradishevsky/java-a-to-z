package radishevsky;

/**
 * Created by Vladislav on 19.12.2016.
 */
public abstract class CarDecorator implements Car {

    protected final Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public int getPrice() {
        return this.car.getPrice();
    }

    @Override
    public String getDescription() {
        return this.car.getDescription();
    }
}
