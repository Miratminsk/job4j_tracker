package job4j.ex;

public class FindMaxLenght {

    public static void main(String[] args) {

        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (String shop : shops) {
            if (shop != null) {
                if (shop.length() > max) {
                    max = shop.length();
                }
            }
        }
        System.out.println("Max length: " + max);
    }
}
