//Domain Logic
class Order {
    ...
    Customer customer;
    OrderItem orderItems[];
}
class OrderItem {
    ...
    String foodId;
    int quantity;
}
class Customer {
    ...
}
interface Orders {
    ...
    Order getOrder(String orderId);
}
interface Customers {
    ...
    Customer getCustomer(String customerId);
}



//Database Logic
class OrdersInDB implements Orders {
    Order getOrder(String orderId) {
        PreparedStatement st = dbConn.prepareStatement(
            "select * from Orders where orderId=?");
        try {
            st.setString(1, orderId);
            ResultSet rs = st.executeQuery();
            try {
                if (!rs.next()) {
                    throw new OrdersException();
                }
                String customerId = rs.getString("customerId");
                CustomersInDB customers = new CustomersInDB();
                Customer customer = customers.getCustomer(customerId);
                Order order = new Order(...,customer, ...);
                getOrderItemsFromDB(order);
                return order;
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        }
    }
    void getOrderItemsFromDB(Order order) {
        PreparedStatement st = dbConn.prepareStatement(
            "select * from OrderItems where orderId=?");
        try {
            st.setString(1, order.getId());
            ResultSet rs = st.executeQuery();
            try {
                while (rs.next()) {
                    order.addOrderItem(new OrderItem(
                        ...,
                    rs.getString("foodId"),
                    rs.getInt("quantity"),
                    ...));
                }
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        }
    }
}

class CustomersInDB implements Customers {
    Customer getCustomer(String customerId) {
        PreparedStatement st = dbConn.prepareStatement(
            "select * from Customers where customerId=?");
        try {
            st.setString(1, customerId);
            ResultSet rs = st.executeQuery();
            try {
                if (!rs.next()) {
                    throw new CustomersException();
                }
                return new Customer(..., rs.getString("name"), ...);
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        }
    }
}

//UI logic
public class ShowOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Orders orders = (Orders)getServletContext().getAttribute("Orders");
        out.println("<HTML><TITLE>Order details</TITLE><BODY>");
        String orderId = request.getParameter("orderId");
        try {
            Order order = orders.getOrder(orderId);
        } catch (OrdersException e) {
            out.println("Error: Order not found!");
            return;
        } catch (CustomersException e) {
            out.println("Error: Customer not found!");
            return;
        }
        out.println("Customer: "+order.getCustomer().getName());
        showOrderItems(out, order);
        out.println("</BODY></HTML>");
    }
    void showOrderItems(PrintWriter out, Order order) {
        out.println("<TABLE>");
        for (int i = 0; i < order.getNoOrderItems(); i++) {
            out.println("<TR>");
            out.println("<TD>");
            out.println(order.getOrderItemAt(i).getFoodId());
            out.println("</TD>");
            out.println("<TD>");
            out.println(order.getOrderItemAt(i).getQuantity()+"");
            out.println("</TD>");
            out.println("</TD>");
            out.println("</TR>");
        }
        out.println("</TABLE>");
    }
}
