package CreationalPatterns.FactoryMethod;

import java.util.List;
import java.util.Random;

import CreationalPatterns.FactoryMethod.Enums.VechileTypes;
import CreationalPatterns.FactoryMethod.Factories.LogisticFactory;
import CreationalPatterns.FactoryMethod.Models.Logistic;
import CreationalPatterns.FactoryMethod.Models.Vechile;

public class LogisticsApp
{
    public static void main(String[] args)
    {
        try
        {
            LogisticFactory logisticFactory = new LogisticFactory();
            Logistic roadLogistics = logisticFactory.getLogistic(VechileTypes.Truck);
            Logistic seaLogistics = logisticFactory.getLogistic(VechileTypes.Boat);

            setMock(roadLogistics);
            setMock(seaLogistics);

            var roadTransporters = roadLogistics.getVechiles();
            var seaTransporters = seaLogistics.getVechiles();
        
            logisticFactory.upsertVechiles(roadTransporters);
            logisticFactory.upsertVechiles(seaTransporters);

            printTransporters("[Road Logistic] : Transporters", roadTransporters);
            printTransporters("[Sea Logistic] : Transporters", seaTransporters);

            printTransporters("[Logistic] : All transporters", logisticFactory.getAllVechiles());

            printTransporters("[Logistic] : Transporters On Road", logisticFactory.getVechilesOnRoad());
            printTransporters("[Logistic] : Transporters Not On Road", logisticFactory.getVechilesNotOnRoad());

            printTransporters("[Logistic] : Trucks", logisticFactory.getVechilesByType(VechileTypes.Truck));
            printTransporters("[Logistic] : Boats", logisticFactory.getVechilesByType(VechileTypes.Boat));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static void setMock(Logistic logistic)
    {
        try
        {
            Random random = new Random();
            for(Integer i = 0; i < 5; i++)
            {
                var newVechile = logistic.createVechile();
                newVechile.setLoadWeight(random.nextDouble());
                newVechile.setRoadDistance(random.nextInt());
            
                if (i % 2 == 0)
                {
                    newVechile.setOnRoad(true);
                }

                logistic.upsertVechile(newVechile);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static void printTransporters(String title, List<Vechile> vechiles)
    {
        System.out.println("\n" + title);
        for(var vechile : vechiles)
        {
            System.out.println("---");
            System.out.println(vechile.getId());
            System.out.println(vechile.getLoadWeight());
            System.out.println(vechile.getRoadDistance());
            System.out.println(vechile.getOnRoad());
            System.out.println(vechile.getVechileType());
            System.out.println("---   ---\n");
        }
    }
}