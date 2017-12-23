package radishevskii;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class PrimeIterator implements Iterator {

    private final int[] values;
    private int index = 0;

    public PrimeIterator(final int[] values) {
        this.values = this.getPrimeArray(values);
    }

    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.values[this.index++];
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] getPrimeArray(int[] values) {
        int[] tempArray = new int[values.length];
        int primeCount = 0;
        for (int value : values) {
            if (this.isPrime(value)) {
                tempArray[primeCount++] = value;
            }
        }
        int[] result = new int[primeCount];
        System.arraycopy(tempArray, 0, result, 0, primeCount);
        return result;
    }
}
