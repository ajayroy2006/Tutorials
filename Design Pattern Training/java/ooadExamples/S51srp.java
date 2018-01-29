class Department {
	final public static Department Account = new Department("Account");
	final public static Department Marketing = new Department("Marketing");
	final public static Department CustomerServices = 
		new Department("Customer Services ");
	private String departmentName;
	private Department(String departmentName){
		this.departmentName = departmentName;
	}
	public String getDepartmentName(){
		return departmentName;
	}
}
