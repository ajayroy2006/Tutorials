class Participants {
	private int id;
	private String name;
	private String telNo;
	private String region;
	...//getters and setters funcions
}
class ParticpantsDBLogic {
	Connection dbConn
	ParticipantsDBLogic() {
		dbConn = ...
	}
	public int nextID() {
		int nextId=0;
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
		return nextId;	
	}
	public void addRecord(Partipants p) {
		PreparedStatement st = dbConn.prepareStatement(
			"insert into from participants values(?,?,?,?)");
		try {
			st.setInt(1, p.getId());
			st.setString(2, p.getName());
			st.setString(3, p.getTelNo());
			st.setString(4, p.getRegion());
			st.executeUpdate();
		} finally {
			st.close();
		} 
	}
}

class ParticipantsBusinessLogic {
	private Particpants participant;
	ParticipantsBusinessLogic(Participants participant) {
		this.participant = p;
	} 
	boolean assertValid() {
		if (participant.getName().equals("")) {
			throw new ParticipantException("Invalid name");
		if (!participant.getRegion.equals("China") &&
				!region.equals("US") &&
				!region.equals("Europe")) 
			throw new ParticipantException("Region is unknown");
	}
} 
class ParticipantException extends RunTimeException {
	ParticipantException(String msg) {
		super(msg);
	}
}

//User Interface Logic
class AddParticipantDialog extends JDialog {
	JTextField id;
	JTextField name;
	JTextField telNo;
	JTextField region;
	AddParticipantDialog() {
		setupComponents();
	}
	void setupComponents() {
		...
	}
	void show() {
		showDefaultValues();
		setVisible(true);
	}
	void showDefaultValues() {
		int nextID = new ParticpantsDBLogic().nextID();
		id.setText(new Integer(nextId).toString());
		name.setText("");
		region.setText("China");
	}
	void onOK() {
		Participant p = new Participants();
		try {
			new ParticipantsBusinessLogic(p).assertValid();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
		}
		p.setId(Integer.parseInt(id.getText());
		p.setName(name.getText());
		p.setTelNo(telNo.getText());
		p.setRegion(region.getTExt());
		new ParticipantsDBLogic().addRecord(p);
		dispose();
	}
}