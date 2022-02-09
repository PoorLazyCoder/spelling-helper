package search;
import java.util.StringTokenizer;
public class PositionWord {
    
    // return the second line word
    public static String getSecondLine(String st){
        
        StringTokenizer tokens = new StringTokenizer(st, "\n");
        String word="";
        
        // get second token
        if (tokens.countTokens() > 1 && tokens.nextToken().contains("match") ) {
            
            word = tokens.nextToken();
            // get rid of "("
            if (word.contains("(")) {
                int pos = word.indexOf("(");
                word = word.substring(0, pos);
            }
        }
        
        return word;
    }
    
    
    // get text among textarea
    // int pos=jTextArea1.getCaretPosition();
    // pos is the position in textarea
    public static String get(int pos,String st){
        
        String wholeSt="",frontSt="",backSt="";
        
        if(pos !=0){
            
            // === get front string
            for(int i=pos; i < st.length(); i++ ){
                char c=st.charAt(i);
                if( Character.isLetter(c))
                    frontSt+=c;
                else
                    break;
            }/*for*/
            
            // === get back string
            for(int i=pos-1; i > -1; i-- ){
                char c=st.charAt(i);
                if( Character.isLetter(c))
                    backSt=c+backSt;
                else
                    break;
            }/*for*/
            
        }
        
        wholeSt=backSt+frontSt;
        
        return wholeSt;
    }
}
