package ui;

public class BuildColorHtml {
    
    final    String startTab = "<b color=blue>";
    final    String midOrderTab = "<b color=CC00FF>"; // purple
    final    String midTab = "<b color=FF00FF>";  // pink
    final    String endTab = "<b color=red>";
    final    String closeTab = "</b>";
    
    String start , mid , midOrder , end, sTemp;
    String fullStartTab,fullEndTab,fullMidOrderTab,fullMidTab;
    int startLen , midOrderLen , midLen , endLen ,wordLen,pos;
    char[] wordCh,midCh;
    
    // constructor
    BuildColorHtml(Info col){
        
        start = col.start;
        mid = col.mid;
        midOrder = col.midOrder;
        end = col.end;
        
        // prepare the tab first
        fullStartTab= startTab + start + closeTab;
        fullEndTab= endTab + end + closeTab;
        fullMidOrderTab=  midOrderTab + midOrder + closeTab;
        fullMidTab = midTab + mid + closeTab;
        
        startLen = start.length();
        midOrderLen = midOrder.length();
        midLen = mid.length();
        endLen = end.length();
        
        midCh=mid.toCharArray();
        
        if (startLen != 0)
            start = fullStartTab;
        
        if (endLen != 0)
            end = fullEndTab;
        
    }//constructor//
    
    // ====================== add html tab to word ================================================
    public String build(String word){
        
        
        if(word.contains("(")){
            pos = word.lastIndexOf("(");
            word=word.substring(0, pos);
        }
        
        word=word.trim();
        wordLen=word.length();
        String wordMid = word.substring(startLen, wordLen - endLen);
        
        
        // ============ have middle string ================
        if (midLen + midOrderLen != 0) {
            
            if (midOrderLen != 0)
                wordMid = wordMid.replace(midOrder, fullMidOrderTab);
            else
               wordMid=replaceMidString(wordMid);
            
        }//else//
        
        
        return start + wordMid + end;
    }// build()
    
    
    // ------------------------- replaceMidString -----------------------------------
    private String replaceMidString(String wordMid){
        
        int i=0,j=0;
        wordCh=wordMid.toCharArray();
        wordMid="";
        
        // ====== compare char by char =========
        for (i= 0; i < wordCh.length; i++) {
            sTemp=wordCh[i]+"";
            
            for(j=0; j<midCh.length; j++){
                if(wordCh[i]==midCh[j]) {
                    sTemp= midTab+ wordCh[i] +closeTab;
                    break;
                }//if//
            }//for//
            
            wordMid+=sTemp;
        }//for//
        
        
        return wordMid;
    }
    
}
