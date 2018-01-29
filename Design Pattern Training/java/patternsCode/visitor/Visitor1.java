import java.util.LinkedList;
import java.util.List;

abstract class Employee {
	String name;
	Employee(final String name) {
		this.name = name;
	}
	abstract void visit(EmployeeVisitor ev);
}

class HourlyEmployee extends Employee {
	int hours;
	HourlyEmployee(final String name, final int hours) {
		super(name);
		this.hours = hours;
	}
	@Override void visit(final EmployeeVisitor ev) {
		ev.visit(this);
	}
}

class SalariedEmployee extends Employee {
	int salary;
	SalariedEmployee(final String name, final int salary) {
		super(name);
		this.salary = salary;
	}
	@Override void visit(final EmployeeVisitor ev) {
		ev.visit(this);
	}
}

interface EmployeeVisitor {
	void visit(HourlyEmployee e);
	void visit(SalariedEmployee e);
}

class EmployeeReportVisitor implements EmployeeVisitor {
	void printEmployees(final List<Employee> all) {
		for (Employee e : all)
			e.visit(this);
	}
	@Override public void visit(final HourlyEmployee e) {
		System.out.printf("Hourly %s worked for %d hours", e.name,
		        e.hours);
	}
	@Override public void visit(final SalariedEmployee e) {
		System.out.printf("Salaried %s has salary %d", e.name,
		        e.salary);
	}
}

public class Visitor1 {
	public static void main(final String[] args) {
		List<Employee> e = new LinkedList<Employee>();
		e.add(new HourlyEmployee("bob", 10));
		e.add(new SalariedEmployee("sam", 500));
		e.add(new HourlyEmployee("boby", 12));
		e.add(new SalariedEmployee("sammy", 600));
		EmployeeReportVisitor erv = new EmployeeReportVisitor();
		erv.printEmployees(e);
	}
}
