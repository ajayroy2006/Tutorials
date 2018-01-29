interface Account {
	boolean canLogin();
} 
class UserAccount implements Account {
	Date expiredDate;
	boolean canLogin() {
		return isAccountExpired();
	} 
	boolean isAccountExpired() {
		Date now = new Date();
		return !getExpiredDate().before(now);
	}
} 
class AdminAccount implements Account {
	boolean hasLogin;
	boolean canLogin() {
		return !isTryingMultiLogin();
	} 
	boolean isTryingMultiLogin() {
		return hasLogin;
	}
} 
class ERPApp {
	public boolean checkLoginIssue(Account account) {
		return account.canLogin();
	}
}
