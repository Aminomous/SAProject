package services;

import models.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DatabaseApplicationService extends DatabaseDataService<Application> {

    public DatabaseApplicationService(String url, DatabaseConnector connector) {
        super(url, connector);
    }

    @Override
    List<String> getCreateTableQueries() {
        List<String> queries = new ArrayList<String>();
        queries.add("CREATE TABLE product (product_id varchar(8) NOT NULL, name text NOT NULL, price double NOT NULL, quantity int(11) NOT NULL, PRIMARY KEY (product_id))");
        return queries;
    }

    public ArrayList<ApplicantDocument> getDocuments(Application application) {
        ArrayList<ApplicantDocument> documents = new ArrayList<ApplicantDocument>();

        try {
            connect();

            String query = "select id, refnum, description from applicant_documents";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                int id = result.getInt(1);
                int ref = result.getInt(2);
                String desc = result.getString(3);
                ApplicantDocument doc = new ApplicantDocument(id, ref, desc);
                documents.add(doc);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }

    public byte[] getFileFromDocument(ApplicantDocument doc) {
        byte[] document = null;
        try {
            connect();

            String query = "select document from applicant_documents where id=" + doc.getId();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                try {

//                    Blob blob = result.getBlob("document");
//
//                    InputStream in = blob.getBinaryStream();
//                    System.out.println("blob length" + blob.length());
//                    return in;
                    byte[] buffer = result.getBytes(1);
                    InputStream in = result.getBinaryStream(1);
                    return buffer;

                } catch (SQLException e) {

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Application> getAll() {
        ArrayList<Application> applications = new ArrayList<Application>();
        try {
            connect();
            String query = "select * from Application";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                int refnum = result.getInt(1);
                String dateRaw = result.getString(2);
                String position1 = result.getString(3);
                String position2 = result.getString(4);
                boolean workInShift = result.getBoolean(5);
                String workerType = result.getString(6);
                double salary = result.getDouble(7);
                String statingDateRaw = result.getString(8);
                String citizeniD = result.getString(9);
                String qh2 = result.getString(10);
                String qh3 = result.getString(11);
                String relativeWorkInHospital = result.getString(12);
                String additionalInformation = result.getString(13);
                boolean status1 = result.getBoolean(14);
                boolean status2 = result.getBoolean(15);
                boolean status3 = result.getBoolean(16);
                boolean status4 = result.getBoolean(17);
                boolean status5 = result.getBoolean(18);
                int status6 = result.getInt(19);

                ArrayList<Apprenticeship> apprenticeships = getApprenticeship(citizeniD);
                ArrayList<Education> educations = getEducation(citizeniD);
                Employee employee = getEmployee(citizeniD);
                ArrayList<EmploymentRecord> employmentRecords = getEmploymentRecords(citizeniD);
                ArrayList<FamilyDetail> familyDetails = getFamilyDetail(citizeniD);
                ArrayList<Hospital> hospitals = getHospital(refnum);
                ArrayList<LanguageAbility> languageAbilities = getLanguageAbility(citizeniD);
                PersonalInformation personalInformation = getPersonalInformation(citizeniD);
                ArrayList<QH1> qh1 = getQH1(refnum);
                ArrayList<ReferencePerson> referencePeople = getReferencePerson(refnum);

                String[] temp = dateRaw.split("-");
                GregorianCalendar date = new GregorianCalendar();
                GregorianCalendar startingDate = new GregorianCalendar();
                date.set(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
                temp = statingDateRaw.split("-");
                startingDate.set(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));

                applications.add(new Application(refnum, date, position1, position2, workInShift, workerType, salary, startingDate, qh1, qh2, qh3, relativeWorkInHospital, additionalInformation, apprenticeships, educations, employee, employmentRecords, familyDetails, hospitals, languageAbilities, personalInformation, referencePeople, status1, status2, status3, status4, status5, status6));
            }

            close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return applications;
    }

    private ArrayList<Apprenticeship> getApprenticeship(String citizenID) throws ClassNotFoundException, SQLException {
        ArrayList<Apprenticeship> apprenticeships = new ArrayList<Apprenticeship>();
        String query = "select * from Apprenticeship where (citizenID = " + citizenID + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String course = result.getString(2);
            String instituteName = result.getString(3);
            String certificate = result.getString(4);
            String period = result.getString(5);
            apprenticeships.add(new Apprenticeship(course, instituteName, certificate, period));
        }
        return apprenticeships;
    }

    private ArrayList<Education> getEducation(String citizenID) throws ClassNotFoundException, SQLException {
        ArrayList<Education> educations = new ArrayList<Education>();
        String query = "select * from Education where (citizenID = " + citizenID + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String level = result.getString(2);
            String instituteName = result.getString(3);
            String degreeOrCertificate = result.getString(4);
            String major = result.getString(5);
            String studyFromRaw = result.getString(6);
            String studyToRaw = result.getString(7);
            double gpa = result.getDouble(8);

            GregorianCalendar studyFrom = new GregorianCalendar();
            GregorianCalendar studyTo = new GregorianCalendar();
            String[] temp = studyFromRaw.split("-");
            studyFrom.set(Calendar.YEAR, Integer.valueOf(temp[0]));
            temp = studyToRaw.split("-");
            studyTo.set(Calendar.YEAR, Integer.valueOf(temp[0]));

            educations.add(new Education(level, instituteName, degreeOrCertificate, major, studyFrom, studyTo, gpa));
        }
        return educations;
    }

    private Employee getEmployee(String citizenID) throws ClassNotFoundException, SQLException {
        Employee employee = null;
        String query = "select * from Employee where (citizenID = " + citizenID + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String employeeID = result.getString(1);
            double salary = result.getDouble(3);
            String position = result.getString(4);

            employee = new Employee(employeeID, salary, position);
        }
        return employee;
    }

    private ArrayList<EmploymentRecord> getEmploymentRecords(String citizenID) throws ClassNotFoundException, SQLException {
        ArrayList<EmploymentRecord> employmentRecords = new ArrayList<EmploymentRecord>();
        String query = "select * from EmploymentRecord where (citizenID = " + citizenID + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String fromM = result.getString(2);
            String fromY = result.getString(3);
            String toM = result.getString(4);
            String toY = result.getString(5);
            String company = result.getString(6);
            String workerType = result.getString(7);
            double salary = result.getDouble(8);
            String reasonForLeaving = result.getString(9);

            employmentRecords.add(new EmploymentRecord(fromM, fromY, toM, toY, company, workerType, salary, reasonForLeaving));
        }
        return employmentRecords;
    }

    private ArrayList<FamilyDetail> getFamilyDetail(String citizenID) throws ClassNotFoundException, SQLException {
        ArrayList<FamilyDetail> familyDetails = new ArrayList<FamilyDetail>();
        String query = "select * from FamilyDetail where (citizenID = " + citizenID + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String status = result.getString(2);
            String firstName = result.getString(3);
            String lastName = result.getString(4);
            int age = result.getInt(5);
            String occupation = result.getString(6);
            String address = result.getString(7);
            String phoneNumber = result.getString(8);

            familyDetails.add(new FamilyDetail(status, firstName, lastName, age, occupation, address, phoneNumber));
        }
        return familyDetails;
    }

    private ArrayList<Hospital> getHospital(int refnum) throws ClassNotFoundException, SQLException {
        ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
        String query = "select * from Hospital where (refnum = " + refnum + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String hospitalName = result.getString(2);

            hospitals.add(new Hospital(hospitalName));
        }
        return hospitals;
    }

    private ArrayList<LanguageAbility> getLanguageAbility(String citizenID) throws ClassNotFoundException, SQLException {
        ArrayList<LanguageAbility> languageAbilities = new ArrayList<LanguageAbility>();
        String query = "select * from LanguageAbility where (citizenID = " + citizenID + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String language = result.getString(2);
            int speaking = result.getInt(3);
            int reading = result.getInt(4);
            int writing = result.getInt(5);

            languageAbilities.add(new LanguageAbility(language, speaking, reading, writing));
        }
        return languageAbilities;
    }

    private PersonalInformation getPersonalInformation(String citizenID) throws ClassNotFoundException, SQLException {
        PersonalInformation personalInformation = new PersonalInformation();
        String query = "select * from PersonalInformation where (citizenID = " + citizenID + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {

            String ID = result.getString(1);
            String titleTH = result.getString(2);
            String fNameTH = result.getString(3);
            String lNameTH = result.getString(4);
            String fNameEN = result.getString(5);
            String lNameEN = result.getString(6);
            String address = result.getString(7);
            String email = result.getString(8);
            String phoneNumber = result.getString(9);
            String dateOfBirthRaw = result.getString(10);
            String placeOfBirth = result.getString(11);
            double weight = result.getDouble(12);
            double height = result.getDouble(13);
            String nationality = result.getString(14);
            String race = result.getString(15);
            String religion = result.getString(16);
            String profNo = result.getString(17);
            String militaryStatus = result.getString(18);
            String maritalStatus = result.getString(19);
            String emergencyContact = result.getString(20);
            int toeicScore = result.getInt(22);
            int toeicYear = result.getInt(23);
            int toeflScore = result.getInt(24);
            int toeflYear = result.getInt(25);
            int word = result.getInt(26);
            int excel = result.getInt(27);
            int powerpoint = result.getInt(28);
            boolean driveCar = result.getBoolean(29);
            boolean ownCar = result.getBoolean(30);
            String driveLicenseCar = result.getString(31);
            boolean rideMotorcycle = result.getBoolean(32);
            boolean ownMotorcycle = result.getBoolean(33);
            String driveLicenseMotorcycle = result.getString(34);
            String hobby = result.getString(35);
            boolean q1 = result.getBoolean(36);
            boolean q2 = result.getBoolean(37);
            boolean q3 = result.getBoolean(38);
            boolean q4 = result.getBoolean(39);
            String q5 = result.getString(40);


            String[] temp = dateOfBirthRaw.split("-");
            GregorianCalendar dateOfBirth = new GregorianCalendar();
            dateOfBirth.set(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
            ArrayList<Q6> q6s = getQ6(citizenID);


            personalInformation = new PersonalInformation(ID, titleTH, fNameTH, lNameTH, fNameEN, lNameEN, address, email, phoneNumber, dateOfBirth, placeOfBirth, weight, height, nationality, race, religion, profNo, militaryStatus, maritalStatus, emergencyContact, toeicScore, toeicYear, toeflScore, toeflYear, word, excel, powerpoint, driveCar, ownCar, driveLicenseCar, rideMotorcycle, ownMotorcycle, driveLicenseMotorcycle, hobby, q1, q2, q3, q4, q5, q6s);
        }
        return personalInformation;
    }

    private ArrayList<Q6> getQ6(String citizenID) throws ClassNotFoundException, SQLException {
        ArrayList<Q6> q6s = new ArrayList<Q6>();
        String query = "select * from Q6 where (citizenID = " + citizenID + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String mediaType = result.getString(2);
            String detail = result.getString(3);

            q6s.add(new Q6(mediaType, detail));
        }
        return q6s;
    }

    private ArrayList<QH1> getQH1(int refnum) throws ClassNotFoundException, SQLException {
        ArrayList<QH1> qh1s = new ArrayList<QH1>();
        String query = "select * from QH1 where (refnum = " + refnum + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            int type = result.getInt(2);
            String detail = result.getString(3);

            qh1s.add(new QH1(type, detail));
        }
        return qh1s;
    }

    private ArrayList<ReferencePerson> getReferencePerson(int refnum) throws ClassNotFoundException, SQLException {
        ArrayList<ReferencePerson> getReferencePeople = new ArrayList<ReferencePerson>();
        String query = "select * from QH1 where (refnum = " + refnum + ")";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            String name = result.getString(2);
            String relationship = result.getString(3);
            String address = result.getString(4);
            String phoneNumber = result.getString(5);

            getReferencePeople.add(new ReferencePerson(name, relationship, address, phoneNumber));
        }
        return getReferencePeople;
    }


    public void update(Application data) {
        try {
            connect();

            String query = String.format("update Application set applicationstatus1 = %d, applicationstatus2 = %d, applicationstatus3 = %d, applicationstatus4 = %d, applicationstatus5 = %d, applicationstatus6 = %d where refnum = %d", data.isApplicationStatus1() ? 1 : 0, data.isApplicationStatus2() ? 1 : 0, data.isApplicationStatus3() ? 1 : 0, data.isApplicationStatus4() ? 1 : 0, data.isApplicationStatus5() ? 1 : 0, data.getApplicationStatus6(), data.getRefnum());
            Statement statement = conn.createStatement();
            statement.execute(query);

            statement.execute(query);

            close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void upload(Application application, String description, String contentType, File file) {

        try {

            connect();
            if (contentType.equals("photo")) {
                String query = "update personalinformation set photo=? where citizenid=?";
                PreparedStatement p = conn.prepareStatement(query);

                try {
                    FileInputStream fis = new FileInputStream(file);
                    p.setBinaryStream(1, fis);

                    p.executeUpdate();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                p.setString(2, application.getPersonalInformation().getID());
                p.executeUpdate();
            } else {
                String query = "insert into applicant_documents (refnum, document, description) values (?, ?, ?)";
                try {
                    PreparedStatement p = conn.prepareStatement(query);
                    FileInputStream input = new FileInputStream(file);

                    p.setInt(1, application.getRefnum());
                    p.setBinaryStream(2, input);
                    p.setString(3, description);

                    p.executeUpdate();
                } catch (SQLException e) {
                    PreparedStatement p = conn.prepareStatement(query);

                    byte[] buffer = new byte[(int) file.length()];
                    InputStream ios = new FileInputStream(file);
                    try {
                        ios.read(buffer);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    p.setInt(1, application.getRefnum());
                    p.setBytes(2, buffer);
                    p.setString(3, description);

                    p.executeUpdate();
                }
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Application data) {
        try {
            connect();
            String query = "";
            Statement statement = conn.createStatement();
            statement.execute(query);
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
