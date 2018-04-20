package tracker;

import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private static final Random RN = new Random();
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private String[] all;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * edit item
     *
     * @param fresh new item
     */
    public void edit(Item fresh) {
        for (int i = 0; i != items.length; i++) {
            Item item = items[i];
            if (item != null && item.getId().equals(fresh.getId())) {
                items[i] = fresh;
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
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * replace object in array
     *
     * @param id   - object id for replace
     * @param item new object
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = item;
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
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                this.position--;
                System.arraycopy(this.items, i + 1, this.items, i, items.length - 1 - i);
                this.items[items.length - 1] = null;
                break;
            }

        }

    }

    /**
     * find all element from array without null
     *
     * @return new array without null
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
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