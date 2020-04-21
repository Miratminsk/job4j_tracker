package ru.job4j.Inheritance;

public class Surgeon extends Doctor {

    private boolean intern;

    public Surgeon(String name, String surname, String education, String birthday, boolean licence, boolean intern) {
        super(name, surname, education, birthday, licence);
        this.intern = intern;
    }

    public void makeSurgery() {
        System.out.println("Hi. I am Surgeon. I am making surgery.");
    }
}
