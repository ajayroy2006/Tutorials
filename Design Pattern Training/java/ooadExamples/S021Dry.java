public class BookRental {
    private String id;
    private String customerName;
    ...
}
public class BookRentals {
    private ArrayList<BookRental> rentals;
    public String getCustomerName(String rentalId) {
        int rentalIdx = getRentalIdxById(rentalId);
        return rentals.get(rentalIdx).getCustomerName();
    }
    public void deleteRental(String rentalId) {
        rentals.remove(getRentalIdxById(rentalId));
    }
    private int getRentalIdxById(String rentalId) {
        for (int i = 0; i < rentals.size(); i++) {
            BookRental rental = rentals.get(i);
            if (rental.getId().equals(rentalId)) {
                return i;
            }
        }
        throw new RentalNotFoundException();
    }
}
public class RentalNotFoundException extends RuntimeException {
    ...
}
