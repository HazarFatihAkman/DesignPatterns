package CreationalPatterns.AbstarctFactory.Models.Chairs;

import CreationalPatterns.AbstarctFactory.Interfaces.IChair;

public class ModernChair implements IChair
{
    @Override
    public Integer legCount()
    {
        return 0;
    }
}