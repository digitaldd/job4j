package pseudo;

/**
 * Class Triangle Решение задачи 4. Используя шаблон проектирования - стратегию
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 17.04.2018
 */
public class Triangle implements Shape {
    /**
     * create triangle
     *
     * @return triangle in string format
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append("  +++  ");
        pic.append(" +++++ ");
        pic.append("+++++++");
        return pic.toString();
    }
}