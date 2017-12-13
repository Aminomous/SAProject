package models;

public class ReferencePerson {
    private String name;
    private String relationship;
    private String address;
    private String phoneNumber;

    public ReferencePerson(String name, String relationship, String address, String phoneNumber) {
        this.name = name;
        this.relationship = relationship;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
