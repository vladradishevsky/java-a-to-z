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
     * Field of total length.
     */
    private int totalLength;

    /**
     * Fields of indexes.
     */
    private int totalIndex = 0;
    private int arrayIndex = 0;
    private int localIndex = 0;

    /**
     * Constructor of MatrixIterator.
     * @param ints 2-dimensional array.
     */
    public MatrixIterator(int[][] ints) {
        this.values = ints;
        this.totalLength = 0;
        for (int[] value : values) {
            this.totalLength += value.length;
        }
    }

    /**
     * Override method hasNext.
     * @return true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        return totalIndex < totalLength;
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
        int result = this.values[this.arrayIndex][this.localIndex];

        this.localIndex++;
        if (this.localIndex >= this.values[arrayIndex].length) {
            this.localIndex = 0;
            this.arrayIndex++;
        }

        this.totalIndex++;
        return result;
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
