package radishevsky.Exceptions;

/**
 * The exception describes the presence of other figures in the way.
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
public class OccupiedWayException extends RuntimeException {

    public OccupiedWayException(String message) {
        super(message);
    }
}
