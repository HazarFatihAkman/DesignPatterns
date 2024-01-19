package CreationalPatterns.AbstarctFactory.Models.Chairs;

import CreationalPatterns.AbstarctFactory.Interfaces.IChair;

public class VictorianChair implements IChair
{
    @Override
    public Integer legCount()
    {
        return 4;
    }
}
