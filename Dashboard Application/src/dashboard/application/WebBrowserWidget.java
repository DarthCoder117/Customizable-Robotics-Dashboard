/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author Brennan
 */
public class WebBrowserWidget extends DataWidget {
    
    private final Label label = new Label();
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    final HBox hb = new HBox();
    
    
    public WebBrowserWidget() {
        
        webEngine.load("https://docs.oracle.com/javase/8/javafx/embedded-browser-tutorial/overview.htm");
        browser.setLayoutX(100.0);
        
        hb.setAlignment(Pos.CENTER_RIGHT);
        
        this.getChildren().add(browser);
    }
}
