/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author GithinjiM
 */
public class SliderWidget extends DataWidget {

    private final Label label = new Label();
    private final Slider pb = new Slider();
    final HBox hb = new HBox();

    public SliderWidget() {

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);

        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(4);

        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        slider.setSnapToTicks(true);
        slider.setBlockIncrement(5);


        hb.getChildren().addAll(label, pb);
        this.getChildren().add(hb);

    }

}
