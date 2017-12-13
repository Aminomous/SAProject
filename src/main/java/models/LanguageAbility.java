package models;

public class LanguageAbility {
    private String language;
    private int speaking;
    private int reading;
    private int writing;

    public LanguageAbility(String language, int speaking, int reading, int writing) {
        this.language = language;
        this.speaking = speaking;
        this.reading = reading;
        this.writing = writing;
    }

    public String getLanguage() {
        return language;
    }

    public int getSpeaking() {
        return speaking;
    }

    public int getReading() {
        return reading;
    }

    public int getWriting() {
        return writing;
    }
}
