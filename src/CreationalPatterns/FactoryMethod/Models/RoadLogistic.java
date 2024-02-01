package CreationalPatterns.FactoryMethod.Models;

import CreationalPatterns.FactoryMethod.Enums.VechileTypes;

public class RoadLogistic extends Logistic
{
    public RoadLogistic()
    {
        super(VechileTypes.Truck);
    }
    
}
