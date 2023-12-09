
import java.util.ArrayList;

public class ChangeHistory{

    private ArrayList<Double> list;

    public ChangeHistory() {
        list = new ArrayList<>();
    }

    public void add(double status) {
        this.list.add(status);
    }

    public void clear() {
        this.list.clear();
    }

    public String toString() {
        return list.toString();
    }

    public double maxValue() {
        if (this.list.size() == 0) {
            return 0;
        }

        double maxChange = 0;

        for (Double item : list) {
            if (item > maxChange) {
                maxChange = item;
            }
        }

        return maxChange;
    }

    public double minValue() {
        if (this.list.size() == 0) {
            return 0;
        }

        double minChange = 10000000;

        for (Double item : list) {
            if (item < minChange) {
                minChange = item;
            }
        }

        return minChange;
    }

    public double average() {
        if (this.list.size() == 0) {
            return 0;
        }

        double total = 0;

        for (Double item : list) {
            total += item;
        }

        return (double) total / this.list.size();
    }
}
