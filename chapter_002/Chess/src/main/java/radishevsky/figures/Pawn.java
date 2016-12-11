package radishevsky.figures;

import radishevsky.Cell;
import radishevsky.Exceptions.ImpossibleMoveException;
import radishevsky.Figure;
import radishevsky.Move;

/**
 * The class implements pawn.
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
public class Pawn extends Figure{

    public Pawn(Move move, Cell position, boolean isWhite) {
        super(move, position, isWhite);
    }

    /*
    * Returns cells of the way to the destentios cell or throws ImpossibleMoveException
    * @param Cell dist - destination
    * @thrown ImpossibleMoveException
    */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] result = new Cell[0];
        int delta_Y = dist.getY() - super.position.getY();
        if (((super.isWhite) == (delta_Y>0)) && (delta_Y != 0)) {
            if ((Math.abs(delta_Y) == 1)
                || ((Math.abs(delta_Y) == 2) && ((super.isWhite && super.position.getY()==1) || (!super.isWhite && super.position.getY()==6)))) {
                result = super.move.getWay(super.position, dist);
            }
        } else {
            throw new ImpossibleMoveException("This move is impossible");
        }
        return result;
    }

    /*
    * Clone this figure to another cell
    * @param destination cell
    * @return new Figure
    */
    @Override
    public Figure clone(Cell destination) {
        return new Pawn(super.move, destination, super.isWhite);
    }

}
