package job4j.ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException(key);
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] value = {"Chicago", "New York", "Moscow"};
        try {
            System.out.println(indexOf(value, "Minsk"));
        } catch (ElementNotFoundException e) {
            System.out.println("Element is not found");
        }
    }
}
