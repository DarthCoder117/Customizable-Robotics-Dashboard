/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Properties;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

//Data display widget base class. 
//This base class implements the common editing and identifier features of data widgets.
public abstract class DataWidget extends Group implements EditorContext.IEditorContextListener
{
    private final DropShadow borderGlow = new DropShadow();
    private final ContextMenu contextMenu = new ContextMenu();
    
    public DataWidget()
    {
        super();
     
        //Listen for editing context changes
        EditorContext.addContextListener(this);
        
        //Selection effect
        borderGlow.setColor(Color.RED);
        borderGlow.setOffsetX(0f);
        borderGlow.setOffsetY(0f);
        borderGlow.setHeight(10);
       
        //Register required mouse events for drag and drop
        setOnMousePressed(this::mousePressed);
        setOnMouseDragged(this::mouseDragged);
        setOnMouseReleased(this::mouseReleased);
        
        //Setup context menu
        MenuItem properties = new MenuItem("Properties");
        properties.setOnAction(this::onPropertiesMenu);
        
        MenuItem deleteWidget = new MenuItem("Delete");
        deleteWidget.setOnAction(this::onDeleteMenu);
        
        contextMenu.getItems().addAll(properties, deleteWidget);
        
        //Check for edit mode on widget creation
        onEditModeChanged(EditorContext.isEditModeEnabled());
        
        addEditableProperty(identifier);
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
    
    private double widgetStartX = 0.0;
    private double widgetStartY = 0.0;
    private double mouseStartX = 0.0;
    private double mouseStartY = 0.0;
    
    private void mousePressed(MouseEvent me)
    {    
        if (EditorContext.isEditModeEnabled())
        {
            //Select the widget if it's clicked on
            EditorContext.setSelection(this);
            
            //Drag and drop only on left-click
            if (me.getButton() == MouseButton.PRIMARY)
            {
                widgetStartX = getLayoutX();
                widgetStartY = getLayoutY();

                mouseStartX = me.getSceneX();
                mouseStartY = me.getSceneY();
            }
            //Context menu on right-click
            else if (me.getButton() == MouseButton.SECONDARY)
            {
                showContextMenu(me.getScreenX(), me.getScreenY());
            }

            //All mouse events are consumed in edit mode.
            me.consume();
        }
    }
    private void mouseDragged(MouseEvent me)
    {
        if (EditorContext.isEditModeEnabled() && EditorContext.getSelection() == this)
        {
            if (me.getButton() == MouseButton.PRIMARY)
            {
                double offsetX = me.getSceneX()-mouseStartX;
                double offsetY = me.getSceneY()-mouseStartY;

                double posX = widgetStartX+offsetX;
                double posY = widgetStartY+offsetY;
                
                if (me.isControlDown())
                {
                    posX = 15.0*Math.floor(posX/15.0);
                    posY = 15.0*Math.floor(posY/15.0);
                }
                
                setLayoutX(posX);
                setLayoutY(posY);
            }
            
            //All mouse events are consumed in edit mode.
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
    
    private void showContextMenu(double x, double y)
    {
        contextMenu.show(this, x, y);
    }
    
    private void onPropertiesMenu(ActionEvent e)
    {
        PropertiesDialog props = new PropertiesDialog(this);
        props.show();
    }
    
    private void onDeleteMenu(ActionEvent e)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this widget?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirm Deletion");
        alert.setHeaderText("Confirm Deletion");
        Optional<ButtonType> result = alert.showAndWait();
        result.ifPresent(respones -> {
            if (respones == ButtonType.YES)
            {
                EditorContext.removeContextListener(this);
                ((AnchorPane)this.getParent()).getChildren().remove(this);
            }
        });   
    }
    
    protected StringProperty identifier = new SimpleStringProperty(this, "identifier", "");
    
    ///Gets the value identifier that this widget should display.
    public void setIdentifier(String ident)
    {
        identifier.set(ident);
    }
    ///Gets the value identifier that this widget should display.
    public String getIdentifier()
    {
        return identifier.get();
    }
    
    public StringProperty identifierProperty()
    {
        return identifier;
    }
    
    private final LinkedList<Property> editableProperties = new LinkedList<>();
    
    //Adds a property to the list of editable properties
    public final void addEditableProperty(Property prop)
    {
        editableProperties.add(prop);
    }
    
    public final LinkedList<Property> getEditableProperties()
    {
        return editableProperties;
    }
}
