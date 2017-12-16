package models;

public class EmploymentRecord {
    private String fromM;
    private String fromY;
    private String toM;
    private String toY;
    private String company;
    private String position;
    private double salary;
    private String reasonForLeaving;


    public EmploymentRecord(String fromM, String fromY, String toM, String toY, String company, String position, double salary, String reasonForLeaving) {
        this.fromM = fromM;
        this.fromY = fromY;
        this.toM = toM;
        this.toY = toY;
        this.company = company;
        this.position = position;
        this.salary = salary;
        this.reasonForLeaving = reasonForLeaving;
    }

    public String getFromM() {
        return fromM;
    }

    public String getFromY() {
        return fromY;
    }

    public String getToM() {
        return toM;
    }

    public String getToY() {
        return toY;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }
}
