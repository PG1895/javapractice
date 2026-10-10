public class Employee {
    private String name;
    private String department;
    private int empId;
    private double salary;

    public Employee(int empId, double salary, String name, String department) {
        this.name = name;
        this.department = department;
        this.empId = empId;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", empId=" + empId +
                ", salary=" + salary +
                '}';
    }
}
