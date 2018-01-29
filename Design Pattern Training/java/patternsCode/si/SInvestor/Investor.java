package SInvestor;
public class Investor {
	private double income;
	private IncomeTaxEngine taxEngine = new IncomeTaxEngine();
	public Investor(double income) {
		this.income = income;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getTaxLiability() {
		return taxEngine.CalculateTaxLiability(income);
	}
	public double getTaxRate() {
		return taxEngine.CalculateTaxRate(income);
	}
	public void setTaxEngine(IncomeTaxEngine taxEngine) {
		this.taxEngine = taxEngine;
	}
}
