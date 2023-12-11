
import java.util.ArrayList;

public class OneItemBox extends Box {

    private ArrayList<Item> items;

    public OneItemBox() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (this.items.size() == 0) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item it : items) {
            if (it.equals(item)) {
                return true;
            }
        }
        return false;
    }

}
 