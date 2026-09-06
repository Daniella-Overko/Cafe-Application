
/*****************************************************************************
 * Coffee shop Member who gets points when they order from the coffee shop. 
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 ****************************************************************************/
public class Member extends Customer 
{
    // instance variables
    private String email;
    private int points;

    // Constructor for objects of class Member
    public Member(String customerName, String memberEmail)
    {
        super(customerName);
        email = memberEmail;
        points = 0;
    }

    // Members can also order drinks, but they also get points 
    public String order()
    {
        points += 5;
        return "Thank you, " + name + ", your order has been placed, and you have earned 5 points!";
    }
    
    // getter method for email
    public String getEmail()
    {
        return email;
    }
    
    // getter method for points
    public int getPoints()
    {
        return points;
    }
    
    // setter for name
    public void setName(String name)
    {
        this.name = name;
    }
    
    // setter for points
    public void setPoints(int points)
    {
        this.points += points;
    }
}
