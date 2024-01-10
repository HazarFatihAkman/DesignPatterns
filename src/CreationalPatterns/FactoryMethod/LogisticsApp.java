package CreationalPatterns.FactoryMethod;

import java.util.List;
import java.util.Random;

import CreationalPatterns.FactoryMethod.Enums.TransporterTypes;
import CreationalPatterns.FactoryMethod.Factories.LogisticFactory;
import CreationalPatterns.FactoryMethod.Interfaces.ILogistic;
import CreationalPatterns.FactoryMethod.Interfaces.ITransporter;

public class LogisticsApp
{
    public static void main(String[] args)
    {
        LogisticFactory logisticFactory = new LogisticFactory();
        ILogistic<ITransporter> roadLogistics = logisticFactory.getLogistic(TransporterTypes.Truck);
        ILogistic<ITransporter> seaLogistics = logisticFactory.getLogistic(TransporterTypes.Boat);

        setMock(roadLogistics);
        setMock(seaLogistics);

        var roadTransporters = roadLogistics.getTransporters();
        var seaTransporters = seaLogistics.getTransporters();
        
        logisticFactory.addTransportersInList(roadTransporters);
        logisticFactory.addTransportersInList(seaTransporters);
        logisticFactory.updateTransporterLists();

        printTransporters("[Road Logistic] : Transporters", roadTransporters);
        printTransporters("[Sea Logistic] : Transporters", seaTransporters);

        printTransporters("[Logistic] : All transporters", logisticFactory.getAllTransporters());

        printTransporters("[Logistic] : Transporters On Road", logisticFactory.getTransportersOnRoad());
        printTransporters("[Logistic] : Transporters Not On Road", logisticFactory.getTransportersNotOnRoad());

        printTransporters("[Logistic] : Trucks", logisticFactory.getTransportersByType(TransporterTypes.Truck));
        printTransporters("[Logistic] : Boats", logisticFactory.getTransportersByType(TransporterTypes.Boat));
    }

    private static void setMock(ILogistic<ITransporter> logistic)
    {
        Random random = new Random();
        for(Integer i = 0; i < 5; i++)
        {
            logistic.createTransporter();
            
            var newTransporter = logistic.getNewTransporter();
            newTransporter.setLoadWeight(random.nextDouble());
            newTransporter.setRoadDistance(random.nextInt());
            
            if (i % 2 == 0)
            {
                newTransporter.setOnRoad(true);
            }

            logistic.addNewTransporterInList();
        }
        logistic.updateTransporterLists();
    }

    private static void printTransporters(String title, List<ITransporter> transporters)
    {
        System.out.println("\n" + title);
        for(var transporter : transporters)
        {
            System.out.println("---");
            System.out.println(transporter.getId());
            System.out.println(transporter.getLoadWeight());
            System.out.println(transporter.getRoadDistance());
            System.out.println(transporter.getOnRoad());
            System.out.println(transporter.getTransporterType());
            System.out.println("---   ---\n");
        }
    }
}