package search;

public class DicData {
    public String words[];
    public String contents[];
    
    public int[] alphaIndexs;
    
    public DicData(String words[], String contents[],int[] alphaIndexs) {
        
        this.words = words;
        this.contents = contents;
        this.alphaIndexs=alphaIndexs;
    }
    
    public int getIndex(char c){
        int i=0;
        try {
            i = alphaIndexs[c - 65];
        } catch(Exception e) {
            System.out.println("error at: alphaIndexs[c - 65] , c:"+c);
            
            System.out.println(e);
        }
        
        return i;
    }
    
}
