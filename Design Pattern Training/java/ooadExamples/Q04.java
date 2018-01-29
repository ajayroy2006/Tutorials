//Improve code
class ParticipantsInDB {
    Connection db;
    void addParticipant(Participant part) {
        PreparedStatement st = db.prepareStatement(
            "INSERT INTO participants VALUES (?,?,?,?,?,?,?)");
        try {
            st.setString(1, part.getId());
            ...
            st.executeUpdate();
        } finally {
            st.close();
        }
    }
    void deleteAllParticipants() {
        PreparedStatement st = db.prepareStatement(
            "DELETE FROM participants");
        try {
            st.executeUpdate();
        } finally {
            st.close();
        }
    }
    int getCount() {
        PreparedStatement st = db.prepareStatement(
            "SELECT COUNT(*) FROM participants");
        try {
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1);
        } finally {
            st.close();
        }
    }
}
