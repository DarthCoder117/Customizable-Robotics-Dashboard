/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author GithinjiM
 */
public class CheckBoxWidget extends NamedWidget 
{

    private final Label label = new Label();
    private final CheckBox pb = new CheckBox();
    final HBox hb = new HBox();
    
    public CheckBoxWidget() 
    {
        label.textProperty().bind(nameProperty());
        
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        pb.setVisible(true);
        pb.selectedProperty().addListener((e) -> this.checkboxChanged());

        hb.getChildren().addAll(label, pb);
        this.getChildren().add(hb);
    }
    
    private void checkboxChanged()
    {
        ConnectionManager.getConnection().SetBool(identifierProperty().get(), pb.isSelected());
    }
}
