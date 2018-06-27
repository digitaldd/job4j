package deps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Class Deps Решение задачи: Отсортировать департаменты
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 07.06.2018
 */
public class Deps {

    /**
     * Ascending sorting
     *
     * @param list - list with departments
     * @return sorted list
     */
    public List<String> makeSortAscending(List<String> list) {
        return new ArrayList<String>(new TreeSet<>(list));
    }

    /**
     * Descending sorting
     *
     * @param list - Ascending sorted list
     * @return sorted list
     */
    public List<String> makeSortDescending(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length = Integer.compare(o1.length(), o2.length());
                int result = 0;
                for (int i = 0; i < (o1.length() < o2.length() ? o1.length() : o2.length()); i++) {
                    if (result == 0 && length >= result) {
                        result = Character.compare(o2.charAt(i), o1.charAt(i));
                    } else {
                        break;
                    }
                }
                return length == -1 ? length : result;
            }
        });
        return list;
    }

    /**
     * add upper departments
     *
     * @param list - list with departments without sort
     * @return - new list with upper level departments
     */
    public List<String> createNewList(List<String> list) {
        List<String> list2 = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            String result = list.get(i);
            result = result.substring(0, result.lastIndexOf("\\"));
            i++;
            while (!list2.contains(result)) {
                list2.add(result);
                if (result.contains("\\")) {
                    result = result.substring(0, result.lastIndexOf("\\"));
                } else {
                    i++;
                }
            }
        }
        return list2;
    }
}