package models;

import java.util.ArrayList;
import java.util.Calendar;

public class Application {
    private int refnum;
    private Calendar date;
    private String position1;
    private String position2;
    private boolean workInShift;
    private String workerType;
    private double salary;
    private Calendar startingDate;
    private ArrayList<QH1> qh1;
    private String QH2;
    private String QH3;
    private String relativeWorkInHospital;
    private String additionalInformation;
    private ArrayList<Apprenticeship> apprenticeship;
    private ArrayList<Education> education;
    private Employee employee;
    private ArrayList<EmploymentRecord> employmentRecords;
    private ArrayList<FamilyDetail> familyDetails;
    private ArrayList<Hospital> hospitals;
    private ArrayList<LanguageAbility> languageAbilities;
    private PersonalInformation personalInformation;
    private ArrayList<ReferencePerson> referencePeople;
    private boolean applicationStatus1;
    private boolean applicationStatus2;
    private boolean applicationStatus3;
    private boolean applicationStatus4;
    private boolean applicationStatus5;

    public Application(int refnum, Calendar date, String position1, String position2, boolean workInShift, String workerType, double salary, Calendar startingDate, ArrayList<QH1> qh1, String qh2, String qh3, String relativeWorkInHospital, String additionalInformation, ArrayList<Apprenticeship> apprenticeship, ArrayList<Education> education, Employee employee, ArrayList<EmploymentRecord> employmentRecords, ArrayList<FamilyDetail> familyDetails, ArrayList<Hospital> hospitals, ArrayList<LanguageAbility> languageAbilities, PersonalInformation personalInformation, ArrayList<ReferencePerson> referencePeople, boolean applicationStatus1, boolean applicationStatus2, boolean applicationStatus3, boolean applicationStatus4, boolean applicationStatus5) {
        this.refnum = refnum;
        this.date = date;
        this.position1 = position1;
        this.position2 = position2;
        this.workInShift = workInShift;
        this.salary = salary;
        this.startingDate = startingDate;
        this.qh1 = qh1;
        QH2 = qh2;
        QH3 = qh3;
        this.relativeWorkInHospital = relativeWorkInHospital;
        this.additionalInformation = additionalInformation;
        this.apprenticeship = apprenticeship;
        this.education = education;
        this.employee = employee;
        this.employmentRecords = employmentRecords;
        this.familyDetails = familyDetails;
        this.hospitals = hospitals;
        this.languageAbilities = languageAbilities;
        this.personalInformation = personalInformation;
        this.referencePeople = referencePeople;
        this.workerType = workerType;
        this.applicationStatus1 = false;
        this.applicationStatus2 = false;
        this.applicationStatus3 = false;
        this.applicationStatus4 = false;
        this.applicationStatus5 = false;
    }

    public int getRefnum() {
        return refnum;
    }

    public Calendar getDate() {
        return date;
    }

    public String getPosition1() {
        return position1;
    }

    public String getPosition2() {
        return position2;
    }

    public boolean isWorkInShift() {
        return workInShift;
    }

    public double getSalary() {
        return salary;
    }

    public Calendar getStartintDate() {
        return startingDate;
    }

    public ArrayList<QH1> getQh1() {
        return qh1;
    }

    public String getQH2() {
        return QH2;
    }

    public String getQH3() {
        return QH3;
    }

    public String getRelaticeWorkInHospital() {
        return relativeWorkInHospital;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public ArrayList<Apprenticeship> getApprenticeship() {
        return apprenticeship;
    }

    public ArrayList<Education> getEducation() {
        return education;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ArrayList<EmploymentRecord> getEmploymentRecords() {
        return employmentRecords;
    }

    public ArrayList<FamilyDetail> getFamilyDetails() {
        return familyDetails;
    }

    public ArrayList<Hospital> getHospitals() {
        return hospitals;
    }

    public ArrayList<LanguageAbility> getLanguageAbilities() {
        return languageAbilities;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public ArrayList<ReferencePerson> getReferencePeople() {
        return referencePeople;
    }

    public boolean isApplicationStatus1() {
        return applicationStatus1;
    }

    public void setApplicationStatus1(boolean applicationStatus1) {
        this.applicationStatus1 = applicationStatus1;
    }

    public boolean isApplicationStatus2() {
        return applicationStatus2;
    }

    public void setApplicationStatus2(boolean applicationStatus2) {
        this.applicationStatus2 = applicationStatus2;
    }

    public boolean isApplicationStatus3() {
        return applicationStatus3;
    }

    public void setApplicationStatus3(boolean applicationStatus3) {
        this.applicationStatus3 = applicationStatus3;
    }

    public boolean isApplicationStatus4() {
        return applicationStatus4;
    }

    public void setApplicationStatus4(boolean applicationStatus4) {
        this.applicationStatus4 = applicationStatus4;
    }

    public boolean isApplicationStatus5() {
        return applicationStatus5;
    }

    public void setApplicationStatus5(boolean applicationStatus5) {
        this.applicationStatus5 = applicationStatus5;
    }

    public String getWorkerType() {
        return workerType;
    }

    public int getLatestStatus() {
        if (isApplicationStatus5()) {
            return 5;
        } else if (isApplicationStatus4()) {
            return 4;
        } else if (isApplicationStatus3()) {
            return 3;
        } else if (isApplicationStatus2()) {
            return 2;
        } else if (isApplicationStatus1()) {
            return 1;
        }
        return 0;
    }

}