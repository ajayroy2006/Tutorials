class BookRental {
    String id;
    String customerName;
    ...
}
class BookRentals {
    private ArrayList<BookRental> rentals;
    public String getCustomerName(String rentalId) {
        for (int i = 0; i < rentals.size(); i++) {
            BookRental rental = rentals.get(i);
            if (rental.getId().equals(rentalId)) {
                return rental.getCustomerName();
            }
        }
        throw new RentalNotFoundException();
    }
    public void deleteRental(String rentalId) {
        for (int i = 0; i < rentals.size(); i++) {
            BookRental rental = rentals.get(i);
            if (rental.getId().equals(rentalId)) {
                rentals.remove(i);
                return;
            }
        }
        throw new RentalNotFoundException();
    }
}
class RentalNotFoundException extends RuntimeException {
    ...
}
