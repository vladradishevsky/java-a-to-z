package radishevskii.list;

import java.util.*;

public class SimpleListImpl<E> implements SimpleList<E> {

    /**
     * Default capacity of using array.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Storage of all values.
     */
    private Object[] container;

    /**
     * Counter that increments on every modification from outside.
     */
    private int modCount = 0;

    /**
     * Last index - The size of the array for external queries.
     */
    private int lastIndex = 0;

    /**
     * Default constructor.
     */
    public SimpleListImpl() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor with optional capacity.
     * @param capacity default capacity.
     */
    public SimpleListImpl(int capacity) {
        this.container = new Object[capacity];
    }

    /**
     * Add new element to collection.
     *
     * @param value value for adding.
     */
    @Override
    public void add(E value) {
        if (this.lastIndex >= this.container.length) {
            this.growContainer();
        }
        this.container[this.lastIndex++] = value;
        this.modCount++;
    }

    /**
     * Get element from collection.
     *
     * @param index position number of wished element.
     * @return element by index.
     */
    @Override
    public E get(int index) {
        if (index >= this.lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        return (E) this.container[index];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             * Expected value of modification's counter.
             */
            private int expectedModCount = modCount;

            /**
             * Index to iterate values.
             */
            private int index = 0;

            /**
             * Returns {@code true} if the iteration has more elements.
             * @return {@code true} if the iteration has more elements
             * @throws ConcurrentModificationException if the storage has been modified.
             */
            @Override
            public boolean hasNext() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (this.index < lastIndex) {
                    if (Optional.ofNullable(container[this.index]).isPresent()) return true;
                    this.index++;
                }
                return false;
            }

            /**
             * Returns the next element in the iteration.
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[this.index++];
            }
        };
    }

    /**
     * Inner method to increase storage capacity.
     */
    private void growContainer() {
        int oldCapacity = this.container.length;
        int newCapacity = oldCapacity + DEFAULT_CAPACITY;
        this.container = Arrays.copyOf(this.container, newCapacity);
    }
}
