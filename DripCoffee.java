
/***********************************************
 * DripCoffee
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 **********************************************/
public class DripCoffee extends Drink
{
    // instance variables
    String additions; 
    
    // Constructor for objects of class DripCoffee
    public DripCoffee(int orderedSize, int orderedTemp, int orderedDrink, int orderedAdditions, String timeOrdered, Customer orderCustomer)
    {
        // initialise instance variables
        super(orderedSize, orderedTemp, orderedDrink, timeOrdered, orderCustomer);
        switch (orderedAdditions)
        {
            case 1:
                additions = "Milk";
                break;
            case 2:
                additions = "Cream";
                break;
            case 3:
                additions = "Both";
                break;
            case 4: 
                additions = "None";
                break;
        }
    }

    // overriding the abstract method
    public String label()
    {
        // print a message
        return "You are ordering a drip coffee with " + additions;
    }
    
    public String info()
    {
        return "Size: " + size + "\t Temperature: " + temp + "\t Drink: " + drink + "\t Additions: " + additions + "\t Time Ordered: " + time + "\t Name: " + customer.getName();
    }
}