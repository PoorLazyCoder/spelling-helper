package tools;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ControlView extends JFrame {
    
    public JTextArea ta;
    private JPopupMenu pop;
    public JScrollPane scroll;
    
    
    // ================== constructor
    public ControlView(int rows,int cols,int fontSize) {
        
        createPopupMenu();
        ta = new JTextArea(rows,cols);
        
        ta.setLineWrap(true); // set line wrap
        ta.setWrapStyleWord(true);
        ta.setFont(new Font("Times", Font.PLAIN, fontSize));
        ta.setTabSize(6);
        ta.setBackground(RandomColor.getLight());
        ta.addMouseListener(new RightClick());
        
        // scroll bar panel
        scroll = new JScrollPane(ta);
        
        // ==== add panel
        JPanel mypanel = new JPanel();
        mypanel.setLayout(new  BorderLayout());
        mypanel.add(scroll);
        setContentPane(mypanel);
        setTitle("view");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    // ============== createPopupMenu
    private void createPopupMenu(){
        pop = new JPopupMenu();
        
        JMenuItem item;
        FontSizeListner fs=new FontSizeListner();
        
        for (int i = 20; i < 36; i++) {
            item=new JMenuItem(String.valueOf(i));
            item.addActionListener(fs);
            pop.add(item);
        }//for//
        
    }
    
    // =============== FontSizeListner
    class FontSizeListner implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int size=Integer.parseInt(e.getActionCommand());
            Font font=ta.getFont();
            ta.setFont(new Font(font.getFamily(),font.getStyle(),size));
        }
        
    }
    
    
    // ============ pass string
    public void display(String st) {
        ta.setText(st);
        ta.setCaretPosition(0);
    }
    
    // ============ RightClick
    private class RightClick extends MouseAdapter{
        public void mouseReleased(MouseEvent Me) {
            if (Me.isPopupTrigger()) {
                pop.show(Me.getComponent(), Me.getX(), Me.getY());
            }
        }
    }
    
    
    // ============= main 
    public static void main(String[] args) {
        ControlView con=new ControlView(15,43,18);
        con.display("Hello World");
        
    }
    
    /*    you can make the window appear again after closing
     
          if(! enDicView.isVisible())
                 enDicView.setVisible(true);
     */
    
}
