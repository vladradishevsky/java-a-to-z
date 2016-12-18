package radishevsky;

import java.util.ArrayList;

/**
 * Круговое поле с движение по часовой стрелки.
 *
 * @author Vlad Radishevsky
 * @since 19.12.2016
 * @version 1.0
 */
public class RoundField implements Field {
    /**
     * Массив всех ячеек
     */
    private final Cell[][] field;

    /**
     * Массив ячеек пути
     */
    private final ArrayList<Cell> way;

    /**
     * Конструктор
     */
    public RoundField(int x_size, int y_size) {
        this.field = new Cell[x_size][y_size];

        for (int x_index = 0; x_index < this.field.length; x_index++) {
            for (int y_index = 0; y_index < this.field[x_index].length; y_index++) {
                this.field[x_index][y_index] = new Cell(x_index, y_index);
            }
        }

        this.way = new ArrayList<Cell>();
    }

    @Override
    public int getScore(int x, int y) {
        return this.field[x][y].getScore();
    }

    @Override
    public void setScore(int x, int y, int score) {
        this.field[x][y].setScore(score);
    }

    @Override
    public ArrayList<Cell> getWay(int start_x, int start_y, int end_x, int end_y) {

        this.jump(start_x, start_y, 0, 0);

        this.makeWay(end_x, end_y, 0, 0);
        if (this.way.size() > 0) this.way.add(0, this.field[end_x][end_y]);

        return this.way;
    }

    /**
     * Рекурсивный метод
     * заполняет каждую очки каждой клеточки
     * минимальным количеством ходов, которое
     * необходимо совершить, чтобы добраться от
     * начальной точки до рассматриваемой
     *
     * @param x - первая координата рассматриваемой точки
     * @param y - вторая координата рассматриваемой точки
     * @param dx - приращение первой координаты в зависимости от правил хода
     * @param dy - приращение второй координаты в зависимости от правил хода
     */
    private void jump(int x, int y, int dx, int dy) {
        // Сколько прыжков уже совершено на данный момент
        int current_score = this.field[x][y].getScore();

        // Новые координаты
        x = (x + dx);
        y = (y + dy) % this.field[0].length;

        // Конец рекурсии
        if (x < 0 || x > 9) return;// если выход за пределы круга или в центр
        if (this.field[x][y].getScore() < 0 // если в новых координатах стоит дерево
        || (this.field[x][y].getScore() > 0) && (this.field[x][y].getScore() < current_score + 1)) { // найден более короткий путь
        return;
        }

        this.field[x][y].setScore(current_score + 1);

        this.jump(x, y, 2, 1);
        this.jump(x, y, 1, 2);
        this.jump(x, y, 0, 3);
        this.jump(x, y, -1, 2);
        this.jump(x, y, -2, 1);
    }

    /**
     * Рекурсивный метод
     * заполняет массив this.way кратчайшим путем ячеек от конечной точки до начальной
     *
     * @param end_x - первая координата конечной точки
     * @param end_y - вторая координата конечной точки
     * @param dx - обратное приращение первой координаты в зависимости от правил хода
     * @param dy - обратное приращение второй координаты в зависимости от правил хода
     */
    private void makeWay(int end_x, int end_y, int dx, int dy) {

        end_x = (end_x + dx);
        end_y = (end_y + dy) % this.field[0].length;
        if (end_y < 0) end_y = end_y + this.field[0].length;

        if (end_x < 0 || end_x > 9) return;

        if (nextStep(this.field[end_x][end_y].getScore(), end_x + 2, end_y - 1)) {
            makeWay(end_x, end_y, 2, -1);
            return;
        }
        if (nextStep(this.field[end_x][end_y].getScore(), end_x + 1, end_y - 2)) {
            makeWay(end_x, end_y, 1, -2);
            return;
        }
        if (nextStep(this.field[end_x][end_y].getScore(), end_x    , end_y - 3)) {
            makeWay(end_x, end_y, 0, -3);
            return;
        }
        if (nextStep(this.field[end_x][end_y].getScore(), end_x - 1, end_y - 2)) {
            makeWay(end_x, end_y, -1, -2);
            return;
        }
        if (nextStep(this.field[end_x][end_y].getScore(), end_x - 2, end_y - 1)) {
            makeWay(end_x, end_y, -2, -1);
        }

    }

    /**
     * Метод проверяет, может ли точка (x, y) быть предыдущей для
     * точки с количеством очков score и добавляет ее в this.way
     * @param score - количетсво очков
     * @param x - первая координата точки
     * @param y - вторая координата точки
     * @return true, если условия выполнены она добавленав this.way, иначе false
     */
    private boolean nextStep(int score, int x, int y) {
        boolean result = false;
        y = y % this.field[0].length;
        if (y < 0) y = y + this.field[0].length;

        if (x < 0 || x > 9) return false;

        if (score == this.field[x][y].getScore() + 1) {
            this.way.add(this.field[x][y]);
            result = true;
        }

        return result;
    }
}
