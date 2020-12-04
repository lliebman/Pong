import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;

    public Cell(Cell square) {
        this.x = square.x;
        this.y = square.y;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param direction
     * @return a new Square moved in the supplied Direction
     */
    public Cell moveTo(Direction direction) {
        switch (direction) {
            case North:
                return new Cell(x, y - 1);
            case East:
                return new Cell(x + 1, y);
            case South:
                return new Cell(x, y + 1);
            case West:
                return new Cell(x - 1, y);
            default:
                throw new RuntimeException(direction + " is not a known Direction");
        }
    }

    /**
     * @return true if this Square is in the bounds of the Garden, otherwise false.
     */
    public boolean inBounds() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell segment = (Cell) o;
        return x == segment.x &&
                y == segment.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
