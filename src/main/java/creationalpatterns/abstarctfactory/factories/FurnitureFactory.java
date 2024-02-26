package creationalpatterns.abstarctfactory.factories;

import java.util.ArrayList;
import java.util.List;

import creationalpatterns.abstarctfactory.models.Chair;
import creationalpatterns.abstarctfactory.models.CoffeeTable;
import creationalpatterns.abstarctfactory.models.Order;
import creationalpatterns.abstarctfactory.models.Sofa;
import creationalpatterns.abstarctfactory.models.Enums.FurnitureStyles;

public class FurnitureFactory
{
    private FurnitureStyles furnitureStyle;
    private List<Order> orders;
    private FurnitureFactory artDecoFactory, modernFactory, victorianFactory, _factory;

    public FurnitureFactory() { }

    public FurnitureFactory(FurnitureStyles furnitureStyle)
    {
        this.furnitureStyle = furnitureStyle;
        this.orders = new ArrayList<Order>();
    }

    public FurnitureFactory getInstance(FurnitureStyles furnitureStyle)
    {
        if (furnitureStyle == FurnitureStyles.ArtDeco)
        {
            if (this.artDecoFactory == null)
            {
                this.artDecoFactory = new FurnitureFactory(furnitureStyle);
            }

            return this.artDecoFactory;
        }
        else if (furnitureStyle == FurnitureStyles.Modern)
        {
            if (this.modernFactory == null)
            {
                this.modernFactory = new FurnitureFactory(furnitureStyle);
            }

            return this.modernFactory;
        } 
        else if (furnitureStyle == FurnitureStyles.Victorian)
        {
            if (this.victorianFactory == null)
            {
                this.victorianFactory = new FurnitureFactory(furnitureStyle);
            }

            return this.victorianFactory;
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
        this.orders.add(order);
    }

    public List<Order> getOrders()
    {
        var orders = new ArrayList<Order>();
        if (this.artDecoFactory != null)
        {
            orders.addAll(this.artDecoFactory.getOrders());
        }

        if (this.modernFactory != null)
        {
            orders.addAll(this.modernFactory.getOrders());
        }

        if (this.victorianFactory != null)
        {
            orders.addAll(this.victorianFactory.getOrders());
        }

        if (this.furnitureStyle == null)
        {
            this.orders = orders;
        }

        return this.orders;
    }

    private Chair createChair()
    {
        return new Chair(this.furnitureStyle);
    }

    private Sofa createSofa()
    {
        return new Sofa(furnitureStyle);
    }

    private CoffeeTable createCoffeeTable()
    {
        return new CoffeeTable(furnitureStyle);
    }
}
