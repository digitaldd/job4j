package ru.job4j.chess;

import chess.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BoardTest Решение задачи Каркас шахматной доски
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.05.2018
 */
public class BoardTest {
    Board board = new Board();

    /**
     * test add to array board.figures
     */
    @Test
    public void whenAddFigureThenFiguresContainFigure() {
        Bishop bishop = new Bishop(new Cell(0, 0));
        board.add(bishop);
        assertThat(board.figures[0], is(bishop));
    }

    /**
     * test board.move, if source not contain figure,then exception
     * FigureNotFoundException = true
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundThenException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Bishop bishop = new Bishop(new Cell(0, 0));
        board.add(bishop);
        Cell c = new Cell(1, 1);
        board.move(c, c);
    }

    /**
     * test OccupiedWayException = true
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWayIsOccupiedThenException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Bishop bishop = new Bishop(new Cell(0, 0));
        Bishop bishop1 = new Bishop(new Cell(1, 1));
        board.add(bishop);
        board.add(bishop1);
        Cell c = new Cell(2, 2);
        board.move(bishop.position, c);
    }

    /**
     * test ImpossibleMoveException = true
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveIsWrongThenException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Bishop bishop = new Bishop(new Cell(0, 0));
        board.add(bishop);
        Cell c = new Cell(4, 2);
        board.move(bishop.position, c);
    }

    /**
     * test move figure
     */
    @Test
    public void whenMoveFigureThenNewFigureCell() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Bishop bishop = new Bishop(new Cell(0, 0));
        board.add(bishop);
        Cell c = new Cell(2, 2);
        board.move(bishop.position, c);
        assertThat(board.figures[0].toString(), is(c.toString()));
    }
}