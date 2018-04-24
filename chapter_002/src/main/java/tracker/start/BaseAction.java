package tracker.start;

/**
 * Class ValidateInput Решение задачи 1. Рефакторинг - Перенести общие методы в абстрактный класс
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 24.04.2018
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    /**
     * @param key  - number of action
     * @param name - name of action
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}