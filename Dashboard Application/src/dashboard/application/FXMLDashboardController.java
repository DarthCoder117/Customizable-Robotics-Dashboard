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
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Brennan
 */
public class FXMLDashboardController implements Initializable 
{
    @FXML private AnchorPane mainWidgetArea;
    @FXML private MenuBar menuBar;
    
    public Stage primaryStage;

    public FXMLDashboardController()
    {
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //Hide the menu if required
        if (!DashboardSettings.getShowMenu())
        {
            ((HBox)menuBar.getParent()).getChildren().remove(menuBar);
        }
    }    
    
    
    public void setPrimaryStage(Stage stage) 
    {
        this.primaryStage = stage;
    }
    
    @FXML
    private void handleFileMenuActionSaveConfig(ActionEvent event) 
    {
        // do stuff if menu is clicked
        System.out.println("File Menu Item Save Config");
    }

    @FXML
    private void handleFileMenuActionLoadConfig(ActionEvent event)
    {
        
        System.out.println("Load Config");
    }
    
    
    @FXML
    private void handleFileMenuActionExit(ActionEvent event) 
    {
        // Exit the application
        System.exit(0);
    }

    @FXML
    private void handleFileMenuActionLockEdit(ActionEvent event) 
    {
        
        System.out.println("Lock Edit");
    }
    
    @FXML
    private void handleFileMenuActionUnlockEdit(ActionEvent event) 
    {
        
        System.out.println("Unlock Edit");
    }
    
    @FXML
    private void handleFileMenuActionHelp(ActionEvent event) 
    {
        System.out.println("Help");
        
        try 
        {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLHelp.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Help");
            stage.show();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @FXML
    private void handleFileMenuActionAbout(ActionEvent event) 
    {
       // New Scene About dialog
       try 
       {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLAbout.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("About");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } 
       catch (Exception ex) 
        {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @FXML
    private void handleFileMenuActionAddWidget(ActionEvent event) 
    {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAddWidget.fxml"));
            
            //Create controller manually.
            FXMLAddWidgetController controller = new FXMLAddWidgetController(mainWidgetArea);
            loader.setController(controller);
            Parent root = loader.load();
            
            //Show dialog
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Widget");
            stage.show();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @FXML
    private void handleFileMenuActionDeleteWidget(ActionEvent event) 
    {
        System.out.println("Delete Widget");
        
        try 
        {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLDeleteWidget.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Widget");
            stage.show();
        } 
        catch (Exception ex)
        {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @FXML
    private void handleFileMenuActionConnection(ActionEvent event)
    {
        
        try
        {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLConnectionInfo.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("User Connection");
            stage.show();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
    @FXML
    private void handleFileMenuActionClear(ActionEvent event) {
        
        // Clear the dashboard
        this.mainWidgetArea.getChildren().clear();
        
    }

    @FXML
    private void handleFileMenuActionFile(ActionEvent event) {
    }

    
    

    
}
