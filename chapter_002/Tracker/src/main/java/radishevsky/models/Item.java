package radishevsky.models;

import java.util.Date;

/**
 * Created by Vladislav on 02.11.2016.
 */
public class Item {

    private int id;
    private String name = "null name";
    private String description;
    private Date create;
    private Comment[] comments = new Comment[0];
    private int commentCount = 0;

    public Item() {
        this.create = new Date();
    }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.create = new Date();
    }
    public String toString() {
        String result = String.format("[id]: %s [Date]: %s.%s.%s %sh:%sm:%ss [Name]: %s [Description]: %s",
                this.id,
                this.create.getDate(),
                this.create.getMonth(),
                this.create.getYear() + 1900,
                this.create.getHours(),
                this.create.getMinutes(),
                this.create.getSeconds(),
                this.name,
                this.description
        );
        if (this.comments.length > 0) {
            for (int index = 0; index < this.comments.length; index++) {
                result = result.concat(
                    String.format("\n\tComment #%s: %s", index, this.comments[index].getText())
                );
            }
        }

        return result;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String desc) {
        this.description = desc;
    }
    public Date getCreateDate() {
        return this.create;
    }
    public void setCreateDate(Date create) {
        this.create = create;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Comment[] getComments() {
        return this.comments;
    }
    public void addComment(String text) {
        Comment[] newComments = new Comment[this.comments.length+1];
        System.arraycopy(this.comments, 0, newComments, 0, this.comments.length);
        newComments[this.comments.length] = new Comment(text);
        this.comments = newComments;
    }
}
