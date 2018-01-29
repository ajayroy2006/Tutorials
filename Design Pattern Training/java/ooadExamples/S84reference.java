interface FontChangeListener {
	void onFontChanged(Font newFont);
}
class WordProcessorMainFrame extends JFrame {
	void onChangeFont() {
		ChooseFontDialog chooseFontDialog = new ChooseFontDialog(
			new FontChangeListener() {
				void onFontChanged(Font newFont) {
				previewWithFont(newFont);
			}
		});
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
	FontChangeListener fontChangeListener;
	Font selectedFont;
	ChooseFontDialog(FontChangeListener fontChangeListener) {
		this.fontChangeListener = fontChangeListener;
	}
	boolean showOnScreen() {
		...
	} 
	void onSelectedFontChange() {
		selectedFont = getSelectedFontFromUI();
		fontChangeListener.onFontChanged(selectedFont);
	}
	Font getSelectedFontFromUI() {
	...
	}
	Font getSelectedFont() {
		return selectedFont;
	}
}