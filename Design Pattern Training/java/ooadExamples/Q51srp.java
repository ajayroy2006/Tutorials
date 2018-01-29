class Department{
    final public int Account =0;
    final public int Marketing = 1;
    final public int CustomerServices = 2;
    protected int departmentCode;
    public Department(int departmentCode){
        this.departmentCode = departmentCode;
    }
    public String getDepartmentName(){
        switch (departmentCode){
        case Account:
            return "Account";
        case Marketing:
            return "Marketing";
        case CustomerServices:
            return "Customer Services";
        }
    }
}
