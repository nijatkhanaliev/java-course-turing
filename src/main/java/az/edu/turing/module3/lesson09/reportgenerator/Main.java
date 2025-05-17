package az.edu.turing.module3.lesson09.reportgenerator;


import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {

        Employee employee = new Employee("nicat", 1235.6, "IT", "Xanaliev");
        Employee employee1 = new Employee("samir", 1235.6, "OIL", "Hasanov");
        Employee employee2 = new Employee("Kamil", 845.3, "IT", "Karimov");
        Employee employee3 = new Employee("Kazim", 1458, "OIL", "Kazimov");


        Product product = new Product("apple", 1.2, "fruit", "eaten");

        List<Employee> employees = List.of(employee1, employee2, employee, employee3);


        Map<String, List<Employee>> map = employees.stream()
                .filter((e) -> e.getSalary() > 1000)
                .sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()))
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Set<String> strings = map.keySet();

        for (String key : strings) {
            List<Employee> employees1 = map.get(key);
            for (Employee emp : employees1) {
                writeToFile(emp);
            }
        }

        readFromFile("employee.ser");
    }

    public static void writeToFile(Object object) {
        Class<?> clazz = object.getClass();
        String lowerCase = clazz.getSimpleName().toLowerCase() + ".ser";
        boolean append = new File(lowerCase).exists();

        try (ObjectOutputStream writer = append ? new AppendableObjectOutputStream(new FileOutputStream(lowerCase,true))
                : new ObjectOutputStream(new FileOutputStream(lowerCase))) {
            writer.writeObject(object);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static ReportGenerator reportGenerator = new ReportGenerator();

    public static void readFromFile(String path) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            while (true){
                try{
                    Object o = inputStream.readObject();
                    reportGenerator.generateReport(o);
                }catch (EOFException e){
                    break;
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
