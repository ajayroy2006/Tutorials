class UIDialogShower {
    public static void show(Dialog d, int left, int top) {
        d.pack();
        d.setLocation(left, top);
        d.setVisible(true);
    }
    private static int LEFT_PIXEL=400, TOP_PIXEL=200;
    public static void showAtDefaultPosition(Dialog d) {
        show(d, LEFT_PIXEL, TOP_PIXEL);
    }
} 

class ChangePasswordButton extends JButton {
    public ChangePasswordButton(final JDialog enclosingDialog) {
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dialog d = new UIChangeAccountPW(
                    enclosingDialog, "chg pw", true);
                UIDialogShower.showAtDefaultPosition(d);
            }
        });
    }
}

class UIDialogCustomerMain extends JDialog {
    JButton btnOrderDel;
    ChangePasswordButton btnCustChangePassword = 
        new ChangePasswordButton(this);
    void bindEvents() {
        ...
        btnOrderDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dialog d = new UIDialogCustomerDeleteOrder
                    (UIDialogCustomerMain.this, "Del Order", true);
                UIDialogShower.showAtDefaultPosition(d);
            }
        });
    }
    ...
}

class UIDialogRestaurantMain extends JDialog {
    ChangePasswordButton btnChangePassword = new ChangePasswordButton(this);
    void bindEvents() {
        ...
    }
    ...
}
