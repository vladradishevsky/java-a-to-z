package radishevsky.models;

/**
 * Comment
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 **/
public class Comment {
    private String text;

    public Comment() {
        this.text = "";
    }
    public Comment(String text) {
        this.text = text;
    }

    /**
     * get Text of comment
     * @return text
     */
    public String getText() {
        return this.text;
    }

    /**
     * Set text to the comment
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

}
