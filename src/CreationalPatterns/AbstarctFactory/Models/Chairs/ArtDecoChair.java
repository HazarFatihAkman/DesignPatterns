package CreationalPatterns.AbstarctFactory.Models.Chairs;

import CreationalPatterns.AbstarctFactory.Interfaces.IChair;

public class ArtDecoChair implements IChair
{
    @Override
    public Integer legCount()
    {
        return 4;
    }
}
