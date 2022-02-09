package search;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnglishDictionary {
    
    
    public static String get(String word) {
        
        //long time = System.currentTimeMillis();
        
        
        if (!new File("en_dic").exists())
            return "en_dic does not exist";
        
        String get_word = "";
        boolean found = false;
        StringBuffer explain = new StringBuffer();
        word = word.trim();
        
        //====== check start and end line number =======
        char firstLetter=Character.toUpperCase(word.charAt(0));
        int startLine=DicLine.getLineNumbers(firstLetter);
        int endLine=99999;
        if (firstLetter != 'Z')
            endLine=DicLine.getLineNumbers((char) ((int) firstLetter+1))+1;  // get next letter
        
        int currentLine=0;
        
        // ---- create regex pattern ----
        Matcher matcher = null;
        Pattern pattern1 = Pattern.compile("^@1 (\\w+) .+");
        Pattern pattern2 = Pattern.compile("^@(\\w+) .+");
        Pattern pattern3 = Pattern.compile("^  -- (\\w+) .+");
        
        try {
            // --- read file ---
            FileReader reader = new FileReader("en_dic");
            BufferedReader br = new BufferedReader(reader);
            String stLine = br.readLine();
            
            // --- start loop ----
            while (stLine != null) {
                
                // == check line
                currentLine++;
                if(startLine <= currentLine ){
                    
                    if(currentLine > endLine)  // if exceed the range
                        break;
                    
                    // ------------ if start with @ ----------------
                    if (stLine.matches("^@.+")) {
                        
                        if (found)
                            break;
                        
                        explain.delete(0, explain.length());
                        
                        if (stLine.matches("^@1 .+")) {
                            
                            matcher = pattern1.matcher(stLine);
                            
                            if (matcher.matches())
                                get_word = matcher.group(1);
                            
                        } else {
                            matcher = pattern2.matcher(stLine);
                            
                            if (matcher.matches())
                                get_word = matcher.group(1);
                            
                        }
                        
                        if (word.equals(get_word))
                            found = true;
                        
                    }// if @ //
                    
                    // ----- if match "--" -------------
                    else if (stLine.matches("^  --.+")) {
                        matcher = pattern3.matcher(stLine);
                        
                        if (matcher.matches())
                            if (word.equals(matcher.group(1)))
                                found = true;
                        
                        
                    }
                    explain.append(stLine + "\n");
                }
                stLine = br.readLine();
            }/*while*/
            
            reader.close();
            br.close();
            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        
        //--  return result ---
        String explainSt = explain.toString();
        explainSt = explainSt.replace("@", "");
        
        explainSt = explainSt.replace("1 ", "(1) ");
        explainSt = explainSt.replace("\n2 ", "\n(2) ");
        explainSt = explainSt.replace("\n3 ", "\n(3) ");
        explainSt = explainSt.replace("\n4 ", "\n(4) ");
        explainSt = explainSt.replace("\n5 ", "\n(5) ");
        explainSt = explainSt.replace("\n6 ", "\n(6) ");
        
        
       // System.out.println("It took " + (System.currentTimeMillis() - time) + " ms");
       // System.out.println(startLine+", "+endLine);
        
        
        
        if (found)
            return explainSt;
        else
            return "not match";
        
    }// en_dictionary //
    
    
}
