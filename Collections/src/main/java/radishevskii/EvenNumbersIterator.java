package radishevskii;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] values;
    private int index = 0;
    private boolean hasNext;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
        if (this.values.length > 0) {
            this.hasNext = true;
        }
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public Object next() {
        if (this.index < this.values.length) {
            if (this.values[this.index] % 2 == 0) {
                return //TODO
            }
        } else {
            throw new NoSuchElementException();
        }
        Object result = this.next();

        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    private boolean pass() {
        return true;
    }
}
