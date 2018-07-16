package ru.job4j.Set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleLinkedSetTest Решение задачи 2. Set реализованный на связном списке
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 13.07.2018
 */
public class SimpleLinkedSetTest {
    private SimpleLinkedSet sal = new SimpleLinkedSet();

    @Before
    public void beforeTest() {
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.add(3);
    }

    /**
     * check iterator
     */
    @Test
    public void whenArrayContainElementThenNextReturnElement() {
        Iterator it = sal.iterator();
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
    }
}