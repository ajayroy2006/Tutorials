package SInvestor;
import java.util.List;

public class IncomeTaxEngine {
	private final List<TaxBand> taxBands;
	public IncomeTaxEngine() {
		this("");
	}
	public IncomeTaxEngine(String cultureInfo) {
		taxBands = TaxBandGenerator.CreateInstance(cultureInfo)
		        .CreateTaxBands();
	}
	public double CalculateTaxLiability(double income) {
		double taxLiability = 0;
		for (TaxBand taxBand : taxBands)
			taxLiability += taxBand.CalculateTaxPortion(income);
		return taxLiability;
	}
	public double CalculateTaxRate(double income) {
		TaxBand selectedBand = null;
		for (TaxBand t : taxBands)
			if (income >= t.getLowerLimitAmount()
			        && income <= t.getUpperLimitAmount())
				selectedBand = t;
		return selectedBand.getTaxRate();
	}
}
