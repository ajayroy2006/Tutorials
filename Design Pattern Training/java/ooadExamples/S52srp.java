abstract class Payment {
    int units;
    double rate;
    final double TAX_RATE = 0.1;
    abstract double getPreTaxedAmount();
    abstract double getTaxRate();
    double getBillableAmount() {
        return getPreTaxedAmount() * (1 + getTaxRate());
    }
    double getNormalAmount() {
        return units * rate;
    }
}
class NormalPayment extends Payment {
    double getPreTaxedAmount() {
        return getNormalAmount();
    }
    double getTaxRate() {
        return TAX_RATE;
    }
}
class PaymentForSeniorCitizen extends Payment {
    double getPreTaxedAmount() {
        return getNormalAmount()*0.8;
    }
    double getTaxRate() {
        return TAX_RATE - 0.05;
    }
}
