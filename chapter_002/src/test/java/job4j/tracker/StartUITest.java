package job4j.tracker;

import org.junit.Test;

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
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }
}