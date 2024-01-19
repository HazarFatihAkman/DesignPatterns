package CreationalPatterns.AbstarctFactory.Factories;

import CreationalPatterns.AbstarctFactory.Interfaces.IChair;
import CreationalPatterns.AbstarctFactory.Interfaces.ICoffeeTable;
import CreationalPatterns.AbstarctFactory.Interfaces.IFurnitureFactory;
import CreationalPatterns.AbstarctFactory.Interfaces.ISofa;
import CreationalPatterns.AbstarctFactory.Models.Chairs.ModernChair;
import CreationalPatterns.AbstarctFactory.Models.CoffeeTables.ModernCoffeeTable;
import CreationalPatterns.AbstarctFactory.Models.Sofas.ModernSofa;

public class ModernFurnitureFactory implements IFurnitureFactory
{
    private ModernChair _chair;
    private ModernCoffeeTable _coffeeTable;
    private ModernSofa _sofa;

    @Override
    public IChair getChair()
    {
        return this._chair == null ? new ModernChair() : this._chair;
    }

    @Override
    public ICoffeeTable getCoffeeTable()
    {
        return this._coffeeTable == null ? new ModernCoffeeTable() : this._coffeeTable;
    }

    @Override
    public ISofa getSofa()
    {
        return this._sofa == null ? new ModernSofa() : this._sofa;
    }

    @Override
    public void createChair()
    {
        this._chair = new ModernChair(); 
    }

    @Override
    public void createCoffeeTable()
    {
        this._coffeeTable = new ModernCoffeeTable();
    }

    @Override
    public void createSofa()
    {
        this._sofa = new ModernSofa();
    }
}
