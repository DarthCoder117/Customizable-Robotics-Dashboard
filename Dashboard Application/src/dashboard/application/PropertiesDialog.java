/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

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
        
        for (Map.Entry<Object, Object> e : widget.getWidgetProperties().entrySet()) 
        {
            vbox.getChildren().add(createRow(e));
        }
        
        getDialogPane().getButtonTypes().add(ButtonType.OK);
        getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
    }
    
    private PropertyRow createRow(Map.Entry<Object, Object> entry)
    {
        String key = (String)entry.getKey();
        Object value = entry.getValue();
        
        if (key.equalsIgnoreCase("identifier") || value instanceof String)
        {
            return new TextPropertyRow(entry, true);
        }
        else if (value instanceof Boolean)
        {
            return new CheckboxPropertyRow(entry);
        }
        else if (value instanceof Integer || value instanceof Long || value instanceof Double || value instanceof Float)
        {
            return new NumericPropertyRow(entry);
        }
        
        return null;
    }
    
    private abstract class PropertyRow extends HBox
    {
        protected final Map.Entry<Object, Object> entry;
        
        public PropertyRow(Map.Entry<Object, Object> entry)
        {
            this.entry = entry;
            this.setPadding(new Insets(5,5,5,5));
            this.setSpacing(5);
        }
    }
    
    private class TextPropertyRow extends PropertyRow
    {
        private final TextField textField = new TextField();
        private boolean isIdentifier = false;
        
        public TextPropertyRow(Map.Entry<Object, Object> entry, boolean isIdentifier)
        {
            super(entry);
            this.isIdentifier = isIdentifier;
            
            Label label = new Label((String)entry.getKey());
            HBox.setHgrow(label, Priority.ALWAYS);
            
            HBox.setHgrow(textField, Priority.ALWAYS);
            textField.setText((String)entry.getValue());
            textField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> 
            {
                onTextChanged(newValue);
            });
            
            getChildren().addAll(label, textField);
        }
        
        public TextPropertyRow(Map.Entry<Object, Object> entry)
        {
            this(entry, false);
        }
        
        private void onTextChanged(final String newValue)
        {
            if(isIdentifier)
            {
                //TODO: Validate identifier
            }
            
            entry.setValue(newValue);
        }
    }
    
    private class CheckboxPropertyRow extends PropertyRow
    {
        public CheckboxPropertyRow(Map.Entry<Object, Object> entry)
        {
            super(entry);
           
            CheckBox checkbox = new CheckBox();
            checkbox.setText((String)entry.getKey());
            
            getChildren().add(checkbox);
        }
        
       
    }
    
    private class NumericPropertyRow extends PropertyRow
    {
        private final Spinner spinner = new Spinner();
        
        public NumericPropertyRow(Map.Entry<Object, Object> entry)
        {
            super(entry);
           
            Label label = new Label((String)entry.getKey());
            HBox.setHgrow(label, Priority.ALWAYS);
            
            HBox.setHgrow(spinner, Priority.ALWAYS);
            
            getChildren().addAll(label, spinner);
        } 
    }
}
