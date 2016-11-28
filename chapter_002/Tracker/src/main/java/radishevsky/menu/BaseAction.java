package radishevsky.menu;

/**
 * class BaseAction for execute menu actions
 *
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 */
public abstract class BaseAction implements UserAction{
    private String name;
    private int key;

    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }
    public BaseAction(String name) {
        this.name = name;
    }

    @Override
    public int key() { return this.key; }

    @Override
    public abstract void execute(Input input, Tracker tracker);

    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), this.name);
    }

    public void setKey(int key) {
        this.key = key;
    }


}
