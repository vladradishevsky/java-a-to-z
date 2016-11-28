package radishevsky.menu;

import radishevsky.models.*;

/**
 * Created by Vladislav on 06.11.2016.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[0];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * This method fills array "actions" with actions
     */
    public void fillActions() {
        addAction(new AddItem("Add the new Item"));
        addAction(new ShowItems("Show all items"));
        addAction(new FindItem("Find item"));
        addAction(new EditItem("Edit the Item"));
        addAction(new DeleteItem("Delete Item"));
        addAction(new AddComment("Add comment to item"));
        addAction(new EmptyAction("Exit"));
    }

    /**
     * Add Action to the array "actions"
     * @param action
     */
    public void addAction(BaseAction action) {
        UserAction[] result = new BaseAction[this.actions.length+1];
        System.arraycopy(this.actions, 0, result, 0, this.actions.length);
        action.setKey(this.actions.length);
        result[this.actions.length] = action;
        this.actions = result;
    }

    /**
     * Get menu size
     * @return length of "actions"
     */
    public int getMenuSize() {return this.actions.length;}

    /**
     * This method get the key of action and excecute it
     * @param key - the key of menu action
     * @return key
     */
    public int select(int key) {
        this.actions[key].execute(this.input, this.tracker);
        return key;
    }

    /**
     * print in console list of menu actions
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Action to create new item and add it
     * @author vladradishevsky
     * @since 28.11.2016
     * @version 1.0
     */
    private class AddItem extends BaseAction {

        public AddItem(String name) {
            super(name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            tracker.addItem(new Item(name, desc));
        }
    }

    /**
     * Action to show all items form Tracker
     * @author vladradishevsky
     * @since 28.11.2016
     * @version 1.0
     */
    private class ShowItems extends BaseAction {

        public ShowItems(String name) {
            super(name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAllItems()) {
                System.out.println(item);
            }
        }
    }

    /**
     * Action to edit item's name and description by it's id
     * @author vladradishevsky
     * @since 28.11.2016
     * @version 1.0
     */
    private class EditItem extends BaseAction {

        public EditItem(String name) {
            super(name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            int id = input.askId(tracker);
            Item item = tracker.getItemById(id);

            String name = input.ask("Please, enter the task's name: ");
            item.setName(name);
            String desc = input.ask("Please, enter the task's desc: ");
            item.setDescription(desc);
        }
    }

    /**
     * Action to delete item from Tracker by it's id
     * @author vladradishevsky
     * @since 28.11.2016
     * @version 1.0
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(String name) {
            super(name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int id = input.askId(tracker);
            tracker.deleteItem(id);
            System.out.println(String.format("Item %s successfully deleted", id));
        }

    }

    /**
     * Action to find item in Tracker by it's id
     * @author vladradishevsky
     * @since 28.11.2016
     * @version 1.0
     */
    private class FindItem extends BaseAction {
        public FindItem(String name) {
            super(name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int id = input.askId(tracker);
            System.out.println(
                    tracker.getItemById(id)
            );

        }

    }

    /**
     * Action to add new comment to item by it's id
     * @author vladradishevsky
     * @since 28.11.2016
     * @version 1.0
     */
    private class AddComment extends BaseAction {

        public AddComment(String name) {
            super(name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int id = input.askId(tracker);
            Item item = tracker.getItemById(id);
            String text = input.ask("Enter the text of your comment: ");
            item.addComment(text);

        }
    }

    /**
     * This action do nothing (needed for quit from program)
     * @author vladradishevsky
     * @since 28.11.2016
     * @version 1.0
     */
    private class EmptyAction extends BaseAction {

        public EmptyAction(String name) {
            super(name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}
