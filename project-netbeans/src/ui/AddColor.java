package ui;

/*
 *This convert normal text to html
 */

public class AddColor {
    
      
    final static int MAX_WORDS=200;  // maximum print words
    
    // ======== convert ========================================
    public static String convert(String st,Info col){
        //long time = System.currentTimeMillis();

        
        String fontSize = String.valueOf(col.taFontSize+8); // get font size
        
        String[] wordArr=st.split("\n");
        
        if(! wordArr[0].contains("match"))
            return "";
        
        String fontSizeTab = "<font style=\"font-size:"+fontSize+"; \" >\n";
        String html=fontSizeTab+"<font color=\"#330066\"><b>"+wordArr[0]+"</b></font><br>\n";
        
        if(wordArr[0].contains("not match")) // if not match, change bgcolor
            html="<body bgcolor=\"#FF0099\" >\n"+html;
        else{
            
            if(col.columns==0)
                html+=sendWordByWord(wordArr, col);
            else
                html+=sendWordByWordTable(wordArr, col,fontSize);
        }
        
        //System.out.println((System.currentTimeMillis() - time) + " ms");

        //System.out.println(html);
        return html;
    }
    
    // ============ sendWordByWord ===============
    private static String sendWordByWord(String[] wordArr, Info col){
        StringBuffer sb=new StringBuffer();
        BuildColorHtml bc=new BuildColorHtml(col);
        
        // ==== send word by word =====
        int arrLen=wordArr.length;
        for (int i = 1; i < arrLen && i < MAX_WORDS; i++)
            if(wordArr[i].length() < 20)
                sb.append(bc.build(wordArr[i])+"<br>");
        
        if( arrLen > MAX_WORDS)  // if has more words haven't print
            sb.append("<br><i>more ......... </i>");
        
        return sb.toString();
    }
    
    
    // ============ sendWordByWordTable ===============
    private static String sendWordByWordTable(String[] wordArr, Info col,String fontSize){
        
        int cols=col.columns, mod=0;
        
        BuildColorHtml bc=new BuildColorHtml(col); // create instance
        
        StringBuffer sb=new StringBuffer("<table width=\"100%\" border=1  cellpadding=3  style=\"font-size:"+fontSize+"; \" >\n");
        // create table
        
        // ==== send word by word =====
        int arrLen=wordArr.length;
        for (int i = 1; i < arrLen && i < MAX_WORDS; i++,mod++){
            
            if(mod%cols==0) // how many columns
                sb.append("<tr>");
            
            if(wordArr[i].length() < 20)
                sb.append("<td>"+bc.build(wordArr[i])+"</td>\n");
              
        }//for//
        
        sb.append("</table>");
        
        
        if( arrLen > MAX_WORDS)  // if has more words haven't print
            sb.append("<h1>more ..................... </h1>");
        
        return sb.toString();
    }
    
    
    
    
    
}
