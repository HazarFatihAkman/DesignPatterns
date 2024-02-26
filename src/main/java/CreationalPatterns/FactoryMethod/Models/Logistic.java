package CreationalPatterns.FactoryMethod.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import CreationalPatterns.FactoryMethod.Enums.VechileTypes;

public class Logistic
{
    private List<Vechile> _vechiles;
    private VechileTypes _vechileType;

    public Logistic(VechileTypes vechileType)
    {
        this._vechiles = new ArrayList<Vechile>();
        this._vechileType = vechileType;
    }

    public Vechile createVechile()
    {
        var vechile = new Vechile(this._vechileType);
        _vechiles.add(vechile);

        return vechile;
    }

    public void upsertVechile(Vechile vechile) throws Exception
    {
        if (vechile == null)
        {
            throw new Exception("Vechile shouldn't be null.");
        }

        if (!vechile.isUpdated())
        {
            throw new Exception("This vechile's not updated.");
        }
        else
        {
            var oldVechile = _vechiles.stream().filter(item -> item.getId() == vechile.getId()).findFirst().get();
            _vechiles.set(_vechiles.indexOf(oldVechile), vechile);
        }
    }

    public List<Vechile> getVechileOnRoad()
    {
        return this._vechiles.stream().filter(x -> x.getOnRoad() == true).toList();
    }

    public List<Vechile> getVechileNotOnRoad()
    {
        return this._vechiles.stream().filter(x -> x.getOnRoad() == false).toList();
    }
    
    public List<Vechile> getVechiles()
    {
        return this._vechiles;
    }

    public Vechile getVechileById(UUID id)
    {
        return _vechiles.stream().filter(x -> x.getId() == id).findFirst().get();
    }
}
