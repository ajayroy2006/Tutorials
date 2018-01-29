class Form1 extends JDialog {
    JComboBox comboBoxReportType;
    Form1() {
        comboBoxReportType = new JComboBox();
        comboBoxReportType.addItem("r1");
        comboBoxReportType.addItem("r2");
        ...
        comboBoxReportType.addItem("r31c");
    }
    void processReport1() {
        //print some fancy report...
    }
    void processReport2() {
        //print another totally different fancy report...
    }
    ...
    void processReport31c() {
        //print yet another totally different fancy report...
    }
    void printReport(String repNo) {
        if (repNo.equals("r1"))
            processReport1();
        else if (repNo.equals("r2"))
            processReport2();
            ...
        else if (repNo.equals("r31c"))
            processReport31c();
    }
    void onPrintClick() {
        printReport((String) comboBoxReportType.getSelectedItem());
    }
}
