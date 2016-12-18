package radishevsky;

import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Vladislav on 18.12.2016.
 */
public class RoundFieldTest {

    @Test
    public void checkGetWay() throws Exception {
        Field field = new RoundField(10, 16);
        int start_x = 6, start_y = 10,
            end_x = 9, end_y = 8;
        field.setScore(8, 11, -1); // Елка

        ArrayList<Cell> way = field.getWay(start_x, start_y, end_x, end_y);
        /*
        for (Cell cell : way) {
            System.out.println(String.format("(%s, %s)", cell.getX(), cell.getY()));
        }
        */
        ArrayList<Cell> result = new ArrayList<Cell>();
        result.add(new Cell(9, 8));
        result.add(new Cell(9, 5));
        result.add(new Cell(9, 2));
        result.add(new Cell(9, 15));
        result.add(new Cell(8, 13));
        result.add(new Cell(6, 12));
        result.add(new Cell(4, 11));
        result.add(new Cell(6, 10));

        assertThat(way, is(result));
    }


}