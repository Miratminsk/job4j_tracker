package ru.job4j.Inheritance;

public class Dentist extends Doctor {

    private boolean prothesiste;

    public Dentist(String name, String surname, String education, String birthday, boolean licence, boolean prothesiste) {
        super(name, surname, education, birthday, licence);
        this.prothesiste = prothesiste;
    }

    public void drillTeeth() {
        System.out.println("Hi. I am Dentist. I am drilling teeth.");
    }
}
