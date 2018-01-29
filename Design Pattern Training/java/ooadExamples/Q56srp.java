/* This application is about restaurants. Initially we created a
 * Restaurant class to represent a restaurant account and
 * includes information such as its
 *      name, access password, tel and fax number, address.
 * The class is like:
 * class Restaurant { String name, password, telNo, faxNo, address;}
 *
 * Later, the following requirements are added in sequence:
 * 1. After initial registration, the restaurant account is assigned an
 *    activation code by the system. Only after the user enters the
 *    activation code, the account will become activated.
 *    Until then, the account is inactive and login is not allowed.
 * 2. If the user would like to change the fax number of the account,
 *    the new fax number will not take effect immediately
 *    (the existing fax number will remain in effect). Instead,
 *    the account is assigned an activation code by the system.
 *    Only after the user enters the activation code, the new fax number
 *    will take effect.
 * 3. A restaurant can be marked as in a certain category
 *    (e.g., Chinese restaurant, Portuguese restaurant and etc.).
 *    A category is identified by a category ID.
 * 4. The user can input the holidays for the restaurant.
 * 5. The user can input the business hours for the restaurant.
 *
 * After implementing all these five requirements, the class has grown
 * significantly and become quite complicated as shown below. Our task
 * now is to implement the five requirements above in separate classes,
 * leaving the original simple Restaurant class unchanged.
 */
class Restaurant {
    String name;
    String password;
    String telNo;
    String faxNo;
    String address;
    String verificationCode;
    boolean isActivated;
    String faxNoToBeConfirmed;
    boolean isThereFaxNoToBeConfirmed = false;
    String catId;
    Vector holidays;
    Vector businessSessions;
    void activate(String verificationCode) {
        isActivated =(this.verificationCode.equals(verificationCode));
        if (isActivated && isThereFaxNoToBeConfirmed){
            faxNo = faxNoToBeConfirmed;
            isThereFaxNoToBeConfirmed = false;
        }
    }
    void setFaxNo(String newFaxNo) {
        faxNoToBeConfirmed = newFaxNo;
        isThereFaxNoToBeConfirmed = true;
        isActivated = false;
    }
    boolean isInCategory(String catId) {
        return this.catId.equals(catId);
    }
    void addHoliday(int year, int month, int day) {
        ...
    }
    void removeHoliday(int year, int month, int day) {
    ...
    }
    boolean addBusinessSession(int fromHour, int fromMin,
                int toHour, int toMin) {
        ...
    }
    boolean isInBusinessHour(Calendar time) {
        ...
    }
    Vector getAllHolidays() {
        return holidays;
    }
    Vector getAllBusinessSessions() {
        return businessSessions;
    }
}
