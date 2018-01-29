/*
The problem domain we would like to solve is as follows:

   1. We need to represent the concept of an Investor in our application.
   2. Our Investor should know its marginal tax rate and tax liability 
   		calculated from the investor’s income.
   3. The income tax laws for the following countries should be incorporated:
          * USA.
          * Australia.
          * New Zealand. 
   4. If none of these countries are specified, the object should have 
   non-exceptional behavior.  What does non-exceptional behavior mean? 
   The application should provide intelligent do nothing behaviors if none of 
   the countries are specified, by hiding the details from its collaborators.
 */
//Below is a solution with procedural orientation

public class Investor {
	private double income;
	private String m_currentCultureName;
	public Investor(double income, String culture) {
		this.income = income;
		this.m_currentCultureName=culture;
	}
	public double getIncome() { 
		return income; 
	}
	public void setIncome(double income) { 
		this.income = income;
	}
	public String getCurrentCultureName() {
		return m_currentCultureName; 
	}
	public void setCurrentCultureName(String culture) {
		m_currentCultureName = culture;
	}
	public double getTaxLiability() {
		double taxLiability=0.0;
		double inv_income=income;
		if (m_currentCultureName.equals("en-NZ")) {
			// Calculate the Tax Liability for the Investor according 
			// to the tax laws of the New Zealand
			if (inv_income > 19500.99) 
				taxLiability += 19500.99 * 0.195;
			if (inv_income <= 19500.99)
				taxLiability += inv_income * 0.195;
			if (inv_income > 60000.99)
				taxLiability += (60000.99 - 19501.00) * 0.33;
			if (inv_income >= 19501.00 && inv_income <= 60000.99)
				taxLiability += (inv_income - 19501.00) * 0.33;
			if (inv_income > 60000.99)
				taxLiability += (inv_income - 60000.99) * 0.39;
		} else if (m_currentCultureName.equals("en-AU")) {
			// Calculate the Tax Liability for the Investor according 
			// to the tax laws of the Australia
			if (inv_income >= 6001.00 && inv_income <= 25000.99)
				taxLiability += (inv_income - 6000.99) * 0.15;
			if (inv_income > 25000.99)
				taxLiability += (25000.99 - 6001.00) * 0.15;
			if (inv_income > 75000.99)
				taxLiability += (75000.99 - 25001.00) * 0.30;
			if (inv_income >= 25001.00 && inv_income <= 75000.99)
				taxLiability += (inv_income - 25001.00) * 0.30;
			if (inv_income > 150000.99)
				taxLiability += (150000.99 - 75001.00) * 0.40;
			if (inv_income >= 75001.00 && inv_income <= 150000.99)
				taxLiability += (inv_income - 75001.00) * 0.40;
			if (inv_income > 150000.99)
				taxLiability += (inv_income - 150000.99) * 0.45;
		} else if (m_currentCultureName.equals("en-US")) {
			// Calculate the Tax Liability for the Investor according 
			// to the tax laws of the USA
			if (inv_income > 7550.99)
				taxLiability += 7550.99 * 0.10;
			if (inv_income >= 0.0 && inv_income <= 7550.99)
				taxLiability += inv_income * 0.10;
			if (inv_income > 30650.99)
				taxLiability += (30650.99 - 7551.00) * 0.15;
			if (inv_income >= 7551.00 && inv_income <= 30650.99)
				taxLiability += (inv_income - 7551.00) * 0.15;
			if (inv_income > 74200.99)
				taxLiability += (74200.99 - 30651.00) * 0.25;
			if (inv_income >= 30651.00 && inv_income <= 74200.99)
				taxLiability += (inv_income - 30651.00) * 0.25;
			if (inv_income > 154800.99)
				taxLiability += (154800.99 - 74201.00) * 0.28;
			if (inv_income >= 74201.00 && inv_income <= 154800.99)
				taxLiability += (inv_income - 74201.00) * 0.28;
			if (inv_income > 336550.99)
				taxLiability += (336550.99 - 154801.00) * 0.33;
			if (inv_income >= 154801.00 && inv_income <= 336550.99)
				taxLiability += (inv_income - 154801.00) * 0.33;
			if (inv_income > 336551.00)
				taxLiability += (inv_income - 336551.00) * 0.35;
		} else
			taxLiability = 0.0;
		return taxLiability;
	}

	public double getTaxRate() {
		double taxRate;
		double inv_income = income;
		if (m_currentCultureName.equals("en-NZ")) {
			// Calculate the tax rate for New Zealand
			if (inv_income >= 0.0 && inv_income <= 19500.99)
				taxRate = 0.195;
			else if (inv_income >= 19501.00 && inv_income <= 60000.99)
				taxRate = 0.33;
			else
				taxRate = 0.39;
		} else if (m_currentCultureName.equals("en-AU")) {
			 // Calculate the tax rate for Australia
			if (inv_income >= 0.0 && inv_income <= 6000.99)
				taxRate = 0.0;
			else if (inv_income >= 6001.00 && inv_income <= 25000.99)
				taxRate = 0.15;
			else if (inv_income >= 25001.00 && inv_income <= 75000.99)
				taxRate = 0.30;
			else if (inv_income >= 75001.00 && inv_income <= 150000.99)
				taxRate = 0.40;
			else
				taxRate = 0.45;
		} else if (m_currentCultureName.equals("en-US")) {
			 // Calculate the tax rate for the United States of America
			if (inv_income >= 0.0 && inv_income <= 7550.99)
				taxRate = 0.10;
			else if (inv_income >= 7551.00 && inv_income <= 30650.99)
				taxRate = 0.15;
			else if (inv_income >= 30651.00 && inv_income <= 74200.99)
				taxRate = 0.25;
			else if (inv_income >= 74201.00 && inv_income <= 154800.99)
				taxRate = 0.28;
			else if (inv_income >= 154801.00 && inv_income <= 336550.99)
				taxRate = 0.33;
			else
				taxRate = 0.35;
		} else 
			taxRate = 0.0;
		return taxRate;
	}
}
/*
 * The above code has the following problems
   1. Copy/Paste Errors 
   2. Duplicate Code 
   3. Big Methods 
   4. Comments 
   5. Switch / if..else Statement 

   Correct the above problem by using OO design principles.
 */

