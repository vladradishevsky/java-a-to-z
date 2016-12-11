package radishevsky;

import radishevsky.Exceptions.ImpossibleMoveException;

/**
 * This class implements moves for figures on chessboard
 *
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
public abstract class Move {

    public abstract Cell[] getWay(Cell source, Cell destination);
}

/**
 * This class implements horizontal moves for figures on chessboard
 *
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
class HorizontalMove extends Move {

    /**
     * get way from current position to destination cell
     * @param source - source cell
     * @param destination - destination cell
     * @return way from source to dest cell
     * @throws ImpossibleMoveException
     */
    public Cell[] getWay(Cell source, Cell destination) throws ImpossibleMoveException {

        if (source.getY() == destination.getY()) {
            throw new ImpossibleMoveException("This move is impossible");
        }

        int x = source.getX();
        Cell[] result = new Cell[Math.abs(x - destination.getX()) - 1];
        int delta_X = destination.getX() > x ? 1 : -1;

        for (int index = 0; index < result.length; index++) {
            result[index] = new Cell(x += delta_X, source.getY());
        }
        return result;
    }
}

/**
 * This class implements vertical moves for figures on chessboard
 *
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
class VerticalMove extends Move {

    /**
     * get way from current position to destination cell
     * @param source - source cell
     * @param destination - destination cell
     * @return way from source to dest cell
     * @throws ImpossibleMoveException
     */
    public Cell[] getWay(Cell source, Cell destination) throws ImpossibleMoveException {

        if (source.getX() == destination.getX()) {
            throw new ImpossibleMoveException("This move is impossible");
        }

        int y = source.getY();
        Cell[] result = new Cell[Math.abs(y - destination.getY()) - 1];
        int delta_Y = destination.getY() > y ? 1 : -1;

        for (int index = 0; index < result.length; index++) {
            result[index] = new Cell(source.getX(), y += delta_Y);
        }
        return result;
    }
}

/**
 * This class implements diagonal moves for figures on chessboard
 *
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
class DiagonalMove extends Move {

    /**
     * get way from current position to destination cell
     * @param source - source cell
     * @param destination - destination cell
     * @return way from source to dest cell
     * @throws ImpossibleMoveException
     */
    public Cell[] getWay(Cell source, Cell destination) throws ImpossibleMoveException {

        int x = source.getX(), y = source.getY();

        if (Math.abs(destination.getX()-x) != Math.abs(destination.getY()-y)) {
            throw new ImpossibleMoveException("This move is impossible");
        }

        Cell[] result = new Cell[Math.abs(x - destination.getX()) - 1];
        int delta_X = destination.getX() > x ? 1 : -1;
        int delta_Y = destination.getY() > y ? 1 : -1;

        for (int index = 0; index < result.length; index++) {
            result[index] = new Cell(x += delta_X, y += delta_Y);
        }
        return result;
    }
}

/**
 * This class implements moves like horse for figures on chessboard
 *
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
class MoveLikeHorse extends Move{

    /**
     * get way from current position to destination cell
     * @param source - source cell
     * @param destination - destination cell
     * @return way from source to dest cell
     * @throws ImpossibleMoveException
     */
    public Cell[] getWay(Cell source, Cell destination) throws ImpossibleMoveException {

        Cell[] result = new Cell[1];
        int prefix_for_x = destination.getX() > source.getX() ? 1 : -1;
        int prefix_for_y = destination.getY() > source.getY() ? 1 : -1;
        if (
                (source.getX() + 2*prefix_for_x == destination.getX()) && (source.getY() +   prefix_for_y == destination.getY())
             || (source.getX() +   prefix_for_x == destination.getX()) && (source.getY() + 2*prefix_for_y == destination.getY()) ) {
            result[0] = destination;

        } else {
            throw new ImpossibleMoveException("This move is impossible");
        }
        return result;
    }
}