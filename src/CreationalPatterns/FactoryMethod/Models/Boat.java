package CreationalPatterns.FactoryMethod.Models;

import java.util.UUID;

import CreationalPatterns.FactoryMethod.Enums.TransporterTypes;
import CreationalPatterns.FactoryMethod.Interfaces.ITransporter;

public class Boat implements ITransporter
{
    private UUID _id;
    private Integer _roadDistance;
    private Double _loadWeight;
    private Boolean _onRoad;
    private TransporterTypes _transporterType;

    public Boat() 
    {
        this._id = UUID.randomUUID();
        this._roadDistance = 0;
        this._loadWeight = 0D;
        this._onRoad = false;
        this._transporterType = TransporterTypes.Boat;
    }

    //Getters
    @Override
    public UUID getId()
    {
        return this._id;
    }

    @Override
    public Integer getRoadDistance()
    {
        return this._roadDistance;
    }

    @Override
    public Double getLoadWeight()
    {
        return this._loadWeight;
    }

    @Override
    public Boolean getOnRoad()
    {
        return this._onRoad;
    }

    @Override
    public TransporterTypes getTransporterType()
    {
        return this._transporterType;
    }

    //Setters
    @Override
    public void setRoadDistance(Integer roadDistance)
    {
        this._roadDistance = roadDistance;
    }

    @Override
    public void setLoadWeight(Double loadWeight)
    {
        this._loadWeight = loadWeight; 
    }

    @Override
    public void setOnRoad(Boolean isOnRoad)
    {
        this._onRoad = isOnRoad;
    }
   
}
