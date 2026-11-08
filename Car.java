package fleet;

public class Car implements Vehicle {
    private final String plateNumber;
    private final int engineVolumeCc;
    private final int mileageKm;

    public Car(String plateNumber, int engineVolumeCc, int mileageKm) {
        this.plateNumber = plateNumber;
        this.engineVolumeCc = engineVolumeCc;
        this.mileageKm = mileageKm;
    }

    @Override
    public String getPlateNumber() {
        return plateNumber;
    }

    public int getEngineVolumeCc() {
        return engineVolumeCc;
    }

    public int getMileageKm() {
        return mileageKm;
    }

    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visitCar(this);
    }
}
