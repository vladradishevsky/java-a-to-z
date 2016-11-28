package radishevsky.exceptions;

/**
 * MenuOutException
 *
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 **/
public class MenuOutException extends RuntimeException {
    public String msg;
    public MenuOutException(String msg) {
        this.msg = msg;
    }
}
