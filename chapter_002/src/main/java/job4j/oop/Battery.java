package job4j.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
        System.out.println("Full battery load is " + this.load + ".");
        System.out.println("Empty battery load is " + another.load + ".");
    }

    public static void main(String[] args) {
        Battery fullBattery = new Battery(100);
        Battery emptyBattery = new Battery(0);
        System.out.println("Full battery load is " + fullBattery.load + ".");
        System.out.println("Empty battery load is " + emptyBattery.load + ".");
        fullBattery.exchange(emptyBattery);
    }
}
