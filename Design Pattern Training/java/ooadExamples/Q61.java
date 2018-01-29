package tictactoe;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Game {
    public static final int SIZE = 3, EMPTY = 0, CROSS = 1,
            CIRCLE = 2;
    private final Table<Integer, Integer, Integer> board = HashBasedTable
            .create(SIZE, SIZE);
    public Game() {
        for (int r = 0; r < SIZE; ++r)
            for (int c = 0; c < SIZE; ++c)
                board.put(r, c, EMPTY);
    }
    public void putX(int r, int c) {
        board.put(r, c, CROSS);
    }
    public void putO(int r, int c) {
        board.put(r, c, CIRCLE);
    }
    public boolean isEmpty(int r, int c) {
        return board.get(r, c) == EMPTY;
    }
    public boolean isOver() {
		/* The game is over, if any of the following condition is true
		   - The board is filled
		   - Any row is filled with same element
		   - Any column is filled with same element
		   - The left or right diagonal is filled with same element.
		*/
    }
}
//Complete the function isOver using functional programming techniques.
//The documentation of Table class is present in Google Guava library.
