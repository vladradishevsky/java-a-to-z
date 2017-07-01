package radishevsky;
import org.junit.Test;
import radishevsky.food.Food;
import radishevsky.repository.StorageArea;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for ProductStorage.
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public class ProductStorageTest {
    /**
     * SimpleDateFormat object for creating dates from strings.
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Checking of correction of created food.
     */
    @Test
    public void checkCreatindFoods() {
        Date currentDate = new Date();
        Date expaireDate = new Date();
        expaireDate.setTime(expaireDate.getTime() + 5 * 24 * 60 * 60 * 1000);

        Food food = new Food("Milk", currentDate, expaireDate, 10d, 1d);

        boolean hasFoodCreatedCorrect =
                   food.getName().equalsIgnoreCase("Milk")
                && food.getCreateDate().equals(currentDate)
                && food.getExpaireDate().equals(expaireDate)
                && food.getPrice() == 10d
                && food.getDiscount() == 1d;

        assertThat(hasFoodCreatedCorrect, is(true));
    }

    /**
     * Checking of correction of food distribution.
     */
    @Test
    public void checkCorrectDistribution() {
        ControllQuality cq = new ControllQuality();
        cq.fillAreas();

        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(new Food("Food_to_Shop", new Date(System.currentTimeMillis() - 1000000),
                new Date(System.currentTimeMillis() + 1000000), 10d, 1d));
        foods.add(new Food("Food_to_Shop_and_set_discount", new Date(System.currentTimeMillis() - 1000000),
                new Date(System.currentTimeMillis() + 100000), 10d, 0d));
        foods.add(new Food("Food_to_Warehouse", new Date(), new Date(System.currentTimeMillis() + 1000000), 10d, 0d));
        foods.add(new Food("Food_to_Trash", new Date(System.currentTimeMillis() - 100),
                new Date(System.currentTimeMillis() - 50), 50d, 0d));


        cq.distributeFood(foods);
        ArrayList<StorageArea> areas = cq.getAreas();
        boolean result =
                   areas.get(0).getStorage().get(0).equals(foods.get(2)) // WareHouse <- Food_to_Warehouse
                && areas.get(1).getStorage().get(0).equals(foods.get(0)) // Shop <- Food_to_Shop
                && areas.get(1).getStorage().get(1).equals(foods.get(1)) // Shop with discount <- Food_to_Shop_and_set_discount
                && areas.get(2).getStorage().get(0).equals(foods.get(3));   // Trash <- Food_to_Trash

        assertThat(result, is(true));
    }
}