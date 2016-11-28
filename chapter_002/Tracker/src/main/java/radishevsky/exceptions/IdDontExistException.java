package radishevsky.exceptions;

/**
 * IdDontExistException
 *
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 **/
public class IdDontExistException extends RuntimeException {
    public String msg;
    public IdDontExistException(String msg) {
        this.msg = msg;
    }
}
