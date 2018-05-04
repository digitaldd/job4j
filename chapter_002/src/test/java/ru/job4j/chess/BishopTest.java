package ru.job4j.chess;

import chess.Bishop;
import chess.Cell;
import chess.ImpossibleMoveException;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BishopTest Решение задачи Каркас шахматной доски
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.05.2018
 */
public class BishopTest {
    /**
     * wrong path of the figure = exception
     *
     * @throws ImpossibleMoveException - msg Error
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenFigureWayWrongThenException() throws ImpossibleMoveException {
        Cell c = new Cell(1, 1);
        Cell c2 = new Cell(4, 2);
        Bishop bishop = new Bishop(c);
        bishop.way(c, c2);
    }

    /**
     * test build and return array with correct way
     *
     * @throws ImpossibleMoveException - msg Error
     */
    @Test
    public void whenFigureWayCorrectThenReturnArrayWithWay() throws ImpossibleMoveException {
        Cell c = new Cell(2, 2);
        Cell c1 = new Cell(3, 3);
        Cell c2 = new Cell(4, 4);
        Bishop bishop = new Bishop(c);
        Cell[] cell = {c1, c2};
        assertThat(Arrays.toString(bishop.way(c, c2)).equals(Arrays.toString(cell)), is(true));
    }
}