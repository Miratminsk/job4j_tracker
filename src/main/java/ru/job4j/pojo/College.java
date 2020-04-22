package ru.job4j.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class College {

    public static void main(String[] args) throws ParseException {
        Student student = new Student();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        student.setFullName("Mirat Rakhmanov");
        student.setGroup("Law");
        student.setAdmissionDate(formatter.parse("1-Sep-2005"));

        System.out.println(student.getFullName() + " is in the group " + student.getGroup() + " since " + formatter.format(student.getAdmissionDate()));
    }
}
