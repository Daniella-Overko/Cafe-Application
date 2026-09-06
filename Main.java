
/*****************************************************
 * This is the coffee shop ordering system.  
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 *****************************************************/

// importing all required classes for the JavaFX program
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.time.LocalTime;
 
public class Main extends Application
{
    // polymorphic references for the order/customers
    Drink d;
    Customer c;
    Member m;
    Member m1;
    
    // required variables
    String email;
    String name;
    LocalTime now = LocalTime.now();
    int match;
    
    // this will contain the order information
    Integer[] orderInfo = new Integer[5];
    
    // required collections
    ArrayList<Member> members = new ArrayList<Member>();
    List<Integer> points = new ArrayList<Integer>();
    Queue<Drink> drinks = new LinkedList<Drink>();
    List<Drink> orders = new ArrayList<Drink>();
    
    // Text required in the methods
    Text fileEmails = new Text(1100, 600, "");
    Text preparedDrinks = new Text(1000, 300, "Who can collect their drinks: \n~~~~~~~~~~~~~~~~~");
    
    // will display the ordering system for the customers in a JavaFX window
    public void start(Stage primaryStage)
    {   
        // the text guiding the customer
        Text title = new Text(50, 50, "What would you like to order?");
        Text drinkLabel = new Text(400, 500, " ");
        Text order = new Text(400, 550, "");
        Text searched = new Text(600, 425, "---");
        Text fileCreated = new Text(50, 650, "");
        
        // make title stand out
        title.setFont(Font.font("Lucida Calligraphy", 20));
        
        // make the panes so that we will be able to access some of their variables
        DrinkPane drinkPane = new DrinkPane();
        NamePane namePane = new NamePane();
        EmailPane emailPane = new EmailPane();
        
        
        // to start, read the file to see who are already members
        readFile();
        
        // create a button to create a search for email
        Button emailButton = new Button("Submit Email");
        emailButton.setOnAction(e -> {
            // create an array of the emails to search
            String[] emails = new String[members.size()];
            for (int i = 0; i < emails.length; i++)
                emails[i] = members.get(i).getEmail();
            
            // establish variables
            email = emailPane.getEmail();
            name = namePane.getName();
            
            // search for a matching email
            Searching<String> searches = new Searching<String>();
            match = searches.linearSearch(emails, email);
            
            // if there is a match, that is our customer
            if (match != -1)
            {
                m1 = members.get(match);
                m1.setName(name);
                searched.setText("Welcome back! You have " + m1.getPoints() +  " points with the email " + emails[match]);
            }
            // if not, our customer is a new member
            else if (email != null)
            {
                m1 = new Member(name, email);
                members.add(m1);
                searched.setText("Thank you for signing up!");
            }
        });
        
        // prepare the GridPane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);
        
        pane.add(emailButton, 65, 37);
        
        
        // create another button to create place the order
        Button placeOrder = new Button("Place Order");
        placeOrder.setOnAction(e -> {
            // if the customer has made a selection
            if (drinkPane.isValid()) {
                try
                {
                    // establish variables and our customer, as well as our order
                    email = emailPane.getEmail();
                    name = namePane.getName();
                    
                    if (email == null || email.isEmpty())
                        c = new Customer(name);
                    else 
                        c = m1;
                    
                    orderInfo = drinkPane.getOrder();
                    
                    // create the drink depending on the constructor, first adding it to the orders, 
                    if (orderInfo[2] == 1 || orderInfo[2] == 2)
                        orders.add(new Coffee(orderInfo[0], orderInfo[1], orderInfo[2], now.getHour() + ":" + now.getMinute(), c));
                    else if (orderInfo[2] == 3)
                        orders.add(new DripCoffee(orderInfo[0], orderInfo[1], orderInfo[2], orderInfo[3], now.getHour() + ":" + now.getMinute(), c));
                    else 
                        orders.add(new MilkBased(orderInfo[0], orderInfo[1], orderInfo[2], orderInfo[3], orderInfo[4], now.getHour() + ":" + now.getMinute(), c));
                    
                    // then making that our drink of focus
                    if (orderInfo[2] == 1 || orderInfo[2] == 2)
                        d = new Coffee(orderInfo[0], orderInfo[1], orderInfo[2], now.getHour() + ":" + now.getMinute(), c);
                    else if (orderInfo[2] == 3)
                        d = new DripCoffee(orderInfo[0], orderInfo[1], orderInfo[2], orderInfo[3], now.getHour() + ":" + now.getMinute(), c);
                    else 
                        d = new MilkBased(orderInfo[0], orderInfo[1], orderInfo[2], orderInfo[3], orderInfo[4], now.getHour() + ":" + now.getMinute(), c);
                        
                    // let the customer know they ordered
                    drinkLabel.setText(d.label());
                    order.setText(c.order());
                    
                    // update the members
                    try
                    {
                        String fileName = "emails.txt";
                    
                        PrintWriter outFile = new PrintWriter(fileName);
                        
                        for (int line = 0; line < members.size(); line++)
                        {
                            outFile.println(members.get(line).getEmail());
                            outFile.println(members.get(line).getPoints());
                        }
                    
                        outFile.close();
                    
                        fileCreated.setText("You have successfully updated " + fileName);
                    }
                    catch (IOException exception)
                    {
                        fileCreated.setText("Something went wrong. Please try again");
                    }
                    finally 
                    {
                        readFile();
                    }
                }
                // clear everything, and show what drinks are ready to be picked up
                finally
                {
                    drinks.add(d);
                    drinkPane.clearAll();
                    namePane.clearAll();
                    emailPane.clearAll();
                    searched.setText("");
                    
                    preparedDrinks.setText(preparedDrinks.getText() + "\n" + d.getName());
                    collectDrink(drinks);
                }
            }
            else
                drinkLabel.setText("Please make your selection to place your order");
        });        
        
        // prepare the GridPane
        GridPane pane1 = new GridPane();
        pane1.setPadding(new Insets(10, 10, 10, 10));
        pane1.setMinSize(300, 300);
        pane1.setVgap(10);
        pane1.setHgap(10);
        
        pane1.add(placeOrder, 10, 55);
        
        
        // create a button to create a file button
        Button createFile = new Button("Create File");
        createFile.setOnAction(e -> {
            // create a file with the orders
            try
            {
                String fileName = "orders.txt";
            
                PrintWriter outFile = new PrintWriter(fileName);
                
            
                for (int line = 0; line < orders.size(); line++)
                {
                    outFile.println(orders.get(line).info());
                }
            
                outFile.close();
            
                fileCreated.setText("Output file has been created: " + fileName);
            }
            catch (IOException exception)
            {
                fileCreated.setText("Something went wrong. Please try again");
            }
        });
        
        // prepare the GridPane
        GridPane pane2 = new GridPane();
        pane2.setPadding(new Insets(10, 10, 10, 10));
        pane2.setMinSize(300, 300);
        pane2.setVgap(10);
        pane2.setHgap(10);
        
        pane2.add(createFile, 10, 60);
        
        
        // prepare the scene
        Group root = new Group(title, order, drinkLabel, searched, preparedDrinks, fileCreated, fileEmails, pane, pane2, emailPane, namePane, pane1, drinkPane);
        Scene scene = new Scene(root, 1300, 700, Color.CORNSILK);
        
        // set everything up and display it
        primaryStage.setTitle("Coffee Shop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // reads the emails that are in the system and makes them members
    public void readFile()
    {
        try
        {
            fileEmails.setText("");
            members.clear();
            
            FileReader f = new FileReader("emails.txt");
            
            BufferedReader b = new BufferedReader(f);
            
            String nextLine = "Emails in the system: \n";
            
            nextLine = b.readLine();
            
            while (nextLine != null)
            {
                m = new Member("", nextLine);
                
                nextLine = b.readLine();
                
                m.setPoints(Integer.parseInt(nextLine));
                members.add(m);
                
                nextLine = b.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            fileEmails.setText("File not found in directory. ");
        }
        catch (IOException e)
        {
            fileEmails.setText("Error in the input in the file. ");
        }
    }
    
    // recursive method to pause and show which drinks are ready to be picked up
    public String collectDrink(Queue<Drink> drinks)
    {
        if (drinks.isEmpty())
        {
            return "";
        }
        else
        {
            Drink current = drinks.poll();
            
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {}
            
            return current.getName() + "\n" + collectDrink(drinks);
        }
    }
}
