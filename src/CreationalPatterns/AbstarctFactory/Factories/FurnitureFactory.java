package CreationalPatterns.AbstarctFactory.Factories;

import java.util.ArrayList;
import java.util.List;

import CreationalPatterns.AbstarctFactory.Models.Chair;
import CreationalPatterns.AbstarctFactory.Models.CoffeeTable;
import CreationalPatterns.AbstarctFactory.Models.Order;
import CreationalPatterns.AbstarctFactory.Models.Sofa;
import CreationalPatterns.AbstarctFactory.Models.Enums.FurnitureStyles;

public class FurnitureFactory
{
    private FurnitureStyles _furnitureStyle;
    private List<Order> _orders;
    private FurnitureFactory _artDecoFactory, _modernFactory, _victorianFactory, _factory;

    public FurnitureFactory() { }

    public FurnitureFactory(FurnitureStyles furnitureStyle)
    {
        this._furnitureStyle = furnitureStyle;
        this._orders = new ArrayList<Order>();
    }

    public FurnitureFactory getInstance(FurnitureStyles furnitureStyle)
    {
        if (furnitureStyle == FurnitureStyles.ArtDeco)
        {
            if (this._artDecoFactory == null)
            {
                this._artDecoFactory = new FurnitureFactory(furnitureStyle);
            }

            return this._artDecoFactory;
        }
        else if (furnitureStyle == FurnitureStyles.Modern)
        {
            if (this._modernFactory == null)
            {
                this._modernFactory = new FurnitureFactory(furnitureStyle);
            }

            return this._modernFactory;
        } 
        else if (furnitureStyle == FurnitureStyles.Victorian)
        {
            if (this._victorianFactory == null)
            {
                this._victorianFactory = new FurnitureFactory(furnitureStyle);
            }

            return this._victorianFactory;
        }
        else
        {
            if (this._factory == null)
            {
                this._factory = new FurnitureFactory();
            }

            return this._factory;
        }
    }

    public Order createOrder()
    {
        return new Order(createChair(), createSofa(), createCoffeeTable());
    }

    public void addOrder(Order order)
    {
        this._orders.add(order);
    }

    public List<Order> getOrders()
    {
        var orders = new ArrayList<Order>();
        if (this._artDecoFactory != null)
        {
            orders.addAll(this._artDecoFactory.getOrders());
        }

        if (this._modernFactory != null)
        {
            orders.addAll(this._modernFactory.getOrders());
        }

        if (this._victorianFactory != null)
        {
            orders.addAll(this._victorianFactory.getOrders());
        }

        if (this._furnitureStyle == null)
        {
            this._orders = orders;
        }

        return this._orders;
    }

    private Chair createChair()
    {
        return new Chair(this._furnitureStyle);
    }

    private Sofa createSofa()
    {
        return new Sofa(_furnitureStyle);
    }

    private CoffeeTable createCoffeeTable()
    {
        return new CoffeeTable(_furnitureStyle);
    }
}
