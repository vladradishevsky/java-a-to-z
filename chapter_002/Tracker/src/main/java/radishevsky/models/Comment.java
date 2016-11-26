package radishevsky.models;

/**
 * Created by Vladislav on 05.11.2016.
 */
public class Comment {
    private String text;

    public Comment() {
        this.text = "";
    }
    public Comment(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
