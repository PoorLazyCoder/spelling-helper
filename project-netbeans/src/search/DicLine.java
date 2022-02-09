package search;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DicLine {
    private static int[] lineNumbers = null;
    
    private static void readFile() {
        lineNumbers = new int[26];
        lineNumbers[0] = 1;
        char ch = 'b';
        int i = 1;
        int currentLine = 1;
        
        try {
            
            // --- read file ---
            
            FileReader Reader = new FileReader("en_dic");
            BufferedReader br = new BufferedReader(Reader);
            String line = br.readLine();
            
            // --- start loop ----
            while (line != null) {
                
                // the start with @X
                if (line.startsWith("@" + String.valueOf(ch))) {
                    lineNumbers[i] = currentLine;
                    ch++;
                    i++;
                }
                currentLine++;
                
                line = br.readLine();
            }
            
            Reader.close();
            br.close();
            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        
    }
    
    // ======= getLineNumbers =========
    public static int getLineNumbers(char c) {
        // accept capital letter
        
        // if not read file yet
        if (lineNumbers == null)
            readFile();
        
        return lineNumbers[(int) c - 65];
    }
    
    // =========== main ==============
    public static void main(String[] arg) {
        
        char ch = 'A';
        
        for (int i = 1; i < 27; i++) {
            System.out.println(ch + ":" + getLineNumbers(ch));
            ch++;
        }
        
    }
    
}
