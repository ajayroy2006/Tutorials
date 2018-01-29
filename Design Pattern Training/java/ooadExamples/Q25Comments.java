//Improve the code
class Order {
    String orderId; //order ID.
    Restaurant r1; //the order is placed for this restaurant.
    Customer c1; //the order is created by this customer.
    String address; //Shipping address

    HashMap orderItems; //order items.

    //get the total amount of this order.
    public double getTotalAmt() {
        //total amount.
        BigDecimal amt= new BigDecimal("0.00");
        //for each order item do...
        Iterator iter=orderItems.values().iterator();
        while(iter.hasNext()){
            //add the amount of the next order item.
            OrderItem oi=(OrderItem)iter.next();
            amt = amt.add(new BigDecimal(
                    String.valueOf(oi.getAmount())));
        }
        return amt.doubleValue();
    }
}
