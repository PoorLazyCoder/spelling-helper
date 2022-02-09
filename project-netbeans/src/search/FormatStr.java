package search;
import java.util.LinkedList;

public class FormatStr {
    
    
    // ============ formatDic() ===========================
    public static DicData formatDic(String[] stArr, String type) {
        
        
        
        LinkedList<String> wordsList = new LinkedList<String>();
        LinkedList<String> contentsList = new LinkedList<String>();
        
        String word = "";
        String content = "";
        
        // get letter index
        int[] alphaIndexs=new int[27];
        char letter='A';
        char wordFirstLetter='A';
        int index=0;
        
        
        for (int i = 0; i < stArr.length; i++) {
            
            // ..........if dic .......................................
            if (type.equals("dic")  || type.equals("usage")) {
                
                //stArr[i] = stArr[i].replace("*", "");
                // cut *
                
                // if not find "("
                if (!stArr[i].contains("("))
                    word = content = stArr[i];
                else {
                    word = splitFrom(stArr[i], "("); // cut "(a)"
                    content = stArr[i];
                }
            }//if//
            //......... if words .......................................
            else if (type.equals("words") || type.equals("wiki")  ) {
                word = stArr[i];
            }
            
            else {
                System.out.println("pass wrong type string!!!");
                System.exit(1);
            }
            
            wordsList.add(word);
            
            if (! ( type.equals("words")  || type.equals("wiki")) )
                contentsList.add(content);
            
            
            // ============ add index ============
            wordFirstLetter=Character.toUpperCase(word.charAt(0));
            if(letter==wordFirstLetter){
                alphaIndexs[index]=i;
                letter++;
                index++;
            }
            
            
        }//for//
        
        // add to link list
        String[] wordsArr=wordsList.toArray(new String[0]);
        String[] contentsArr=null;
        
        //  point to same array reference
         if (! ( type.equals("words")  || type.equals("wiki")) )
            contentsArr=contentsList.toArray(new String[0]);
        else
            contentsArr=wordsArr;
        
        
        
        //for (int i = 0; i < alphaIndexs.length-1; i++) 
            //System.out.println((char)(i+65)+":"+ alphaIndexs[i]+":"+wordsArr[alphaIndexs[i]]);
       
        
        
        return new DicData(wordsArr,contentsArr,alphaIndexs);
    }//formatDic//
    

    
    // .......................split word and (a) .........................
    private static String splitFrom(String st, String separator) {
        
        if (!st.contains(separator))
            return st;
        else {
            int index = st.indexOf(separator);
            st = st.substring(0, index).trim();
        }
        
        return st;
    }
    
}
