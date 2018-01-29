class Account {
    final static int LEVEL_USER = 1;
    final static int LEVEL_ADMIN = 2;
    int accountLevel;

    Date expiredDate; // for user account only

    boolean hasLogin; // for admin account only
}
class ERPApp {
    public boolean checkLoginIssue(Account account) {
        if (account.getLevel() == Account.LEVEL_USER) {
            // Check the account expired date
            Date now = new Date();
            if (account.getExpiredDate().before(now))
                return false;
            return true;
        } else if (account.getLevel() == Account.LEVEL_ADMIN) {
            // No expired date for admin account
            // Check multilogin
            if (account.hasLogin())
                return false;
            return true;
        }
        return false;
    }
}