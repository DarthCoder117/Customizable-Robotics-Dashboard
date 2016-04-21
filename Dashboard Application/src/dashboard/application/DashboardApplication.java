/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.*;
import java.net.URL;
import javafx.scene.Parent;




/**
 *
 * @author Brennan
 */
public class DashboardApplication extends Application {
    
    // Fields
    
    
    @Override
    public void start(Stage primaryStage) {
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        */
        
        try {
            AnchorPane page = (AnchorPane) FXMLLoader.load(DashboardApplication.class.getResource("FXML Dashboard.fxml"));
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Realtime Robotics Dashboard");
            
            
            Parent root = FXMLLoader.load(DashboardApplication.class.getResource("FXML Dashboard.fxml"));
            
            MenuBar menuBar = (MenuBar) root.lookup("menu_bar");
            //menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
            
            
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
