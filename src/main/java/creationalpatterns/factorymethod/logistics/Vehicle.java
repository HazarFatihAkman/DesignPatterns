package creationalpatterns.factorymethod.logistics;

import java.util.UUID;

public class Vehicle {
    private final UUID id;
    private final VehicleType vehicleType;
    private final int range;
    private final int loadCapacity;
    private boolean isOnRoad = false;

    public Vehicle(VehicleType vehicleType, int range, int loadCapacity) {
        this.id = UUID.randomUUID();
        this.range = range;
        this.loadCapacity = loadCapacity;
        this.vehicleType = vehicleType;
    }

    public UUID getId() {
        return id;
    }

    public int getRange() {
        return range;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isOnRoad() {
        return isOnRoad;
    }

    public void setOnRoad(boolean b) {
        this.isOnRoad = b;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] [%d km] [%d ton]", id, vehicleType, range, loadCapacity);
    }
}
