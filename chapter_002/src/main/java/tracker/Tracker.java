package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private static final Random RN = new Random();
    /**
     * Массив для хранение заявок.
     */
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);

        return item;
    }

    /**
     * edit item
     *
     * @param fresh new item
     */
    public void edit(Item fresh) {
        for (Item item : items) {
            if (item != null && item.getId().equals(fresh.getId())) {
                item.setName(fresh.getName());
                item.setDesc(fresh.getDesc());
                break;
            }
        }
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * get all elements of items array
     *
     * @return items copy
     */
    public List<Item> getAll() {
        return items;
    }

    /**
     * replace object in array
     *
     * @param id   - object id for replace
     * @param item new object
     */
    public void replace(String id, Item item) {
        for (Item item1 : items) {
            if (item1 != null && item1.getId().equals(id)) {
                item1.setDesc(item.getDesc());
                item1.setName(item.getName());
                break;
            }
        }
    }

    /**
     * delete element from array (offset)
     *
     * @param id of the element for delete with offset
     */
    public void delete(String id) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                items.remove(item);
                break;
            }
        }
    }

    /**
     * find all element from array without null
     *
     * @return new array without null
     */
    public List<Item> findAll() {
        List<Item> li = new ArrayList<>();
        for (Item item : items) {
            if (item != null) {
                li.add(item);
            }
        }
        return li;
    }

    /**
     * find object in array by name (field)
     *
     * @param key - name
     * @return object with name (key)
     */
    public Item findByName(String key) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * find object in array by ID (field)
     *
     * @param id - object ID
     * @return object with ID (id)
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}