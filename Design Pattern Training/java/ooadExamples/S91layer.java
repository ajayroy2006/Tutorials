class Order {
	String orderId;
	String customerId;
	String restId;
	OrderItem items[];
}
class OrderItem {
	String foodId;
	int quantity;
	double unitPrice;
}


interface Orders {
	void addOrder(Order order);
	void deleteOrder(String orderId);
	void updateOrder(Order order);
	OrderIterator getOrdersById();
}


class OrdersInDB implements Orders {
	void addOrder(Order order) {
		PreparedStatement st =
			dbConn.prepareStatement("insert into from Orders values(?,?,?)");
			try {
				st.setString(1, order.getId());
				st.setString(2, order.getCustomerId());
				st.setString(3, order.getRestId());
				st.executeUpdate();
			} finally {
				st.close();
			}
		st = dbConn.prepareStatement(
				"insert into from OrderItems values(?,?,?,?,?)");
		try {
			for (int i = 0; i < order.items.length; i++) {
				OrderItem orderItem = order.items[i];
				st.setString(1, order.getId());
				st.setInt(2, i);
				st.setString(3, orderItem.getFoodId());
				st.setInt(4, orderItem.getQuantity());
				st.setDouble(5, orderItem.getUnitPrice());
				st.executeUpdate();
			}
		} finally {
			st.close();
		}
	}
}
