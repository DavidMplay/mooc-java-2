
public enum Education {
    PHD("Doctoral degree"),
    MA("Masters degree"),
    BA("Bachelors degree"),
    HS("High School");

    private String education;        // object reference variable

    private Education(String edu) { // constructor
        this.education = edu;
    }
}
