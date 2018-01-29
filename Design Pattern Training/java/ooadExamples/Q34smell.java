//Improve the code
class CustomersInDB {
    Connection conn;
    Customer getCustomer(String IDNumber) {
        PreparedStatement st = conn.prepareStatement(
            "select * from customer where ID=?");
        try {
            st.setString(1, IDNumber.replace('-', ' ').replace('(', ' ').
                replace(')', ' ').replace('/', ' '));
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
            st.setString(1,customer.getIDNumber().replace('-', ' ').
                replace('(', ' ').replace(')', ' ').replace('/', ' '));
            st.setString(2, customer.getName());
            ...
            st.executeUpdate();
            ...
        } finally {
            st.close();
        }
    }
}
