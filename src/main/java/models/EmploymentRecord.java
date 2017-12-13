package models;

import java.util.Calendar;

public class EmploymentRecord {
    private Calendar fromM;
    private Calendar fromY;
    private Calendar toM;
    private Calendar toY;
    private String company;
    private String workerType;
    private double salary;
    private String reasonForLeaving;


    public EmploymentRecord(Calendar fromM, Calendar fromY, Calendar fromM1, Calendar toM, Calendar toY, String company, String workerType, double salary, String reasonForLeaving) {
        this.fromM = fromM;
        this.fromY = fromY;
        this.fromM = fromM1;
        this.toM = toM;
        this.toY = toY;
        this.company = company;
        this.workerType = workerType;
        this.salary = salary;
        this.reasonForLeaving = reasonForLeaving;
    }

    public Calendar getFromM() {
        return fromM;
    }

    public Calendar getFromY() {
        return fromY;
    }

    public Calendar getToM() {
        return toM;
    }

    public Calendar getToY() {
        return toY;
    }

    public String getCompany() {
        return company;
    }

    public String getWorkerType() {
        return workerType;
    }

    public double getSalary() {
        return salary;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }
}
