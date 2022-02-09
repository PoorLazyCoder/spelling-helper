package tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// change all color in components
public class ChangeComponentsColor {
    
    
    private static Color allColor=null;
    
    // =========== popup select color dialog box ===============
    public static Color changeAll(Object[] objArr){
        
        // must choose a color
        do{
            allColor= showColorDialog();
        }while(allColor==null);
        
        changeComponentsColor(objArr);
        
        return allColor;
    }
    
    // =========== receive Color =================
    public static Color changeAll(Object[] objArr,Color _allColor){
        allColor=_allColor;
        
        if(allColor !=null)
            changeComponentsColor(objArr);
        
        return allColor;
    }
    
    
    // ======== changeComponentsColor ==============
    private static void changeComponentsColor(Object[] objArr) {
        // recursive child
        // if the Container has child
        if (objArr != null)
            for (int i = 0; i < objArr.length; i++) {
            changeStyle(((Component) objArr[i]));
            changeComponentsColor(((Container) objArr[i]).getComponents());
            }
        
    }
    
    // ============= changeStyle ============
    private static void changeStyle(Component com) {
        
        // change JTextArea and JTextField color
        if (com instanceof JTextArea || com instanceof JTextField ) {
            com.setBackground(allColor);
            
            // change border
            //xxx.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        
        
    }
    
    // -------- popup dialog box ----------
    public static Color  showColorDialog(){
        return JColorChooser.showDialog(new JFrame(), "Choose Background Color", Color.yellow);
    }
}
