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
import javafx.scene.control.Button;
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
    
    @FXML private AnchorPane anchorPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Button btn = new Button("Text Button");
        anchorPane.getChildren().add(btn);
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
        
        try {
            Parent root;
            addWidgetStage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLHelp.fxml"));
            addWidgetStage.setScene(new Scene(root));
            addWidgetStage.initModality(Modality.APPLICATION_MODAL);
            addWidgetStage.setTitle("Help");
            addWidgetStage.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @FXML
    private void handleFileMenuActionAbout(ActionEvent event) {
        
       // New Scene About dialog
       try {
        
            Parent root;
            addWidgetStage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLAbout.fxml"));
            addWidgetStage.setScene(new Scene(root));
            addWidgetStage.setTitle("About");
            addWidgetStage.initModality(Modality.APPLICATION_MODAL);
            addWidgetStage.show();

        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }

    @FXML
    private void handleFileMenuActionAddWidget(ActionEvent event) {
     
        try {
            System.out.println("Add Widget");
            Parent root;
            addWidgetStage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLAddWidget.fxml"));
            addWidgetStage.setScene(new Scene(root));
            addWidgetStage.initModality(Modality.APPLICATION_MODAL);
            addWidgetStage.setTitle("Add Widget");
            addWidgetStage.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
       
    }

    @FXML
    private void handleFileMenuActionDeleteWidget(ActionEvent event) {
            
        System.out.println("Delete Widget");
        
        try {
            Parent root;
            addWidgetStage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLDeleteWidget.fxml"));
            addWidgetStage.setScene(new Scene(root));
            addWidgetStage.initModality(Modality.APPLICATION_MODAL);
            addWidgetStage.setTitle("Delete Widget");
            addWidgetStage.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @FXML
    private void handleFileMenuActionConnection(ActionEvent event) {
        
        try {
            Parent root;
            addWidgetStage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLConnectionInfo.fxml"));
            addWidgetStage.setScene(new Scene(root));
            addWidgetStage.initModality(Modality.APPLICATION_MODAL);
            addWidgetStage.setTitle("User Connection");
            addWidgetStage.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }

    @FXML
    private void handleFileMenuActionFile(ActionEvent event) {
    }

    
    

    
}
