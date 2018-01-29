//Improve the code
class FoodSalesReport {
    int q0; //how many items of rice sold?
    int q1; //how many items of noodle sold?
    int q2; //how many items of drink sold?
    int q3; //how many items of dessert sold?
    void LoadData(Connection conn) {
        PreparedStatement st = conn.prepareStatement("select "+
            "sum(case when foodType=0 then qty else 0 end) as totalQty0,"+
            "sum(case when foodType=1 then qty else 0 end) as totalQty1,"+
            "sum(case when foodType=2 then qty else 0 end) as totalQty2,"+
            "sum(case when foodType=3 then qty else 0 end) as totalQty3 "+
            "from foodSalesTable group by foodType");
        try {
            ResultSet rs = st.executeQuery();
            try {
                rs.next();
                q0 = rs.getInt("totalQty0");
                q1 = rs.getInt("totalQty1");
                q2 = rs.getInt("totalQty2");
                q3 = rs.getInt("totalQty3");
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        }
    }
}
