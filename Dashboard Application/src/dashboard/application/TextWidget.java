/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import edu.cwu.rrdtp.*;
import javafx.scene.control.Label;

/**
 *
 * @author Brennan
 */
public class TextWidget extends NamedWidget 
{
    private final Label label = new Label();
    
    public TextWidget() 
    {
        super();
      
        this.getChildren().addAll(label);
    }
    
    @Override
    public void update()
    {
        Entry entry = ConnectionManager.getConnection().GetEntry(identifierProperty().get());
        if (entry != null)
        {
            label.setText(nameProperty().get()+": "+entry.toString());
        }
        else
        {
            label.setText(nameProperty().get()+":");
        }
    }
}
