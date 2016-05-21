/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author super
 */
public abstract class NamedWidget extends DataWidget 
{
    public NamedWidget()
    {
        super();
        
        addEditableProperty(name);
    }
    
    protected final StringProperty name = new SimpleStringProperty(this, "name", "New Widget");
    
    ///Sets the name identifier that this widget should display.
    public final void setName(String n)
    {
        name.set(n);
    }
    ///Gets the name identifier that this widget should display.
    public final String getName()
    {
        return name.get();
    }
    
    public final StringProperty nameProperty()
    {
        return name;
    }
}
