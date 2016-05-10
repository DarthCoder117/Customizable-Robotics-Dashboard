/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.scene.control.Label;

/**
 *
 * @author Brennan
 */
public class TextWidget extends DataWidget {
    
    // Fields
    private String lastDisplayedValue;
    private Label label;
    
    
    // Constructor
    public TextWidget() {
        
        // New Label object
        label = new Label();
        // Set the label text
        label.setText("Default");
        label.setLayoutX(100.0);
        label.setLayoutY(100.0);
        // Add label to children
        this.getChildren().add(label);
        
    }
    
}
