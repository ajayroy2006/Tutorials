/* This is a conference management system. The system needs to record
 * the ID, name, telephone of each participant and the region he comes
 * from.
 * The participant ID is a unique integer assigned by the conference
 * organizer. The name must be specified. Telephone can be omitted. All the
 * participants must come from China, US or Europe.
 * We have created a database and a table to store the information of the
 * participants. The schema is: create table Participants (
 * 		id int primary key, name varchar(20) not null, telNo varchar(20),
 *		region varchar(20));
 *	We have also written the code below to let an operator add a new
 * participant. The system will check all the existing participants to find
 * the maximum ID and then adds one to it and use it as the default value
 * for the ID of this new participant. The operator may use this ID or
 * use any other value.
 * What are the problems with this code?
 */
class AddParticipantDialog extends JDialog {
    Connection dbConn;
    JTextField id;
    JTextField name;
    JTextField telNo;
    JTextField region;
    AddParticipantDialog() {
        setupComponents();
        dbConn = ...;
    }
    void setupComponents() {
        ...
    }
    void show() {
        showDefaultValues();
        setVisible(true);
    }
    void showDefaultValues() {
        int nextId;
        PreparedStatement st = dbConn.prepareStatement(
            "select max(id) from participants");
        try {
            ResultSet rs = st.executeQuery();
            try {
                rs.next();
                nextId = rs.getInt(1)+1;
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        }
        id.setText(new Integer(nextId).toString());
        name.setText("");
        region.setText("China");
    }
    void onOK() {
        if (name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Invalid name");
            return;
        }
        if (!region.equals("China") && !region.equals("US") &&
                !region.equals("Europe")) {
            JOptionPane.showMessageDialog(this, "Region is unknown");
            return;
        }
        PreparedStatement st = dbConn.prepareStatement(
            "insert into from participants values(?,?,?,?)");
        try {
            st.setInt(1, Integer.parseInt(id.getText()));
            st.setString(2, name.getText());
            st.setString(3, telNo.getText());
            st.setString(4, region.getText());
            st.executeUpdate();
        } finally {
            st.close();
        }
        dispose();
    }
}