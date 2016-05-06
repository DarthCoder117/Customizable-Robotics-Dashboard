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
import javafx.fxml.JavaFXBuilderFactory;




/**
 *
 * @author Brennan
 */
public class DashboardApplication extends Application {
    
    // Fields
    public Stage primaryStage;
    
    
    @Override
    public void start(Stage stage) {
        
        primaryStage = stage;
        
        try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLDashboard.fxml"));
            Parent root = loader.load();
            ((FXMLDashboardController) loader.getController()).setPrimaryStage(primaryStage);
            
            
        } 
        catch (Exception e) 
        {
            
        }
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
            AnchorPane page = (AnchorPane) FXMLLoader.load(DashboardApplication.class.getResource("FXMLDashboard.fxml"));
            Scene scene = new Scene(page);
            
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Realtime Robotics Dashboard");
            
            
            //Parent root = FXMLLoader.load(DashboardApplication.class.getResource("FXML Dashboard.fxml"));
            
            
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
    
    
    /*
    private void gotoAbout() {
        try {
            replaceSceneContent("FXMLAbout.fxml");
        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(DashboardApplication.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = primaryStage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 450);
            //scene.getStylesheets().add(Dash.class.getResource("demo.css").toExternalForm());
            primaryStage.setScene(scene);
        } else {
            primaryStage.getScene().setRoot(page);
        }
        primaryStage.sizeToScene();
        return page;
    }
*/
    
}
