/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.input.KeyCombination;

/**
 *
 * @author Brennan
 */
public class DashboardApplication extends Application 
{
    public Stage primaryStage;
    
    @Override
    public void start(Stage stage) 
    {
        //Load settings
        DashboardSettings.loadSettings();
        
        //Load main window
        primaryStage = stage;
        try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLDashboard.fxml"));
            Parent root = loader.load();
            ((FXMLDashboardController) loader.getController()).setPrimaryStage(primaryStage);
       
            AnchorPane page = (AnchorPane) FXMLLoader.load(DashboardApplication.class.getResource("FXMLDashboard.fxml"));
            Scene scene = new Scene(page);
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Realtime Robotics Dashboard");
            
            //Fullscreen mode
            if (DashboardSettings.getFullscreen())
            {
                primaryStage.setFullScreen(true);
                primaryStage.setFullScreenExitHint("");
                //primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            }

            primaryStage.show();
        }
        catch (Exception ex) 
        {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
