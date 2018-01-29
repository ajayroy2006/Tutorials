class TelNo {
    private String countryCode;
    private String areaCode;
    private String localNumber;
    ...
}
class PersonName {
    private String firstName, lastName;
    ...
}
class ContactPerson {
    private PersonName englishName, chineseName;
    private TelNo telNo, faxNo, mobileNo;

    ...
}
class Organization {
    private String id;
    private String englishName;
    private String chineseName;
    private TelNo telNo, faxNo;
    private ContactPerson contactPerson;
    ...
}