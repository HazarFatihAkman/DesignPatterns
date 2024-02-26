package creationalpatterns.abstarctfactory;

import java.util.Scanner;

import creationalpatterns.abstarctfactory.factories.FurnitureFactory;
import creationalpatterns.abstarctfactory.models.Enums.FurnitureStyles;

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
        FurnitureFactory furnitureFactory = new FurnitureFactory().getInstance(null);
        FurnitureFactory factory;
        Boolean addNewOrder = true;

        while (addNewOrder)
        {
            while(variatianCode < 1 || variatianCode > 3)
            {
                System.out.println("Select your furniture variation : \n 1 - Art Deco \n 2 - Modern \n 3 - Victorian");
                variatianCode = Integer.parseInt(scanner.nextLine());
            }

            if (variatianCode == 1)
            {
                factory = furnitureFactory.getInstance(FurnitureStyles.ArtDeco);
            }
            else if (variatianCode == 2)
            {
                factory = furnitureFactory.getInstance(FurnitureStyles.Modern);
            }
            else if (variatianCode == 3)
            {
                factory = furnitureFactory.getInstance(FurnitureStyles.Victorian);
            }
            else
            {
                throw new Exception("out of range");
            }
            System.out.println(factory.hashCode());
            var newOrder = factory.createOrder();
            factory.addOrder(newOrder);

            System.out.println("Chair -> " + newOrder.getChair().getFurnitureStyle());
            System.out.println("Sofa -> " + newOrder.getSofa().getFurnitureStyle());
            System.out.println("Coffee Table -> " + newOrder.getCoffeeTable().getFurnitureStyle());

            String answer = new String();
            
            while (!answer.equals("y") && !answer.equals("n"))
            {
                System.out.println("Add new order? y/n");   
                answer = scanner.nextLine().toLowerCase();
            }

            addNewOrder = answer.equals("y");
            if (!addNewOrder)
            {
                scanner.close();
            }
            else
            {
                variatianCode = 0;
            }
        }

        System.out.println("\n[-----------------]");
        System.out.println("[Order List]");

        for(var order : furnitureFactory.getOrders())
        {
            System.out.println("---------");
            System.out.println("Order Id : " + order.getId());
            System.out.println("Chair Style : " + order.getChair().getFurnitureStyle());
            System.out.println("Sofa Style : " + order.getSofa().getFurnitureStyle());
            System.out.println("Coffee Table Style : " + order.getCoffeeTable().getFurnitureStyle());
            System.out.println("---------");
        }
    }
}