package designpatterns.factorymethod.models.logistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import designpatterns.factorymethod.models.Vehicle;

public abstract class Logistic {
    private final List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public void addVehicle(int distance, int loadCapacity, HashMap<UUID, Integer> orders) {
        if (distance > getMaxRange()) {
            throw new IllegalArgumentException(String.format("%s does not support the distance %d km", this.getClass().getSimpleName(), distance));
        }

        if (loadCapacity > getMaxLoadCapacity()) {
            throw new IllegalArgumentException(String.format("%s does not support the load %d ton", this.getClass().getSimpleName(), loadCapacity));
        }

        var vehicle = createVehicle(distance, loadCapacity);
        vehicle.updateCurrentLoadWeight(orders);
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return Collections.unmodifiableList(vehicles);
    }

    public List<Vehicle> getVechilesOnRoad() {
        return this.vehicles.stream().filter(Vehicle::isOnRoad).toList();
    }

    public List<Vehicle> findSuitableVehicles(int distance, double weight) {
        return this.vehicles.stream().filter(v -> !v.isOnRoad() && v.getRange() >= distance && v.getLoadCapacity() >= weight).toList();
    }

    public void parkAllVehicles() {
        vehicles.forEach(v -> v.setOnRoad(false));
    }

    protected abstract Vehicle createVehicle(int distance, int loadCapacity);

    public abstract int getMaxLoadCapacity();

    public abstract int getMaxRange();
}
