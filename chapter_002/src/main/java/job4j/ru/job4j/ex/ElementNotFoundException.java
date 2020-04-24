package job4j.ru.job4j.ex;

public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(String key) {
        super("Element " + key + " is not found.");
    }
}
