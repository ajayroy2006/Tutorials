/* This application is about restaurants. An order has an order ID,
 * a restaurant ID and a customer ID and contains some order items.
 * Each order item contains the food ID, the quantity and unit price.
 * You have created the tables and classes below.
        create table Orders (
        orderId varchar(20) primary key,
        customerId varchar(20) not null,
        restId varchar(20) not null
        );
        create table OrderItems (
        orderId varchar(20),
        itemId int,
        foodId varchar(20) not null,
        quantity int not null,
        unitPrice float not null,
        primary key(orderId, itemId)
        );
*/
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
/*Your tasks are:
1. Create an interface for accessing the orders, while hiding the database.
2. Create a class to implement that interface and show how to implement
   its method for adding an order to the database.
*/