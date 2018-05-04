package chess;

/**
 * Class Figure Решение задачи Каркас шахматной доски
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 04.05.2018
 */
public abstract class Figure {
    public final Cell position;

    Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);

    @Override
    public String toString() {
        return String.valueOf(this.position);
    }
}