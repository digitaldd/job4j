package ru.job4j.deps;

import deps.Deps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class DepsTest Решение задачи: Отсортировать департаменты
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 07.06.2018
 */
public class DepsTest {

    /**
     * not a test, just create list for testing
     */
    public List<String> createList() {
        List<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        return list;
    }

    /**
     * test - make sure, that upper departments is added
     */
    @Test
    public void whenNeedAddUpperDeps() {
        List<String> list2 = new ArrayList<>();
        list2.add("K1\\SK1");
        list2.add("K1\\SK2");
        list2.add("K1\\SK1\\SSK1");
        list2.add("K1\\SK1\\SSK2");
        list2.add("K2");
        list2.add("K2\\SK1\\SSK1");
        list2.add("K2\\SK1\\SSK2");
        list2.add("K1");
        list2.add("K2\\SK1");
        Deps deps = new Deps();
        assertThat(deps.createNewList(createList()), is(list2));
    }

    /**
     * test - Ascending sorting
     */
    @Test
    public void whenSortAscending() {
        List<String> list2 = new ArrayList<>();
        list2.add("K1");
        list2.add("K1\\SK1");
        list2.add("K1\\SK1\\SSK1");
        list2.add("K1\\SK1\\SSK2");
        list2.add("K1\\SK2");
        list2.add("K2");
        list2.add("K2\\SK1");
        list2.add("K2\\SK1\\SSK1");
        list2.add("K2\\SK1\\SSK2");
        Deps deps = new Deps();
        assertThat(deps.makeSortAscending(deps.createNewList(createList())), is(list2));
    }

    /**
     * test - Descending sorting - before need make Ascending sort
     */
    @Test
    public void whenSortDescending() {
        List<String> list2 = new ArrayList<>();
        list2.add("K2");
        list2.add("K2\\SK1");
        list2.add("K2\\SK1\\SSK2");
        list2.add("K2\\SK1\\SSK1");
        list2.add("K1");
        list2.add("K1\\SK2");
        list2.add("K1\\SK1");
        list2.add("K1\\SK1\\SSK2");
        list2.add("K1\\SK1\\SSK1");
        Deps deps = new Deps();
        assertThat(deps.makeSortDescending(deps.makeSortAscending(deps.createNewList(createList()))), is(list2));
    }
}