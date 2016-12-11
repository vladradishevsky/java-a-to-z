package radishevsky.Exceptions;

/**
 * The exception describes incorrect to move on given way by this figure.
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException(String message) {
        super(message);
    }
}
