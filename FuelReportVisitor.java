package fleet;

public class FuelReportVisitor implements VehicleVisitor {
    private static final double CAR_L_PER_100KM = 8.5;
    private static final double TRUCK_L_PER_100KM = 32.0;
    private static final double BUS_L_PER_100KM = 27.0;

    private double totalLiters;

    @Override
    public void visitCar(Car car) {
        add(car, car.getMileageKm(), CAR_L_PER_100KM);
    }

    @Override
    public void visitTruck(Truck truck) {
        add(truck, truck.getMileageKm(), TRUCK_L_PER_100KM);
    }

    @Override
    public void visitBus(Bus bus) {
        add(bus, bus.getMileageKm(), BUS_L_PER_100KM);
    }

    public double getTotalLiters() {
        return totalLiters;
    }

    private void add(Vehicle vehicle, int mileageKm, double litersPer100Km) {
        double liters = mileageKm / 100.0 * litersPer100Km;
        totalLiters += liters;
        System.out.printf("  %-10s burned about %,.0f L%n", vehicle.getPlateNumber(), liters);
    }
}
