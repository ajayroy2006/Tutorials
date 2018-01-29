//EmployeeList does not want to inherit the addNode method.
//Employee is not a Node.
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
public class Employee {
	String employeeId;
	String name;
	...
} 
public class EmployeeNode extends Node {
	Employee employee;
}
public class EmployeeList {
	LinkList list;
	public void addEmployee(Employee employee) {
		list.addNode(new EmployeeNode(employee));
	}
	public Employee getFirstEmployee() {
		return ((EmployeeNode)list.getFirstNode()).getEmployee();
	}
	...
}
