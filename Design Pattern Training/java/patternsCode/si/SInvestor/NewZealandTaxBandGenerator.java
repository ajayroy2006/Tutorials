package SInvestor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NewZealandTaxBandGenerator extends TaxBandGenerator {
	@Override
	public List<TaxBand> CreateTaxBands() {
		List<TaxBand> taxBands = new LinkedList<TaxBand>();
		taxBands.add(new TaxBand(0.0, 19500.99, 0.195));
		taxBands.add(new TaxBand(19501.00, 60000.99, 0.33));
		taxBands.add(new TaxBand(60001.00, Double.MAX_VALUE, 0.39));
		return Collections.unmodifiableList(taxBands);
	}
}
