/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLAddWidgetController;

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
public class java implements Initializable {
    
    // Fields
    private boolean isAddTextChecked, isAddProgressChecked, isAddLEDChecked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleActionTextFieldCheck(ActionEvent event) {
        
        if (isAddTextChecked == false) {
            isAddTextChecked = true;
        } else if (isAddTextChecked) {
            isAddTextChecked = false;
        }
        
        System.out.println("Text Check: " + String.valueOf(isAddTextChecked));
    }

    @FXML
    private void handleActionProgressBarCheck(ActionEvent event) {
        
        if (isAddProgressChecked == false) {
            isAddProgressChecked = true;
        } else if (isAddProgressChecked) {
            isAddProgressChecked = false;
        }
        
        System.out.println("Progress Check: " + String.valueOf(isAddProgressChecked));
    }

    @FXML
    private void handleActionLEDCheck(ActionEvent event) {
        
        if (isAddLEDChecked == false) {
            isAddLEDChecked = true;
        } else if (isAddLEDChecked) {
            isAddLEDChecked = false;
        }
        
        System.out.println("LED Check: " + String.valueOf(isAddLEDChecked));
    }
    
}
