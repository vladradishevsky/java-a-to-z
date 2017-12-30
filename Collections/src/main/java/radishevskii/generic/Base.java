package radishevskii.generic;

/**
 * Base class of storing objects.
 *
 * @author Vladislav Radishevskii
 * @version $Id$
 */
public abstract class Base {

    /**
     * Identification of object.
     */
    private final String id;

    /**
     * Constructor.
     * @param id Identification of object.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Get Id of object.
     * @return Id of object.
     */
    public String getId() {
        return id;
    }
}
