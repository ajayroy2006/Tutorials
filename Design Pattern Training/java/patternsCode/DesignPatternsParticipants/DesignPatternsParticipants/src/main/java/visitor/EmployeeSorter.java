package visitor;
import java.util.List;

abstract class Employee {
	// ...
}

class Engineer extends Employee {
	// ...
}

class Manager extends Employee {
	// ...
}

class Salesman extends Employee {
	// ...
}

class EmployeeSorter {
	private List<Engineer> engineers;
	private List<Salesman> salesmen;
	private List<Manager> managers;
	void sortEmployee(final Employee emp) {
		if (emp instanceof Engineer)
			engineers.add((Engineer) emp);
		else if (emp instanceof Salesman)
			salesmen.add((Salesman) emp);
		else if (emp instanceof Manager)
			managers.add((Manager) emp);
		else
			throw new IllegalArgumentException("Incorrect Employee");
	}
	// ... Other functions and variables
}
