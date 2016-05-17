/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.geometry.Pos;
import static javafx.scene.Node.BASELINE_OFFSET_SAME_AS_HEIGHT;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author Brennan
 */
public class LEDWidget extends DataWidget {

    final HBox hb = null;

    public LEDWidget() {

            // New Label object
            final Label label = new Label();
            label.setText("LED:" );

            final Circle led = new Circle();
            final HBox hb = new HBox();
            hb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(label, led);
            
            this.getChildren().add(hb);
    }

    public static void main(String[] args) {
        DataWidget.launch(args);
    }
}
