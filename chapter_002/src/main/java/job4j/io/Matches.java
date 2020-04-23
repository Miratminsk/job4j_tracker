package job4j.io;

import java.util.Scanner;

public class Matches {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int count = 0;
        int matches = 11;
        int playerSelect;
        System.out.println("Let's play the eleven.");
        while (run) {
            boolean check = true;
            System.out.println("Total " + matches + " matches on the table.");
            if (count % 2 == 0) {
                System.out.println("The first player takes matches. From 1 to 3 ");
            } else {
                System.out.println("The second player takes matches. From 1 to 3 ");
            }
            while (check) {
                try {
                    playerSelect = Integer.parseInt(input.nextLine());
                    while (playerSelect < 1 || playerSelect > 3) {
                        System.out.println("You can take only 1, 2 or 3 matches. Try again");
                        playerSelect = Integer.parseInt(input.nextLine());
                    }
                    matches = matches - playerSelect;
                    check = false;
                } catch (NumberFormatException nfe) {
                    System.out.println("You can put only integers!");
                }
            }
            count++;
            if (matches <= 3) {
                if (count % 2 == 0) {
                    System.out.println("The first player is win. The game over");
                } else {
                    System.out.println("The second player is win. The game over");
                }
                run = false;
            }
            System.out.println();
        }
    }
}
