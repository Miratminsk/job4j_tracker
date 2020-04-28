package job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItemOne() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction()};
        actions[0].execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddItemTwo() {
        String[] answers = {"Mirat", "Anna"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction()};
        actions[0].execute(input, tracker);
        actions[0].execute(input, tracker);
        Item created1 = tracker.findAll()[0];
        Item created2 = tracker.findAll()[1];
        Item expected1 = new Item("Mirat");
        Item expected2 = new Item("Anna");
        assertThat(created1.getName(), is(expected1.getName()));
        assertThat(created2.getName(), is(expected2.getName()));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Mirat");
        tracker.add(item);
        String[] answers = {"Mirat", "Anna"};
        UserAction[] actions = {new EditAction()};
        actions[0].execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("Anna"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Mirat");
        tracker.add(item);
        String[] answers = {"Mirat"};
        UserAction[] actions = {new DeleteAction()};
        actions[0].execute(new StubInput(answers), tracker);
        Item[] expected = tracker.findByName("Mirat");
        assertNull(expected);
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        List<UserAction> ul = new ArrayList<>();
        ul.add(action);
        new StartUI().init(input, new Tracker(), ul);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenFindAllActionTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindAllAction act = new FindAllAction();
        act.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(1 + ". " + item.getName() + " " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenFindByNameActionTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("Mirat");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction();
        findByNameAction.execute(new StubInput(new String[] {"Mirat"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(1 + ". " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenShowMenuTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new FindAllAction());
        actions.add(new EditAction());
        actions.add(new DeleteAction());
        actions.add(new FindByIdAction());
        actions.add(new FindByNameAction());
        new StartUI().showMenu(actions);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add(0 + ". === Create a new Item ====")
                .add(1 + ". === Show all items ====")
                .add(2 + ". === Edit item ====")
                .add(3 + ". === Delete item ====")
                .add(4 + ". === Find item by Id ====")
                .add(5 + ". === Find item by name ====")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}