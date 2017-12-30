package radishevskii.generic;

import java.util.NoSuchElementException;

/**
 * Class to store objects with string IDs.
 *
 * @author Vladislav Radishevskii
 * @version 0.1
 * @param <T> class of objects to store.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Size of storage.
     */
    protected final int size;

    /**
     * Base storage.
     */
    private SimpleArray<T> array;

    /**
     * Default constructor.
     * @param size Size of storage.
     */
    public AbstractStore(int size) {
        this.size = size;
        this.array = new SimpleArray<T>(size);
    }

    /**
     * Add element to storage.
     * @param model element to add.
     */
    @Override
    public void add(T model) {
        this.array.add(model);
    }

    /**
     * Replace element in the storage.
     * @param id ID of object to be replaced.
     * @param model object to replace with.
     * @return True if successful.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result;
        try {
            this.array.update(this.findIndexById(id), model);
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }

    /**
     * Delete object by id.
     * @param id ID of object to be deleted from storage.
     * @return True if successful.
     */
    @Override
    public boolean delete(String id) {
        boolean result;
        try {
            this.array.delete(this.findIndexById(id));
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }

    /**
     * Get object by id.
     * @param id ID of object to find.
     * @return Object with same id if it exist.
     */
    @Override
    public T findById(String id) {
        return this.array.get(this.findIndexById(id));
    }

    /**
     * Inner method to find storage's index by id.
     * @param id ID of object to find.
     * @return index in array.
     */
    private Integer findIndexById(String id) {
        Integer result = null;
        for (int index = 0; index < this.size; index++) {
            if (this.array.get(index) != null && this.array.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        if (result == null) {
            throw new NoSuchElementException(String.format("No element with current id: %s", id));
        }
        return result;
    }
}
