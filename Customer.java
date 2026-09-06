
/*****************************************************
 * Customer who will ordering from the coffee shop. 
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 *****************************************************/
public class Customer
{
    // instance variables 
    protected String name;

    // Constructor for objects of class Customer
    public Customer(String customerName)
    {
        // initialise instance variables
        name = customerName;
    }

    // The customer can order drinks from the coffee shop
    public String order()
    {
        return "Thank you, " + name + ", your order has been placed. ";
    }
    
    public String getName()
    {
        return name;
    }
}
