class CustomersInDB {
	Connection conn;
	private String replaceSymbolsInID(String idNumber) {
		String symbolsToReplace = "-()/";
		for (int i = 0; i < symbolsToReplace.length(); i++) {
			idNumber = idNumber.replace(symbolsToReplace.charAt(i), ' ');
		} 
		return idNumber;
	}
	Customer getCustomer(String IDNumber) {
		PreparedStatement st = conn.prepareStatement(
			"select * from customer where ID=?");
		try {
			st.setString(1, replaceSymbolsInID(IDNumber));
			ResultSet rs = st.executeQuery();
			...
		} finally {
			st.close();
		}
	}
	void addCustomer(Customer customer) {
		PreparedStatement st = conn.prepareStatement(
			"insert into customer values(?,?,?,?)");
		try {
			st.setString(1, replaceSymbolsInID(customer.getIDNumber()));
			st.setString(2, customer.getName());
			...
			st.executeUpdate();
			...
		} finally {
			st.close();
		}
	}
}
