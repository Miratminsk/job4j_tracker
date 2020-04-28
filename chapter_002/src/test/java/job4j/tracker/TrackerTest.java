package job4j.tracker;

        import org.junit.Test;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;

        import static org.hamcrest.Matchers.is;
        import static org.hamcrest.core.IsNull.nullValue;
        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenAddNewItemThenFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item[] result = tracker.findByName(item.getName());
        assertThat(result[0].getName(), is(item.getName()));
    }

    @Test
    public void whenAddNewItemsThenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is(item1.getName()));
        assertThat(result[1].getName(), is(item2.getName()));
        assertThat(result[2].getName(), is(item3.getName()));
    }

    @Test
    public void whenReplaceOne() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenReplaceTwo() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String id1 = item1.getId();
        String id2 = item2.getId();
        String id3 = item3.getId();
        Item replaced1 = new Item("Replaced1");
        Item replaced2 = new Item("Replaced2");
        Item replaced3 = new Item("Replaced3");
        tracker.replace(id1, replaced1);
        tracker.replace(id2, replaced2);
        tracker.replace(id3, replaced3);
        assertThat(tracker.findById(id1).getName(), is("Replaced1"));
        assertThat(tracker.findById(id2).getName(), is("Replaced2"));
        assertThat(tracker.findById(id3).getName(), is("Replaced3"));
    }

    @Test
    public void whenDeleteOne() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDeleteTwo() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String id2 = item2.getId();
        tracker.delete(id2);
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is("test1"));
        assertThat(result[1].getName(), is("test3"));
        assertThat(result.length, is(2));
    }

    @Test
    public void whenSortUp() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("B"),
                new Item("A"),
                new Item("D"),
                new Item("C")));
        Collections.sort(items);
        List<Item> expected = new ArrayList<>(Arrays.asList(
                new Item("A"),
                new Item("B"),
                new Item("C"),
                new Item("D")));
        assertEquals(expected.toString(), items.toString());
    }

    @Test
    public void whenSortDown() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("B"),
                new Item("A"),
                new Item("D"),
                new Item("C")));
        Collections.sort(items, new SortDown());
        List<Item> expected = new ArrayList<>(Arrays.asList(
                new Item("D"),
                new Item("C"),
                new Item("B"),
                new Item("A")));
        assertEquals(expected.toString(), items.toString());
    }
}