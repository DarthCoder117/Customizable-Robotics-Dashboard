/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import edu.cwu.rrdtp.DoubleEntry;
import edu.cwu.rrdtp.Entry;
import edu.cwu.rrdtp.FloatEntry;
import edu.cwu.rrdtp.IntEntry;
import edu.cwu.rrdtp.LongEntry;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
        
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        hb.getChildren().addAll(label, pb);

        this.getChildren().add(hb);
        
        addEditableProperty(min);
        addEditableProperty(max);
    }
    
    DoubleProperty max = new SimpleDoubleProperty(this, "max range", 100);
    DoubleProperty min = new SimpleDoubleProperty(this, "min range", 0);
    
    @Override
    public void update()
    {
        Entry entry = ConnectionManager.getConnection().GetEntry(identifierProperty().get());
        if (entry != null)
        {
            double val = 0.0;
            
            if (entry instanceof IntEntry)
            {
                val = (double)((IntEntry)entry).Get();  
            }
            else if (entry instanceof LongEntry)
            {
                val = (double)((LongEntry)entry).Get();  
            }
            else if (entry instanceof FloatEntry)
            {
                val = (double)((FloatEntry)entry).Get();  
            }
            else if (entry instanceof DoubleEntry)
            {
                val = ((DoubleEntry)entry).Get();  
            }
            
            double percent = (val-min.get())/(max.get()-min.get());
            pb.setProgress(percent);
        }
    }
}
