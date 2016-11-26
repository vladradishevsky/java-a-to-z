package radishevsky.menu;

/**
 * Created by Vladislav on 05.11.2016.
 */
public class StubInput implements Input{

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        System.out.println(question);
        System.out.println(answers[position]);
        return answers[position++];
    }

    public int ask(String question, int[] range) {
        System.out.println(question);
        System.out.println(Integer.parseInt(answers[position]));
        return Integer.parseInt(answers[position++]);
    }

    public int askId(Tracker tracker) {
        int id = Integer.parseInt(this.ask("Please, enter the task's id: "));
        return id;
    }
}
