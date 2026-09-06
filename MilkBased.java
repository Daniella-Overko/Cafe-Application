
/***********************************************
 * Milk Based Drinks
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 **********************************************/
public class MilkBased extends Drink
{
    // instance variables 
    private String milk;
    private String flavour;

    // Constructor for objects of class MilkBased
    public MilkBased(int orderedSize, int orderedTemp, int orderedDrink, int orderedMilk, int orderedFlavour, String timeOrdered, Customer orderCustomer)
    {
        // initialise instance variables
        super(orderedSize, orderedTemp, orderedDrink, timeOrdered, orderCustomer);
        
        switch (orderedMilk)
        {
            case 1:
                milk = "Whole Milk";
                break;
            case 2:
                milk = "2% Milk";
                break;
            case 3:
                milk = "Almond Milk";
                break;
            case 4: 
                milk = "Oat Milk";
                break;
        }
        
        switch (orderedFlavour)
        {
            case 1:
                flavour = "Vanilla";
                break;
            case 2:
                flavour = "Caramel";
                break;
            case 3:
                flavour = "Hazelnut";
                break;
            case 4: 
                flavour = "None";
                break;
        }
    }

    // overriding the abstract method
    public String label()
    {
        // print a message
        return "You are ordering a " + size + " " + temp + " " + drink + " with " + milk + " and a shot of " + flavour;
    }
    
    // returning information
    public String info()
    {
        return "Size: " + size + "\t Temperature: " + temp + "\t Drink: " + drink + "\t Milk: " + milk + "\t Flavour: " + flavour + "\t Time Ordered: " + time + "\t Name: " + customer.getName();
    }
}