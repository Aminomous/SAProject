package models;

import java.util.Calendar;

public class Education {
    private String level;
    private String instituteName;
    private String degreeOrCertificate;
    private String major;
    private Calendar studyFrom;
    private Calendar studyTo;

    public Education(String level, String instituteName, String degreeOrCertificate, String major, Calendar studyFrom, Calendar studyTo) {
        this.level = level;
        this.instituteName = instituteName;
        this.degreeOrCertificate = degreeOrCertificate;
        this.major = major;
        this.studyFrom = studyFrom;
        this.studyTo = studyTo;
    }

    public String getLevel() {
        return level;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public String getDegreeOrCertificate() {
        return degreeOrCertificate;
    }

    public String getMajor() {
        return major;
    }

    public Calendar getStudyFrom() {
        return studyFrom;
    }

    public Calendar getStudyTo() {
        return studyTo;
    }
}
