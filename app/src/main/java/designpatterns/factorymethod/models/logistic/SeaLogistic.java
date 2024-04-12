package designpatterns.factorymethod.models.logistic;

import designpatterns.factorymethod.models.Vehicle;
import static designpatterns.factorymethod.models.VehicleTypes.Ship;;

public class SeaLogistic extends Logistic {
    public static final int MAX_RANGE = 20_000;
    public static final int MAX_LOAD = 100_000;

    @Override
    protected Vehicle createVehicle(int range, int loadCapacity) {
        return new Vehicle(Ship, range, loadCapacity);
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