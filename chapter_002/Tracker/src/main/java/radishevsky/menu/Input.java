package radishevsky.menu;

/**
 * Created by Vladislav on 05.11.2016.
 */
public interface Input {

    public String ask(String question);

    int ask(String question, int[] range);

    int askId(Tracker tracker);

}
