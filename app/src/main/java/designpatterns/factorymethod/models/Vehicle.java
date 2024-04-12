package designpatterns.factorymethod.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Vehicle {
    private final UUID id;
    private final VehicleTypes vehicleType;
    private final int range;
    private final int loadCapacity;
    private int currentLoadWeight = 0;
    private boolean isOnRoad = false;
    private List<UUID> orderIds = new ArrayList<UUID>();

    public Vehicle(VehicleTypes vehicleType, int range, int loadCapacity) {
        this.id = UUID.randomUUID();
        this.vehicleType = vehicleType;
        this.range = range;
        this.loadCapacity = loadCapacity;
    }

    public UUID getId() {
        return this.id;
    }

    public VehicleTypes getVehicleType() {
        return this.vehicleType;
    }

    public int getRange() {
        return this.range;
    }

    public int getLoadCapacity() {
        return this.loadCapacity;
    }

    public boolean isOnRoad() {
        return this.isOnRoad;
    }

    public int getCurrentLoadWeight() {
        return this.currentLoadWeight;
    }

    public void setOnRoad(boolean isOnRoad) {
        if (isOnRoad && currentLoadWeight > loadCapacity) {
            throw new IllegalArgumentException("Load Capacity Exceeded.");
        }
        this.isOnRoad = isOnRoad;
    }

    public void updateCurrentLoadWeight(HashMap<UUID, Integer> orders) {
        for (var order : orders.entrySet()) {
            this.currentLoadWeight += order.getValue();
            this.orderIds.add(order.getKey());
        }
    }

    public List<UUID> getOrderIds() {
        return this.orderIds;
    }

    @Override
    public String toString() {
        return String
            .format("%s [%s] [%d km] [%d ton / %d ton]",
                    this.id,
                    this.vehicleType,
                    this.range,
                    this.currentLoadWeight,
                    this.loadCapacity);
    }
}
