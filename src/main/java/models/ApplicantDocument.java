package models;

public class ApplicantDocument {

    private int id;
    private String description;
    private int refnum;
    private byte[] document;

    public ApplicantDocument(int id, int refnum, String description){
        this.id = id;
        this.refnum = refnum;
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public int getRefnum() {
        return refnum;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public int getId() {
        return id;
    }
}
