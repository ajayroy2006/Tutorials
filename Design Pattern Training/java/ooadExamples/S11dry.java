//There are two kinds of rentals i.e. Books and Movies.
public abstract class Rental {
    private Date rentDate;
    private Date dueDate;
    private double rentalFee;
    protected abstract double getOverduePenaltyRate();
    public boolean isOverdue() {
        Date now=new Date();
        return dueDate.before(now);
    }
    public double getTotalFee() {
        return isOverdue() ? getOverduePenaltyRate()*rentalFee : rentalFee;
    }
}
public class BookRental extends Rental {
    private String bookTitle;
    private String author;
    private static double PENALTY_RATE=1.2;
    protected double getOverduePenaltyRate() {
        return PENALTY_RATE;
    }
}
public class MovieRental extends Rental {
    private String movieTitle;
    private int classification;
    private static double PENALTY_RATE=1.3;
    protected double getOverduePenaltyRate() {
        return PENALTY_RATE;
    }
}
