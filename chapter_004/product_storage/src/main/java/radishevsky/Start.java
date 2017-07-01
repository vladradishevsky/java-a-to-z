package radishevsky;
import radishevsky.food.Beverage;
import radishevsky.food.Drink;
import radishevsky.food.Food;
import radishevsky.food.Meat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class for starting current program.
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public class Start {

    /**
     * SimpleDateFormat object for creating dates from strings.
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Initialize program.
     */
    public void init() {
        ControllQuality cq = new ControllQuality();
        cq.fillAreas();
        cq.distributeFood(this.createFood());
    }

    /**
     * Creating food for areas.
     * @return Food objects.
     */
    public ArrayList<Food> createFood() {
        ArrayList<Food> result = new ArrayList<Food>();
        try {
            //add your own food
            result.add(new Drink("Coca-cola", this.sdf.parse("01.01.2017"), this.sdf.parse("01.01.2018"), 10d, 0d));
            result.add(new Meat("Chicken", this.sdf.parse("01.01.2017"), this.sdf.parse("15.01.2017"), 10d, 0d));
            result.add(new Food("Chocolate", this.sdf.parse("01.01.2017"), this.sdf.parse("30.06.2017"), 10d, 0d));
            result.add(new Beverage("Potato", this.sdf.parse("01.01.2017"), this.sdf.parse("01.01.2018"), 10d, 0d));
            result.add(new Food("Taste", this.sdf.parse("01.01.2017"), this.sdf.parse("01.01.2018"), 10d, 0d));

        } catch (ParseException pe) {
            pe.printStackTrace();
            System.out.println(pe.getMessage());
        }
        return result;
    }

    /**
     * Main loop.
     * @param args default args.
     */
    public static void main(String[] args) {
        new Start().init();
    }
}
