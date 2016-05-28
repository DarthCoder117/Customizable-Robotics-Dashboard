package dashboard.application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Brennan
 */
public class FXMLDashboardController implements Initializable, EditorContext.IEditorContextListener
{
    @FXML private AnchorPane mainWidgetArea;
    @FXML private MenuBar menuBar;
    
    public Stage primaryStage;

    @FXML private CheckMenuItem enableEditModeMenuItem;
    
    public FXMLDashboardController()
    {
        EditorContext.addContextListener(this);
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
        
        loadLayout();
    }    
    
    private void saveLayout()
    {
        System.out.println("Saving layout...");
        
        File file = new File("layout.conf");
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            
            //Number of widgets
            out.writeInt(mainWidgetArea.getChildren().size());
            
            for (Node node : mainWidgetArea.getChildren())
            {
                DataWidget widget = (DataWidget)node;
                out.writeObject(widget);
            }
            
            out.close();
        }
        catch(IOException ex)
        {
            Logger.getLogger(FXMLDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Successfully saved layout.");
    }
    
    private void loadLayout()
    {
        System.out.println("Loading layout...");
        
        File file = new File("layout.conf");
        if (file.exists())
        {
            try
            {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("layout.conf"));

                //Number of widgets
                int numWidgets = in.readInt();

                for (int i=0; i<numWidgets; ++i)
                {
                    DataWidget widget = null;
                    widget = (DataWidget)in.readObject();
                    mainWidgetArea.getChildren().add(widget);
                }

                in.close();
            }
            catch(IOException ex)
            {
                Logger.getLogger(FXMLDashboardController.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ClassNotFoundException ex)
            {
                Logger.getLogger(FXMLDashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Successfully loaded layout.");
        }
    }
    
    public void setPrimaryStage(Stage stage) 
    {
        this.primaryStage = stage;
    }
    
    @Override
    public void onEditModeChanged(boolean editMode)
    {
        enableEditModeMenuItem.setSelected(editMode);
    }
    
    @FXML
    private void onEditModeMenuAction(ActionEvent event)
    {
        EditorContext.setEditMode(enableEditModeMenuItem.isSelected());
    }
    
    @FXML
    private void handleFileMenuActionSaveConfig(ActionEvent event) 
    {
        saveLayout();
    }

    @FXML
    private void handleFileMenuActionLoadConfig(ActionEvent event)
    {
        loadLayout();
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
    private void handleFileMenuActionClear(ActionEvent event) 
    {
        Alert alert = new Alert(Alert.AlertType.WARNING, "This will delete all widgets from the dashboard, are you sure you want to do this?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirm Clear");
        alert.setHeaderText("Confirm Clear");
        Optional<ButtonType> result = alert.showAndWait();
        result.ifPresent(respones -> {
            if (respones == ButtonType.YES)
            {
                EditorContext.setSelection(null);
                
                //Unregister all widgets as listeners
                for (Node n : mainWidgetArea.getChildren())
                {
                    if (n instanceof DataWidget)
                    {
                        DataWidget widget = (DataWidget)n;
                        EditorContext.removeContextListener(widget);
                    }
                }
                
                //Clear everything
                this.mainWidgetArea.getChildren().clear();
            }
        });
    }

    @FXML
    private void handleFileMenuActionFile(ActionEvent event) {}

    @Override
    public void onSelectionChanged(DataWidget selected) {}
}
