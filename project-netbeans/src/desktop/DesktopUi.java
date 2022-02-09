package desktop;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import search.EnglishDictionary;

import ui.*;
import tools.*;


public class DesktopUi extends SpellingHelperUI{
    
    JDesktopPane desk = new JDesktopPane();
    int frameCount = 1; // how many frame open
    
    //--------- constructor
    public DesktopUi() {
        
        desk.setBackground(RandomColor.getDeep());
        jMenuBar1.add(getColorMenu());
        
        JFrame mainFa = new JFrame();
        
        // add menu bar
        mainFa.setJMenuBar(jMenuBar1);
        
        // tab pane
        desk.add(newInFrame(TpOne, "input", 5, 7));
        
        // option panel
        desk.add(newInFrame(optionPanel, "option", 310, 7));
        optionPanel.setVisible(true);
        
        // textarea
        JInternalFrame spFrame=newInFrame(jScrollPane1, "words", 642, 7);
        desk.add(spFrame);
        spFrame.setSize(320,670);  // set frame size
        
        // enDicView
        enDicView=new ControlView(15,43,18);
        enDicView.setVisible(false);
        desk.add(newInFrame(enDicView.scroll, "dictionary", 7, 280));
        
        mainFa.add(desk);
        mainFa.setTitle("desktop");
        mainFa.setSize(1000, (int)getToolkit().getScreenSize().getHeight()-100);
        mainFa.setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    // =========== newInFrame =======================
    // Component, title name, X, Y
    private JInternalFrame newInFrame(Component com, String name, int x, int y) {
        JInternalFrame fa = new JInternalFrame(name, true, false, true, true);
        fa.add(com);
        Dimension dem = com.getSize();
        fa.setSize((int) dem.getWidth() +20, (int) dem.getHeight() + 40);  // size
        
        if (x + y != 0)
            fa.setLocation(x, y);
        else
            fa.setLocation(frameCount, frameCount); // prevent frames pile
        
        fa.setVisible(true);
        frameCount += 50;
        
        return fa;
    }
    
    
    protected JMenu getColorMenu(){
        
        JMenu colorMenu=new JMenu("color");
        JMenuItem colorItem=new JMenuItem("bgcolor");
        colorMenu.add(colorItem);
        
        colorItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Color color=ColorDialog.getColor();
                if(color !=null)
                    desk.setBackground(color);
            }
            
        });
        
        return colorMenu;
    }
    
    
// =============== main ====================
    public static void main(String[] args) {
        DesktopUi ui = new DesktopUi();
    }
    
    //======== overridden ============
    protected void dictionaryViewMouseClick(int click){
        if(click==3){
            searchEngDic();
            taOne.grabFocus();
        }
    }
    
    
    //======== overridden ======
    protected void searchFromEnDic(String word) {
        if( word != null &&   (!  word.isEmpty() )){
            
            String explain=EnglishDictionary.get(word);
            
            // add item on HistoryMenu
            if(! explain.contains("not match"))
                HistoryMenu.addItem(historyMenu,word,new HistroyItemsListener());
            
            enDicView.display(explain);
            
        }
    }
    
}
