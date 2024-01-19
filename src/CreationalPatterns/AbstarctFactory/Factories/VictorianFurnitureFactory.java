package CreationalPatterns.AbstarctFactory.Factories;

import CreationalPatterns.AbstarctFactory.Interfaces.IChair;
import CreationalPatterns.AbstarctFactory.Interfaces.ICoffeeTable;
import CreationalPatterns.AbstarctFactory.Interfaces.IFurnitureFactory;
import CreationalPatterns.AbstarctFactory.Interfaces.ISofa;
import CreationalPatterns.AbstarctFactory.Models.Chairs.VictorianChair;
import CreationalPatterns.AbstarctFactory.Models.CoffeeTables.VictorianCoffeeTable;
import CreationalPatterns.AbstarctFactory.Models.Sofas.VictorianSofa;

public class VictorianFurnitureFactory implements IFurnitureFactory
{
    private VictorianChair _chair;
    private VictorianCoffeeTable _coffeeTable;
    private VictorianSofa _sofa;

    @Override
    public IChair getChair()
    {
        return this._chair == null ? new VictorianChair() : this._chair;
    }

    @Override
    public ICoffeeTable getCoffeeTable()
    {
        return this._coffeeTable == null ? new VictorianCoffeeTable() : this._coffeeTable;
    }

    @Override
    public ISofa getSofa()
    {
        return this._sofa == null ? new VictorianSofa() : this._sofa;
    }

    @Override
    public void createChair()
    {
        this._chair = new VictorianChair(); 
    }

    @Override
    public void createCoffeeTable()
    {
        this._coffeeTable = new VictorianCoffeeTable();
    }

    @Override
    public void createSofa()
    {
        this._sofa = new VictorianSofa();
    }
}
