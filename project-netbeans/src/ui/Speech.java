package ui;

import java.io.*;


public class Speech {
    
    static boolean fileExist=false;
    
    public static void run(String word){
     
        if(fileExist==false)
            fileExist=new File("C:/Users/Public/Documents/java_library/freetts-speech-jar/speak.jar").exists();
        
        if(fileExist){
            String command="java -classpath C:/Users/Public/Documents/java_library/freetts-speech-jar/speak.jar;C:/Users/Public/Documents/java_library/freetts-speech-jar/freetts.jar   Speak "+word;
            try {
                Runtime.getRuntime().exec("cmd.exe /E:1900 /C "+command);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//if//
    }
}
