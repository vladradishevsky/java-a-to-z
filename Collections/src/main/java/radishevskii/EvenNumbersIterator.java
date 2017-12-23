package radishevskii;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] values;
    private int index = 0;


    public EvenNumbersIterator(final int[] values) {
        this.values = this.getOddIntArr(values);
    }

    public boolean hasNext() {
        return this.index < this.values.length;
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.values[this.index++];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

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
