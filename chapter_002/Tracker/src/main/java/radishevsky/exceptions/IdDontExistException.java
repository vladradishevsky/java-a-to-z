package radishevsky.exceptions;

/**
 * Created by Vladislav on 21.11.2016.
 */
public class IdDontExistException extends RuntimeException {
    public String msg;
    public IdDontExistException(String msg) {
        this.msg = msg;
    }
}
