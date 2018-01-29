package SInvestor;
import java.util.List;

public abstract class TaxBandGenerator {
	public static TaxBandGenerator CreateInstance() {
		return CreateInstance("");
	}
	public static TaxBandGenerator CreateInstance(String cultureInfo) {
		if (cultureInfo.equals("en-NZ"))
			return new NewZealandTaxBandGenerator();
		else if (cultureInfo.equals("en-AU"))
			return new AustralianTaxBandGenerator();
		else if (cultureInfo.equals("en-US"))
			return new UsaTaxBandGenerator();
		else
			return new NullTaxBandGenerator();
	}
	public abstract List<TaxBand> CreateTaxBands();
}
