package CreationalPatterns.AbstarctFactory.Models.Sofas;

import CreationalPatterns.AbstarctFactory.Interfaces.ISofa;

public class ArtDecoSofa implements ISofa
{
    @Override
    public Integer legCount()
    {
        return 4;
    }
}
