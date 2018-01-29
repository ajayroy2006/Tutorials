package csv;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
// A CSV file book.csv contains lots of information in format
// ISBN,Title,Price
// 123,Java,500
// 234,C#,700
// 345,OOAD,600
//
// Our goal is to find sum all the book prices.
// Also report number of valid and invalid books.
// The procedural code is given below.

public class ProceduralCode {
    static double currentBookPrice = 0;
    public static void main(String[] args) throws FileNotFoundException {
        double totalPrice = 0;
        int validRecords = 0, invalidRecords = 0;
        Scanner s = new Scanner(new File("src/csv/book.csv"));
        s.nextLine(); //Skip the header line
        while (s.hasNext()) {
            validatePrice(s.nextLine());
            if (currentBookPrice > 0) validRecords++;
            else invalidRecords++;
            totalPrice += currentBookPrice;
        }
        s.close();
        System.out.printf("Total price of all Books %f%n. Total Valid records - %d.    Total Invalid records - %d%n",
                totalPrice, validRecords, invalidRecords);
    }
    public static void validatePrice(String line) {
        currentBookPrice = 0;
        if ((line == null) || (line.length() == 0)) return;
        String[] items = line.split(",");
        if (items.length != 3) return;
        String price = items[2].trim();
        if (!Pattern.compile("[0-9]+").matcher(price).matches()) return;
        try {
            currentBookPrice = Double.valueOf(price);
        } catch (NumberFormatException ignore) {
        }
    }
}
