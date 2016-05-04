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
public class FXMLConnectionInfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void checkClientAction(ActionEvent event) {
        
        System.out.println("Client checked");
    }
    
    @FXML
    private void checkServerAction(ActionEvent event) {
        
        System.out.println("Server Checked");
    }

    @FXML
    private void ipAddressAction(ActionEvent event) {
        
        System.out.println("IP Action");
    }
    
     @FXML
    private void handleActionSaveConfig(ActionEvent event) {
        
        System.out.println("Save Config");
    }
    
}
