package javaapplication8;
public class HierarchyDemo {
    public static void main(String[] args) {
        Manager mgr = new Manager("kalyan", 20, "101", "IT", 5);
        
        System.out.println("=== Manager Details ===");
        System.out.println("Name: " + mgr.getName());
        System.out.println("Age: " + mgr.getAge());
        System.out.println("Employee ID: " + mgr.getEmployeeId());
        System.out.println("Department: " + mgr.getDepartment());
        System.out.println("Team Size: " + mgr.getTeamSize());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Employee extends Person {
    private String employeeId;
    private String department;

    public Employee(String name, int age, String employeeId, String department) {
        super(name, age); 
        this.employeeId = employeeId;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int age, String employeeId, String department, int teamSize) {
        super(name, age, employeeId, department); 
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
