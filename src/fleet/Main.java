package fleet;

public class Main {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        fleet.add(new Car("777 ABC 02", 1600, 59_500));
        fleet.add(new Car("123 KZA 01", 2400, 34_200));
        fleet.add(new Truck("555 TRK 02", 12.5, 118_000));
        fleet.add(new Bus("909 BUS 02", 45, 74_000));

        System.out.println("Tax:");
        TaxVisitor tax = new TaxVisitor();
        fleet.accept(tax);
        System.out.printf("Total tax: %,d KZT%n%n", tax.getTotal());

        System.out.println("Maintenance:");
        MaintenanceVisitor maintenance = new MaintenanceVisitor();
        fleet.accept(maintenance);
        System.out.println("Vehicles to service soon: " + maintenance.getVehiclesToService());
        System.out.println();

        System.out.println("Fuel:");
        FuelReportVisitor fuel = new FuelReportVisitor();
        fleet.accept(fuel);
        System.out.printf("Total fuel: %,.0f L%n", fuel.getTotalLiters());
    }
}
