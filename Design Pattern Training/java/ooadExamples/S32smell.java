class FoodSalesReport {
    int riceSold, noodlesSold, drinkSold, dessertSold;
    private static final int RICE_CODE=0, NOODLE_CODE=1,
            DRINK_CODE=2, DESSERT_CODE=3;
    private static final String SUM_CASE = "sum(case when foodType=";
    private static final String QTY_IF=" then qty else 0 end)";
	private static final String SQL_S = "select "+
            SUM_CASE + RICE_CODE + QTY_IF + ","+
            SUM_CASE + NOODLE_CODE + QTY_IF + ","+
            SUM_CASE + DRINK_CODE + QTY_IF + ","+
            SUM_CASE + DESSERT_CODE + QTY_IF +
            " from foodSalesTable group by foodType";
    void LoadData(Connection conn) {
        PreparedStatement st = conn.prepareStatement(SQL_S);
        ResultSet rs = null;
        try {
            rs = st.executeQuery();
            rs.next();
            riceSold = rs.getInt(1);
            noodlesSold = rs.getInt(2);
            drinkSold = rs.getInt(3);
            dessertSold = rs.getInt(4);
        } finally {
            if (rs != null) rs.close();
            st.close();
        }
    }
}
