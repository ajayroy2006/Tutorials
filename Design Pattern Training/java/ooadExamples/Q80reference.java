/*This is a small program handling zip files. The user can input the
 * path to the zip file such as c:\f.zip and the paths to the files
 * that he would like to add to the zip file such as c:\f1.doc,
 * c:\f2.doc and etc. in the main frame, then the program will compress
 * f1.doc and f2.doc and create f.zip. When it is compressing each file,
 * the status bar in the main frame will display the related message.
 * For example, when it is compressing c:\f2.doc,
 * the status bar will display "zipping c:\f2.zip".
 */

class ZipMainFrame extends Frame {
    StatusBar sb;
    void makeZip() {
        String zipFilePath;
        String srcFilePaths[];
        //setup zipFilePath and srcFilePaths according to the UI.
        ...
        ZipEngine ze = new ZipEngine();
        ze.makeZip(zipFilePath, srcFilePaths, this);
    }
    void setStatusBarText(String statusText) {
        sb.setText(statusText);
    }
}
class ZipEngine {
    void makeZip(String zipFilePath, String srcFilePaths[], ZipMainFrame f) {
        //create zip file at the path.
        ...
        for (int i = 0; i < srcFilePaths.length; i++) {
            f.setStatusBarText("Zipping "+srcFilePaths[i]);
            //add the file srcFilePaths[i] into the zip file.
            ...
        }
    }
}
