package creationalpatterns.factorymethod.logistics;


import java.util.Random;

public class LogisticsApp {
    public static void main(String[] args) {
        try {

            buildLogisticsFor(650, 20);
            buildLogisticsFor(300, 45);
            buildLogisticsFor(11_000, 50);
            buildLogisticsFor(5_000, 75_000);


        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    public static void buildLogisticsFor(int distance, int load) {
        var logistic = LogisticFactory.createLogistic(distance, load);
        println("===========================================================================");
        println("Logistics for %d km distance and %d ton load: %s", distance, load, logistic);

        var random = new Random(System.currentTimeMillis());

        for (int i = 0; i < random.nextInt(1, 10); i++) {
            var range = random.nextInt(distance, logistic.getMaxRange());
            var loadCapacity = random.nextInt(load, logistic.getMaxLoadCapacity());
            logistic.addVehicle(range, loadCapacity);
        }

        println("Vehicles:");
        logistic.getAllVehicles().forEach(v -> println("\tVehicle: %s", v));
    }

    public static void println(String message, Object... args) {
        System.out.printf(message + "%n", args);
    }
}