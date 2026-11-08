package fleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fleet {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }

    public void accept(VehicleVisitor visitor) {
        for (Vehicle vehicle : vehicles) {
            vehicle.accept(visitor);
        }
    }
}
