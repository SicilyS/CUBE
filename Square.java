/**
 * One square in the Sudoku grid.
 *
 * @author Peter Drake
 */
public class Square {

    /** 1 through 9, or 0 if this square doesn't have a value yet. */
    int value;

    /** Other squares in the same row with this one. */
    Square[] row;

    /** Other squares in the same column with this one. */
    Square[] column;

    /** Other squares in the same 3x3 block with this one. */
    Square[] block;

    public Square() {
        this.value = 0;
        this.row = new Square[8];
        this.column = new Square[8];
        this.block = new Square[8];
    }

    public Square(char c) {
        if (c == '.') {
            this.value = 0;
        } else {
            this.value = Character.getNumericValue(c);
        }

        this.row = new Square[8];
        this.column = new Square[8];
        this.block = new Square[8];

    }

}