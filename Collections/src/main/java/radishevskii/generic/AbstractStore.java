package radishevskii.generic;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Class to store objects with string IDs.
 *
 * @author Vladislav Radishevskii
 * @version 0.1
 * @param <T> class of objects to store.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Default size of storage.
     */
    protected static final int DEFAULT_STORAGE_CAPACITY = 10;

    /**
     * Base storage.
     */
    private SimpleArray<T> array;

    /**
     * Default constructor.
     */
    public AbstractStore() {
        this(DEFAULT_STORAGE_CAPACITY);
    }

    /**
     * Constructor.
     * @param size Size of storage.
     */
    public AbstractStore(int size) {
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
        int index = this.findIndexById(id);
        if (index != -1) {
            this.array.update(index, model);
        } else {
            throw new NoSuchElementException();
        }
        return true;
    }

    /**
     * Delete object by id.
     * @param id ID of object to be deleted from storage.
     * @return True if successful.
     */
    @Override
    public boolean delete(String id) {
        int index = this.findIndexById(id);
        if (index != -1) {
            this.array.delete(index);
        } else {
            throw new NoSuchElementException();
        }
        return true;
    }

    /**
     * Get object by id.
     * @param id ID of object to find.
     * @return Object with same id if it exist.
     */
    @Override
    public T findById(String id) {
        int index = this.findIndexById(id);
        if (index != -1) {
            return this.array.get(index);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Inner method to find storage's index by id.
     * @param id ID of object to find.
     * @return index in array.
     */
    private int findIndexById(String id) {
        int result = -1;
        for (int index = 0; index < this.array.size(); index++) {
            if (this.array.get(index) != null && this.array.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
