package ru.job4j.Inheritance;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name, String surname, String education, String birthday, boolean certificate, String language) {
        super(name, surname, education, birthday, certificate);
        this.language = language;
    }

    public void writingCode() {
        System.out.println("Hi. I am Programmer. I am writing code.");
    }
}
