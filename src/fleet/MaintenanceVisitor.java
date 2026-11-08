package fleet;

public class MaintenanceVisitor implements VehicleVisitor {
    private static final int CAR_SERVICE_INTERVAL_KM = 10_000;
    private static final int TRUCK_SERVICE_INTERVAL_KM = 25_000;
    private static final int BUS_SERVICE_INTERVAL_KM = 15_000;

    private int vehiclesToService;

    @Override
    public void visitCar(Car car) {
        check(car, car.getMileageKm(), CAR_SERVICE_INTERVAL_KM);
    }

    @Override
    public void visitTruck(Truck truck) {
        check(truck, truck.getMileageKm(), TRUCK_SERVICE_INTERVAL_KM);
    }

    @Override
    public void visitBus(Bus bus) {
        check(bus, bus.getMileageKm(), BUS_SERVICE_INTERVAL_KM);
    }

    public int getVehiclesToService() {
        return vehiclesToService;
    }

    private void check(Vehicle vehicle, int mileageKm, int intervalKm) {
        int sinceLastService = mileageKm % intervalKm;
        int left = intervalKm - sinceLastService;
        boolean due = left <= intervalKm / 10;
        if (due) {
            vehiclesToService++;
        }
        System.out.printf("  %-10s next service in %,d km%s%n",
                vehicle.getPlateNumber(), left, due ? "  <- book it now" : "");
    }
}
