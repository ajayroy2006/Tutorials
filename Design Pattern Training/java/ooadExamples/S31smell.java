class UserAccount {
	UserType userType;
	String id;
	String name;
	String password;
	Date dateOfLastPasswdChange;
	UserType getType() {
		return userType;
	}
} 
class UserType {
	int passwordMaxAgeInDays;
	boolean allowedToPrintReport;
	UserType(int passwordMaxAgeInDays, boolean allowedToPrintReport) {
		this.passwordMaxAgeInDays = passwordMaxAgeInDays;
		this.allowedToPrintReport = allowedToPrintReport;
	} 
	int getPasswordMaxAgeInDays() {
		return passwordMaxAgeInDays;
	} 
	boolean canPrintReport() {
		return allowedToPrintReport;
	} 
	static private final int PASSWORD_AGE_NORMAL = 90;
	static UserType normalUserType = new UserType(
	   PASSWORD_AGE_NORMAL, true);
    static private final int PASSWORD_AGE_ADMIN = 30;
	static UserType adminUserType = new UserType(
	   PASSWORD_AGE_ADMIN, true);
	static UserType guestUserType = 
		new UserType(Integer.MAX_VALUE, false);
}
class InventoryApp {
	void login(UserAccount userLoggingIn, String password) {
		if (userLoggingIn.checkPassword(password)) {
			GregorianCalendar today = new GregorianCalendar();
			GregorianCalendar expiryDate = 
				getAccountExpiryDate(userLoggingIn);
			if (today.after(expiryDate)) {
				//prompt the user to change password
				...
			}
		}
	}
	GregorianCalendar getAccountExpiryDate(UserAccount account) {
		int passwordMaxAgeInDays = getPasswordMaxAgeInDays(account);
		GregorianCalendar expiryDate = new GregorianCalendar();
		expiryDate.setTime(account.dateOfLastPasswdChange);
		expiryDate.add(Calendar.DAY_OF_MONTH, passwordMaxAgeInDays);
		return expiryDate;
	}
	int getPasswordMaxAgeInDays(UserAccount account) {
		return account.getType().getPasswordMaxAgeInDays();
	}
	void printReport(UserAccount currentUser) {
		boolean canPrint;
		canPrint = currentUser.getType().canPrintReport();
		if (!canPrint) {
			throw new SecurityException("You have no right");
		}
		//print the report.
	}
}