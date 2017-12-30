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
        this.values = values;
    }

    /**
     * Override method hasNext.
     * @return true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        while (this.index < this.values.length) {
            if (this.values[this.index] % 2 == 0) return true;
            this.index++;
        }
        return false;
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

}
