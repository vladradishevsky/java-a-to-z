package radishevskii;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIterator.
 * Iterate all integers in jagged array.
 */
public class MatrixIterator implements Iterator{

    /**
     * Field of jagged array.
     */
    private final int[][] values;

    /**
     * Fields of indexes.
     */
    private int arrayIndex = 0;
    private int localIndex = 0;

    /**
     * Constructor of MatrixIterator.
     * @param values 2-dimensional array.
     */
    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    /**
     * Override method hasNext.
     * @return true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {

        if (!(arrayIndex < values.length)) return false;
        if (!(localIndex < values[arrayIndex].length)) {
            this.localIndex = 0;
            this.arrayIndex++;
        }
        return arrayIndex < values.length;
    }

    /**
     * Override method next.
     * @return the next number in the iteration.
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.values[arrayIndex][localIndex++];
    }

    /**
     * Override method next.
     * Unsupported Operation.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
