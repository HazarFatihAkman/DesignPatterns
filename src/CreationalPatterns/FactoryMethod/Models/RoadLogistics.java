package CreationalPatterns.FactoryMethod.Models;

import java.util.ArrayList;
import java.util.List;

import CreationalPatterns.FactoryMethod.Interfaces.ILogistic;

public class RoadLogistics implements ILogistic<Truck>
{
    private List<Truck> _trucks, _trucksOnRoad, _trucksNotOnRoad;
    private Truck _newTruck;

    public RoadLogistics()
    {
        this._trucks = this._trucksOnRoad = this._trucksNotOnRoad = new ArrayList<Truck>();
    }

    @Override
    public void createTransporter()
    {
        if (this._newTruck == null)
        {
            this._newTruck = new Truck();    
        }
    }

    @Override
    public void addTransporterInList(Truck truck)
    {
        if (truck == null || this._trucks == null)
        {
            return;
        }

        this._trucks.add(truck);
    }

    @Override
    public Truck getNewTransporter()
    {
        return this._newTruck;
    }

    @Override
    public void updateNewTransporter(Truck truck)
    {
        this._newTruck = truck;
    }

    @Override
    public void updateTransporterLists()
    {
        this._trucksOnRoad = this._trucks.stream().filter(x -> x.getOnRoad() == true).toList();
        this._trucksNotOnRoad = this._trucks.stream().filter(x -> x.getOnRoad() == false).toList();
    }

    @Override
    public List<Truck> getTransportersOnRoad()
    {
        return this._trucksOnRoad;   
    }

    @Override
    public List<Truck> getTransportersNotOnRoad()
    {
        return this._trucksNotOnRoad;
    }

    @Override
    public void addNewTransporterInList()
    {
        var newTruck = getNewTransporter();
        
        if (newTruck == null)
        {
            return;
        }

        this._trucks.add(newTruck);
        this._newTruck = null;
    }

    @Override
    public List<Truck> getTransporters()
    {
        return this._trucks;
    }
    
}
