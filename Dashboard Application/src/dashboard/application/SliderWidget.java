/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

/**
 *
 * @author GithinjiM
 */
public class SliderWidget extends NamedWidget 
{
    private final Label label = new Label();
    private final Slider slider = new Slider();
    final HBox hb = new HBox();

    public SliderWidget() 
    {
        label.textProperty().bind(nameProperty());
        
        slider.valueProperty().addListener((e) -> this.valueChanged());
        
        slider.setMin(0);
        slider.setMax(100);
        
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(4);

        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        slider.setSnapToTicks(true);
        slider.setBlockIncrement(5);
        
        hb.setAlignment(Pos.CENTER);

        hb.getChildren().addAll(label, slider);
        this.getChildren().add(hb);
        
        addEditableProperty(slider.minProperty());
        addEditableProperty(slider.maxProperty());
        
        addEditableProperty(slider.majorTickUnitProperty());
        addEditableProperty(slider.minorTickCountProperty());
        
        addEditableProperty(slider.showTickLabelsProperty());
        addEditableProperty(slider.showTickMarksProperty());
        addEditableProperty(slider.snapToTicksProperty());
    }
    
    void valueChanged()
    {
        if (getIdentifier().length() != 0)
        {
            ConnectionManager.getConnection().SetDouble(identifierProperty().get(), slider.getValue());
        }
    }
}
