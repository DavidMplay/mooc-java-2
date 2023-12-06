
import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> list;

    public VehicleRegistry() {
        this.list = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (!list.containsKey(licensePlate)) {
            list.put(licensePlate, owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate licensePlate) {
        if (list.containsKey(licensePlate)) {
            return this.list.get(licensePlate);
        }
        return null;
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.list.containsKey(licensePlate)) {
            this.list.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate li : this.list.keySet()) {
            System.out.println(li);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();

        for (String owner : this.list.values()) {
            if (!owners.contains(owner)) {
                owners.add(owner);
            }
        }
        for(String owner : owners){
            System.out.println(owner);
        }
    }
}
