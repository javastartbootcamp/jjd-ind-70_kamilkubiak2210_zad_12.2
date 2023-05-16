import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/employees.csv");
        Factory factory = new Factory();
        Employee[] employees = factory.employeesDataReader(file);

        if (file.exists()) {
            File stats = new File("src/main/stats.txt");

            FileWriter fileWriter = new FileWriter(stats);
            fileWriter.write(factory.printInfoAboutFactory(employees));

            fileWriter.close();
        }
    }
}
