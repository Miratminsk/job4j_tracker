package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Driving...");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Total number of passengers " + number + ".");
    }

    @Override
    public int fillUpGas(int liters) {
        int gasPrice = 50;
        int totalPrice = liters * gasPrice;
        System.out.println("Total gas price " + totalPrice + ".");
        return totalPrice;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.fillUpGas(300);
        bus.passengers(50);
        bus.drive();
    }
}
