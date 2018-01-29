// Point out and remove the code smells in the code
class Customer {
    String homeAddress;
    String workAddress;
}
class Order {
    String orderId;
    Restaurant restaurantReceivingOrder;
    Customer customerPlacingOrder;

    //"H": deliver to home address of the customer.
    //"W": deliver to work address of the customer.
    //"O": deliver to the address specified here.
    String addressType;

    String otherAddress; //address if addressType is "O".
    HashMap orderItems;

    public String getDeliveryAddress() {
        if (addressType.equals("H")) {
            return customerPlacingOrder.getHomeAddress();
        } else if (addressType.equals("W")) {
            return customerPlacingOrder.getWorkAddress();
        } else if (addressType.equals("O")) {
            return otherAddress;
        } else {
            return null;
        }
    }
}