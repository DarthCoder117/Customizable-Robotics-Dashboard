/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.util.Properties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * Base class for data display widgets.
 */
public abstract class DataWidget extends Group implements EditorContext.IEditorContextListener
{
    protected Properties widgetProperties = new Properties();
    
    DropShadow borderGlow = new DropShadow();
    
    public DataWidget()
    {
        super();
     
        borderGlow = new DropShadow();
        borderGlow.setColor(Color.RED);
        borderGlow.setOffsetX(0f);
        borderGlow.setOffsetY(0f);
        borderGlow.setHeight(10);
        
        EditorContext.addContextListener(this);
        
        setOnMousePressed(this::mousePressed);
        setOnMouseDragged(this::mouseDragged);
        setOnMouseReleased(this::mouseReleased);
    }
    
    @Override
    public void onEditModeChanged(boolean editMode)
    {
        if (editMode)
        {
            setEffect(borderGlow);
        }
        else
        {
            setEffect(null);
        }
    }
    
    @Override
    public void onSelectionChanged(DataWidget widget)
    {
        if (widget == this)
        {
            borderGlow.setColor(Color.GREEN);
        }
        else
        {
            borderGlow.setColor(Color.RED);
        }
    }
    
    private void mousePressed(MouseEvent me)
    {
        if (EditorContext.isEditModeEnabled())
        {
            EditorContext.setSelection(this);
            
            me.consume();
        }
    }
    
    private void mouseDragged(MouseEvent me)
    {
        if (EditorContext.isEditModeEnabled())
        {
            me.consume();
        }
    }
    
    private void mouseReleased(MouseEvent me)
    {
        if (EditorContext.isEditModeEnabled())
        {
            me.consume();
        }
    }
    
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
