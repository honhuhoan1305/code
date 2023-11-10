package queens;

public class Queen {
    private int row;
    private int column;

    public Queen(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    public void move(int newRow) {
        this.row = newRow;
    }


    // check whether this Queen can attack the given Queen (q)
    public boolean isConflict(Queen q) {
        return this.row == q.getRow() ||
                this.column == q.getColumn() ||
                Math.abs(this.row - q.getRow()) == Math.abs(this.column - q.getColumn());
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}

