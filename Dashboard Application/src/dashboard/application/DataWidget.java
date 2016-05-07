/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.util.Properties;
import javafx.scene.Parent;

/**
 * Base class for data display widgets.
 */
public abstract class DataWidget extends Parent
{
    protected Properties widgetProperties = new Properties();
    
    ///Gets the value identifier that this widget should display.
    public void setIdentifier(String identifier)
    {
        widgetProperties.setProperty("identifier", identifier);
    }
    ///Gets the value identifier that this widget should display.
    public String getIdentifier()
    {
        return widgetProperties.getProperty("identifier", "");
    }
    
    ///Returns the properties object used by this widget.
    public Properties getWidgetProperties()
    {
        return widgetProperties;
    }
}
