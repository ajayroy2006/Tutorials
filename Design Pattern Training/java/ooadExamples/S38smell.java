abstract class PaymentUI {
	JTextField paymentDate;
	PaymentUI(JTextField paymentDate) {
		...
	}
	void displayPaymentDate(Payment payment) {
		paymentDate.setText(
		new SimpleDateFormat().format(payment.getPaymentDate()));
	}
	Date makePaymentDate() {
		//parse the text in paymentDate and return a date;
	}
	abstract boolean tryToDisplayPayment(Payment payment);
	abstract Payment makePayment();
	abstract JPanel getPanel();
}
abstract class RealPaymentUI extends PaymentUI {
	JTextField actualPayment;
	JTextField discount;
	RealPaymentUI(JTextField paymentDate) {
		super(paymentDate);
		actualPayment = new JTextField();
		discount = new JTextField();
	}
	void displayActualPayment(RealPayment payment) {
		actualPayment.setText(Integer.toString(payment.getActualPayment()));
	}
	void displayDiscount(RealPayment payment) {
		discount.setText(Integer.toString(payment.getDiscount()));
	}
	int makeActualPayment() {
		//parse the text in actualPayment and return an int;
	}
	int makeDiscount() {
		//parse the text in discount and return an int;
	}
}
class TTPaymentUI extends RealPaymentUI {
	JPanel panel;
	JTextField bankName;
	TTPaymentUI(JTextField paymentDate) {
		super(paymentDate);
		panel = ...;
		bankName = ...;
		//add bankName, actualPayment, discount to panel.
	}
	boolean tryToDisplayPayment(Payment payment) {
		if (payment instanceof TTPayment) {
			TTPayment ttpayment = (TTPayment)payment;
			displayPaymentDate(payment);
			displayActualPayment(ttpayment);
			displayDiscount(ttpayment);
			bankName.setText(ttpayment.getBankName());
			return true;
		}
		return false;
	}
	Payment makePayment() {
		return new TTPayment(makePaymentDate(),
			makeActualPayment(),
			makeDiscount(),
			bankName.getText());
	}
	String toString() {
		return "TT";
	}
	JPanel getPanel() {
		return panel;
	}
}
class FOCPaymentUI extends PaymentUI {
	...
}
class ChequePaymentUI extends RealPaymentUI {
	...
}
class EditPaymentDialog extends JDialog {
	Payment newPaymentToReturn;
	JPanel sharedPaymentDetails;
	JTextField paymentDate;
	JComboBox paymentType;
	PaymentUI paymentUIs[];
	EditPaymentDialog() {
		setupComponents();
	}
	void setupComponents() {
		setupComponentsSharedByAllPaymentTypes();
		setupPaymentUIs();
		setupPaymentTypeIndicator();
		setupComponentsUniqueToEachPaymentType();
	}
	void setupComponentsSharedByAllPaymentTypes() {
		paymentDate = new JTextField();
		sharedPaymentDetails = new JPanel();
		sharedPaymentDetails.add(paymentDate);
		Container contentPane = getContentPane();
		contentPane.add(sharedPaymentDetails, BorderLayout.NORTH);
	}
	void setupPaymentUIs() {
		paymentUIs[0] = new TTPaymentUI(paymentDate);
		paymentUIs[1] = new FOCPaymentUI(paymentDate);
		paymentUIs[2] = new ChequeaymentUI(paymentDate);
		...
	}
	void setupPaymentTypeIndicator() {
		paymentType = new JComboBox(paymentUIs);
		sharedPaymentDetails.add(paymentType);
	}
	void setupComponentsUniqueToEachPaymentType() {
		JPanel uniquePaymentDetails = new JPanel();
		uniquePaymentDetails.setLayout(new CardLayout());
		for (int i = 0; i < paymentUIs.length; i++) {
			PaymentUI UI = paymentUIs[i];
			uniquePaymentDetails.add(UI.getPanel(), UI.toString());
		}
		Container contentPane = getContentPane();
		contentPane.add(uniquePaymentDetails, BorderLayout.CENTER);
	}
	Payment editPayment(Payment payment) {
		displayPayment(payment);
		setVisible(true);
		return newPaymentToReturn;
	}
	void displayPayment(Payment payment) {
		for (int i = 0; i < paymentUIs.length; i++) {
			PaymentUI UI = paymentUIs[i];
			if (UI.tryToDisplayPayment(payment)) {
				paymentType.setSelectedItem(UI);
			}
		}
	}
	void onOK() {
		newPaymentToReturn = makePayment();
		dispose();
	}
	Payment makePayment() {
		PaymentUI UI = (PaymentUI)paymentType.getSelectedItem();
		return UI.makePayment();
	}
}