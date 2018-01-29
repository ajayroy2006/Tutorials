//There are two kinds of rentals i.e. Books and Movies. Improve the code
public class BookRental {
    private String bookTitle;
    private String author;
    private Date rentDate;
    private Date dueDate;
    private double rentalFee;
    public boolean isOverdue() {
        Date now=new Date();
        return dueDate.before(now);
    }
    public double getTotalFee() {
        return isOverdue() ? 1.2*rentalFee : rentalFee;
    }
}
public class MovieRental {
    private String movieTitle;
    private int classification;
    private Date rentDate;
    private Date dueDate;
    private double rentalFee;
    public boolean isOverdue() {
        Date now=new Date();
        return dueDate.before(now);
    }
    public double getTotalFee() {
        return isOverdue() ? 1.3*rentalFee : rentalFee;
    }
}
