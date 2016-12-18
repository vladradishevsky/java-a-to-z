package radishevsky;

import java.util.ArrayList;

/**
 * Осуществляет хранение и поиск кратчайшего пути с учетом
 * препятствий и правилам перемещения для двумерного поля
 *
 * @author Vlad Radishevsky
 * @since 19.12.2016
 * @version 1.0
 */
public interface Field {

    /**
     * @param x - первая координата
     * @param y - вторая координата
     * @return количество ходов до ячейки
     */
    int getScore(int x, int y);

    /**
     * Устанавливает количество очков для ячейке
     * @param x - первая координата
     * @param y - вторая координата
     * @param score - количество очков
     */
    void setScore(int x, int y, int score);

    /**
     *
     * @param start_x - первая координата начальной точки
     * @param start_y - вторая координата конечной точки
     * @param end_x - первая координата начальной точки
     * @param end_y - вторая координата конечной точки
     * @return путь (включая начальную и конечную ячейку)
     */
    ArrayList<Cell> getWay(int start_x, int start_y, int end_x, int end_y);
}
