package CreationalPatterns.AbstarctFactory.Models;

import java.util.UUID;

public class Order
{
    private UUID _id;
    private Chair _chair;
    private Sofa _sofa;
    private CoffeeTable _coffeeTable;

    public Order(Chair chair, Sofa sofa, CoffeeTable coffeeTable)
    {
        this._id = UUID.randomUUID();
        this._chair = chair;
        this._sofa = sofa;
        this._coffeeTable = coffeeTable;
    }

    //Getters

    public UUID getId()
    {
        return this._id;
    }

    public Chair getChair()
    {
        return this._chair;
    }

    public Sofa getSofa()
    {
        return this._sofa;
    }

    public CoffeeTable getCoffeeTable()
    {
        return this._coffeeTable;
    }
}
