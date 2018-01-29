//Improve the code
class UserAccount {
    final static int USERTYPE_NORMAL = 0;
    final static int USERTYPE_ADMIN  = 1;
    final static int USERTYPE_GUEST  = 2;
    int userType;

    String id;
    String name;
    String password;
    Date dateOfLastPasswdChange;
    public boolean checkPassword(String password) {
        ...
    }
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
        switch (account.getType()) {
        case UserAccount.USERTYPE_NORMAL:
            return 90;
        case UserAccount.USERTYPE_ADMIN:
            return 30;
        case UserAccount.USERTYPE_GUEST:
            return Integer.MAX_VALUE;
        }
    }

    void printReport(UserAccount currentUser) {
        boolean canPrint;
        switch (currentUser.getType()) {
        case UserAccount.USERTYPE_NORMAL:
            canPrint = true;
            break;
        case UserAccount.USERTYPE_ADMIN:
            canPrint = true;
            break;
        case UserAccount.USERTYPE_GUEST:
            canPrint = false;
        }
        if (!canPrint) {
            throw new SecurityException("You have no right");
        } //print the report.
    }
}

