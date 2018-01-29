package tictactoe;
import static tictactoe.TableChecker.allElementsNonZero;
import static tictactoe.TableChecker.anyColumnFilledWithSameElements;
import static tictactoe.TableChecker.anyRowFilledWithSameElements;
import static tictactoe.TableChecker.leftDiagnalFilledWithSameElements;
import static tictactoe.TableChecker.rightDiagonalFilledWithSameElements;
import java.util.Collections;
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
        return leftDiagnalFilledWithSameElements(board)
                || rightDiagonalFilledWithSameElements(board)
                || anyRowFilledWithSameElements(board)
                || anyColumnFilledWithSameElements(board)
                || allElementsNonZero(board);
    }
    @Override
    public String toString() {
        return "Game [board=" + board + "]";
    }
}

class TableChecker {
    private static boolean areMapValuesEqualButNotZero(
            Map<Integer, Integer> mv) {
        return TableChecker
                .ensureOneNonZeroValuePresentInSet(new HashSet<Integer>(
                        mv.values()));
    }
    private static boolean ensureOneNonZeroValuePresentInSet(
            Set<Integer> values) {
        return !values.contains(Game.EMPTY) && (values.size() == 1);
    }
    static boolean leftDiagnalFilledWithSameElements(
            Table<Integer, Integer, Integer> t) {
        Set<Integer> v = new HashSet<Integer>();
        for (int i = 0; t.containsRow(i) && t.containsColumn(i); ++i)
            v.add(t.get(i, i));
        return ensureOneNonZeroValuePresentInSet(v);
    }
    static boolean rightDiagonalFilledWithSameElements(
            Table<Integer, Integer, Integer> t) {
        Set<Integer> v = new HashSet<Integer>();
        int c = Collections.max(t.columnKeySet());
        for (int r = 0; t.containsRow(r) && t.containsColumn(c);)
            v.add(t.get(r++, c--));
        return ensureOneNonZeroValuePresentInSet(v);
    }
    static boolean anyColumnFilledWithSameElements(
            Table<Integer, Integer, Integer> t) {
        for (int c : t.columnKeySet())
            if (areMapValuesEqualButNotZero(t.column(c)))
                return true;
        return false;
    }
    static boolean anyRowFilledWithSameElements(
            Table<Integer, Integer, Integer> t) {
        for (int r : t.rowKeySet())
            if (areMapValuesEqualButNotZero(t.row(r)))
                return true;
        return false;
    }
    static boolean allElementsNonZero(
            Table<Integer, Integer, Integer> t) {
        return !t.values().contains(0);
    }
}
