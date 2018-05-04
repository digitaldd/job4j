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
        Cell[] cell;
        if (dest.getX() - source.getX() == dest.getY() - source.getY()) {
            cell = calculateWay(source, dest);
        } else {
            throw new ImpossibleMoveException("Impossible move (Bishop)");
        }
        return cell;
    }

    /**
     * @param source from
     * @param dest in
     * @return array with way (cells)
     */
    private Cell[] calculateWay(Cell source, Cell dest) {
        Cell[] cells = new Cell[dest.getX() - source.getX()];
        int countX = source.getX();
        int countY = source.getY();
        for (int i = 0; i != cells.length; i++) {
            countX++;
            countY++;
            cells[i] = new Cell(countX, countY);
        }
        return cells;
    }

    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}