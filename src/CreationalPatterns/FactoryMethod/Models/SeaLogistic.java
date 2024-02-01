package CreationalPatterns.FactoryMethod.Models;

import CreationalPatterns.FactoryMethod.Enums.VechileTypes;

public class SeaLogistic extends Logistic
{

    public SeaLogistic()
    {
        super(VechileTypes.Boat);
    }
    
}
