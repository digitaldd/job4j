package chess;

/**
 * Class Board Решение задачи Каркас шахматной доски
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.05.2018
 */
public class Board {
    public Figure[] figures = new Figure[32];

    /**
     * add figure in figures array
     *
     * @param figure - new figure
     */
    public void add(Figure figure) {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null) {
                figures[i] = figure;
                break;
            } else if (i == figures.length - 1) {
                System.out.println("Board is full");
                break;
            }
        }
    }

    /**
     * move figure out source in dest
     *
     * @param source where
     * @param dest   in
     */
    public void move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        if (check(source, dest)) {
            Figure figure = getFigure(source);
            Figure figure1 = figure.copy(dest);
            deleteFigure(figure);
            add(figure1);
        }
    }

    /**
     * checks exceptions
     *
     * @param source where
     * @param dest   in
     * @return true or false
     */
    private boolean check(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        return checkFigureFound(source) && !checkOccupiedWayException(source, dest);
    }

    /**
     * if figure is found - return true
     * else return false and exception
     *
     * @param source - cell, where figure must bu founded
     * @return true or false
     * @throws FigureNotFoundException msg Not Found
     */
    private boolean checkFigureFound(Cell source) throws FigureNotFoundException {
        boolean found = false;
        for (Figure figure : figures) {
            found = figure.toString().equals(source.toString());
            if (!found) {
                throw new FigureNotFoundException("Figure not found");
            } else {
                break;
            }
        }
        return found;
    }

    /**
     * if way is not vacancy, then exception OccupiedWayException
     *
     * @param source from
     * @param dest   in
     * @return true or false
     */
    private boolean checkOccupiedWayException(Cell source, Cell dest) throws OccupiedWayException, ImpossibleMoveException {
        boolean occupied = false;
        Figure figure = getFigure(source);
        Cell[] cells = figure.way(source, dest);
        for (Figure figure1 : figures) {
            for (Cell cell : cells) {
                if (figure1 != null && cell != null) {
                    occupied = figure1.toString().equals(cell.toString());
                }
                if (occupied) {
                    throw new OccupiedWayException("Occupied");
                }
            }
        }
        return occupied;
    }

    /**
     * get figure from figures
     *
     * @param source - figure cell
     * @return figure
     */
    private Figure getFigure(Cell source) {
        Figure figure = null;
        for (Figure figure1 : figures) {
            if (figure1 != null && figure1.toString().equals(source.toString())) {
                figure = figure1;
            }
        }
        return figure;
    }

    /**
     * delete figure from array figures
     *
     * @param figure for delete
     */
    private void deleteFigure(Figure figure) {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && figures[i].toString().equals(figure.toString())) {
                figures[i] = null;
            }
        }
    }
}