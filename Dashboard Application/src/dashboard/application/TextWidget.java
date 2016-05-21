/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Brennan
 */
public class TextWidget extends DataWidget {
    
    // Fields
    private String lastDisplayedValue;
    private Label label;
    private TextField textField;
    
    
    // Constructor
    public TextWidget() {
        
        // New Label object
        label = new Label();
        
        // New TextField object
        //textField = new TextField();
        //textField.setText("....");
       // textField.setLayoutX(200.0);
       // textField.setLayoutY(100.0);
        
        // Set the label text
        label.setText("Default:  ");
        label.setLayoutX(100.0);
        label.setLayoutY(100.0);
        // Add label to children
        this.getChildren().addAll(label);
        
    }
}
