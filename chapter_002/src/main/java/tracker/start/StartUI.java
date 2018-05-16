package tracker.start;

import tracker.Item;
import tracker.Tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Запуск программы.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.addAction(menu.new AddItem(0, "Add new item\n") {
            public void execute(Input input, Tracker tracker) {
                String name = input.ask("Please, enter the tasks's name:");
                String desc = input.ask("Please, enter the tasks's description:");
                tracker.add(new Item(name, desc));
            }
        });
        menu.addAction(menu.new ShowItems(1, "Show items\n") {
            public void execute(Input input, Tracker tracker) {
                for (Item item : tracker.getAll()) {
                    System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDesc()));
                }
            }
        });
        menu.addAction(menu.new EditItem(2, "Edit item\n") {
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Please, enter the task's id");
                if (tracker.findById(id) != null) {
                    String name = input.ask("Please, enter the tasks's name:");
                    String desc = input.ask("Please, enter the tasks's description:");
                    Item item = new Item();
                    item.setId(id);
                    item.setName(name);
                    item.setDesc(desc);
                    tracker.edit(item);
                } else {
                    System.out.println("Incorrect ID");
                }
            }
        });
        menu.addAction(menu.new DeleteItem(3, "Delete item\n") {
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Please, enter the item id for delete");
                if (tracker.findById(id) != null) {
                    tracker.delete(id);
                } else {
                    System.out.println("Not found");
                }
            }
        });
        menu.addAction(menu.new FindItemById(4, "Find item by ID\n") {
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Please, enter the task's id");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDesc()));
                } else {
                    System.out.println("Not found");
                }
            }
        });
        menu.addAction(menu.new FindItemByName(5, "Find item by name\n") {
            public void execute(Input input, Tracker tracker) {
                String name = input.ask("Please, enter the task's name");
                Item item = tracker.findByName(name);
                if (item != null) {
                    System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDesc()));
                } else {
                    System.out.println("Not found");
                }
            }
        });
        do {
            menu.show();
            menu.select(input.ask("select:", menu.actionsArray()));
        } while (!"y".equals(this.input.ask("Exit? (y)")));
    }
}