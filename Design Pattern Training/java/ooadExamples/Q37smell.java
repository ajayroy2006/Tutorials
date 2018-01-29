//Improve the code
class Payment {
    final static String FOC = "FOC"; //free of charge.
    final static String TT = "TT"; //paid by telegraphic transfer.
    final static String CHEQUE = "Cheque"; //paid by cheque.
    final static String CREDIT_CARD = "CreditCard"; //paid by credit card.
    final static String CASH = "Cash"; //paid by cash.
    //type of payment. Must be one of the above constant.
    String paymentType;

    Date paymentDate; //if FOC, the date the fee is waived.
    int actualPayment; //if FOC, it is 0.
    int discount; //if FOC, the amount that is waived.
    String bankName; //if it is by TT, cheque or credit card.
    String chequeNumber; //if it is by cheque.

    //if it is by credit card.
    String creditCardType;
    String creditCardHolderName;
    String creditCardNumber;
    Date creditCardExpiryDate;

    int getNominalPayment() {
        return actualPayment+discount;
    }

    String getBankName() {
        if (paymentType.equals(TT) || paymentType.equals(CHEQUE) ||
            paymentType.equals(CREDIT_CARD)) {
            return bankName;
        }
        else
            throw new RuntimeException(
                "bank name is undefined for this payment type");
    }
}
