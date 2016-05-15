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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Brennan
 */
public class FXMLConnectionInfoController implements Initializable 
{
    @FXML private TextField ipAddressField;
    @FXML private CheckBox isServerCheckBox;
    @FXML private TextField portField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        isServerCheckBox.setSelected(DashboardSettings.getIsServer());
        ipAddressField.setText(DashboardSettings.getIpAddress());
        portField.setText(String.valueOf(DashboardSettings.getPort()));
    }    
    
    @FXML
    private void checkServerAction(ActionEvent event) 
    {
        DashboardSettings.setIsServer(isServerCheckBox.isSelected());
    }

    @FXML
    private void ipAddressAction(ActionEvent event) 
    {
        DashboardSettings.setIpAddress(ipAddressField.getText());
    }
    
    @FXML
    private void portAction(ActionEvent event) 
    {
       DashboardSettings.setPort(Integer.parseInt(portField.getText()));
    }
    
     @FXML
    private void handleActionSaveConfig(ActionEvent event) 
    {
        DashboardSettings.saveSettings();
    }
}
