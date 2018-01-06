package radishevskii.generic;

import java.util.Optional;

/**
 * Class SimpleArray.
 * @param <T> type of element.
 */
public class SimpleArray<T> {

    /**
     * Array values field.
     */
    private Object[] values;

    /**
     * Index field.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param size size of array to create.
     */
    public SimpleArray(int size) {
        this.values = new Object[size];
    }

    /**
     * Add element to array.
     * @param value
     */
    public void add(T value) {
        this.values[this.index++] = value;
    }

    /**
     * Update element in array.
     * @param index index to update.
     * @param value value to update.
     */
    public void update(int index, T value) {
        this.values[index] = value;
    }

    /**
     * Get element by index.
     * @param index index in array.
     * @return element from array.
     */
    public T get(int index) {
        return (T) this.values[index];
    }

    /**
     * Delete element by index.
     * @param index index of array.
     */
    public void delete(int index) {
        this.values[index] = null;
    }

    /**
     * Return current size of object in array.
     * @return length of object array.
     */
    public int size() {
        return this.values.length;
    }
}
