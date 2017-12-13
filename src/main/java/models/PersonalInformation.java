package models;

import java.util.ArrayList;
import java.util.Calendar;

public class PersonalInformation {
    private String ID;
    private String titleTH;
    private String fNameTH;
    private String lNameTH;
    private String fNameEN;
    private String lNameEN;
    private String address;
    private String email;
    private String phoneNumber;
    private Calendar dateOfBirth;
    private String placeOfBirth;
    private double weight;
    private double heigth;
    private String nationality;
    private String race;
    private String religion;
    private String profNo;
    private String militaryStatus;
    private String  maritalStatus;
    private String emergencyContact;
    private int toeicScore;
    private int toeicYear;
    private int toeflScore;
    private int toeflYear;
    private int word;
    private int excel;
    private int powerpoint;
    private boolean driveCar;
    private boolean ownCar;
    private String driveLicenseCar;
    private boolean rideMotocycle;
    private boolean ownMotocycle;
    private boolean driveLicenseMotocycle;
    private String hobby;
    private boolean q1;
    private boolean q2;
    private boolean q3;
    private boolean q4;
    private boolean q5;
    private ArrayList<Q6> q6;

    public PersonalInformation(String id, String titleTH, String fNameTH, String lNameTH, String fNameEN, String lNameEN, String address, String email, String phoneNumber, Calendar dateOfBirth, String placeOfBirth, double weight, double heigth, String nationality, String race, String religion, String profNo, String militaryStatus, String maritalStatus, String emergencyContact, int toeicScore, int toeicYear, int toeflScore, int toeflYear, int word, int excel, int powerpoint, boolean driveCar, boolean ownCar, String driveLicenseCar, boolean rideMotocycle, boolean ownMotocycle, boolean driveLicenseMotocycle, String hobby, boolean q1, boolean q2, boolean q3, boolean q4, boolean q5, ArrayList<Q6> q6) {
        ID = id;
        this.titleTH = titleTH;
        this.fNameTH = fNameTH;
        this.lNameTH = lNameTH;
        this.fNameEN = fNameEN;
        this.lNameEN = lNameEN;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.weight = weight;
        this.heigth = heigth;
        this.nationality = nationality;
        this.race = race;
        this.religion = religion;
        this.profNo = profNo;
        this.militaryStatus = militaryStatus;
        this.maritalStatus = maritalStatus;
        this.emergencyContact = emergencyContact;
        this.toeicScore = toeicScore;
        this.toeicYear = toeicYear;
        this.toeflScore = toeflScore;
        this.toeflYear = toeflYear;
        this.word = word;
        this.excel = excel;
        this.powerpoint = powerpoint;
        this.driveCar = driveCar;
        this.ownCar = ownCar;
        this.driveLicenseCar = driveLicenseCar;
        this.rideMotocycle = rideMotocycle;
        this.ownMotocycle = ownMotocycle;
        this.driveLicenseMotocycle = driveLicenseMotocycle;
        this.hobby = hobby;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
    }


    public String getID() {
        return ID;
    }

    public String getTitleTH() {
        return titleTH;
    }

    public String getfNameTH() {
        return fNameTH;
    }

    public String getlNameTH() {
        return lNameTH;
    }

    public String getfNameEN() {
        return fNameEN;
    }

    public String getlNameEN() {
        return lNameEN;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeigth() {
        return heigth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getRace() {
        return race;
    }

    public String getReligion() {
        return religion;
    }

    public String getProfNo() {
        return profNo;
    }

    public String getMilitaryStatus() {
        return militaryStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public int getToeicScore() {
        return toeicScore;
    }

    public int getToeicYear() {
        return toeicYear;
    }

    public int getToeflScore() {
        return toeflScore;
    }

    public int getToeflYear() {
        return toeflYear;
    }

    public int getWord() {
        return word;
    }

    public int getExcel() {
        return excel;
    }

    public int getPowerpoint() {
        return powerpoint;
    }

    public boolean isDriveCar() {
        return driveCar;
    }

    public String getDriveLicenseCar() {
        return driveLicenseCar;
    }

    public boolean isOwnCar() {
        return ownCar;
    }

    public boolean isRideMotocycle() {
        return rideMotocycle;
    }

    public boolean isOwnMotocycle() {
        return ownMotocycle;
    }

    public String getHobby() {
        return hobby;
    }

    public boolean isDriveLicenseMotocycle() {
        return driveLicenseMotocycle;
    }

    public boolean isQ1() {
        return q1;
    }

    public boolean isQ2() {
        return q2;
    }

    public boolean isQ3() {
        return q3;
    }

    public boolean isQ4() {
        return q4;
    }

    public boolean isQ5() {
        return q5;
    }

    public ArrayList<Q6> getQ6() {
        return q6;
    }
}
