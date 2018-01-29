//Remove the duplication for scanning the listeners array
interface GridListener {
    void onRowAppended();
    void onRowMoved(int existingIdx, int newIdx);
}
class Grid {
    GridListener listeners[];
    void appendRow() {
        //append a row at the end of the grid.
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].onRowAppended();
        }
    }
    void moveRow(int existingIdx, int newIdx) {
        //move the row.
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].onRowMoved(existingIdx, newIdx);
        }
    }
}
