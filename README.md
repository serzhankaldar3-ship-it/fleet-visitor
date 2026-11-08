# Fleet Visitor

Assignment #6: Visitor pattern in Java. Topic: vehicle fleet.

Elements: `Car`, `Truck`, `Bus`. Visitors: `TaxVisitor`, `MaintenanceVisitor`, `FuelReportVisitor`.
`Fleet` is the object structure the client walks through.

## Run

    javac -d out src/fleet/*.java
    java -cp out fleet.Main

## How double dispatch works

`fleet.accept(visitor)` calls `vehicle.accept(visitor)` for each vehicle. The first dispatch is on the
vehicle's real type (Car, Truck or Bus). Inside, `visitor.visitCar(this)` is the second dispatch, picked
by the visitor's real type. So the exact algorithm is chosen by both types, without any `instanceof`.

## Clean Code principles

1. **Meaningful names.** `Vehicle` and `VehicleVisitor` show who is data and who is an operation.
   `visitCar`, `visitTruck`, `visitBus` say exactly which element they handle.
2. **No type checks.** There is no `instanceof` or `switch` on type anywhere. Double dispatch does it.
3. **Single Responsibility.** Each visitor does one job for all vehicles: tax, service check or fuel.
   Vehicles only keep their data and know how to accept a visitor.
4. **No magic numbers.** Rates and intervals are named constants (`CAR_RATE_PER_100CC`, `BUS_SERVICE_INTERVAL_KM` ...).
5. **Small methods, no duplication.** The shared part of each visitor is in one private method
   (`print`, `check`, `add`), the `visitX` methods only pass the right numbers.
6. **Open/Closed.** A new operation is a new class. Vehicle classes stay untouched.

## Encapsulation trade-off

Visitors need vehicle data (engine volume, seats, load, mileage). Fields stay `private final`
and are given through public getters only, so visitors can read but never change a vehicle.
`Fleet.getVehicles()` returns an unmodifiable list.

The known cost of Visitor: adding a new vehicle type (for example `Motorcycle`) means adding a
`visitMotorcycle` method to the interface and to every visitor.

## Extensibility

To add an insurance report, create `InsuranceVisitor implements VehicleVisitor` and call
`fleet.accept(new InsuranceVisitor())`. `Car`, `Truck`, `Bus`, `Fleet` and the other visitors do not change.
