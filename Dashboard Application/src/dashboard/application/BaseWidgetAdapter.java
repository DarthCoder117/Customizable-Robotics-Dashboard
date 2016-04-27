/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

/**
 *
 * @author Brennan
 */
public class BaseWidgetAdapter {
    
    // Fields
    private String widgetId;
    private String widgetType;
    
    // Constructor
    public BaseWidgetAdapter() {
        
    }
    
 
    // Setters and Getters
    public void setId(String id) {
        widgetId = id;
    }
    
    public void setWidgetType(String type) {
        widgetType = type;
    }
    
}
