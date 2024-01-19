package CreationalPatterns.AbstarctFactory.Models.CoffeeTables;

import CreationalPatterns.AbstarctFactory.Interfaces.ICoffeeTable;

public class VictorianCoffeeTable implements ICoffeeTable
{
    @Override
    public Integer legCount()
    {
        return 4;
    }
}
