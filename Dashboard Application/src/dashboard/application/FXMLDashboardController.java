package dashboard.application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dashboard.application.DashboardApplication;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Brennan
 */


public class FXMLDashboardController implements Initializable {
    
    // Fields
    public Stage primaryStage;
    public Stage addWidgetStage;
    public Scene sceneAddWidget;

    public FXMLDashboardController()
    {
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }
    
    @FXML
    private void handleFileMenuActionSaveConfig(ActionEvent event) {
        // do stuff if menu is clicked
        System.out.println("File Menu Item Save Config");
    }

    @FXML
    private void handleFileMenuActionLoadConfig(ActionEvent event) {
        
        System.out.println("Load Config");
    }
    
    
    @FXML
    private void handleFileMenuActionExit(ActionEvent event) {
        
        // Exit the application
        System.exit(0);
    }

    @FXML
    private void handleFileMenuActionLockEdit(ActionEvent event) {
        
        System.out.println("Lock Edit");
    }
    
    @FXML
    private void handleFileMenuActionUnlockEdit(ActionEvent event) {
        
        System.out.println("Unlock Edit");
    }
    
    @FXML
    private void handleFileMenuActionHelp(ActionEvent event) {
        
        System.out.println("Help");
    }
    
    @FXML
    private void handleFileMenuActionAbout(ActionEvent event) {
        
 
        
       try {
        

            Parent root;
            addWidgetStage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLAbout.fxml"));
            addWidgetStage.setScene(new Scene(root));
            addWidgetStage.initModality(Modality.APPLICATION_MODAL);
           // addWidgetStage.initOwner(____________.getScene().getWindow());
            addWidgetStage.show();

        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }

    @FXML
    private void handleFileMenuActionAddWidget(ActionEvent event) {
        /*Stage addWidgetStage;
        System.out.println("Add Widget");
       
        addWidgetStage = new Stage();
        addWidgetStage.setScene(sceneAddWidget);
        addWidgetStage.initModality(Modality.APPLICATION_MODAL);
        addWidgetStage.showAndWait();*/
        try {
            System.out.println("hgfdxhgc");
            Parent root;
            addWidgetStage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLAddWidget.fxml"));
            addWidgetStage.setScene(new Scene(root));
            addWidgetStage.initModality(Modality.APPLICATION_MODAL);
           // addWidgetStage.initOwner(____________.getScene().getWindow());
            addWidgetStage.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
        //addWidgetStage.initOwner(primaryStage);
        //addWidgetStage.showAndWait();
    }

    @FXML
    private void handleFileMenuActionDeleteWidget(ActionEvent event) {
            
        System.out.println("Delete Widgetttt");
    }

    @FXML
    private void handleFileMenuActionFile(ActionEvent event) {
    }

    
    

    
}
