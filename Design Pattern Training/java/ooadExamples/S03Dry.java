class ConferenceDBConnection {
    private static Connection db;
    static Connection makeConnection() {
        return db;
    }
    static {
        Class.forName("org.postgresql.Driver");
        db = DriverManager.getConnection(
                "jdbc:postgresql://myhost/ConferenceDB",
                "PaulChan", "myP@ssword");
    }
}
class ParticipantsInDB {
    Connection db = ConferenceDBConnection.makeConnection();

    void addParticipant(Participant part) {
        PreparedStatement st = db.prepareStatement(
            "INSERT INTO participants VALUES (?,?,?,?,?,?,?)");
        try {
            st.setString(1, part.getId());
            st.setString(2, part.getEFirstName());
            st.setString(3, part.getELastName());
            ...
            st.executeUpdate();
        } finally {
            st.close();
        }
    }
}
class OrganizationsInDB {
    Connection db=ConferenceDBConnection.makeConnection();
    void addOrganization(Organization o) {
        PreparedStatement st =
        db.prepareStatement(
            "INSERT INTO organizations VALUES (?,?,?,?,?,?,?,?,?,?,)");
        try {
            st.setString(1, o.getId());
            st.setString(2, o.getEName());
            st.setString(3, o.getCName());
            ...
            st.executeUpdate();
        } finally {
            st.close();
        }
    }
}
