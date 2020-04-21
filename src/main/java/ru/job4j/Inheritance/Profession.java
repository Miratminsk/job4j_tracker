package ru.job4j.Inheritance;

import java.util.Date;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public static void main(String[] args) {
        Dentist dentist = new Dentist("Mirat", "Rakhmanov", "BSU", "17/02/1988", true, false);
        Surgeon surgeon = new Surgeon("Anna", "Rakhmanova", "BNTU", "29/03/1986", true, true);
        Builder builder = new Builder("Gleb", "Morozov", "MTI", "12/12/1985", false, 5);
        Programmer programmer = new Programmer("Alex", "Zinya", "TTU", "15/03/1986", false, "Java");
        dentist.drillTeeth();
        System.out.println(dentist.getBirthday());
        System.out.println(dentist.getEducation());
        System.out.println(dentist.getName());
        System.out.println(dentist.getSurname());
        System.out.println(dentist.isLicence());
        surgeon.makeSurgery();
        System.out.println(surgeon.getBirthday());
        System.out.println(surgeon.getEducation());
        System.out.println(surgeon.getName());
        System.out.println(surgeon.getSurname());
        System.out.println(surgeon.isLicence());
        builder.buildingHomes();
        System.out.println(builder.getBirthday());
        System.out.println(builder.getEducation());
        System.out.println(builder.getName());
        System.out.println(builder.getSurname());
        System.out.println(builder.isCertificate());
        programmer.writingCode();
        System.out.println(programmer.getBirthday());
        System.out.println(programmer.getEducation());
        System.out.println(programmer.getName());
        System.out.println(programmer.getSurname());
        System.out.println(programmer.isCertificate());
    }
}
