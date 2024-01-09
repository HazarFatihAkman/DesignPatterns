package CreationalPatterns.FactoryMethod.Interfaces;

import java.util.UUID;

import CreationalPatterns.FactoryMethod.Enums.TransporterTypes;

public interface ITransporter
{
    //Getters
    UUID getId();
    Integer getRoadDistance();
    Double getLoadWeight();
    Boolean getOnRoad();
    TransporterTypes getTransporterType();

    //Setters
    void setRoadDistance(Integer roadDistance);
    void setLoadWeight(Double loadWeight);
    void setOnRoad(Boolean isOnRoad);
}
