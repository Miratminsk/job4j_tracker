package ru.job4j.Inheritance;

public class Doctor extends Profession{

    private boolean licence;

    public Doctor(String name, String surname, String education, String birthday, boolean licence) {
        super(name, surname, education, birthday);
        this.licence = licence;
    }

    public boolean isLicence() {
        return licence;
    }
}
