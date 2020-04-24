package job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemToReplace = input.askStr("Enter item to delete: ");
        Item[] itemToreplace = tracker.findByName(itemToReplace);
        String id = itemToreplace[0].getId();
        tracker.delete(id);
        return true;
    }
}
