package SInvestor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NullTaxBandGenerator extends TaxBandGenerator {
	@Override
	public List<TaxBand> CreateTaxBands() {
		List<TaxBand> taxBands = new LinkedList<TaxBand>();
		taxBands.add(new TaxBand(0.0, Double.MAX_VALUE, 0.0));
		return Collections.unmodifiableList(taxBands);
	}
}
