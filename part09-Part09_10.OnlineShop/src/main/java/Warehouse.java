
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> price;
    private Map<String, Integer> quantity;

    public Warehouse() {
        this.price = new HashMap<>();
        this.quantity = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.price.put(product, price);
        this.quantity.put(product, stock);
    }

    public int price(String product) {
        if (this.price.containsKey(product)) {
            return this.price.get(product);
        }
        return -99;
    }

    public int stock(String product) {
        if (this.quantity.containsKey(product)) {
            return this.quantity.get(product);
        }
        return 0;
    }

    public boolean take(String product) {
        if (this.quantity.containsKey(product) && this.quantity.get(product) > 0) {
            this.quantity.put(product, this.quantity.get(product) - 1);
            return true;

        }
        return false;
    }

    public Set<String> products() {
        Set<String> set = new HashSet<>();

        for (Object item : this.quantity.keySet()){
            set.add((String) item);
        }
        return set;
    }
}
