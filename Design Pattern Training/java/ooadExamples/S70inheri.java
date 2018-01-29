interface GridListener {
    void onRowAppended();
    void onRowMoved(int existingIdx, int newIdx);
}
interface GridListenerNotifier {
    void notify(GridListener listener);
}
class Grid {
    GridListener listeners[];
    void appendRow() {
        //append a row at the end of the grid.
        notifyListeners(new GridListenerNotifier() {
            void notify(GridListener listener) {
                listener.onRowAppended();
            }
        });
    }
    void moveRow(final int existingIdx, final int newIdx) {
        //move the row.
        notifyListeners(new GridListenerNotifier() {
            void notify(GridListener listener) {
                listener.onRowMoved(existingIdx, newIdx);
            }
        });
    }
    void notifyListeners(GridListenerNotifier notifier) {
        for (int i = 0; i < listeners.length; i++) {
            notifier.notify(listeners[i]);
        }
    }
}
