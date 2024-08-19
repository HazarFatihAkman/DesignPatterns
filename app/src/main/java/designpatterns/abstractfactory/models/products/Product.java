package designpatterns.abstractfactory.models.products;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final ProductStyleTypes productStyle;
    private final ProductTypes productType;

    public Product(ProductTypes productType, ProductStyleTypes productStyle) {
        this.id = UUID.randomUUID();
        this.name = productStyle.name() + " " + productType.name();
        this.productType = productType;
        this.productStyle = productStyle;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        var manifacturingCost = getManufacturingCost();
        return manifacturingCost + (manifacturingCost / 100 * 10);
    }

    public ProductTypes getProductType() {
        return this.productType;
    }

    public ProductStyleTypes getProductStyleType()
    {
        return this.productStyle;
    }

    public int getWeight() {
        int materialWeight;
   
        switch (productStyle) {
            case Modern:
                materialWeight = 2;
                break;
            case Victorian:
                materialWeight = 4;
                break;
            case ArtDeco:
                materialWeight = 3;
                break;
            default:
                throw new EnumConstantNotPresentException(ProductStyleTypes.class, productStyle.name());
        }

        switch (productType) {
            case Chair:
                return materialWeight + 1;
            case Sofa:
                return materialWeight + 3;
            case Table:
                return materialWeight + 2;
            default:
                throw new EnumConstantNotPresentException(ProductTypes.class, productType.name());
        }
    }

    public double getManufacturingCost() {
        double materialCost;

        switch (productStyle) {
            case Modern:
                materialCost = 1110.3;
                break;
            case Victorian:
                materialCost = 1510.9;
                break;
            case ArtDeco:
                materialCost = 1210.5;
                break;
            default:
                throw new EnumConstantNotPresentException(ProductStyleTypes.class, productStyle.name());
        }

        switch (productType) {
            case Chair:
                return materialCost * 4.7;
            case Sofa:
                return materialCost * 3.1;
            case Table:
                return materialCost * 5.8;
            default:
                throw new EnumConstantNotPresentException(ProductTypes.class, productType.name());
        }
    }

    public int getShippingDayCount() {
        var price = getPrice();

        if (price > 0 && price <= 5500) {
            return 5;
        }
        else if (price > 5500 && price <= 8000) {
            return 8;
        }
        else if (price > 8000) {
            return 10;
        }

        throw new IllegalArgumentException("Price cannot be less than 1$");
    }

    @Override
    public String toString() {
        return String
            .format("\t\t\t[%s] \n"
                    + "\t\t\t[Price : %.2f €] \n"
                    + "\t\t\t[Manufacturing Cost : %.2f €] \n"
                    + "\t\t\t[%d ton] \n"
                    + "\t\t\t[Ready For Shipping in %d] \n"
                    + "\t\t\t=========================================================================== \n",
                  name,
                  getPrice(),
                  getManufacturingCost(),
                  getWeight(),
                  getShippingDayCount());
    }
}
