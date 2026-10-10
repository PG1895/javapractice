import java.util.*;

public class Collections {
    public static void main(String[] args) {
        //NORMAL with CONSTRUCTOR
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, 10000, "POOJA", "IT"));
        employeeList.add(new Employee(102, 20000, "KRISHIV", "HOME"));
        employeeList.add(new Employee(103, 30000, "KAILASH", "IT"));
        employeeList.add(new Employee(104, 50000, "RUDRANSH", "SCHOOL"));
        employeeList.add(new Employee(104, 50000, "RUDRANSH", "SCHOOL"));

        for (Employee e : employeeList) {
            System.out.println(e);
        }

        //LIST
        List<Employee> employeeList1 = new ArrayList<>();
        Employee e1 = new Employee(101, 10000, "POOJA", "IT");
        Employee e2 = new Employee(102, 20000, "KRISHIV", "HOME");
        Employee e3 = new Employee(103, 30000, "KAILASH", "IT");
        Employee e4 = new Employee(104, 50000, "RUDRANSH", "SCHOOL");
        Employee e5 = new Employee(104, 50000, "RUDRANSH", "SCHOOL");
        employeeList1.add(e1);
        employeeList1.add(e2);
        employeeList1.add(e3);
        employeeList1.add(e4);
        employeeList1.add(e5);
        System.out.println("ArrayList: " + employeeList1);

        List<Employee> linkedList = new LinkedList<>(employeeList1);
        System.out.println("linkedList: " + linkedList);

        Vector<Employee> vector = new Vector<>(employeeList1);
        System.out.println("Vector: " + vector);

        Stack<Employee> stack = new Stack<>();
        stack.push(e1);
        stack.push(e2);
        stack.push(e4);
        stack.push(e5);
        stack.push(e3);
        System.out.println("stack: " + stack);
        //System.out.println("Stack top: " + stack.peek()); == getTop
        //System.out.println("Stack pop: " + stack.pop()); == remove
        //-------------------SET--------------

        Set<Employee> hashSet = new HashSet<>(employeeList1);
        System.out.println("hashSet: " + hashSet);

        Set<Employee> linkedHashSet = new LinkedHashSet<>(employeeList1);
        System.out.println("linkedHashSet: " + linkedHashSet);

        Set<Employee> treeSet = new TreeSet<>
                (Comparator.comparingInt(Employee::getEmpId));
        treeSet.addAll(employeeList1);
        System.out.println("treeSet: " + treeSet);

        //-------------------QUEUE--------------
            //highest salary
        Queue<Employee> priorityQueue = new PriorityQueue<>(
                Comparator.comparingDouble(Employee::getSalary).reversed());
        priorityQueue.addAll(employeeList);
        System.out.println("priorityQueue: " + priorityQueue);

        //HASHMAP
        Map<Integer, Employee> hashMap = new HashMap<>();
        for (Employee e : employeeList1) {
            hashMap.put(e.getEmpId(), e);
        }
        System.out.println("hashMap get id 102: " + hashMap.get(102));

        //LinkedHashMap
        Map<Integer, Employee> linkedHashMap = new LinkedHashMap<>();
        for (Employee e : employeeList1) {
            linkedHashMap.put(e.getEmpId(), e);
        }
        System.out.println("linkedHashMap " + linkedHashMap);


    //TREEMAP
    Map<Integer, Employee> treeMap = new TreeMap<>();
    for (Employee e: employeeList1) {
        treeMap.put(e.getEmpId(), e);
    }
        System.out.println("treeMap " + treeMap);
    }
}
