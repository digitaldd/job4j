package chess;

public class OccupiedWayException extends Exception {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}