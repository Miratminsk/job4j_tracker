package stragery;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("+++++")
                                .add("+   +")
                                .add("+   +")
                                .add("+++++")
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("  +  ")
                                .add(" +++ ")
                                .add("+++++")
                                .toString()
                )
        );
    }

    @Test
    public void whenPrint() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфур для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("+++++")
                                .add("+   +")
                                .add("+   +")
                                .add("+++++")
                                .add("")
                                .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    @Test
    public void whenPrintTriange() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("  +  ")
                                .add(" +++ ")
                                .add("+++++")
                                .add("")
                                .toString()
                )
        );
        System.setOut(stdout);
    }


}