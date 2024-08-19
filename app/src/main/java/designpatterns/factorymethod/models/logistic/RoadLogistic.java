package designpatterns.factorymethod.models.logistic;

import designpatterns.factorymethod.models.Vehicle;
import static designpatterns.factorymethod.models.VehicleTypes.Truck;

public class RoadLogistic extends Logistic {
    public static final int MAX_RANGE = 1_500;
    public static final int MAX_LOAD = 1050;

    @Override
    protected Vehicle createVehicle(int range, int loadCapacity) {
        return new Vehicle(Truck, range, loadCapacity);
    }

    @Override
	public int getMaxRange() {
        return MAX_RANGE;
    }

    @Override
	public int getMaxLoadCapacity() {
        return MAX_LOAD;
    }
}