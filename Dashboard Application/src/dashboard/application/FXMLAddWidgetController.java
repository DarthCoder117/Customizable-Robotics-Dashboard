/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
        widgetTypeSelect.setItems(FXCollections.observableArrayList("Text Widget", "Progress Widget", "LED Widget"));
        
    }    
    
    @FXML
    private void handleActionAddWidgets(ActionEvent event)
    {
        System.out.println("Add Widgets");
        
        //TODO: Create widget based on choice box and close the dialog
        
        //Button btn = new Button("Test Button");
        //btn.setLayoutX(100.0);
        //btn.setLayoutY(100.0);
        
        Stage stage;
        // Switch Case to add the 3 different widgets
        int widgetPos = widgetTypeSelect.getSelectionModel().getSelectedIndex();
        
        switch(widgetPos) {
            
            case 0:
                
                // Add Test Text Widget
                TextWidget textWidget = new TextWidget();
                mainWidgetArea.getChildren().add(textWidget);
                // Close the dialog
                stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
                
                break;
            
            case 1: 
                
                // Add Test Text Widget
                ProgressBarWidget progressWidget = new ProgressBarWidget();
                progressWidget.setLayoutX(100.0);
                progressWidget.setLayoutY(100.0);
                mainWidgetArea.getChildren().add(progressWidget);
                // Close the dialog
                stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
                
                break;
                
            case 2:
                
                // Add Test Text Widget
                LEDWidget ledWidget = new LEDWidget();
                mainWidgetArea.getChildren().add(ledWidget);
                // Close the dialog
                stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
                
                break;
                
        }
        
       
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
