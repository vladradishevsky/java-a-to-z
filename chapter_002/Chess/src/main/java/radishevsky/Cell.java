package radishevsky;

/**
 * Class Cell for chess board
 *
 * @author Vlad Radishevsky
 * @since 10.12.2016
 * @version 1.0
 */
public class Cell {

    private int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
    * Getters && Setters
    */
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
