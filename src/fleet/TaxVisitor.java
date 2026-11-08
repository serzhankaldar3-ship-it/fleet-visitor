package fleet;

public class TaxVisitor implements VehicleVisitor {
    private static final int CAR_RATE_PER_100CC = 700;
    private static final int TRUCK_RATE_PER_TON = 15_000;
    private static final int BUS_RATE_PER_SEAT = 4_000;

    private long total;

    @Override
    public void visitCar(Car car) {
        long tax = (long) car.getEngineVolumeCc() / 100 * CAR_RATE_PER_100CC;
        print(car, tax);
    }

    @Override
    public void visitTruck(Truck truck) {
        long tax = Math.round(truck.getLoadCapacityTons() * TRUCK_RATE_PER_TON);
        print(truck, tax);
    }

    @Override
    public void visitBus(Bus bus) {
        long tax = (long) bus.getSeats() * BUS_RATE_PER_SEAT;
        print(bus, tax);
    }

    public long getTotal() {
        return total;
    }

    private void print(Vehicle vehicle, long tax) {
        total += tax;
        System.out.printf("  %-10s tax: %,d KZT%n", vehicle.getPlateNumber(), tax);
    }
}
