package radishevskii;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class PrimeIterator.
 * Iterate all prime integers from input array.
 */
public class PrimeIterator implements Iterator {

    /**
     * Field values.
     */
    private final int[] values;

    /**
     * Field index.
     */
    private int index = 0;

    /**
     * Constructor of PrimeIterator.
     * @param values array of integers.
     */
    public PrimeIterator(final int[] values) {
        this.values = this.getPrimeArray(values);
    }

    /**
     * Override method hasNext.
     * @return true if the iteration has more prime elements.
     */
    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }

    /**
     * Override method next.
     * @return the next prime number in the iteration.
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.values[this.index++];
    }

    /**
     * Method to check whether the number is prime.
     * @param number number to check.
     * @return true if number is prime.
     */
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

    /**
     * Inner method to filter non-prime numbers in array.
     * @param values array of numbers.
     * @return new array of numbers with only prime numbers.
     */
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
