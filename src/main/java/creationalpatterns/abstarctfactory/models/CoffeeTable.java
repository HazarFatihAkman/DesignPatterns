package creationalpatterns.abstarctfactory.models;

import creationalpatterns.abstarctfactory.models.Enums.FurnitureStyles;

public class CoffeeTable
{    
    private FurnitureStyles _furnitureStyle;
    private Integer _legCount;
    private Integer _longSideLength;
    private Integer _shortSideLength;

    public CoffeeTable(FurnitureStyles furnitureStyle)
    {
        this._furnitureStyle = furnitureStyle;
    }
    
    //Getters

    public FurnitureStyles getFurnitureStyle()
    {
        return this._furnitureStyle;
    }

    public Integer getLegCount()
    {
        return this._legCount;
    }

    public Integer getLongSideLength()
    {
        return this._longSideLength;
    }

    public Integer getShortSideLength()
    {
        return this._shortSideLength;
    }

    //Setters

    public void setLegCount(Integer legCount)
    {
        this._legCount = legCount;
    }

    public void setLongSideLength(Integer longSideLength)
    {
        this._longSideLength = longSideLength;
    }

    public void setShortSideLength(Integer shortSideLength)
    {
        this._shortSideLength = shortSideLength;
    }
}
