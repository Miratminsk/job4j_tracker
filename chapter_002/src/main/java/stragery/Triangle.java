package stragery;

import java.util.StringJoiner;

public class Triangle implements Shape {


    @Override
    public String draw() {
        String triangle = new StringJoiner(System.lineSeparator())
                .add("  +  ")
                .add(" +++ ")
                .add("+++++")
                .toString();
        return triangle;
    }
}
