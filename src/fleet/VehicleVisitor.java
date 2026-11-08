package fleet;

public interface VehicleVisitor {
    void visitCar(Car car);

    void visitTruck(Truck truck);

    void visitBus(Bus bus);
}
