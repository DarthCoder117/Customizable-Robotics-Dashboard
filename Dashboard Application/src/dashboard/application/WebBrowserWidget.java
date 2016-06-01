/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
    
    public StringProperty url = new SimpleStringProperty(this, "URL", "http://www.arma2base.de/content/images/ac130_12.jpg");
    
    public DoubleProperty width = new SimpleDoubleProperty(this, "width", 1);
    public DoubleProperty height = new SimpleDoubleProperty(this, "height", 1);
    
    public WebBrowserWidget()
    {
        url.addListener((e) -> this.urlChanged());
        url.addListener((e) -> this.widthChanged());
        url.addListener((e) -> this.heightChanged());
        
        webEngine.load(url.get());
        browser.setLayoutX(100.0);
        
        browser.setScaleX(width.get());
        browser.setScaleY(height.get());
        
        hb.setAlignment(Pos.CENTER_RIGHT);
        
        this.getChildren().add(browser);
        
        addEditableProperty(width);
        addEditableProperty(height);
        addEditableProperty(url);
    }
    
    private void urlChanged()
    {
        webEngine.load(url.get());
    }
    
    private void widthChanged()
    {
        browser.setScaleX(width.get());
    }
    
    private void heightChanged()
    {
        browser.setScaleY(height.get());
    }
}
