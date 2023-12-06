
import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> list;

    public StorageFacility() {
        this.list = new HashMap();
    }

    public void add(String unit, String item) {
        this.list.putIfAbsent(unit, new ArrayList<>());

        this.list.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        if (this.list.get(storageUnit) == null) {
            ArrayList<String> empty = new ArrayList();
            return empty;
        }
        return this.list.get(storageUnit);
    }

    public void remove(String storageUnit, String item) {
        this.list.get(storageUnit).remove(item);
        if (this.list.get(storageUnit).size() == 0) {
            this.list.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> storage = new ArrayList<>();

        for (String unit : this.list.keySet()) {
            storage.add(unit);
        }

        return storage;
    }
}
