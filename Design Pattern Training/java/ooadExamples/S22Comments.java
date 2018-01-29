class Account {
	...
	boolean isComplexPassword(String password){
		return containsLetter(password) &&
			(containsDigit(password) || containsSymbol(password));
	} 
	boolean containsLetter(String password) {
		...
	} 
	boolean containsDigit(String password) {
		...
	} 
	boolean containsSymbol(String password) {
		...	
	}
}
