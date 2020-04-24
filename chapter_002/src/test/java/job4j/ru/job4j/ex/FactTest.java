package job4j.ru.job4j.ex;

import job4j.ex.Fact;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void WhenFactorialNegativeNumberThenError() {
        new Fact().calc(-1);
    }

    @Test
    public void WhenFactorial5Than120Test() {
        assertEquals(120, new Fact().calc(5));
    }



}