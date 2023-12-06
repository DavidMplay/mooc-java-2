
import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> list;
    
    public IOU() {
        this.list = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        this.list.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        if (this.list.keySet().contains(toWhom)) {
            return this.list.get(toWhom);
        } return 0;
    }
}
