package radishevsky.Exceptions;

/**
 * The exception describes non-availability figure as result of request.
 * @author Vlad Radishevsky
 * @since 11.12.2016
 * @version 1.0
 */
public class FigureNotFoundException extends RuntimeException {

    public FigureNotFoundException(String message) {
        super(message);
    }
}
