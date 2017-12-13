package models;

public class FamilyDetail {
    private String status;
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;
    private String phoneNumber;

    public FamilyDetail(String status, String firstName, String lastName, int age, String occupation, String phoneNumber) {
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
