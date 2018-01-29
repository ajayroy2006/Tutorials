package csv;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.google.common.base.Function;
import com.google.common.base.Supplier;

class AccumulateBookDetails {
    double totalPrice;
    int validRecords, invalidRecords;
    public void process(Supplier<String> input, Function<String, Double> extractPrice) {
        String next = input.get(); //Skip header
        while (!(next = input.get()).isEmpty()) {
            double price = extractPrice.apply(next);
            if (price > 0) validRecords++;
            else invalidRecords++;
            totalPrice += price;
        }
    }
}

class ReadEachLineOfFile {
    Scanner s;
    public ReadEachLineOfFile() {
        try {
            s = new Scanner(new File("src/csv/book.csv"));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
    public String nextLine() {
        if (s == null) return "";
        if (!s.hasNext()) {
            s.close();
            return "";
        }
        return s.nextLine();
    }
}

class BookRecord {
    final String isbn, title, price;
    private static BookRecord EMPTY = new BookRecord("", "", "");
    public BookRecord(String isbn, String title, String price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }
    public static BookRecord createFrom(String line) {
        if ((line == null) || (line.length() == 0)) return EMPTY;
        String[] items = line.split(",");
        if (items.length != 3) return EMPTY;
        return new BookRecord(items[0], items[1], items[2]);
    }
    public static double getValidPrice(BookRecord b) {
        double r = 0;
        if (Pattern.compile("[0-9]+").matcher(b.price).matches()) try {
            r = Double.valueOf(b.price);
        } catch (NumberFormatException ignore) {
        }
        return r;
    }
}

public class OOFunctionalCode {
    public static void main(String[] args) throws FileNotFoundException {
        AccumulateBookDetails acc = new AccumulateBookDetails();
        final ReadEachLineOfFile rin = new ReadEachLineOfFile();
        acc.process(new Supplier<String>() {
            @Override
            public String get() {
                return rin.nextLine();
            }
        }, new Function<String, Double>() {
            @Override
            public Double apply(String line) {
                return BookRecord.getValidPrice(BookRecord.createFrom(line));
            }
        }); //This syntax will be simple in Java 8
        System.out.printf("Total price of all Books %f%n. Total Valid records - %d.    Total Invalid records - %d%n",
                acc.totalPrice, acc.validRecords, acc.invalidRecords);
    }
}
// The above code is better designed because it can easily accomodate 
// new features like take sum of costliest 3 books only.