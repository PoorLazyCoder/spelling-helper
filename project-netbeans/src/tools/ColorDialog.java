package tools;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorDialog {
    
    public static Color getColor(){
        Color color=null;
        color=JColorChooser.showDialog(new JFrame(), "Choose Color", Color.blue);

        return  color;
    }
    
}
