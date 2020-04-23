package job4j.Inheritance;

public class Builder extends Engineer {

    private int level;

    public Builder(String name, String surname, String education, String birthday, boolean certificate, int level) {
        super(name, surname, education, birthday, certificate);
        this.level = level;
    }

    public void buildingHomes() {
        System.out.println("Hi. I am Builder. I am building homes.");
    }
}
