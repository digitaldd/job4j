package tracker.start;

import tracker.Tracker;

import java.util.ArrayList;
import java.util.List;


public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void addAction(UserAction action) {
        this.actions.add(action);
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public int[] actionsArray() {
        int[] array = new int[actions.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    public class ShowItems extends BaseAction {
        ShowItems(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    public class AddItem extends BaseAction {
        AddItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    public class EditItem extends BaseAction {
        EditItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    public class DeleteItem extends BaseAction {
        DeleteItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    public class FindItemById extends BaseAction {
        FindItemById(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    public class FindItemByName extends BaseAction {
        FindItemByName(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }
}