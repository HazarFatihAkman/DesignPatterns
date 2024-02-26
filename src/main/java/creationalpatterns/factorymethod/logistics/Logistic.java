package creationalpatterns.factorymethod.logistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Logistic {
    private final List<Vehicle> vehicleList = new ArrayList<>();

    public void addVehicle(int distance, int loadCapacity) {
        if (distance > getMaxRange()) {
            throw new IllegalArgumentException(String.format("%s does not support the distance %d km", this.getClass().getSimpleName(), distance));
        }
        if (loadCapacity > getMaxLoadCapacity()) {
            throw new IllegalArgumentException(String.format("%s does not support the load %d ton", this.getClass().getSimpleName(), loadCapacity));
        }

        var vehicle = createVehicle(distance, loadCapacity);
        this.vehicleList.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return Collections.unmodifiableList(vehicleList);
    }

    public List<Vehicle> getVechilesOnRoad() {
        return this.vehicleList.stream().filter(Vehicle::isOnRoad).toList();
    }

    public List<Vehicle> findSuitableVehicles(int distance, double weight) {
        return this.vehicleList.stream().filter(v -> !v.isOnRoad() && v.getRange() >= distance && v.getLoadCapacity() >= weight).toList();
    }

    public void parkAllVehicles() {
        vehicleList.forEach(v -> v.setOnRoad(false));
    }

    protected abstract Vehicle createVehicle(int range, int loadCapacity);

    protected abstract int getMaxRange();

    protected abstract int getMaxLoadCapacity();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
