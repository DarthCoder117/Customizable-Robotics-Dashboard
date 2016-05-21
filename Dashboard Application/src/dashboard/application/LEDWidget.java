/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author Brennan
 */
public class LEDWidget extends NamedWidget 
{

    final HBox hb = null;

    public LEDWidget() 
    {
        super();
        
            // New Label object
            final Label label = new Label();
            label.setText("LED:     " );
            
            final Circle led = new Circle(10, 10, 20);
            led.setFill(Color.RED);
            final HBox hb = new HBox();
            hb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(label, led);
            
            this.getChildren().add(hb);
    }
}
