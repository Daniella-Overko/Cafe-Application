
/******************************************************
 * Parent class to the different drinks you can order. 
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 *****************************************************/
import java.lang.*;
 
public class Drink implements Order
{
    // instance variables 
    protected String size, temp, drink;
    protected String notes;
    protected String time; 
    protected Customer customer;
    
    // Constructor for objects of class Drink
    public Drink(int orderedSize, int orderedTemp, int orderedDrink, String timeOrdered, Customer orderCustomer)
    {
        // initialise instance variables
        switch (orderedSize)
        {
            case 1:
                size = "Large";
                break;
            case 2:
                size = "Medium";
                break;
            case 3:
                size = "Small";
                break;
        }
        
        switch (orderedTemp)
        {
            case 1:
                temp = "Hot";
                break;
            case 2:
                temp = "Iced";
                break;
        }
        
        switch (orderedDrink)
        {
            case 1:
                drink = "Espresso";
                break;
            case 2:
                drink = "Americano";
                break;
            case 3:
                drink = "Drip Coffee";
                break;
            case 4:
                drink = "Latte";
                break;
            case 5:
                drink = "Cappuccino";
                break;
            case 6: 
                drink = "Mocha";
                break;
            case 7:
                drink = "Matcha Latte";
                break;
            case 8:
                drink = "Chai Latte";
                break;
            case 9:
                drink = "London Fog";
                break;
        }
        
        customer = orderCustomer;
        time = timeOrdered; 
    }
    
    // getter method to access the name
    public String getName()
    {
        return customer.getName();
    }
    
    // getter method to access time 
    public String getTime()
    {
        return time;
    }
    
    // overriding the abstract methods from the Order interface: 
    
    // the drink label for the customer
    public String label()
    {
        // print a message
        return "You are ordering something!";
    }
    
    // the information about the drink (for the employees)
    public String info()
    {
        return "Size: " + size + "\t Temperature: " + temp + "\t Drink: " + drink + "\t Time Ordered: " + time + "\t Name: " + customer.getName();
    }
}