package tracker.start;

import tracker.Item;
import tracker.Tracker;


public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
        this.actions[6] = new ExitProgram();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDesc()));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the tasks's name:");
            String desc = input.ask("Please, enter the tasks's description:");
            tracker.add(new Item(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }
    }

    class EditItem implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id");
            String name = input.ask("Please, enter the tasks's name:");
            String desc = input.ask("Please, enter the tasks's description:");
            Item item = new Item();
            item.setId(id);
            item.setName(name);
            item.setDesc(desc);
            tracker.edit(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id");
            tracker.delete(id);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    class FindItemById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDesc()));
            } else {
                System.out.println("Not found");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find by ID");
        }
    }

    class FindItemByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name");
            Item item = tracker.findByName(name);
            if (item != null) {
                System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDesc()));
            } else {
                System.out.println("Not found");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find by name");
        }
    }

    class ExitProgram implements UserAction {
        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit program");
        }
    }
}