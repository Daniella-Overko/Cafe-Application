
/******************************************************
 * Write a description of class DrinkPane here.
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 ******************************************************/
 

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Arrays;

public class DrinkPane extends GridPane
{
    private ChoiceBox<String> sizeChoice;
    private ChoiceBox<String> tempChoice;
    private ChoiceBox<String> drinkChoice;
    private ChoiceBox<String> milkChoice;
    private ChoiceBox<String> flavourChoice;
    private ChoiceBox<String> additionChoice;
    private Label text;
    private Label text1;
    private Label text2;
    private Label text3;
    private Label text4;
    private Label text5;
    private Label message = new Label("");
    private Button confirm;
    
    private String[] sizes = {"Select Size", "Large", "Medium", "Small"};
    private String[] temps = {"Select Temperature", "Hot", "Iced"};
    private String[] drinks = {"Select Drink", "Espresso", "Americano", "Drip Coffee", "Latte", "Cappuccino", "Mocha", "Matcha Latte", "Chai Latte", "London Fog"};
    private String[] milks = {"Select Milk", "Whole Milk", "2% Milk", "Almond Milk", "Oat Milk"};
    private String[] flavours = {"Select Flavour", "Vanilla", "Caramel", "Hazelnut", "None"};
    private String[] additions = {"Select Additions", "Milk", "Cream", "Both", "None"};
    
    private Integer[] order = {0, 0, 0, 0, 0};
    
    public DrinkPane()
    {
        message.setWrapText(true);
        message.setPrefWidth(200);
        
        Label inputLabel = new Label("Select a size:");
        GridPane.setHalignment(inputLabel, HPos.LEFT);
        
        text = new Label("---");
        GridPane.setHalignment(text, HPos.CENTER);
        
        sizeChoice = new ChoiceBox<String>();
        sizeChoice.getItems().addAll(sizes);
        sizeChoice.getSelectionModel().selectFirst();
        sizeChoice.setOnAction(e -> {
            text.setText(sizes[sizeChoice.getSelectionModel().getSelectedIndex()]);
            order[0] = sizeChoice.getSelectionModel().getSelectedIndex();
        });
        
        Label inputLabel1 = new Label("Select a temperature:");
        GridPane.setHalignment(inputLabel1, HPos.LEFT);
        
        text1 = new Label("---");
        GridPane.setHalignment(text1, HPos.CENTER);
        
        tempChoice = new ChoiceBox<String>();
        tempChoice.getItems().addAll(temps);
        tempChoice.getSelectionModel().selectFirst();
        tempChoice.setOnAction(e -> {
            text1.setText(temps[tempChoice.getSelectionModel().getSelectedIndex()]);
            order[1] = tempChoice.getSelectionModel().getSelectedIndex();
        });
        
        
        Label inputLabel2 = new Label("Select your drink:");
        GridPane.setHalignment(inputLabel2, HPos.LEFT);
        
        text2 = new Label("---");
        GridPane.setHalignment(text2, HPos.CENTER);
        
        drinkChoice = new ChoiceBox<String>();
        drinkChoice.getItems().addAll(drinks);
        drinkChoice.getSelectionModel().selectFirst();
        drinkChoice.setOnAction(e -> {
            text2.setText(drinks[drinkChoice.getSelectionModel().getSelectedIndex()]);
            
            order[2] = drinkChoice.getSelectionModel().getSelectedIndex();
            
            if (text2.getText().equals("Espresso") || text2.getText().equals("Americano") || text2.getText().equals("Drip Coffee"))
                milkChoice.setDisable(true);
            else
                milkChoice.setDisable(false);
                
            if (text2.getText().equals("Espresso") || text2.getText().equals("Americano") || text2.getText().equals("Drip Coffee"))
                flavourChoice.setDisable(true);
            else
                flavourChoice.setDisable(false);
                
            if (text2.getText().equals("Drip Coffee"))
                additionChoice.setDisable(false);
            else
                additionChoice.setDisable(true);
        });
        
        
        Label inputLabel3 = new Label("Select your milk:");
        GridPane.setHalignment(inputLabel3, HPos.LEFT);
        
        text3 = new Label("---");
        GridPane.setHalignment(text3, HPos.CENTER);
        
        milkChoice = new ChoiceBox<String>();
        milkChoice.getItems().addAll(milks);
        milkChoice.getSelectionModel().selectFirst();
        
        milkChoice.setOnAction(e -> {
            text3.setText(milks[milkChoice.getSelectionModel().getSelectedIndex()]);
            
            order[3] = milkChoice.getSelectionModel().getSelectedIndex();
        });
        
        
        Label inputLabel4 = new Label("Select a flavour:");
        GridPane.setHalignment(inputLabel4, HPos.LEFT);
        
        text4 = new Label("---");
        GridPane.setHalignment(text4, HPos.CENTER);
        
        flavourChoice = new ChoiceBox<String>();
        flavourChoice.getItems().addAll(flavours);
        flavourChoice.getSelectionModel().selectFirst();
        flavourChoice.setOnAction(e -> {
            text4.setText(flavours[flavourChoice.getSelectionModel().getSelectedIndex()]);
            
            order[4] = flavourChoice.getSelectionModel().getSelectedIndex();
        });
        
        
        Label inputLabel5 = new Label("Would you like milk and/or cream?");
        GridPane.setHalignment(inputLabel5, HPos.LEFT);
        
        text5 = new Label("---");
        GridPane.setHalignment(text5, HPos.CENTER);
        
        additionChoice = new ChoiceBox<String>();
        additionChoice.getItems().addAll(additions);
        additionChoice.getSelectionModel().selectFirst();
        additionChoice.setOnAction(e -> {
            text5.setText(additions[additionChoice.getSelectionModel().getSelectedIndex()]);
            
            order[3] = additionChoice.getSelectionModel().getSelectedIndex();
        });
        
        additionChoice.setDisable(true);
        
        
        
        confirm = new Button("Confirm Selection");

        confirm.setAlignment(Pos.CENTER);
        confirm.setOnAction(e -> {            
            isValid();
        });
        
        
        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(20);
        
        add(inputLabel, 1, 4);
        add(sizeChoice, 1, 5);
        add(text, 1, 6);
        
        add(inputLabel1, 3, 4);
        add(tempChoice, 3, 5);
        add(text1, 3, 6);
        
        add(inputLabel2, 5, 4);
        add(drinkChoice, 5, 5);
        add(text2, 5, 6);
        
        add(inputLabel3, 7, 4);
        add(milkChoice, 7, 5);
        add(text3, 7, 6);
        
        add(inputLabel4, 9, 4);
        add(flavourChoice, 9, 5);
        add(text4, 9, 6);
        
        add(inputLabel5, 11, 4);
        add(additionChoice, 11, 5);
        add(text5, 11, 6);
        
        add(confirm, 13, 5);
        
        add(message, 13, 6, 10, 1);
    }
   
    public Integer[] getOrder()
    {
        return order;
    }
    
    public void clearAll()
    {
        sizeChoice.getSelectionModel().selectFirst();
        tempChoice.getSelectionModel().selectFirst();
        drinkChoice.getSelectionModel().selectFirst();
        milkChoice.getSelectionModel().selectFirst();
        flavourChoice.getSelectionModel().selectFirst();
        additionChoice.getSelectionModel().selectFirst();
        text.setText("---");
        text1.setText("---");
        text2.setText("---");
        text3.setText("---");
        text4.setText("---");
        text5.setText("---");
        message.setText("");
    }
    
    public boolean isValid()
    {
        Integer found;
            
        Searching<Integer> searches = new Searching<Integer>();
            
        if (text2.getText().equals("Espresso") || text2.getText().equals("Americano") || text2.getText().equals("Drip Coffee"))
            found = searches.linearSearch(Arrays.copyOfRange(order, 0, 3), 0);
        else if (text2.getText().equals("Drip Coffee"))
            found = searches.linearSearch(Arrays.copyOfRange(order, 0, 4), 0);
        else
            found = searches.linearSearch(order, 0);
            
        if (found != -1)
        {
            message.setText("Please make sure you have made a selection for everything");
            return false;
        }
        else
        {
            message.setText("Thank you!");
            return true;
        }
    }
}