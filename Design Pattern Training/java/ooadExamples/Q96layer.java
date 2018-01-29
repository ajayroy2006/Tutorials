/* This is a web-based application concerned with food orders. A user
 * can enter an order id in a form and click submit. Then the application
 * will display the customer name of the order and the order items
 * (food id and quantity) in the order. The servlet doing that is shown
 * below.
 */
public class ShowOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML><TITLE>Order details</TITLE><BODY>");
        String orderId = request.getParameter("orderId");
        String customerId;
        Connection dbConn = ...;
        PreparedStatement st = dbConn.prepareStatement(
            "select * from Orders where orderId=?");
        try {
            st.setString(1, orderId);
            ResultSet rs = st.executeQuery();
            try {
                if (!rs.next()) {
                    out.println("Error: Order not found!");
                    return;
                }
                customerId = rs.getString("customerId");
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        }
        //find and show the customer's name from his id.
        PreparedStatement st = dbConn.prepareStatement(
                "select * from Customers where customerId=?");
        try {
            st.setString(1, customerId);
            ResultSet rs = st.executeQuery();
            try {
                if (!rs.next()) {
                    out.println("Error: Customer not found!");
                    return;
                }
                out.println("Customer: "+rs.getString("name"));
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        }
        //find and show the order items.
        st = dbConn.prepareStatement(
            "select * from OrderItems where orderId=?");
        try {
            st.setString(1, orderId);
            ResultSet rs = st.executeQuery();
            try {
                out.println("<TABLE>");
                while (rs.next()) {
                    out.println("<TR>");
                    out.println("<TD>");
                    out.println(rs.getString(3)); //food id
                    out.println("</TD>");
                    out.println("<TD>");
                    out.println(rs.getInt(4)+""); //quantity
                    out.println("</TD>");
                    out.println("</TD>");
                    out.println("</TR>");
                }
                out.println("</TABLE>");
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        }
        out.println("</BODY></HTML>");
    }
}
//Point out and remove the problems in the code above.