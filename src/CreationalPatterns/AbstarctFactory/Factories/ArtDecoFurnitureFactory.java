package CreationalPatterns.AbstarctFactory.Factories;

import CreationalPatterns.AbstarctFactory.Interfaces.IChair;
import CreationalPatterns.AbstarctFactory.Interfaces.ICoffeeTable;
import CreationalPatterns.AbstarctFactory.Interfaces.IFurnitureFactory;
import CreationalPatterns.AbstarctFactory.Interfaces.ISofa;
import CreationalPatterns.AbstarctFactory.Models.Chairs.ArtDecoChair;
import CreationalPatterns.AbstarctFactory.Models.CoffeeTables.ArtDecoCoffeeTable;
import CreationalPatterns.AbstarctFactory.Models.Sofas.ArtDecoSofa;

public class ArtDecoFurnitureFactory implements IFurnitureFactory
{
    private ArtDecoChair _chair;
    private ArtDecoCoffeeTable _coffeeTable;
    private ArtDecoSofa _sofa;

    @Override
    public IChair getChair()
    {
        return this._chair == null ? new ArtDecoChair() : this._chair;
    }

    @Override
    public ICoffeeTable getCoffeeTable()
    {
        return this._coffeeTable == null ? new ArtDecoCoffeeTable() : this._coffeeTable;
    }

    @Override
    public ISofa getSofa()
    {
        return this._sofa == null ? new ArtDecoSofa() : this._sofa;
    }

    @Override
    public void createChair()
    {
        this._chair = new ArtDecoChair(); 
    }

    @Override
    public void createCoffeeTable()
    {
        this._coffeeTable = new ArtDecoCoffeeTable();
    }

    @Override
    public void createSofa()
    {
        this._sofa = new ArtDecoSofa();
    }
}
