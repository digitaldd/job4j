package list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertMatrix2List Решение задачи 3. Конвертация двумерного массива в ArrayList
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 15.05.2018
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}