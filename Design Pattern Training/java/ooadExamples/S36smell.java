interface Currency {
	public String format(int amount);
} 
class USDCurrency implements Currency {
	public String format(int amount) {
		//return something like $1,200
	}
} 
class RMBCurrency implements Currency {
	public String format(int amount) {
		//return something like RMB1,200
	}
} 
class ESCUDOCurrency implements Currency {
	public String format(int amount) {
		//return something like $1.200
	}
}
