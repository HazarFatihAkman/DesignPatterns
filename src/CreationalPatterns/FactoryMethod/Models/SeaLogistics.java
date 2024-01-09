package CreationalPatterns.FactoryMethod.Models;

import java.util.ArrayList;
import java.util.List;

import CreationalPatterns.FactoryMethod.Interfaces.ILogistic;

public class SeaLogistics implements ILogistic<Boat>
{
    private List<Boat> _boats, _boatsOnRoad, _boatsNotOnRoad;
    private Boat _newBoat;

    public SeaLogistics()
    {
        this._boats = this._boatsOnRoad = this._boatsNotOnRoad = new ArrayList<Boat>();
    }

    @Override
    public void createTransporter()
    {
        if (this._newBoat == null)
        {
            this._newBoat = new Boat();
        }
    }

    @Override
    public void addTransporterInList(Boat boat)
    {
        if (boat == null || this._boats == null)
        {
            return;
        }

        this._boats.add(boat);
    }

    @Override
    public void addNewTransporterInList()
    {
        var newBoat = getNewTransporter();
        
        if (newBoat == null)
        {
            return;
        }

        this._boats.add(_newBoat);
        this._newBoat = null;
    }

    @Override
    public void updateNewTransporter(Boat boat)
    {
        this._newBoat = boat;
    }

    @Override
    public void updateTransporterLists()
    {
        this._boatsOnRoad = this._boats.stream().filter(x -> x.getOnRoad() == true).toList();
        this._boatsNotOnRoad = this._boats.stream().filter(x -> x.getOnRoad() == false).toList();
    }

    @Override
    public List<Boat> getTransportersOnRoad()
    {
        return this._boatsOnRoad;
    }

    @Override
    public List<Boat> getTransportersNotOnRoad()
    {
        return this._boatsNotOnRoad;
    }

    @Override
    public Boat getNewTransporter()
    {
        return this._newBoat;
    }

    @Override
    public List<Boat> getTransporters()
    {
        return this._boats;
    }
    
}
