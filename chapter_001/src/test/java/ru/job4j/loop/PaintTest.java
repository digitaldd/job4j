package ru.job4j.loop;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.StringJoiner;
import org.junit.Test;

/**
 * Class Paint Решение задачи 4.4. Построить пирамиду в псевдографике
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 10.04.2018
 */
public class PaintTest {

    /**
     * test right side of pyramid
     */
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
        assertThat(rst,
                is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("^   ")
                        .add("^^  ")
                        .add("^^^ ")
                        .add("^^^^")
                        .toString()
                )
        );
    }

    /**
     * test left side of pyramid
     */
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }

    /**
     * test pyramid complete
     */
    @Test
    public void whenPyramidComplete() {
        Paint paint = new Paint();
        String pyr = paint.pyramid(4);
        assertThat(pyr,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }
}