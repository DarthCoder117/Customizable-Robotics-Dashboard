/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Brennan
 */
public class LEDWidget extends NamedWidget 
{
    final Label label = new Label();
    final HBox hb = new HBox();
    final Circle led = new Circle(10, 10, 20);
    
    public LEDWidget() 
    {
        super();
        
        //Bind label text to name
        label.textProperty().bindBidirectional(this.nameProperty());
        
        //Setup default LED display options
        led.setFill(onColor.get());
        led.setStroke(Color.BLACK);
        led.setStrokeWidth(2);
        led.setRadius(15);

        //Setup horizontal box
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(label, led);
        hb.setSpacing(10);

        this.getChildren().add(hb);
        
        //Add editable properties
        addEditableProperty(invert);
        
        addEditableProperty(onColor);
        addEditableProperty(offColor);
        
        addEditableProperty(led.radiusProperty());
        addEditableProperty(led.strokeWidthProperty());
    }
    
    private final ObjectProperty<Color> onColor = new SimpleObjectProperty<>(this, "on color", Color.GREENYELLOW);
    private final ObjectProperty<Color> offColor = new SimpleObjectProperty<>(this, "off color", Color.GREY);
    private final BooleanProperty invert = new SimpleBooleanProperty(this, "invert", false);
    
    //Sets the color of the LED when it's in the on state.
    public void setColor(Color color)
    {
        onColor.set(color);
    }
    //Gets the color of the LED when it's in the on state.
    public Color getColor()
    {
        return onColor.get();
    }
    
    public ObjectProperty<Color> onColorProperty()
    {
        return onColor;
    }
    
    @Override
    public void update()
    {
        boolean value = ConnectionManager.getConnection().GetBool(getIdentifier());
        System.out.println(getIdentifier() + ": " + value);
        
        if (invert.get())
        {
            value = !value;
        }
        
        if (value == true)
        {
            led.setFill(onColor.get());
        }
        else
        {
            led.setFill(offColor.get());
        }
    }
}
