package fleet;

public class Truck implements Vehicle {
    private final String plateNumber;
    private final double loadCapacityTons;
    private final int mileageKm;

    public Truck(String plateNumber, double loadCapacityTons, int mileageKm) {
        this.plateNumber = plateNumber;
        this.loadCapacityTons = loadCapacityTons;
        this.mileageKm = mileageKm;
    }

    @Override
    public String getPlateNumber() {
        return plateNumber;
    }

    public double getLoadCapacityTons() {
        return loadCapacityTons;
    }

    public int getMileageKm() {
        return mileageKm;
    }

    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visitTruck(this);
    }
}
