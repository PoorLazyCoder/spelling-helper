package image;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JOptionPane;

// This class accept string from textarea,
// and search words that match filenames
// then write a html file to display images
public class ShowImages {

    public static void run(String taSt) {

        // ---- convert textarea string to array --------
        taSt = taSt.replaceAll("\\(.+\\)", "");
        String[] words = taSt.split("\n");

        // ------ get filenames from dir ------------
        File imageDir;
        imageDir = new File("C:\\Users\\Public\\Documents\\garage\\dic_images");
        if (!imageDir.exists()) {
            imageDir = new File("dic_images");
        }
        if (!imageDir.exists()) {
            JOptionPane.showMessageDialog(null, "image folder not found");
            return;
        }

        String[] fileNames = imageDir.list(new JPGFilter());
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = fileNames[i].replace(".jpg", "").trim();
        }

        // ------- search match ---------
        Vector<String> matchV = new Vector<String>();
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
            for (int j = 0; j < fileNames.length; j++) {
                if (words[i].equalsIgnoreCase(fileNames[j])) {
                    matchV.add(words[i]);
                    break;
                }
            }
        }

        if (matchV.size() > 0) { // if find images
            String[] matchWords = matchV.toArray(new String[0]); // to array

            // ----- write html file -------------
            String path = new File(imageDir, "index.html").toString();
            String toWrite = CreateImageTable.create(matchWords, 5, 18, 0, 0, "white", 100, matchWords.length + " match", true);
            writeFile(toWrite, path);

            // ----- open brower ----------------
            try {
                Runtime.getRuntime().exec("cmd.exe /E:1900 /C \"" + path + "\"");
            } catch (IOException e) {
            }
        }else
            JOptionPane.showMessageDialog(null, "Picture not found");

    }

    // -------- writeFile -----------
    public static void writeFile(String st, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(st);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

// ------- JPGFilter class ---------
class JPGFilter implements FilenameFilter {

    public boolean accept(File dir, String name) {
        return name.endsWith(".jpg");
    }
}
