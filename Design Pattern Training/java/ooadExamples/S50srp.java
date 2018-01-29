abstract class Account {
	private double balance;
	abstract public double calcInterest();
	public double getInterestRate(...) { // Some method;
		...
	}
} 
class SavingAccount extends Account {
	public double calcInterest() {
		return getBalance()*getInterestRate();
	}
} 
class ChequeAccount extends Account {
	public double calcInterest() {
		return 0;
	}
} 
class FixedAccount extends Account {
	public double calcInterest() {
		return getBalance()*(getInterestRate()+0.02);
	}
}
