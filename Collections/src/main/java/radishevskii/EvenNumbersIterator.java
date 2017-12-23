package radishevskii;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenNumbersIterator.
 * Iterate only even numbers.
 */
public class EvenNumbersIterator implements Iterator {

    /**
     * Inner fields.
     */
    private final int[] values;
    private int index = 0;

    /**
     * Constructor of EvenNumbersIterator.
     * @param values array of integers.
     */
    public EvenNumbersIterator(final int[] values) {
        this.values = this.getOddIntArr(values);
    }

    /**
     * Override method hasNext.
     * @return true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }

    /**
     * Override method next.
     * @return the next even number in the iteration.
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.values[this.index++];
    }

    /**
     * Override method next.
     * Unsupported Operation.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * Inner method to filter non-even numbers.
     * @param values array of integers.
     * @return new array of integers includes only even numbers.
     */
    private int[] getOddIntArr(int[] values) {
        int oddCount = 0;
        for (int num : values) {
            if (num % 2 == 0) {
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int index = 0;
        for (int num : values) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }
        return result;
    }

}
