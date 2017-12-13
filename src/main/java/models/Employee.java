package models;

public class Employee {
    private String employeeID;
    private String ID;
    private double salary;
    private String position;

    public Employee(String employeeID, String id, double salary, String position) {
        this.employeeID = employeeID;
        ID = id;
        this.salary = salary;
        this.position = position;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getID() {
        return ID;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }
}
