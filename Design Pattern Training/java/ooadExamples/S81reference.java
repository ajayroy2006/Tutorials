interface CopyMonitor {
    void updateProgress(int noBytesCopied, int sizeOfSource);
}
class FileCopier {
    CopyMonitor copyMonitor;
    FileCopier(CopyMonitor copyMonitor) {
        this.copyMonitor = copyMonitor;
    }
    void copyFile(File source, File target) {
        int sizeOfSource = (int)source.length();
        for (int i = 0; i < sizeOfSource; ) {
            //read n (<= 512) bytes from source.
            //write n bytes to target.
            i += n;
            copyMonitor.updateProgress(i, sizeOfSource);
        }
    }
}
class MainApp extends JFrame {
    ProgressBar progressBar;
    void main() {
        FileCopier fileCopier = new FileCopier(
            new CopyMonitor() {
                void updateProgress(int noBytesCopied, int sizeOfSource) {
                    updateProgressBar(noBytesCopied, sizeOfSource);
                }
            });
        fileCopier.copyFile(new File("f1.doc"), new File("f2.doc"));
    }
    void updateProgressBar(int noBytesCopied, int sizeOfSource) {
        progressBar.setPercentage(noBytesCopied*100/sizeOfSource);
    }
}
class TextApp {
    void main() {
        FileCopier fileCopier = new FileCopier(
            new CopyMonitor() {
                void updateProgress(int noBytesCopied, int sizeOfSource) {
                System.out.println(noBytesCopied*100/sizeOfSource);
            }
        });
        fileCopier.copyFile(new File("f1.doc"), new File("f2.doc"));
    }
}
/*In the above case, suppose that you need to develop another text mode
 * file copying application that will display a "*" for each 10% of
 * progress in its text console. What should you do?*/