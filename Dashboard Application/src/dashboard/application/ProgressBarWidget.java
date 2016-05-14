/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

/**
 *
 * @author Brennan
 */
public class ProgressBarWidget extends DataWidget {

    // Fields
    public String LastDisplayedValue;
    private Label label;
    private ProgressBar pb;
    final HBox hb = null;
    final float[] value = new float[]{1.0f};

    public ProgressBarWidget() {

            // New Label object
            final Label label = new Label();
            label.setText("PROGRESS:" );

            final ProgressBar pb = new ProgressBar();
            pb.setProgress(BASELINE_OFFSET_SAME_AS_HEIGHT);
            final HBox hb = new HBox();
            hb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(label, pb);
            
            this.getChildren().add(hb);
    }

    public static void main(String[] args) {
        DataWidget.launch(args);
    }
}
