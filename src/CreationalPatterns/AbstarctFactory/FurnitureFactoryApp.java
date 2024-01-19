package CreationalPatterns.AbstarctFactory;

import java.util.Scanner;

import CreationalPatterns.AbstarctFactory.Factories.ArtDecoFurnitureFactory;
import CreationalPatterns.AbstarctFactory.Factories.ModernFurnitureFactory;
import CreationalPatterns.AbstarctFactory.Factories.VictorianFurnitureFactory;
import CreationalPatterns.AbstarctFactory.Interfaces.IFurnitureFactory;

public class FurnitureFactoryApp
{
    public static void main(String[] args)
    {
        try
        {
            orderNewFurniture();
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    private static void orderNewFurniture() throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        Integer variatianCode = 0;
        IFurnitureFactory factory;
        
        while(variatianCode < 1 || variatianCode > 3)
        {
            System.out.println("Select your furniture variation : \n 1 - Art Deco \n 2 - Modern \n 3 - Victorian");
            variatianCode = scanner.nextInt();
        }
        scanner.close();

        if (variatianCode == 1)
        {
            factory = new ArtDecoFurnitureFactory();
        }
        else if (variatianCode == 2)
        {
            factory = new ModernFurnitureFactory();
        }
        else if (variatianCode == 3)
        {
            factory = new VictorianFurnitureFactory();
        }
        else
        {
            throw new Exception("out of range");
        }

        factory.createChair();
        factory.createCoffeeTable();
        factory.createSofa();

        System.out.println("Chair -> " + factory.getChair().getClass().getSimpleName());
        System.out.println("Sofa -> " + factory.getSofa().getClass().getSimpleName());
        System.out.println("Coffee Table -> " + factory.getCoffeeTable().getClass().getSimpleName());
    }
}