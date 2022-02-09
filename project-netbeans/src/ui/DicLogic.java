package ui;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import search.Search;

public class DicLogic {
    
    private Search sObj=new Search();
    
    // ----------normalSearch()----------------------------------------------------------------
    public String normalSearch(Info iObj) {
        //long time = System.currentTimeMillis();
        String getSt = sObj.normalSearch(iObj);
        //System.out.println((System.currentTimeMillis() - time) + " ms");
        return getSt;
        
    }
       
    // ----------normalSearch()----------------------------------------------------------------
    public String regexSearch(Info iObj) {
        //long time = System.currentTimeMillis();
        String getSt = sObj.regexSearch(iObj);
        //System.out.println((System.currentTimeMillis() - time) + " ms");
        
        return getSt;
        
    }
    
}
