package models;

public class Employee {
    private String employeeID;
    private double salary;
    private String position;

    public Employee(String employeeID, double salary, String position) {
        this.employeeID = employeeID;
        this.salary = salary;
        this.position = position;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }
}
