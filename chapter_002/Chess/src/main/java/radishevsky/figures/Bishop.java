package radishevsky.figures;

import radishevsky.Cell;
import radishevsky.Figure;
import radishevsky.Move;

/**
 * The class implements bishop.
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
public class Bishop extends Figure {

    public Bishop(Move move, Cell position, boolean isWhite) {
        super(move, position, isWhite);
    }

    /*
    * Returns cells of the way to the destentios cell or throws ImpossibleMoveException
    * @param Cell dist - destination
    * @return way to new destination cell
    * @thrown ImpossibleMoveException
    */
    @Override
    public Cell[] way(Cell dist) {
        return super.move.getWay(super.position, dist);
    }

    /*
    * Clone this figure to another cell
    * @param destination cell
    * @return new Figure
    */
    @Override
    public Figure clone(Cell destination) {
        return new Bishop(super.move, destination, super.isWhite);
    }
}
