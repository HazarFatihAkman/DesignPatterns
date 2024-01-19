package CreationalPatterns.AbstarctFactory.Interfaces;

public interface IFurnitureFactory
{
    IChair getChair();
    ICoffeeTable getCoffeeTable();
    ISofa getSofa();

    void createChair();
    void createCoffeeTable();
    void createSofa();
}
