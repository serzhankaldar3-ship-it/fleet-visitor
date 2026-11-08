package fleet;

public interface Vehicle {
    String getPlateNumber();

    void accept(VehicleVisitor visitor);
}
