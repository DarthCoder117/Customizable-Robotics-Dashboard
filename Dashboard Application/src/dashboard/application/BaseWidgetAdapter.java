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
    private boolean isDisplayed;
    private String name;
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
    
    public void setWidgetName(String name) {
        this.name = name;
    }
    
    public void setIsDisplayed(boolean bIsDisplayed) {
        isDisplayed = bIsDisplayed;
    }
    
    public String getId() {
        return widgetId;
    }
    
    public String getWidgetType() {
        return widgetType;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean getIsDisplayed() {
        return isDisplayed;
    }
    
}
