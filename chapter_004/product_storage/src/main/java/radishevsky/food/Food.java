package radishevsky.food;
import java.util.Date;

/**
 * Class Food.
 * @author vladradishevsky
 * @since 30/06/2017
 * @version 1.0
 **/
public class Food {

    /**
     * Name of current food.
     */
    private String name;

    /**
     * Creating date.
     */
    private Date createDate;

    /**
     * Expiration Date.
     */
    private Date expaireDate;

    /**
     * Price for sale.
     */
    private double price;

    /**
     * Discount for sale.
     */
    private double discount;

    /**
     * Default constructor.
     *
     * @param name name of current food
     * @param createDate creating date
     * @param expaireDate expiration Date
     * @param price price for sale
     * @param discount Discount for sale
     */
    public Food(String name, Date createDate, Date expaireDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expaireDate = expaireDate;
        this.price = price;
        this.discount = discount;
    }

    /**
     * Get name.
     * @return name of food
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get create date.
     * @return create date
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Get expaire date.
     * @return expaire date
     */
    public Date getExpaireDate() {
        return this.expaireDate;
    }

    /**
     * Get price.
     * @return price for sale
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Get discount.
     * @return discount for sale
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * Set name.
     * @param name name of food
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set create date.
     * @param createDate create date of food
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Set expaire date.
     * @param expaireDate expaire date of food
     */
    public void setExpaireDate(Date expaireDate) {
        this.expaireDate = expaireDate;
    }

    /**
     * Set price.
     * @param price price for sale
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Set discount.
     * @param discount discount for sale
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Get the expiry product depends from current time.
     * @return proportion from 0 (food has been created yet) to 1 (food is overdue)
     */
    public double getConsumptionExpiry() {
        return (double) (System.currentTimeMillis() - this.createDate.getTime())
                / (this.expaireDate.getTime() - this.createDate.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Food)) {
            return false;
        }

        Food food = (Food) o;

        if (Double.compare(food.price, price) != 0) {
            return false;
        }
        if (Double.compare(food.discount, discount) != 0) {
            return false;
        }
        if (!name.equals(food.name)) {
            return false;
        }
        if (!createDate.equals(food.createDate)) {
            return false;
        }
        return expaireDate.equals(food.expaireDate);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + createDate.hashCode();
        result = 31 * result + expaireDate.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
