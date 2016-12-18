package radishevsky;

/**
 * Created by Vladislav on 18.12.2016.
 */
public class Cell {

    /**
     * Координаты ячейке
     */
    private int x, y;

    /**
     * Количество очков
     */
    private int score;

    /**
     * Конструкторы
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }
    public Cell(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }

    /**
     * Getters & Setters
     */
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getScore() {
        return this.score;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (this.x != cell.getX()) return false;
        return this.y == cell.getY();

    }

    @Override
    public int hashCode() {
        int result = this.x;
        result = 31 * result + this.y;
        return result;
    }
}
