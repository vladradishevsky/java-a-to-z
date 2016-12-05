package radishevsky.models;

import java.util.Arrays;
import java.util.Date;

/**
 * class Item
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 **/
public class Item {

    private int id = -1;
    private String name;
    private String description;
    private Date create;
    private Comment[] comments = new Comment[0];
    private int commentCount = 0;

    public Item() {
        this.name = "no name";
        this.description = "no desc";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (commentCount != item.commentCount) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (create != null ? !create.equals(item.create) : item.create != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(comments, item.comments);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (create != null ? create.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(comments);
        result = 31 * result + commentCount;
        return result;
    }

    /**
     * Get name
     * @return name of this item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set name to item
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get Description
     * @return description of item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set description
     * @param desc description to item
     */
    public void setDescription(String desc) {
        this.description = desc;
    }

    /**
     * get Date of create
     * @return Date of create
     */
    public Date getCreateDate() {
        return this.create;
    }

    /**
     * Set Date of item's create
     * @param create
     */
    public void setCreateDate(Date create) {
        this.create = create;
    }

    /**
     * get id of item
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set id to item
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get array "comments" of this item
     * @return
     */
    public Comment[] getComments() {
        return this.comments;
    }

    /**
     * add new comment
     * @param text
     */
    public void addComment(String text) {
        Comment[] newComments = new Comment[this.comments.length+1];
        System.arraycopy(this.comments, 0, newComments, 0, this.comments.length);
        newComments[this.comments.length] = new Comment(text);
        this.comments = newComments;
    }
}
