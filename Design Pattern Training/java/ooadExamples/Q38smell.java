//Improve the code
class EditPaymentDialog extends JDialog {
    Payment newPayment; //new payment to be returned.
    JPanel sharedPaymentDetails;
    JPanel uniquePaymentDetails;
    JTextField paymentDate;
    JComboBox paymentType;
    JTextField discountForFOC;
    JTextField bankNameForTT;
    JTextField actualAmountForTT;
    JTextField discountForTT;
    JTextField bankNameForCheque;
    JTextField chequeNumberForCheque;
    JTextField actualAmountForCheque;
    JTextField discountForCheque;
    ...

    EditPaymentDialog() {
        //setup the components.
        Container contentPane = getContentPane();
        String comboBoxItems[] = { //available payment types.
            Payment.FOC, Payment.TT, Payment.CHEQUE,
            Payment.CREDIT_CARD, Payment.CASH };

        //setup the components for the details shared by all types of payment.
        sharedPaymentDetails = new JPanel();
        paymentDate = new JTextField();
        paymentType = new JComboBox(comboBoxItems);
        sharedPaymentDetails.add(paymentDate);
        sharedPaymentDetails.add(paymentType);
        contentPane.add(sharedPaymentDetails, BorderLayout.NORTH);

        //setup the unique components for each type of payment.
        uniquePaymentDetails = new JPanel();
        uniquePaymentDetails.setLayout(new CardLayout());

        //setup a panel for FOC payment.
        JPanel panelForFOC = new JPanel();
        discountForFOC = new JTextField();
        panelForFOC.add(discountForFOC);
        uniquePaymentDetails.add(panelForFOC, Payment.FOC);

        //setup a panel for TT payment.
        JPanel panelForTT = new JPanel();
        bankNameForTT = new JTextField();
        actualAmountForTT = new JTextField();
        discountForTT = new JTextField();
        panelForTT.add(bankNameForTT);
        panelForTT.add(actualAmountForTT);
        panelForTT.add(discountForTT);
        uniquePaymentDetails.add(panelForTT, Payment.TT);

        //setup a panel for cheque payment.
        JPanel panelForCheque = new JPanel();
        bankNameForCheque = new JTextField();
        chequeNumberForCheque = new JTextField();
        actualAmountForCheque = new JTextField();
        discountForCheque = new JTextField();
        panelForCheque.add(bankNameForCheque);
        panelForCheque.add(chequeNumberForCheque);
        panelForCheque.add(actualAmountForCheque);
        panelForCheque.add(discountForCheque);
        uniquePaymentDetails.add(panelForCheque, Payment.CHEQUE);

        //setup a panel for credit card payment.
        ...
        //setup a panel for cash payment.
        ...

        contentPane.add(uniquePaymentDetails, BorderLayout.CENTER);
    }

    Payment editPayment(Payment payment) {
        displayPayment(payment);
        setVisible(true);
        return newPayment;
    }

    void displayPayment(Payment payment) {
        paymentDate.setText(payment.getDateAsString());
        paymentType.setSelectedItem(payment.getType());
        if (payment.getType().equals(Payment.FOC)) {
            discountForFOC.setText(Integer.toString(payment.getDiscount()));
        }
        else if (payment.getType().equals(Payment.TT)) {
            bankNameForTT.setText(payment.getBankName());
            actualAmountForTT.setText(
            Integer.toString(payment.getActualAmount()));
            discountForTT.setText(Integer.toString(payment.getDiscount()));
        }
        else if (payment.getType().equals(Payment.CHEQUE)) {
            bankNameForCheque.setText(payment.getBankName());
            chequeNumberForCheque.setText(payment.getChequeNumber());
            actualAmountForCheque.setText(
            Integer.toString(payment.getActualAmount()));
            discountForCheque.setText(Integer.toString(payment.getDiscount()));
        } else if (payment.getType().equals(Payment.CREDIT_CARD)) {
            //...
        }
        else if (payment.getType().equals(Payment.CASH)) {
            //...
        }
    }

    //when the user clicks OK.
    void onOK() {
        newPayment = makePayment();
        dispose();
    }

    //make a payment from the components.
    Payment makePayment() {
        String paymentTypeString = (String) paymentType.getSelectedItem();
        Payment payment = new Payment(paymentTypeString);
        payment.setDateAsText(paymentDate.getText());
        if (paymentTypeString.equals(Payment.FOC)) {
            payment.setDiscount(Integer.parseInt(discountForFOC.getText()));
        }
        else if (paymentTypeString.equals(Payment.TT)) {
            payment.setBankName(bankNameForTT.getText());
            payment.setActualAmount(
            Integer.parseInt(actualAmountForTT.getText()));
            payment.setDiscount(
            Integer.parseInt(discountForTT.getText()));
        }
        else if (paymentTypeString.equals(Payment.CHEQUE)) {
            payment.setBankName(bankNameForCheque.getText());
            payment.setChequeNumber(chequeNumberForCheque.getText());
            payment.setActualAmount(
            Integer.parseInt(actualAmountForCheque.getText()));
            payment.setDiscount(
            Integer.parseInt(discountForCheque.getText()));
        } else if (
            paymentTypeString.equals(Payment.CREDIT_CARD)) {
            //...
        }
        else if (paymentTypeString.equals(Payment.CASH)) {
            //...
        }
        return payment;
    }
}
