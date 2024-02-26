package creationalpatterns.factorymethod.logistics;

public final class LogisticFactory {

    public static Logistic createLogistic(int distance, int loadWeight) {

        if (distance <= 1500 && loadWeight <= 50) {
            return new RoadLogistic();
        } else if (distance <= 20_000 && loadWeight <= 100_000) {
            return new SeaLogistic();
        } else {
            throw new IllegalArgumentException("There is no any logistic for longer than 20.000Km distance and heavier than 100 Gross Ton load");
        }

    }

}
