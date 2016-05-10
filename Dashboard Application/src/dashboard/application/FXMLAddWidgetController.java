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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brennan
 */
public class FXMLAddWidgetController implements Initializable
{
    private AnchorPane mainWidgetArea;//Main widget area from DashboardController
    
    @FXML private ChoiceBox widgetTypeSelect;
    @FXML private Button cancelButton;

    FXMLAddWidgetController(AnchorPane mainWidgetArea)
    {
        this.mainWidgetArea = mainWidgetArea;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //TODO: Initialize choice box with all widget types.
    }    
    
    @FXML
    private void handleActionAddWidgets(ActionEvent event)
    {
        System.out.println("Add Widgets");
        
        //TODO: Create widget based on choice box and close the dialog
        
        //Button btn = new Button("Test Button");
        //btn.setLayoutX(100.0);
        //btn.setLayoutY(100.0);
        
        // Add Test Text Widget
        TextWidget textWidget = new TextWidget();
        
        mainWidgetArea.getChildren().add(textWidget);
        // Close the dialog
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handleActionCancel(ActionEvent event)
    {
        System.out.println("Cancel");
        
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        //TODO: Close this dialog...
    }
}
