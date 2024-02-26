package creationalpatterns.factorymethod.logistics;

import static creationalpatterns.factorymethod.logistics.VehicleType.Truck;

public class RoadLogistic extends Logistic {
    public static final int MAX_RANGE = 1_500;
    public static final int MAX_LOAD = 50;

    @Override
    protected Vehicle createVehicle(int range, int loadCapacity) {
        return new Vehicle(Truck, range, loadCapacity);
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
