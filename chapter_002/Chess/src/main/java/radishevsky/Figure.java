package radishevsky;

/**
 * This abstract class implements figure on chessboard
 *
 * @author Vlad Radishevsky
 * @since 10.12.2016
 * @version 1.0
 */
public abstract class Figure {
    protected final Cell position;
    protected final boolean isWhite;
    protected final Move move;

    public Figure(Move move, Cell position, boolean isWhite) {
        this.move = move;
        this.position = position;
        this.isWhite = isWhite;
    }

    /**
     * get way from current position to destination cell
     * @param dist - destination cell
     * @return result
     */
    public abstract Cell[] way(Cell dist);

    /**
     * get new figure as current but with destination cell
     * @param destination - destination cell
     * @return new figure
     */
    public abstract Figure clone(Cell destination);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        if (isWhite != figure.isWhite) return false;
        return position.equals(figure.position);

    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + (isWhite ? 1 : 0);
        return result;
    }
}
