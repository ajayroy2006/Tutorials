//Improve the code
class BookRentals {
    Vector rentals;
    int countRentals() {
        return rentals.size();
    }
    BookRental getRentalAt(int i) {
        return (BookRental)rentals.elementAt(i);
    }
    void printOverdueRentals() {
        int i;
        for (i=0; i<countRentals(); i++) {
            BookRental rental = getRentalAt(i);
            if (rental.isOverdue() &&
                      ... //Complex condition
               )
                System.out.println(rental.toString());
        }
    }
    int countOverdueRentals() {
        int i, count;
        count=0;
        for (i=0; i<countRentals(); i++)
            if (getRentalAt(i).isOverdue() &&
                      ... //Same complex condition
               )
                count++;
        return count;
    }
}