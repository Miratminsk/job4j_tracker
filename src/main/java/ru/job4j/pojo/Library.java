package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 100);
        Book warAndPeace = new Book("War and Peace", 500);
        Book historyOfUsa = new Book("History of USA", 400);
        Book idiot = new Book("Idiot", 200);

        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = warAndPeace;
        books[2] = historyOfUsa;
        books[3] = idiot;

        for (Book book : books) System.out.println(book.getName() + " " + book.getPages());

        books[3] = books[0];
        books[0] = idiot;

        for (Book book : books) System.out.println(book.getName() + " " + book.getPages());

        for (Book book : books)
            if (book.getName().equalsIgnoreCase("Clean code")) {
                System.out.println(book.getName() + " " + book.getPages());
            }
    }
}
