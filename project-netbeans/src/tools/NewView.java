package tools;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NewView extends JFrame {
    
    // ======== Text Area
    private JTextArea ta;
    
    // ================== constructor
    private NewView(String st,int rows,int cols,int fontSize) {
        
        ta = new JTextArea(rows,cols);
        
        ta.setLineWrap(true); // set line wrap
        ta.setWrapStyleWord(true);
        
        Font bigfont = new Font("Times", Font.PLAIN, fontSize);
        ta.setFont(bigfont);
        ta.setTabSize(6);
        ta.setBackground(Color.decode("#FFFF99"));
        
        // scroll bar panel
        JScrollPane scroll = new JScrollPane(ta);
        
        JPanel mypanel = new JPanel();
        mypanel.setLayout(new  BorderLayout());
        mypanel.add(scroll);
        setContentPane(mypanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // ======= pass string , rows , cols and font size
    public static void display(String st,int rows,int cols,int fontSize) {
        NewView window = new NewView(st,rows,cols,fontSize);
        window.ta.setText(st);
        window.ta.setCaretPosition(0);
    }
    
    // ============ pass string only
    public static void display(String st) {
        display(st,20,30,16); // default
    }
    
    
}
