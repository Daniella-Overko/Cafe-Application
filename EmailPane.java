
/******************************************************
 * Write a description of class EmailPane here.
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
import java.util.List;
import java.util.ArrayList;

public class EmailPane extends GridPane
{
    private Label message;
    private TextField emailBox;
    private String email;
    private boolean isEmail;
    
    // set up the pane
    public EmailPane()
    {
        Label inputLabel = new Label("Please enter your email if you are/would like to be a member:");
        inputLabel.setWrapText(true);
        inputLabel.setPrefWidth(200);
        GridPane.setHalignment(inputLabel, HPos.RIGHT);
        
        message = new Label("Please press the 'Enter' key when you have entered your email");
        message.setWrapText(true);
        message.setPrefWidth(200);
        GridPane.setHalignment(message, HPos.CENTER);
        
        emailBox = new TextField();
        emailBox.setPrefWidth(200);
        emailBox.setAlignment(Pos.CENTER);
        
        emailBox.setOnAction(e -> {
            email = emailBox.getText();
            isEmail = false;
                
            for (int i = 0; i < email.length(); i++)
            {
                if ((int) email.charAt(i) == 64)
                {
                    isEmail = true;
                    message.setText("");
                }
            }
                
            if (isEmail == false)
                message.setText("Invalid email. Please enter a valid email. ");
        });
        
        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(20);
        
        add(inputLabel, 24, 14);
        add(emailBox, 25, 14);
        add(message, 25, 15);
    }
    
    public String getEmail()
    {
        if (isEmail == true)
            return email;
        else 
            return null;
    }
    
    public void clearAll()
    {
        emailBox.clear();
        message.setText("Please press the 'Enter' key when you have entered your email");
    }
}