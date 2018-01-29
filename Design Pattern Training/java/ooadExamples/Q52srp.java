class NormalPayment {
    int units;
    double rate;
    final double TAX_RATE = 0.1;
    double getBillableAmount() {
        double baseAmt = units * rate;
        double tax = baseAmt * TAX_RATE;
        return baseAmt + tax;
    }
}
class PaymentForSeniorCitizen {
    int units;
    double rate;
    final double TAX_RATE = 0.1;
    double getBillableAmount() {
        double baseAmt = units * rate * 0.8;
        double tax = baseAmt * (TAX_RATE - 0.05) ;
        return baseAmt + tax;
    }
}
