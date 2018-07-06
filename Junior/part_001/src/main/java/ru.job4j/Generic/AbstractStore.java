package ru.job4j.Generic;

/**
 * Class AbstractStore Решение задачи 5.2.2. Реализовать Store<T extends Base>
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 03.07.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    public AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean replace = false;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (simpleArray.get(i) != null && simpleArray.get(i).getId().equals(id)) {
                simpleArray.set(i, (T) model);
                replace = true;
                break;
            }
        }
        return replace;
    }

    @Override
    public boolean delete(String id) {
        boolean delete = false;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (simpleArray.get(i) != null && simpleArray.get(i).getId().equals(id)) {
                simpleArray.delete(i);
                delete = true;
                break;
            }
        }
        return delete;
    }

    @Override
    public T findById(String id) {
        T value = null;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                value = simpleArray.get(i);
                break;
            }
        }
        return value;
    }
}