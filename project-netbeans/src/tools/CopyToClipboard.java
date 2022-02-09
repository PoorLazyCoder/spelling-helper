package tools;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

// ---- CopyToClipboard class -----------
public class CopyToClipboard {
    public static void copy(String st){
        StringSelection ss = new StringSelection(st);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }
    
}

