package radishevsky;

import org.junit.Before;
import org.junit.Test;
import radishevsky.figures.Bishop;
import radishevsky.figures.Pawn;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Vladislav on 11.12.2016.
 */
public class BoardTest {

    @Test
    public void AddFigureTest() {
        Board board = new Board();
        Move move = new VerticalMove();
        boolean result;
        result = board.addFigure(new Pawn(move, new Cell(0, 0), true));
        assertThat(result, is(true));
    }
    @Test
    public void whenBishopMovedInCleanAreaThenReturnTrue() {
        Board board = new Board();
        Move move = new DiagonalMove();

        board.addFigure(new Bishop(move, new Cell(0, 0), true));
        boolean isMoved = board.move(new Cell(0, 0), new Cell(5, 5));
        boolean isSourceCellCleared = board.figures[0][0]==null;
        boolean isDestinationCellCleared = board.figures[5][5].equals(new Bishop(move, new Cell(5, 5), true));

        assertThat((isMoved && isSourceCellCleared && isDestinationCellCleared), is(true));
    }
    @Test
    public void whenBishopMovesOutwardThenReturnFalse() {
        Board board = new Board();
        Move move = new DiagonalMove();

        board.addFigure(new Bishop(move, new Cell(0, 0), true));
        boolean isMoved = board.move(new Cell(0, 0), new Cell(9, 9));

        assertThat((isMoved), is(false));
    }
    @Test
    public void whenBishopMovesAndAnotherFigureOnThWayThenReturnFalse() {
        Board board = new Board();

        board.addFigure(new Bishop(new DiagonalMove(), new Cell(0, 0), true));
        board.addFigure(new Pawn(new VerticalMove(), new Cell(2, 2), false));
        boolean isMoved = board.move(new Cell(0, 0), new Cell(5, 5));

        assertThat((isMoved), is(false));
    }
    @Test
    public void whenMovesCellWithoutFigureThenReturnFalse() {
        Board board = new Board();

        board.addFigure(new Bishop(new DiagonalMove(), new Cell(1, 1), true));
        board.addFigure(new Pawn(new VerticalMove(), new Cell(2, 2), false));
        boolean isMoved = board.move(new Cell(0, 0), new Cell(5, 5));

        assertThat((isMoved), is(false));
    }
}