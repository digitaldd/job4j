package chess;

/**
 * Class Bishop Решение задачи Каркас шахматной доски
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.05.2018
 */
public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (dest.getX() - source.getX() != dest.getY() - source.getY()) {
            throw new ImpossibleMoveException("Impossible move (Bishop)");
        }
        return calculateWay(source, dest);
    }

    /**
     * @param source from
     * @param dest   in
     * @return array with way (cells)
     */
    private Cell[] calculateWay(Cell source, Cell dest) {
        Cell[] cells = new Cell[Math.abs(dest.getX() - source.getX())];
        int countX = source.getX();
        int countY = source.getY();
        for (int i = 0; i != cells.length; i++) {
            countX = dest.getX() > countX ? countX + 1 : countX - 1;
            countY = dest.getY() > countY ? countY + 1 : countY - 1;
            cells[i] = new Cell(countX, countY);
        }
        return cells;
    }

    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}