package ui;

import javax.swing.JEditorPane;

public class HtmlViewer  {
    // ======== JEditorPane
    public JEditorPane pa = new JEditorPane();
    
    // ================== constructor
    public HtmlViewer() {
        pa.setContentType("text/html");
        pa.setEditable(false);
    }
    
    // ===== pass content =======
    public void pass(String st,Info col) {
        st=AddColor.convert(st,col);  // convert to html
        pa.setText(st);
        pa.setCaretPosition(0);
    }
    
    // return JEditorPane
    public JEditorPane getPane(){
        return pa;
    }
    
}
