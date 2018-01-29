//Remove the problem in code below without using Collections
public class Node {
    private Node nextNode;
    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
public class LinkList {
    private Node firstNode;
    public void addNode(Node newNode) {
        ...
    } 
    public Node getFirstNode() {
        return firstNode;
    }
}
public class Employee extends Node {
    String employeeId;
    String name;
    ...
}
public class EmployeeList extends LinkList {
    public void addEmployee(Employee employee) {
        addNode(employee);
    }
    public Employee getFirstEmployee() {
        return (Employee)getFirstNode();
    }
    ...
}
