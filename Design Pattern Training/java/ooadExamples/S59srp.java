class Order {
    String orderId;
    String customerId;
    String supplierId;
    Date orderDate;
    OrderLine[] orderLines;
}
class OrderLine {
    String productName;
    int quantity;
}
class Orders {
    Order orders[];
    void placeOrder(String customerId, String supplierId, ...) {
        ...
    }
    void printOrdersByCustomer(String customerId) {
        ...
    }
    void printOrdersForSupplier(String supplierId) {
        ...
    }
}
class Discount {
    String supplierId;
    String customerId;
    String productName;
    double discountRate;
}
class Discounts {
    Discount discounts[];
    void addDiscount(String supplierId, String customerId,
        String productName,    double discountRate) {
        ...
    }
    double findDiscount(String supplierId,String customerId,
        String productName){
        ...
    }
}
class SalesSystem {
    List customers;
    List suppliers;
    Orders orders;
    Discounts discounts;
}
