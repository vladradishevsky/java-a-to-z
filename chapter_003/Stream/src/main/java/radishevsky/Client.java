package radishevsky;

/**
 * Created by Vladislav on 19.12.2016.
 */
public class Client {
    public static void main(String[] args) {
        Car car = new SimpleCar();
        System.out.println(car.getPrice());
        System.out.println(car.getDescription());

        car = new Conditioner(car);
        System.out.println(car.getPrice());
        System.out.println(car.getDescription());

        car = new WoodInterior(car);
        System.out.println(car.getPrice());
        System.out.println(car.getDescription());

        Car Matreshka = new WoodInterior(new Conditioner(new SimpleCar()));
        System.out.println(Matreshka.getDescription() + " " + Matreshka.getPrice());
    }
}
