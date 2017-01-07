package radishevsky.server.exceptions;

/**
 * Created by Vladislav on 07.01.2017.
 */
public class ActionException extends RuntimeException {

    public ActionException() {

    }
    public ActionException(String message) {
        super(message);
    }
}
