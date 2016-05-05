/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Brennan
 */
public class FXMLAddWidgetController implements Initializable {
    
    // Fields 
    private boolean isTextChecked, isProgressChecked, isLEDChecked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
            
    @FXML
    private void handleActionTextFieldCheck(ActionEvent event) {
        
        if (isTextChecked == false) {
            isTextChecked = true;
        } else if (isTextChecked) {
            isTextChecked = false;
        }
        
        System.out.println("Text Checked: " + String.valueOf(isTextChecked));
    }
    
    @FXML
    private void handleActionProgressBarCheck(ActionEvent event) {
        
        if (isProgressChecked == false) {
            isProgressChecked = true;
        } else if (isProgressChecked) {
            isProgressChecked = false;
        }
        
        System.out.println("Progress Checked: " + String.valueOf(isProgressChecked));
    }
    
    @FXML
    private void handleActionLEDCheck(ActionEvent event) {
        
        if (isLEDChecked == false) {
            isLEDChecked = true;
        } else if (isLEDChecked) {
            isLEDChecked = false;
        }
        
        System.out.println("LED Checked: " + String.valueOf(isLEDChecked));
    }
    
    @FXML
    private void handleActionAddWidgets(ActionEvent event) {
        System.out.println("Add Widgets");
    }
    
}
