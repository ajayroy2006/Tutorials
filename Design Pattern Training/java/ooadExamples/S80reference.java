/* Problems	in the code
 * - circular references. DIP violated.
 *	 Code not reusable in a different enviroment
 * - SRP violated
 */
interface MessageDisplay {
	void showMessage(String msg);
}
class ZipEngine {
	void makeZip(String zipFilePath, String srcFilePaths[],
			MessageDisplay msgDisplay) {
		//create zip file at the path.
		...
		for (int i = 0; i < srcFilePaths.length; i++) {
			msgDisplay.showMessage("Zipping "+srcFilePaths[i]);
			//add the file srcFilePaths[i] into the zip file.
			...
		}
	}
}
class ZipMainFrame extends Frame {
	StatusBar sb;
	void makeZip() {
		String zipFilePath;
		String srcFilePaths[];
		//setup zipFilePath and srcFilePaths according to the UI.
		...
		ZipEngine ze = new ZipEngine();
		ze.makeZip(zipFilePath, srcFilePaths,
			new MessageDisplay() {
				void showMessage(String msg) {
				setStatusBarText(msg);
			}
		});
	}
	void setStatusBarText(String statusText) {
		sb.setText(statusText);
	}
}
class TextModeApp {
	void makeZip() {
		String zipFilePath;
		String srcFilePaths[];
		...
		ZipEngine ze = new ZipEngine();
		ze.makeZip(zipFilePath, srcFilePaths,
			new MessageDisplay() {
				void showMessage(String msg) {
				System.out.println(msg);
			}
		});
	}
}
