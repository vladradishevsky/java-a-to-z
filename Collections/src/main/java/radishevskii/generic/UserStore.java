package radishevskii.generic;


/**
 * Class to store users.
 *
 * @author Vladislav Radishevskii
 * @version 0.1
 * @param <User> type of elements to store.
 */
public class UserStore<User> extends AbstractStore{
    public UserStore(int size) {
        super(size);
    }
}
