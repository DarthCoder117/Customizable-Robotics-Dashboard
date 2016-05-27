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
import javafx.scene.control.CheckBox;
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
        widgetTypeSelect.setItems(FXCollections.observableArrayList("Text Widget", "Progress Widget", "LED Widget" ,"SliderWidget","CheckBox", "Web Browser"));
        
    }    
    
    @FXML
    private void handleActionAddWidgets(ActionEvent event)
    {
        Stage stage;
 
        int widgetPos = widgetTypeSelect.getSelectionModel().getSelectedIndex();
        switch(widgetPos) 
        {
            case 0:

                TextWidget textWidget = new TextWidget();
                mainWidgetArea.getChildren().add(textWidget);
                textWidget.setLayoutX(100.0);
                textWidget.setLayoutY(200.0);
                
                break;
            
            case 1: 
      
                ProgressBarWidget progressWidget = new ProgressBarWidget();
                progressWidget.setLayoutX(100.0);
                progressWidget.setLayoutY(200.0);
                mainWidgetArea.getChildren().add(progressWidget);
                
                break;
                
            case 2:
        
                LEDWidget ledWidget = new LEDWidget();
                ledWidget.setLayoutX(100.0);
                ledWidget.setLayoutY(300.0);
                mainWidgetArea.getChildren().add(ledWidget);
                
                break;
                
            case 3:
       
                SliderWidget slider = new SliderWidget();
                slider.setLayoutX(100.0);
                slider.setLayoutY(400.0);
                mainWidgetArea.getChildren().add(slider);

                break;
                    
            case 4:
         
                CheckBoxWidget CheckBox = new CheckBoxWidget();
                CheckBox.setLayoutX(100.0);
                CheckBox.setLayoutY(500.0);
                mainWidgetArea.getChildren().add(CheckBox);
                
                break;
                
            case 5:
      
                WebBrowserWidget webBrowserWidget = new WebBrowserWidget();
                webBrowserWidget.setLayoutX(200.0);
                webBrowserWidget.setLayoutY(100.0);     
                mainWidgetArea.getChildren().add(webBrowserWidget);

                break;   
        }
        
        //Close the dialog
        stage = (Stage) cancelButton.getScene().getWindow();
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
