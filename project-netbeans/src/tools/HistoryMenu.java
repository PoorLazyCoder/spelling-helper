package tools;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


// add item on menu
public class HistoryMenu {
    
    
    static public boolean addItem(JMenu menu, String word, ActionListener al){
        
        boolean noDuplicate=true;
        
        // check if any word duplicate
        for (int i = 0; i < menu.getItemCount(); i++) {
            if(word.equals(menu.getItem(i).getActionCommand()))
                noDuplicate=false;
        }//for//
        
        if(noDuplicate){
            // add the word on history meun
            JMenuItem wordItem=new JMenuItem(word);
            menu.add(wordItem,0);
            wordItem.addActionListener(al);
            
            // cut item if too long
            if(menu.getItemCount()>20)
                menu.remove(menu.getItemCount()-1);
        }
        
        return noDuplicate;  // success or fail to add
    }


    
}
