package list;

import java.util.List;

/**
 * Class ConvertList2Array Решение задачи 3. Конвертация ArrayList в двухмерный массив
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 15.05.2018
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = calc(list, rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer count : list) {
            array[i][j] = count;
            j++;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }

    /**
     * calculate cells
     */
    private int calc(List<Integer> list, int rows) {
        int count = 0;
        while ((list.size() + count) % rows != 0) {
            count++;
        }
        return (list.size() + count) / rows;
    }
}