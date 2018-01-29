abstract class Employee {
    private String name, address;
    private long id, mobile;
    //Assume public constructor, getters,setters, toString and other common functions.
    abstract int calculateHolidaysPermitted(int month);
}

class PermanentEmployee extends Employee {
    @Override
    int calculateHolidaysPermitted(int month) {
        return (month == 12)?4:3;
    }
}

class TemporaryEmployee extends Employee {
    @Override
    int calculateHolidaysPermitted(int month) {
        return 2;
    }
}
//Replace simple hierarchy with Higher-order functions