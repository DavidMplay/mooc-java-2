
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        VehicleRegistry vr = new VehicleRegistry();
        vr.add(new LicensePlate("FI", "AAA-111"), "Arto");
        vr.add(new LicensePlate("FI", "BBB-222"), "Pekka");
        vr.add(new LicensePlate("FI", "CCC-333"), "Arto");
        vr.printOwners();
    }
}
