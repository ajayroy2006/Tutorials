import java.util.function.IntFunction;

class Employee1 {
    private String name, address;
    private long id, mobile;
    int numberOfHolidays;
    //Assume getters,setters, toString and other common functions.
    private final IntFunction hoildaysPermitted;
    private Employee1(IntFunction holidaysPermitted) {
        hoildaysPermitted = holidaysPermitted;
    }
    static Employee1 CreatePermanentEmployee() {
        return new Employee1(Employee1::PermanentEmployeeHolidays);
    }
    static Employee1 CreateTemporaryEmployee() {
        return new Employee1(Employee1::TemporaryEmployeeHolidays);
    }
    static int PermanentEmployeeHolidays(int month) {
        return (month == 12)?4:3;
    }
    static int TemporaryEmployeeHolidays(int month) {
        return 2;
    }
}
