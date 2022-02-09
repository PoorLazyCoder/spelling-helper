package tools;
import ui.Info;
// convert lines to columns
public class ConventToColumns {
    
    //	 cols is how many columns you want
    public static String toTab(String st, int margin, Info coll) {
        
        
        int cols=coll.columns;
        int spaces = 0, i = 0, mod = 1;
        StringBuffer sb = new StringBuffer();
        String[] arr = st.split("\n");
        
        for (i = 0; i < arr.length; i++)
            arr[i] = arr[i].trim(); // get rid of \r and \t
        
        margin += findMaxLenght(arr); // how width every column
        
        sb.append(arr[0]+"\n"); // skip first line
        
        int len = arr.length;
        for (i = 1; i < len; i++) {
            sb.append(arr[i]);
            spaces = margin - arr[i].length(); // how many spaces need to add
            
            if (mod % cols == 0) //remain
                sb.append('\n');
            else
                sb.append(getSpaces(spaces));
            
            mod++;
        }//for//
        
        return sb.toString();
    }//end tabView//
    
    // =========== findMaxLenght
    private static int findMaxLenght(String[] arr) {
        int max = 0, j = 0;
        
        // find the max lenght of strings
        for (j = 0, max = arr[0].length(); j < arr.length; j++)
            if (max < arr[j].length())
                max = arr[j].length();
        
        return max;
    }
    
    // ========== getSpaces
    private static String getSpaces(int spaces) {
        String st = "";
        for (int i = 0; i < spaces; i++)
            st += " ";
        
        return st;
    }
    
    
}
