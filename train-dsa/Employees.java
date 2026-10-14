import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


record Employee(Long id, String name, String department, Double salary) {

    public Employee(String name) {
        this(0l,name, "", Double.valueOf(0));
    }

    public Employee() {
        this(0l, "", "", Double.valueOf(0));
    }

}

public class Employees {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(1l, "Mayank", "Development", Double.valueOf(250000));
        Employee employee1 = new Employee(2l, "Naitik", "Sales", Double.valueOf(150000));
        Employee employee2 = new Employee(3l, "Harish", "Marketing", Double.valueOf(120000));
        Employee employee3 = new Employee(4l, "Abhiyank", "Development", Double.valueOf(350000));
        Employee employee4 = new Employee(5l, "Mona", "Sales", Double.valueOf(735000));
        Employee employee5 = new Employee(6l, "Monika", "Marketing", Double.valueOf(1300000));
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        // System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::department)));;
        // System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting())));
        // System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary))));

        // employees.stream().map(e ->e.salary()).sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().ifPresent(System.out::println);

        // employees.stream().map(e->e.salary()).sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().ifPresent(System.out::println);


        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::salary)), e->e.get().salary()))));;
    }
}


