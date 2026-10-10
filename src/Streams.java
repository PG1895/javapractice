import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Streams {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 40, 30, 10, 53, 77);
        // find unique values / remove duplicate
        List<Integer> distinctNumbers = new ArrayList<>(numbers.stream()
                .distinct().collect(Collectors.toList()));
        System.out.println("distinctNumbers : " + distinctNumbers);

        // find duplicate
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicateNumbers = new ArrayList<>(numbers.stream()
                .filter(n -> !seen.add(n))
                .distinct()
                .collect(Collectors.toList()));
        System.out.println("duplicateNumbers : " + duplicateNumbers);

//        //find duplicate and count
//        List<Integer> duplicateCount = new ArrayList<>(numbers.stream()
//        )

        //FilterEvenNos
        List<Integer> evenNo = new ArrayList<>(numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList()));

        System.out.println("evenNo : " + evenNo);

        //convert List String to upperCase
        List<String> name = new ArrayList<>();
        name.add("pooja");
        name.add("arti");

        List<String> uppercase = new ArrayList<>(name.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList()));

        System.out.println("uppercase : " + uppercase);

        //sum of numbers ==
        // Reduce is used to combine multiple elements into a single result,
        // such as a sum, product, maximum, or minimum.

        int sumReduce = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("sumReduce : " + sumReduce);

        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("product : " + product);

        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE,
                        (a, b) -> a > b ? a : b);
        System.out.println("max : " + max);

        int min = numbers.stream()
                .reduce(Integer.MAX_VALUE,
                        (a, b) -> a < b ? a : b);
        System.out.println("min : " + min);


        //count freq of no
        Map<Integer, Long> freq = new HashMap<>(numbers.stream()
                .collect(Collectors.groupingBy(
                        n -> n, Collectors.counting()
                )));
        System.out.println("freq : " + freq);


        //second lowest no
        int secondLowest = numbers.stream()
                .distinct()
                .sorted().skip(1).findFirst().get();

        System.out.println("secondLowest : " + secondLowest);

        //second highest no
        int secondHighest = numbers.stream()
                .distinct().sorted((a, b) -> b - a)
                .skip(1).findFirst().get();

        System.out.println("secondHighest : " + secondHighest);

        //sort employees by salary
        List<Employee> employeeList = new ArrayList<>();
        Employee e1 = new Employee(101, 10000, "POOJA", "IT");
        Employee e2 = new Employee(102, 20000, "KRISHIV", "HOME");
        Employee e3 = new Employee(103, 30000, "KAILASH", "IT");
        Employee e4 = new Employee(104, 50000, "RUDRANSH", "SCHOOL");
        Employee e5 = new Employee(105, 50000, "SHIVANSH", "SCHOOL");
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        // for highest to lowest
        List<Employee> empSortBySal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList()).reversed();

        System.out.println("empSortBySal : " + empSortBySal);

        //for lowest to highest
        List<Employee> empLowSal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println("empLowSal : " + empLowSal);

        //sort by sal and then name
        List<Employee> salNameSort = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());

        System.out.println("salNameSort : " + salNameSort);

        //group by dept
        Map<String, List<Employee>> groupDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupDept.forEach((dept, list) ->
                System.out.println("dept: " + dept + " emp: " + list));

        //highest salary per department
        Map<String, Optional<Employee>> highSalDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary
                        ))));

        highSalDept.forEach((dept, emp) ->
                System.out.println("dept: " + dept + " emp: " + emp));


        //

    }

}
