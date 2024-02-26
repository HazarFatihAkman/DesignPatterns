package creationalpatterns.factorymethod.logistics;

import static creationalpatterns.factorymethod.logistics.VehicleType.Ship;

public class SeaLogistic extends Logistic {
    public static final int MAX_RANGE = 20_000;
    public static final int MAX_LOAD = 100_000;

    @Override
    protected Vehicle createVehicle(int range, int loadCapacity) {
        return new Vehicle(Ship, range, loadCapacity);
    }

    @Override
    protected int getMaxRange() {
        return MAX_RANGE;
    }

    @Override
    protected int getMaxLoadCapacity() {
        return MAX_LOAD;
    }
}
