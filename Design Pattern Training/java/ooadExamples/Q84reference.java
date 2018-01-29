/* This is a word processor application. It can let the user select the
 * font. Before the user confirms to change the font, it will let the
 * user preview the effect of the change. The current code is shown below.
 * Point out the code smell. If we need to reuse the ChooseFontDialog
 * in a GUI application that doesn't support this preview functionality,
 * how should you change the code?
 */
class WordProcessorMainFrame extends JFrame {
    void onChangeFont() {
        ChooseFontDialog chooseFontDialog = new ChooseFontDialog(this);
        if (chooseFontDialog.showOnScreen()) {
            Font newFont = chooseFontDialog.getSelectedFont();
            //show the contents using this new font.
        } else {
            //show the contents using the existing font.
        }
    }
    void previewWithFont(Font font) {
        //show the contents using this preview font.
    }
}
class ChooseFontDialog extends JDialog {
    WordProcessorMainFrame mainFrame;
    Font selectedFont;
    ChooseFontDialog(WordProcessorMainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    boolean showOnScreen() {
        ...
    }
    void onSelectedFontChange() {
        selectedFont = getSelectedFontFromUI();
        mainFrame.previewWithFont(selectedFont);
    }
    Font getSelectedFontFromUI() {
        ...
    }
    Font getSelectedFont() {
        return selectedFont;
    }
}