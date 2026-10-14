import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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


public class test {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(1l, "Mayank", "Development", Double.valueOf(250000));
        Employee employee1 = new Employee(2l, "Naitik", "Sales", Double.valueOf(150000));
        Employee employee2 = new Employee(3l, "Harish", "Marketing", Double.valueOf(120000));
        Employee employee3 = new Employee(4l, "Abhiyank", "Development", Double.valueOf(350000));
        Employee employee4 = new Employee(5l, "Mona", "Sales", Double.valueOf(735000));
        Employee employee5 = new Employee(6l, "Monika", "Marketing", Double.valueOf(1300000));
        Employee e = new Employee();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        // System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.summingDouble(Employee::salary))));
        // System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.maxBy(Comparator.comparing(Employee::salary)))));
        System.out.println(employees.stream().collect(Collectors.toMap(Employee::salary, Function.identity(), (e1,e2) -> e1)));
        Map<String, Double> departmentSalary = employees
        .stream()
        .collect(Collectors.groupingBy(Employee::department, 
            Collectors.summingDouble(Employee::salary)))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.
                reverseOrder()))
                .limit(3)
                .collect(Collectors
                    .toMap(Map.Entry::getKey, 
                        Map.Entry::getValue, (e1,e2) -> e1,
                         LinkedHashMap::new));
        System.out.println(departmentSalary);
    employees.stream().collect(Collectors.toMap(Employee::id, Function.identity(), (e1,e2) -> e1.salary() > e2.salary() ? e1 : e2));
    employees.stream().map(e1 -> e1.salary()).sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst();
    employees.stream().collect(Collectors.groupingBy(Employee::salary, TreeMap::new, Collectors.toList())).descendingMap().values().stream().skip(1).flatMap(List::stream).findFirst();

    employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.toMap(Employee::department, Employee::name, (e1,e2) -> e1)));
    employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    Map<String, Double> deptTotalSalaries = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.summingDouble(Employee::salary)));
    deptTotalSalaries.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresentOrElse(null, null);
    }
}
