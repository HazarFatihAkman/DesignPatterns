package CreationalPatterns.FactoryMethod.Factories;

import java.util.ArrayList;
import java.util.List;

import CreationalPatterns.FactoryMethod.Enums.VechileTypes;
import CreationalPatterns.FactoryMethod.Models.Logistic;
import CreationalPatterns.FactoryMethod.Models.RoadLogistic;
import CreationalPatterns.FactoryMethod.Models.SeaLogistic;
import CreationalPatterns.FactoryMethod.Models.Vechile;

public class LogisticFactory
{
    private Logistic _seaLogisticSingletonInstance, _roadLogisticSingletonInstance;
    private List<Vechile> _vechiles, _vechilesOnRoad, _vechilesNotOnRoad;

    public LogisticFactory()
    {
        this._vechiles = this._vechilesOnRoad = this._vechilesNotOnRoad = new ArrayList<Vechile>();
    }
    
    public Logistic getLogistic(VechileTypes vechileType) throws Exception
    {        
        if (vechileType == VechileTypes.Boat)
        {
            if (this._seaLogisticSingletonInstance == null)
            {            
                this._seaLogisticSingletonInstance = new SeaLogistic();
            }

            return this._seaLogisticSingletonInstance;
        }
        else if (vechileType == VechileTypes.Truck)
        {
            if (this._roadLogisticSingletonInstance == null)
            {
                this._roadLogisticSingletonInstance = new RoadLogistic();
            }

            return this._roadLogisticSingletonInstance;
        }
        else
        {
            throw new Exception("Out of range");
        }
    }

    public void upsertVechiles(List<Vechile> vechiles) throws Exception
    {
        if (vechiles == null)
        {
            throw new Exception("Vechiles shouldn't be null.");
        }

        for (var vechile : vechiles)
        {
            if (vechile.getVechileType() == VechileTypes.Boat && vechile.isUpdated())
            {
                upsertVechileBasedOnType(this._seaLogisticSingletonInstance, vechile);
            }
            else if (vechile.getVechileType() == VechileTypes.Truck && vechile.isUpdated())
            {
                upsertVechileBasedOnType(this._roadLogisticSingletonInstance, vechile);
            }
        }

        this._vechiles = new ArrayList<Vechile>();
        this._vechiles.addAll(this._seaLogisticSingletonInstance.getVechiles());
        this._vechiles.addAll(this._roadLogisticSingletonInstance.getVechiles());

        this._vechilesOnRoad = this._vechiles.stream().filter(x -> x.getOnRoad() == true).toList();
        this._vechilesNotOnRoad = this._vechiles.stream().filter(x -> x.getOnRoad() == false).toList();
    }

    public List<Vechile> getAllVechiles()
    {
        return this._vechiles;
    }

    public List<Vechile> getVechilesOnRoad()
    {
        return this._vechilesOnRoad;
    }

    public List<Vechile> getVechilesNotOnRoad()
    {
        return this._vechilesNotOnRoad;
    }

    public List<Vechile> getVechilesByType(VechileTypes vechileType)
    {
        return this._vechiles.stream().filter(x -> x.getVechileType() == vechileType).toList();
    }

    public void upsertVechileBasedOnType(Logistic logistic, Vechile vechile) throws Exception
    {
        if (logistic == null)
        {
            throw new Exception("Not Found Instance");
        }
        else
        {
            logistic.upsertVechile(vechile);
        }
    }
}
