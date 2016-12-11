package radishevsky;

import radishevsky.Exceptions.*;

/**
 * The class implements a chessboard and manage figures on it.
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
public class Board {
    final private int vertical_size = 8;
    final private int horizontal_size = 8;
    Figure[][] figures = new Figure[horizontal_size][vertical_size];

    /*
     * This method add figure to the chessboard
     * @param Figure figure - figure to add
     * @return true if figure was successfully added of false
     * @thrown ImpossibleMoveException
     */
    public boolean addFigure(Figure figure) {
        boolean result = false;
        try {
            int x = figure.position.getX(), y = figure.position.getY();
            if ((figure == null)
                || (x < 0) || (x > 7)
                || (y < 0) || (y > 7)) {
                throw new FigureNotFoundException("Can't create new figure");
            }
            this.figures[x][y] = figure;
            result = true;
        } catch (FigureNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
        return result;
    }

    /*
     * This method delete figure to the chessboard
     * @param Cell cell - cell to delete figure from it
     */
    public void deleteFigure(Cell cell) {
        figures[cell.getX()][cell.getY()] = null;
    }

    /*
     * This method moves figures on chessboard or thrown exceptions
     * @param Cell source - source cell
     * @param Cell dist - destination cell
     * @return true if figure was successfully moved of false
     */
    public boolean move(Cell source, Cell dist) {

        boolean result = false;
        Figure source_figure = figures[source.getX()][source.getY()];
        try {
            if ((source_figure == null)
                    || (source.getX() < 0) || (source.getX() > 7)
                    || (source.getY() < 0) || (source.getY() > 7)) {
                throw new FigureNotFoundException("Figure not found");
            }
            if (
                    (dist.getX() < 0) || (dist.getX() > 7)
                 || (dist.getY() < 0) || (dist.getY() > 7)) {
                throw new ImpossibleMoveException("This move is impossible");
            }

            Cell[] way = source_figure.way(dist);
            int x, y;
            for (Cell cell : way) {
                x = cell.getX();
                y = cell.getY();
                if (figures[x][y] != null) {
                    throw new OccupiedWayException(String.format("The way is occupied by another figure (%s) on cell: %s,%s", figures[x][y].getClass().getSimpleName(), x, y));
                }
            }

            figures[dist.getX()][dist.getY()] = source_figure.clone(dist);
            this.deleteFigure(source);
            result = true;
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());

        }
        return result;
    }
}
