enum DeliveryAddress {
    HOME_ADDRESS, WORK_ADDRESS, OTHER_ADDRESS;
}
class Order {
    String orderId;
    Restaurant restToReceiveOrder;
    Customer customerPlacingOrder;

    String shippingAddress;
    HashMap orderItems;
    Iterator getItemsIterator() {
        return orderItems.values().iterator();
    }

    public double getTotalAmount() {
        BigDecimal totalAmt= new BigDecimal("0.00");
        for (Iterator iter=getItemsIterator(); iter.hasNext(); ){
            OrderItem nextOrderItem=(OrderItem)iter.next();
            totalAmt = totalAmt.add( new BigDecimal(
                    String.valueOf(nextOrderItem.getAmount())));
        }
        return totalAmt.doubleValue();
    }
}
