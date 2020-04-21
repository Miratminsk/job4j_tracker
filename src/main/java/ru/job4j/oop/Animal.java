package ru.job4j.oop;

public class Animal {

    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal class");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
    }
}
