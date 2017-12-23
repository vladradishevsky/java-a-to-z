package radishevskii;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator{

    private final int[][] values;
    private int totalLenght;
    private int totalIndex = 0;
    private int arrayIndex = 0;
    private int localIndex = 0;

    public MatrixIterator(int[][] ints) {
        this.values = ints;
        this.totalLenght = 0;
        for (int[] value : values) {
            this.totalLenght += value.length;
        }
    }

    public boolean hasNext() {
        return totalIndex < totalLenght;
    }

    public Object next() {
        if (this.hasNext()) {
            throw new NoSuchElementException();
        }
        int result = this.values[this.arrayIndex][this.localIndex];

        this.localIndex = this.localIndex + 1;
        if (this.localIndex >= this.values[arrayIndex].length) {
            this.localIndex = 0;
            this.arrayIndex = this.arrayIndex + 1;
        }

        this.totalIndex++;
        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}
