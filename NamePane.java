
/******************************************************
 * Write a description of class NamePane here.
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 ******************************************************/

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import java.io.*;

public class NamePane extends GridPane
{
    private Label message;
    private TextField nameBox;
    private String name;
    
    // set up the pane
    public NamePane()
    {
        Font font = new Font(13);
        
        Label inputLabel = new Label("Please enter your name:");
        inputLabel.setFont(font);
        GridPane.setHalignment(inputLabel, HPos.RIGHT);
        
        message = new Label("Please press the 'Enter' key when you have entered your name");
        message.setWrapText(true);
        message.setPrefWidth(200);
        
        message.setFont(font);
        GridPane.setHalignment(message, HPos.CENTER);
        
        nameBox = new TextField();
        nameBox.setFont(font);
        nameBox.setPrefWidth(200);
        nameBox.setAlignment(Pos.CENTER);
        
        nameBox.setOnAction(e -> {
            try
            {
                name = nameBox.getText();
                message.setText("Thank you, " + name);
            }
            catch (StringIndexOutOfBoundsException exception)
            {
                message.setText("Invalid email. Please enter a valid name. ");
            }
        });
        
        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(20);
        
        add(inputLabel, 4, 14);
        add(nameBox, 5, 14);
        add(message, 5, 15);
    }
    
    public String getName()
    {
        return name;
    }
    
    public void clearAll()
    {
        nameBox.clear();
        message.setText("Please press the 'Enter' key when you have entered your name");
    }
}