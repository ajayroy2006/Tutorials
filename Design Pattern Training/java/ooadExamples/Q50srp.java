class Account {
    final public int SAVING=0;
    final public int CHEQUE=1;
    final public int FIXED=2;
    private int accountType;

    private double balance;

    public double getInterestRate(...) { // Some method;
        ...
    }

    public Account(int accountType) {
        this.accountType=accountType;
    }

    public double calcInterest() {
        switch (accountType) {
        case SAVING:
            return balance*getInterestRate();
        case CHEQUE:
            return 0;
        case FIXED:
            return balance*(getInterestRate()+0.02);
        }
    }
}
