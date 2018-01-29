interface Report {
    void print();
}
class Report1 implements Report {
    String toString() {
        return "r1";
    }
    void print() {
        //print some fancy report...
    }
}
class Report2 implements Report {
    String toString() {
        return "r2";
    }
    void print() {
        //print another totally different fancy report...
    }
}
...
class Report31c implements Report {
    String toString() {
        return "r31c";
    }
    void print() {
        //print yet another totally different fancy report...
    }
}
class Form1 extends JDialog {
    JComboBox comboBoxReportType;
    Report reports[] = { new Report1(), new Report2(),... new Report31c() };
    Form1() {
        comboBoxReportType = new JComboBox();
        for (int i = 0; i < reports.length; i++) {
            comboBoxReportType.addItem(reports[i]);
        }
    }
    void onPrintClick() {
        Report report = (Report)comboBoxReportType.getSelectedItem();
        report.print();
    }
}
