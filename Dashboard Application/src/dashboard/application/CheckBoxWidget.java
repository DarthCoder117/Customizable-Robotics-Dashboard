/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

/**
 *
 * @author cs380001_13
 */
public class CheckBoxWidget extends DataWidget {

    private final Label label = new Label();
    private final CheckBox pb = new CheckBox();
    final HBox hb = new HBox();

    public CheckBoxWidget() {

        CheckBox check = new CheckBox();

        hb.getChildren().addAll(label, pb);
        this.getChildren().add(hb);

    }
}
