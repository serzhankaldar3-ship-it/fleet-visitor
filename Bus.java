package fleet;

public class Bus implements Vehicle {
    private final String plateNumber;
    private final int seats;
    private final int mileageKm;

    public Bus(String plateNumber, int seats, int mileageKm) {
        this.plateNumber = plateNumber;
        this.seats = seats;
        this.mileageKm = mileageKm;
    }

    @Override
    public String getPlateNumber() {
        return plateNumber;
    }

    public int getSeats() {
        return seats;
    }

    public int getMileageKm() {
        return mileageKm;
    }

    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visitBus(this);
    }
}
