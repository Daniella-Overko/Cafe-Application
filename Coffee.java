
/***********************************************
 * Coffee
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 **********************************************/

public class Coffee extends Drink
{
    // Constructor for objects of class Coffee
    public Coffee(int orderedSize, int orderedTemp, int orderedDrink, String timeOrdered, Customer orderCustomer)
    {
        // initialise instance variables
        super(orderedSize, orderedTemp, orderedDrink, timeOrdered, orderCustomer);
    }

    // overriding the abstract method
    public String label()
    {
        // print a message 
        return "You are ordering a " + size + " " + temp + " " + drink;
    }
}