package stragery;

import java.util.StringJoiner;

public class Square implements Shape {

    @Override
    public String draw() {
        String square = new StringJoiner(System.lineSeparator())
                .add("+++++")
                .add("+   +")
                .add("+   +")
                .add("+++++")
                .toString();
        return square;
    }
}
