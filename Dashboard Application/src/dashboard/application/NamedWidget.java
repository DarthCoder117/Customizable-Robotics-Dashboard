/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

/**
 *
 * @author super
 */
public abstract class NamedWidget extends DataWidget 
{
    public NamedWidget()
    {
        super();
        
        setName("Default");
    }
    
    ///Gets the name that this widget should display.
    public void setName(String identifier)
    {
        widgetProperties.setProperty("name", identifier);
    }
    ///Gets the name that this widget should display.
    public String getName()
    {
        return widgetProperties.getProperty("name", "");
    }
}
