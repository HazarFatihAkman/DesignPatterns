package CreationalPatterns.FactoryMethod.Factories;

import java.util.ArrayList;
import java.util.List;

import CreationalPatterns.FactoryMethod.Enums.TransporterTypes;
import CreationalPatterns.FactoryMethod.Interfaces.ILogistic;
import CreationalPatterns.FactoryMethod.Interfaces.ITransporter;
import CreationalPatterns.FactoryMethod.Models.RoadLogistics;
import CreationalPatterns.FactoryMethod.Models.SeaLogistics;

public class LogisticFactory
{
    private List<ITransporter> _transporters;
    private List<ITransporter> _transportersOnRoad;
    private List<ITransporter> _transportersNotOnRoad;

    public LogisticFactory()
    {
        this._transporters = this._transportersOnRoad = this._transportersNotOnRoad = new ArrayList<ITransporter>();
    }

    public ILogistic getLogistic(TransporterTypes transporterType)
    {
        switch (transporterType) {
            case TransporterTypes.Boat:
                return new SeaLogistics();
            case TransporterTypes.Truck:
                return new RoadLogistics();
            default:
                return null;
        }
    }

    public void addTransportersInList(List<ITransporter> transporters)
    {
        this._transporters.addAll(transporters);
    }

    public void updateTransporterLists()
    {
        this._transportersOnRoad = this._transporters.stream().filter(x -> x.getOnRoad() == true).toList();
        this._transportersNotOnRoad = this._transporters.stream().filter(x -> x.getOnRoad() == false).toList();
    }

    public List<ITransporter> getAllTransporters()
    {
        return this._transporters;
    }

    public List<ITransporter> getTransportersOnRoad()
    {
        return this._transportersOnRoad;
    }

    public List<ITransporter> getTransportersNotOnRoad()
    {
        return this._transportersNotOnRoad;
    }

    public List<ITransporter> getTransportersByType(TransporterTypes transporterType)
    {
        return this._transporters.stream().filter(x -> x.getTransporterType() == transporterType).toList();
    }
}
