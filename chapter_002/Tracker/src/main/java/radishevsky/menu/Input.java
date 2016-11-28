package radishevsky.menu;

/**
 * interface Input
 *
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 **/
public interface Input {

    String ask(String question);

    int ask(String question, int[] range);

    int askId(Tracker tracker);

}
