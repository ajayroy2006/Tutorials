package SInvestor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class AustralianTaxBandGenerator extends TaxBandGenerator {
	@Override
	public List<TaxBand> CreateTaxBands() {
		List<TaxBand> taxBands = new LinkedList<TaxBand>();
		taxBands.add(new TaxBand(0.0, 6000.99, 0.0));
		taxBands.add(new TaxBand(6001.00, 25000.99, 0.15));
		taxBands.add(new TaxBand(25001.00, 75000.99, 0.30));
		taxBands.add(new TaxBand(75001.00, 150000.99, 0.40));
		taxBands.add(new TaxBand(150001.00, Double.MAX_VALUE, 0.45));
		return Collections.unmodifiableList(taxBands);
	}
}
