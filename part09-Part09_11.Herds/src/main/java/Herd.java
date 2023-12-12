
import java.util.List;
import java.util.ArrayList;

public class Herd implements Movable {

    private List<Movable> list;

    public Herd() {
        list = new ArrayList();
    }

    public String toString() {
        String value = "";

        for (Movable organism : list) {
            value += organism.toString();
            value += "\n";
        }
        return value;
    }

    public void addToHerd(Movable movable) {
        this.list.add(movable);
    }

    public void move(int dx, int dy) {
        for (Movable organism : list) {
            organism.move(dx, dy);
        }
    }
}
