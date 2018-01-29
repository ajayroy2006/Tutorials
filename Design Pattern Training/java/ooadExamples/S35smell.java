interface RentalProcessor {
	void process(BookRental rental);
}
class BookRentals {
	Vector rentals;
	int countRentals() {
		return rentals.size();
	}
	BookRental getRentalAt(int i) {
		return (BookRental)rentals.elementAt(i);
	}
	void processOverdueRentals(RentalProcessor processor) {
		for (int i=0; i<countRentals(); i++) {
			BookRental rental = getRentalAt(i);
			if (rental.isOverdue() &&
				... //A complex condition
			   )
				processor.process(rental);
		}
	}
	void printOverdueRentals() {
		processOverdueRentals(new RentalProcessor() {
			void process(BookRental rental) {
				System.out.println(rental.toString());
			}
		});
	}
	int countOverdueRentals() {
		class CountRentals implements RentalProcessor {
			int count;
			void process(BookRental rental) {
				count++;
			}
		}
		CountRentals cr=new CountRentals();
		processOverdueRentals(cr);
		return cr.count;
	}
}