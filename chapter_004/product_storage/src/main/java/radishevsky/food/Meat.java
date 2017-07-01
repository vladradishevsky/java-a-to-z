package radishevsky.food;
import java.util.Date;

/**
 * Class Meat.
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public class Meat extends Food {

    /**
     * Default constructor.
     *
     * @param name name of current food
     * @param createDate creating date
     * @param expaireDate expiration Date
     * @param price price for sale
     * @param discount Discount for sale
     */
    public Meat(String name, Date createDate, Date expaireDate, double price, double discount) {
        super(name, createDate, expaireDate, price, discount);
    }
}
