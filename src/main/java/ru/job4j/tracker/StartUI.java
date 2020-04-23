package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                tracker.findAll();
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                String itemToReplace = input.askStr("Enter item to replace: ");
                Item[] itemToreplace = tracker.findByName(itemToReplace);
                String id = itemToreplace[0].getId();
                Item item = new Item(input.askStr("Enter new Item: "));
                tracker.replace(id, item);
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                String itemToReplace = input.askStr("Enter item to delete: ");
                Item[] itemToreplace = tracker.findByName(itemToReplace);
                String id = itemToreplace[0].getId();
                tracker.delete(id);
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                String id = input.askStr("Enter item id: ");
                tracker.findById(id);
                System.out.println(tracker.findById(id).getName());
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                String name = input.askStr("Enter name: ");
                tracker.findByName(name);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Create a new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
