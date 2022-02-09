package tools;
import java.awt.Color;
import java.util.Random;


public class RandomLightColor {
    
    
    public static String[] lightColor = new String[] { 
        "#FFFF66",
"#FFFF99",
"#FFFFCC",
"#CCFF99",
"#CCFFCC",
"#CCFFFF",
"#99FFFF",
"#99FFCC",
"#99FFCC",
"#CCFF66",
"#FBEC5D",
"#CBCAB6",
"#E6E6FA",
"#EEAEEE",
"#EED2EE",
"#FFB5C5",
"#FFC0CB",
"#AEEEEE",
"#B4EEB4",
"#CCFFCC",
"#C1FFC1",
"#FCD59C",
"#DFFFA5",
"#E8F1D4"
    };
    
    
    public static Color getLight(){
        
        Random r = new Random();
        String co=lightColor[r.nextInt(lightColor.length)];
        
        Color lightColor=Color.decode(co);
        
        return lightColor;
    }
    
}
