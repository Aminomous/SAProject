package models;

public class Apprenticeship {
    private String course;
    private String instituteName;
    private String certificate;
    private String period;

    public Apprenticeship(String course, String instituteName, String certificate, String period) {
        this.course = course;
        this.instituteName = instituteName;
        this.certificate = certificate;
        this.period = period;
    }

    public String getCourse() {
        return course;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public String getCertificate() {
        return certificate;
    }

    public String getPeriod() {
        return period;
    }
}
