package chainOfResponsibility;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

// Count the type of program lines
public class QFormatLines {
    public static void main(String[] args) throws IOException {
        Path thisFile = FileSystems.getDefault().getPath("src/main/java/chainOfResponsibility/QFormatLines.java");
        Map<LineType, Long> lineCount = Files.lines(thisFile).peek(System.out::println).map(s -> s.trim())
                .map(QFormatLines::classify).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.printf("Saw %s lines", lineCount);
    }

    enum LineType {
        CODE, COMMENT, BLANK, IMPORT
        //Assume many more line types will be added later
    }
    public static LineType classify(String line) {
        if (line.startsWith("import")) return LineType.IMPORT;
        else if (line.isEmpty()) return LineType.BLANK;
        else if (line.startsWith("//")) return LineType.COMMENT;
        else return LineType.CODE;
    }
}
//The above code is bad because the the if else will keep growing.
//Improve this code