package job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter item id: ");
        tracker.findById(id);
        System.out.println(tracker.findById(id).getName());
        return true;
    }
}
