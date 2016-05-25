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
public class ProgressBarWidget extends NamedWidget 
{
    private final Label label = new Label();
    private final ProgressBar pb = new ProgressBar();
    final HBox hb = new HBox();

    public ProgressBarWidget()
    {
        super();

        //Bind label text
        label.textProperty().bindBidirectional(this.nameProperty());
        
       pb.setProgress(0.5);
        
        hb.setAlignment(Pos.CENTER);
       hb.getChildren().addAll(label, pb);

        this.getChildren().add(hb);
    }
    
    
}
