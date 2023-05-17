public class Employee {
    private final String firstName;
    private final String lastName;
    private final String pesel;
    private final String departmentName;
    private final int salary;

    public String getDepartmentName() {
        return departmentName;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String firstName, String lastName, String pesel, String departmentName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + pesel + " " + departmentName + " " + salary;
    }
}

