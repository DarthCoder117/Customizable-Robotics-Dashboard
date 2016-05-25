/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author GithinjiM
 */
public class CheckBoxWidget extends DataWidget {

    private final Label label = new Label();
    private final CheckBox pb = new CheckBox();
    final VBox hb = new VBox();

    public CheckBoxWidget() {

        CheckBox check = new CheckBox();

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, check);
        Scene scene = new Scene(vbox, 600, 600);

        pb.setVisible(true);

        hb.getChildren().addAll(label, pb);
        this.getChildren().add(hb);

    }
}
