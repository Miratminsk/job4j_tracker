package job4j.Inheritance;

public class JSONReport extends TextReport{

    @Override
    public String generate(String name, String body) {
        return "{" + "\n"
                + name + " : " + name + ",\n"
                + body + " : " + body + "\n"
                + "}";
    }
}
