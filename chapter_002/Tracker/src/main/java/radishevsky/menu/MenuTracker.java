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

    public void fillActions() {
        addAction(new AddItem("Add the new Item"));
        addAction(new ShowItems("Show all items"));
        addAction(new FindItem("Find item"));
        addAction(new EditItem("Edit the Item"));
        addAction(new DeleteItem("Delete Item"));
        addAction(new AddComment("Add comment to item"));
        addAction(new EmptyAction("Exit"));


    }
    public void addAction(BaseAction action) {
        UserAction[] result = new BaseAction[this.actions.length+1];
        System.arraycopy(this.actions, 0, result, 0, this.actions.length);
        action.setKey(this.actions.length);
        result[this.actions.length] = action;
        this.actions = result;
    }
    public int getMenuSize() {return this.actions.length;}

    public int select(int key) {
        this.actions[key].execute(this.input, this.tracker);
        return key;
    }

    /**
     * Выводит на консоль меню программы
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     *
     *
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

    private class EmptyAction extends BaseAction {

        public EmptyAction(String name) {
            super(name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}
