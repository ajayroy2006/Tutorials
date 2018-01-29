class Customer {
    String homeAddress;
    String workAddress;
}
interface DeliveryAddress {
}
class HomeAddress implements DeliveryAddress {
    Customer customer;
    HomeAddress(Customer customer) {
        ...
    }
    String toString() {
        return customer.getHomeAddress();
    }
}
class WorkAddress implements DeliveryAddress {
    Customer customer;
    WorkAddress(Customer customer) {
    ...
    }
    String toString() {
        return customer.getWorkAddress();
    }
}
class SpecifiedAddress implements DeliveryAddress {
    String addressSpecified;
    SpecifiedAddress(String addressSpecified) {
    ...
    }
    String toString() {
        return addressSpecified;
    }
}
class Order {
    String orderId;
    Restaurant restaurantReceivingOrder;
    Customer customerPlacingOrder;
    DeliveryAddress deliveryAddress;
    HashMap orderItems;
    public String getDeliveryAddress() {
        return deliveryAddress.toString();
    }
}
