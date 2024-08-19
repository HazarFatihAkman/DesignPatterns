package designpatterns.abstractfactory.factories;

import java.util.*;

import designpatterns.abstractfactory.models.Order;
import designpatterns.abstractfactory.models.products.Product;
import designpatterns.abstractfactory.models.products.ProductStyleTypes;
import designpatterns.abstractfactory.models.products.ProductTypes;

public final class FurnitureFactory {
    private FurnitureFactory _artDeco, _modern, _victorian, _singletonInstance;
    private final ProductStyleTypes productStyle;
    private final List<Order> orders = new ArrayList<Order>();
    
    public FurnitureFactory() {
        this.productStyle = ProductStyleTypes.None;
    }

    public FurnitureFactory(ProductStyleTypes productStyle) {
        this.productStyle = productStyle;
    }

    public final FurnitureFactory getInstance(ProductStyleTypes productStyle) {
        switch (productStyle) {
            case Modern:
                if (this._modern == null) {
                    this._modern = new FurnitureFactory(productStyle);
                }

                return this._modern;
            case ArtDeco:
                if (this._artDeco == null) {
                    this._artDeco = new FurnitureFactory(productStyle);
                }

                return this._artDeco;
            case Victorian:
                if (this._victorian == null) {
                    this._victorian = new FurnitureFactory(productStyle);
                }

                return this._victorian;
            case None:
                if (this._singletonInstance == null) {
                    this._singletonInstance = new FurnitureFactory();
                }

                return this._singletonInstance;
            default :
                if (this._singletonInstance == null) {
                    this._singletonInstance = new FurnitureFactory();
                }

                return this._singletonInstance;
        }
    }

    public Product createProduct(ProductTypes productType) {
        return new Product(productType, this.productStyle);
    }

    public Order creatOrder() {
        return new Order();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public Order getOrderById(UUID id) {
        return this.orders.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
}
