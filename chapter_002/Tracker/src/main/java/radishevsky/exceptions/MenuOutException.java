package radishevsky.exceptions;

/**
 * Created by Vladislav on 08.11.2016.
 */
public class MenuOutException extends RuntimeException {
    public String msg;
    public MenuOutException(String msg) {
        this.msg = msg;
    }
}
