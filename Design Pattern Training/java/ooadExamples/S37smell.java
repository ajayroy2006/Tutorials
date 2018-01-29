abstract class Payment {
	Date paymentDate;
	abstract int getNominalPayment();
}
class FreeOfCharge extends Payment {
	int amountWaived;
	int getNominalPayment() {
		return amountWaived;
	}
}
class RealPayment extends Payment {
	int actualPayment;
	int discount;
	int getNominalPayment() {
		return actualPayment+discount;
	}
}
class CashPayment extends RealPayment {
}
class BankPayment extends RealPayment {
	String bankName;
	String getBankName() {
		return bankName;
	}
}
class TelegraphicTransfer extends BankPayment {
}
class ChequePayment extends BankPayment {
	String chequeNumber;
}
class CreditCardPayment extends BankPayment {
	String cardType;
	String cardHolderName;
	String cardNumber;
	Date expiryDate;
}