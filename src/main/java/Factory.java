import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Factory {

    public Employee[] employeesDataReader(File fileName) throws IOException {
        int lines = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.readLine() != null) {
                lines++;
            }
        }
        Employee[] employees = new Employee[lines];
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int employeesCount = 0;
            while ((line = bufferedReader.readLine()) != null) {

                String[] strings = line.split(";");

                String firstName = strings[0];
                String lastName = strings[1];
                String pesel = strings[2];
                String departmentName = strings[3];
                int salary = Integer.parseInt(strings[4]);
                employees[employeesCount] = new Employee(firstName, lastName, pesel, departmentName, salary);
                employeesCount++;

            }
        }
        return employees;
    }

    public String printInfoAboutFactory(Employee[] employees) {
        int employeeCount = 0;
        int allEmployeesSalary = 0;
        int minSalary = 1000_000;
        int maxSalary = 1;
        int itWorker = 0;
        int supportWorker = 0;
        int managementWorker = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                employeeCount++;
                int employeeSalary = employee.getSalary();
                allEmployeesSalary += employeeSalary;
                if (employeeSalary > maxSalary) {
                    maxSalary = employeeSalary;
                }
                if (employeeSalary < minSalary) {
                    minSalary = employeeSalary;
                }
                switch (employee.getDepartmentName()) {
                    case "Management" -> managementWorker++;
                    case "IT" -> itWorker++;
                    case "Support" -> supportWorker++;
                    default -> throw new IllegalStateException("Nieznana wartość: " + employee.getDepartmentName());
                }
            }
        }
        int averageSalary = allEmployeesSalary / employeeCount;

        return "Średnia wypłata: " + averageSalary
                + "\nMinimalna wypłata: " + minSalary
                + "\nMaksymalna wypłata: " + maxSalary
                + "\nLiczba pracowników IT: " + itWorker
                + "\nLiczba pracowników Support: " + supportWorker
                + "\nLiczba pracowników Management: " + managementWorker;
    }
}