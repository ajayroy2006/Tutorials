public class ParticipantInfoOnBadge {
    String participantId;
    String participantEngFullName;
    String participantChiFullName;
    String engOrgName;
    String chiOrgName;
    String engOrgCountry;
    String chiOrgCountry;

    ParticipantInfoOnBadge(String participantId) {
        loadInfoFromDB(participantId);
    }
    void loadInfoFromDB(String participantId) {
        this.participantId = participantId;
        getParticipantFullNames();
        getOrgNameAndCountry();
    }
    void getParticipantFullNames() {
        ParticipantsInDB partsInDB = ParticipantsInDB.getInstance();
        Participant part = partsInDB.locateParticipant(participantId);
        if (part != null) {
            participantEngFullName = part.getEFullName();
            participantChiFullName = part.getCFullName();
        }
    }
    void getOrgNameAndCountry() {
        OrganizationsInDB orgsInDB = OrganizationsInDB.getInstance();
        String oid = orgsInDB.findOrganizationEmploying(participantId);
        if (oid != null) {
            Organization org = orgsInDB.locateOrganization(oid);
            engOrgName = org.getEName();
            chiOrgName = org.getCName();
            engOrgCountry = org.getEAddress().getCountry();
            chiOrgCountry = org.getCAddress().getCountry();
        }
    }
}
