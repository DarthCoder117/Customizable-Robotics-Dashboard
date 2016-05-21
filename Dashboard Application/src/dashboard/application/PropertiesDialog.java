/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.util.Map;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author super
 */
public class PropertiesDialog extends Dialog
{
    private final VBox vbox = new VBox();
    private final ScrollPane sp = new ScrollPane();
    
    public PropertiesDialog(DataWidget widget)
    {
        super();
        
        setTitle("Widget Properties");
        setResizable(true);
        
        vbox.setFillWidth(true);
        
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        sp.setContent(vbox);
        getDialogPane().setContent(sp);
        
        for (Property prop : widget.getEditableProperties()) 
        {
            vbox.getChildren().add(createRow(prop));
        }
        
        getDialogPane().getButtonTypes().add(ButtonType.OK);
        getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
    }
    
    private PropertyRow createRow(Property prop)
    {  
        if (prop instanceof StringProperty)
        {
            boolean isIdentifier = prop.getName().equalsIgnoreCase("identifier");
            
            return new TextPropertyRow(prop);
        }
        else if (prop instanceof BooleanProperty)
        {
            return new CheckboxPropertyRow(prop);
        }
        else if (
                prop instanceof IntegerProperty || 
                prop instanceof DoubleProperty)
        {
            return new NumericPropertyRow(prop);
        }
        else if (prop instanceof ObjectProperty)
        {
            ObjectProperty objectProp = (ObjectProperty)prop;
            if (objectProp.getValue() instanceof Color)
            {
                return new ColorPropertyRow(prop);
            }
        }
        
        return null;
    }
    
    private abstract class PropertyRow extends HBox
    {
        protected final Property prop;
        
        public PropertyRow(Property prop)
        {
            this.prop = prop;
            this.setPadding(new Insets(5,5,5,5));
            this.setSpacing(5);
        }
    }
    
    private class TextPropertyRow extends PropertyRow
    {
        private final TextField textField = new TextField();
       
        public TextPropertyRow(Property prop)
        {
            super(prop);
            
            Label label = new Label(prop.getName());
            HBox.setHgrow(label, Priority.ALWAYS);
            
            HBox.setHgrow(textField, Priority.ALWAYS);
            textField.textProperty().bindBidirectional(prop);
            
            getChildren().addAll(label, textField);
        }
    }
    
    private class CheckboxPropertyRow extends PropertyRow
    {
        public CheckboxPropertyRow(Property prop)
        {
            super(prop);
           
            CheckBox checkbox = new CheckBox();
            checkbox.setText(prop.getName());
            checkbox.selectedProperty().bindBidirectional(prop);
            
            getChildren().add(checkbox);
        }
    }
    
    private class NumericPropertyRow extends PropertyRow
    {
        private final Spinner spinner = new Spinner();
        
        public NumericPropertyRow(Property prop)
        {
            super(prop);
           
            Label label = new Label(prop.getName());
            HBox.setHgrow(label, Priority.ALWAYS);
            
            SpinnerValueFactory svf = null;
            if (prop instanceof IntegerProperty)
            {
                svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(Integer.MIN_VALUE, Integer.MAX_VALUE, ((IntegerProperty)prop).getValue());
            }
            else if (prop instanceof DoubleProperty)
            {
                svf = new SpinnerValueFactory.DoubleSpinnerValueFactory(Double.MIN_VALUE, Double.MAX_VALUE, ((DoubleProperty)prop).getValue());
            }
            
            svf.valueProperty().bindBidirectional(prop);
            spinner.setValueFactory(svf);
            
            HBox.setHgrow(spinner, Priority.ALWAYS);
            
            getChildren().addAll(label, spinner);
        } 
    }
    
    private class ColorPropertyRow extends PropertyRow
    {
        private final ColorPicker picker = new ColorPicker();
        
        public ColorPropertyRow(Property prop)
        {
            super(prop);
           
            Label label = new Label(prop.getName());
            HBox.setHgrow(label, Priority.ALWAYS);
            
            picker.valueProperty().bindBidirectional(prop);
            HBox.setHgrow(picker, Priority.ALWAYS);
            
            getChildren().addAll(label, picker);
        } 
    }
}
