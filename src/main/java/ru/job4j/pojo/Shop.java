package ru.job4j.pojo;

public class Shop {

    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
            int point = i;
            while (products[point] == null && point < products.length - 1) {
                point++;
            }
                Product temp = products[i];
                products[i] = products[point];
                products[point] = temp;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Water", 2);

        delete(products, 2);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
