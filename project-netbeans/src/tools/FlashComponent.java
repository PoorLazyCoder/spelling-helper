package tools;
// This class receive Component, then make the background flash

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FlashComponent extends JFrame {
    
    Color oldColor;
    Color newColor;
    
    Component com;
    int timeCounter = 0;
    final int sec=30;
    
    Timer timer;
    
    //================== run ==========================================
    public static void run(Component com,Color oldColor,Color newColor) {
        FlashComponent obj = new FlashComponent();
        obj.com = com;
        obj.oldColor=oldColor;
        obj.newColor=newColor;
        obj.timer.start();
    }//run//
    
    
    // ..... constructor
    FlashComponent() {
        timer = new Timer(sec, new TimerListener());
    }
    
    // ============== TimerListener ===================================
    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            // flash background
            if (com.getBackground() == oldColor)
                com.setBackground(newColor);
            else
                com.setBackground(oldColor);
            
            
            // set time up
            if (timeCounter++ > 4) {
                timeCounter = 0;
                timer.stop();
                com.setBackground(oldColor);
            }
        }
    }// TimerListener//
    
}//FlashText//

