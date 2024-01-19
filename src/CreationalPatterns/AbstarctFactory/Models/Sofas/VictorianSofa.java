package CreationalPatterns.AbstarctFactory.Models.Sofas;

import CreationalPatterns.AbstarctFactory.Interfaces.ISofa;

public class VictorianSofa implements ISofa
{
    @Override
    public Integer legCount()
    {
        return 4;
    }
}
