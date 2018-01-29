//Improve the code
class UIDialogCustomerMain extends JDialog {
    JButton btnOrderDel;
    JButton btnCustChangePassword;
    void bindEvents() {
        ...
        btnOrderDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dialog d = new UIDialogCustomerDeleteOrder(
                    UIDialogCustomerMain.this, "Del Order", true);
                d.pack();
                d.setLocation(400,200);
                d.setVisible(true);
            }
        });
        btnCustChangePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dialog d = new UIChangeAccountPW(
                    UIDialogCustomerMain.this, "chg pw", true);
                d.pack();
                d.setLocation(400,200);
                d.setVisible(true);
            }
        });
    }
    ...
}

class UIDialogRestaurantMain extends JDialog {
    JButton btnChangePassword;
    void bindEvents() {
        ...
        btnChangePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dialog d = new UIChangeAccountPW(
                    UIDialogRestaurantMain.this, "chg pw", true);
                d.pack();
                d.setLocation(400,200);
                d.setVisible(true);
            }
        });
    }
    ...
}
