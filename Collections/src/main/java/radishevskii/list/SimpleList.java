package radishevskii.list;

/**
 * Contract for containers.
 * @param <E> specify which type may store container.
 */
public interface SimpleList<E> extends Iterable<E> {

    /**
     * Add new element to collection.
     * @param value value for adding.
     */
    public void add(E value);

    /**
     * Get element from collection.
     * @param index position number of wished element.
     * @return element by index.
     */
    public E get(int index);
}
