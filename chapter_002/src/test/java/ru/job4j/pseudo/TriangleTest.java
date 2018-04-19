package ru.job4j.pseudo;

import org.junit.Test;
import pseudo.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class TriangleTest {
    /**
     * test output triangle
     */
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(
                new StringBuilder()
                        .append("   +   ")
                        .append("  +++  ")
                        .append(" +++++ ")
                        .append("+++++++")
                        .toString()
                )
        );
    }
}