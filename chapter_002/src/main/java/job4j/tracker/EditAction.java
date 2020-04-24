package job4j.tracker;

public class EditAction implements UserAction {

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemToReplace = input.askStr("Enter item to replace: ");
        Item[] itemToreplace = tracker.findByName(itemToReplace);
        String id = itemToreplace[0].getId();
        Item item = new Item(input.askStr("Enter new Item: "));
        tracker.replace(id, item);
        return true;
    }
}
