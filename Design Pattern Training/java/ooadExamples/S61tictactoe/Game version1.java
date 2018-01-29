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
        return leftDiagnalFilledWithSameElements()
                || rightDiagonalFilledWithSameElements()
                || anyRowFilledWithSameElements()
                || anyColumnFilledWithSameElements()
                || allElementsOfBoardAreOccupied();
    }
    private boolean allElementsOfBoardAreOccupied() {
        return !board.values().contains(EMPTY);
    }
    private boolean anyRowFilledWithSameElements() {
        for (int r = 0; r < SIZE; ++r)
            if (areMapValuesEqualButNotZero(board.row(r)))
                return true;
        return false;
    }
    private boolean anyColumnFilledWithSameElements() {
        for (int c = 0; c < SIZE; ++c)
            if (areMapValuesEqualButNotZero(board.column(c)))
                return true;
        return false;
    }
    private boolean rightDiagonalFilledWithSameElements() {
        Set<Integer> v = new HashSet<Integer>();
        for (int i = 0; i < SIZE; ++i)
            v.add(board.get(i, SIZE - i - 1));
        return ensureOneNonZeroValuePresentInSet(v);
    }
    private boolean leftDiagnalFilledWithSameElements() {
        Set<Integer> v = new HashSet<Integer>();
        for (int i = 0; i < SIZE; ++i)
            v.add(board.get(i, i));
        return ensureOneNonZeroValuePresentInSet(v);
    }
    private static boolean ensureOneNonZeroValuePresentInSet(
            Set<Integer> values) {
        return !values.contains(EMPTY) && (values.size() == 1);
    }
    private static boolean areMapValuesEqualButNotZero(
            Map<Integer, Integer> mv) {
        return ensureOneNonZeroValuePresentInSet(new HashSet<Integer>(
                mv.values()));
    }
    @Override
    public String toString() {
        return "Game [board=" + board + "]";
    }
}
