package creationalpatterns.abstarctfactory.models;

import creationalpatterns.abstarctfactory.models.Enums.FurnitureStyles;

public class Sofa
{
    private FurnitureStyles _furnitureStyle;
    private Integer _legCount;    

    public Sofa(FurnitureStyles furnitureStyle)
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

    //Setters

    public void setLegCount(Integer legCount)
    {
        this._legCount = legCount;
    }
}
