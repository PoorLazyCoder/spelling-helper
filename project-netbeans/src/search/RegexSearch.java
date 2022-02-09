package search;
import ui.*;
import java.io.File;


public class RegexSearch {
    
    protected DicData dicData;
    protected DicData wordsData;
    protected DicData wikiData;
    protected DicData usageData;
    
    protected DicData requestData; // to be assignned other reference
    
    protected int exactLen;
    protected int greatLen;
    protected int lessLen;
    
    //........... constructor ..............
    public RegexSearch(){
        
        // read file, and assign to reference
        File fi = new File("dic");
        File myFi = new File("mydic.txt"); // other user defined file
        
        String[] stArr = null;
        
        if(myFi.exists())
            stArr = ReadMyDicFile.run(myFi);
        else
            stArr = ReadFile.run(fi);       
        
        dicData = FormatStr.formatDic(stArr, "dic");
    }
    
    
    // ===================== regexSearch ============================
    public String regexSearch(Info iObj) {
        
        exactLen=iObj.exactLen;
        greatLen=iObj.greatLen;
        lessLen=iObj.lessLen;
        
        boolean isCheck=isCheckLenght(iObj);
        
        String dataType = iObj.datatype;
        String reg=iObj.reg;
        
        boolean match=true;
        boolean checklen=true ;
        
        StringBuffer sb = new StringBuffer();
        int matchCount=0;  // how many match
        
        assignDataType(dataType);
        
        String[] wordsArr=requestData.words;
        String[] contentsArr=requestData.contents;
        
        int wordsArrLen=wordsArr.length;
        // ................ start loop linked list ...................
        for (int i = 0; i < wordsArrLen; i++) {
            
            checklen=match=true ;
            String word=wordsArr[i];
            
            // ========== check string lenght
            if(isCheck )
                if(! checkLenght(word))
                    match=false;
            
            // regex
            if(match)
                match = word.matches(reg);
            
            
            // ----------- append on string buffer -------------------
            if (match){
                matchCount++;
                sb.append(contentsArr[i]);
               
                sb.append("\n");
            }
            
            
        }// end linked list loop
        
        if(matchCount > 0 )  // add match count
            sb.insert(0, matchCount+" match\n");
        else
            sb.insert(0, "not match");
        
        return sb.toString();
        
    }//regexSearch()//
    
        /*
         *
         *
         */
    
    // ============ checkLenght()========================
    protected boolean isCheckLenght(Info iObj) {
        
        if (exactLen+ greatLen + lessLen == 0)
            return false;
        else
            return true;
    }
    
    
    // ============ checkLenght()========================
    protected boolean checkLenght(String word) {
        
        boolean match = true;
        int wordLen = word.length();
        
        // exact length
        if (exactLen != 0) {
            if (!(wordLen == exactLen))
                match = false;
        } else
            if (greatLen != 0) {  // equal or greater than word length
            if (!(wordLen >= greatLen))
                match = false;
            } else
                
                if (lessLen != 0) {  // equal or lesser than word length
            if (!(wordLen <= lessLen))
                match = false;
                }
        
        return match;
    }// checkLenght()//
    
    // =============== assignDataType ============================
    protected void assignDataType(String dataType){
        // assign to reference
        if (dataType.equals("dic"))
            requestData = dicData;
        else if (dataType.equals("words")){
            if(wordsData==null){
                File fi = new File("words");
                String[] stArr = ReadFile.run(fi);
                wordsData = FormatStr.formatDic(stArr, "words");
            }
            
            requestData = wordsData;
        }
        // wiki
        else if (dataType.equals("wiki")){
            if(wikiData==null){
                File fi = new File("wiki");
                String[] stArr = ReadFile.run(fi);
                wikiData = FormatStr.formatDic(stArr, "wiki");
            }
            requestData = wikiData;
            // words
        }
        // usage
        else if (dataType.equals("usage")){
            if(usageData==null){
                File fi = new File("usage");
                String[] stArr = ReadFile.run(fi);
                usageData = FormatStr.formatDic(stArr, "usage");
            }
            requestData = usageData;
            // words
        }
    }
    
}
