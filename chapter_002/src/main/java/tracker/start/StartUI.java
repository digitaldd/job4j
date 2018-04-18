package tracker.start;

import tracker.Item;
import tracker.Tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * show all items
     */
    private static final String SHOW = "1";
    /**
     * edit item
     */
    private static final String EDIT = "2";
    /**
     * delete item
     */
    private static final String DELETE = "3";
    /**
     * Find item by id
     */
    private static final String FIND_BY_ID = "4";
    /**
     * find item by name
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Add new item --------------");
        String name = this.input.ask("Enter a name of item :");
        String desc = this.input.ask("Enter description of item :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New item with getId : " + item.getId() + "-----------");
    }

    /**
     * show item in console
     */
    private void showItem() {
        System.out.println("------------ Show Items --------------");
        for (Item item : tracker.findAll()) {
            System.out.println("ID = " + item.getId() + ", name = " + item.getName() +
                    ", description = " + item.getDesc());
        }
    }

    /**
     * edit fields of item - name or description
     */
    private void editItem() {
        System.out.println("------------ Edit Item --------------");
        String userId = input.ask("Enter item id:");
        if (tracker.findById(userId) != null) {
            System.out.println("Select action: 1 - change Name, 2 - change Description");
            String select = input.ask("Select action:");
            if (Integer.parseInt(select) == 1) {
                Item item = tracker.findById(userId);
                String name = input.ask("Enter correct name:");
                item.setName(name);
                tracker.replace(userId, item);
                System.out.println("Edit name done");
            } else if (Integer.parseInt(select) == 2) {
                Item item = tracker.findById(userId);
                String desc = input.ask("Enter correct description:");
                item.setDesc(desc);
                tracker.replace(userId, item);
                System.out.println("Edit description done");
            } else {
                System.out.println("Incorrect action");
            }
        } else {
            System.out.println("Incorrect ID");
        }
    }

    /**
     * delete item
     */
    private void deleteItem() {
        System.out.println("------------ Delete Items --------------");
        String userId = input.ask("Enter item id for delete:");
        if (tracker.findById(userId) != null) {
            tracker.delete(userId);
            System.out.println("Item " + userId + " was deleted");
        } else {
            System.out.println("Incorrect ID");
        }
    }

    /**
     * find item by id
     */
    private void findItemById() {
        System.out.println("------------ Find item by ID --------------");
        String userId = input.ask("Enter item id:");
        if (tracker.findById(userId) != null) {
            Item item = tracker.findById(userId);
            System.out.println("ID = " + item.getId() + ", name = " + item.getName() +
                    ", description = " + item.getDesc());
        } else {
            System.out.println("Incorrect ID");
        }
    }

    /**
     * find item by name
     */
    private void findItemByName() {
        System.out.println("------------ Find item by Name --------------");
        String key = input.ask("Enter item Name:");
        if (tracker.findByName(key) != null) {
            Item item = tracker.findByName(key);
            System.out.println("ID = " + item.getId() + ", name = " + item.getName() +
                    ", description = " + item.getDesc());
        } else {
            System.out.println("Incorrect Name");
        }
    }

    /**
     * menu in console
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 - Add new item.");
        System.out.println("1 - Show all items.");
        System.out.println("2 - Edit item.");
        System.out.println("3 - Delete item.");
        System.out.println("4 - Find item by id.");
        System.out.println("5 - Find item by name.");
        System.out.println("6 - Exit.");
    }
}