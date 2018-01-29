package SInvestor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class UsaTaxBandGenerator extends TaxBandGenerator {
	@Override
	public List<TaxBand> CreateTaxBands() {
		List<TaxBand> taxBands = new LinkedList<TaxBand>();
		taxBands.add(new TaxBand(0.0, 7550.99, 0.10));
		taxBands.add(new TaxBand(7551.00, 30650.99, 0.15));
		taxBands.add(new TaxBand(30651.00, 74200.99, 0.25));
		taxBands.add(new TaxBand(74201.00, 154800.99, 0.28));
		taxBands.add(new TaxBand(154801.00, 336550.99, 0.33));
		taxBands.add(new TaxBand(336551.00, Double.MAX_VALUE, 0.35));
		return Collections.unmodifiableList(taxBands);
	}
}
