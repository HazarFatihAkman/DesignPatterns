package CreationalPatterns.FactoryMethod.Models;

import java.util.UUID;

import CreationalPatterns.FactoryMethod.Enums.VechileTypes;

public class Vechile
{
    private UUID _id;
    private Integer _roadDistance;
    private Double _loadWeight;
    private Boolean _onRoad = false;
    private VechileTypes _vechileType;
    private Boolean _isUpdated;
    
    public Vechile()
    {
        this._id = UUID.randomUUID();
    }

    public Vechile(VechileTypes vechileType)
    {
        this._id = UUID.randomUUID();
        this._vechileType = vechileType;
    }

    //Getters
    public UUID getId() throws NullPointerException
    {
        throwNullExceptionIfNull(this._id, "Id");
        return this._id;
    }

    public Integer getRoadDistance() throws NullPointerException
    {
        throwNullExceptionIfNull(this._roadDistance, "Road Distance");
        return this._roadDistance;
    }
    
    public Double getLoadWeight() throws NullPointerException
    {
        throwNullExceptionIfNull(this._loadWeight, "Load Weight");
        return this._loadWeight;
    }
    
    public Boolean getOnRoad() throws NullPointerException
    {
        throwNullExceptionIfNull(this._onRoad, "On Road");
        return this._onRoad;
    }

    public VechileTypes getVechileType() throws NullPointerException
    {
        throwNullExceptionIfNull(this._vechileType, "Transporter Type");
        return this._vechileType;
    }

    public Boolean isUpdated()
    {
        return this._isUpdated;
    }

    //Setters
    public void setRoadDistance(Integer roadDistance) throws NullPointerException
    {
        throwNullExceptionIfNull(roadDistance, "Road Distance");
        this._roadDistance = roadDistance;
    }

    public void setLoadWeight(Double loadWeight) throws NullPointerException
    {
        throwNullExceptionIfNull(loadWeight, "Load Weight");
        this._loadWeight = loadWeight;
    }

    public void setOnRoad(Boolean isOnRoad) throws NullPointerException
    {
        throwNullExceptionIfNull(isOnRoad, "Is On Road");
        this._onRoad = isOnRoad;
    }

    public void setTransporterType(VechileTypes transporterType)
    {
        throwNullExceptionIfNull(transporterType, "Transporter Type");
        this._vechileType = transporterType;
    }

    private void throwNullExceptionIfNull(Object obj, String propertyName)
    {
        if (obj == null)
        {
            throw new NullPointerException(propertyName + " is null.");
        }

        this._isUpdated = true;
    }
}
