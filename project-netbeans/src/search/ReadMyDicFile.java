package search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

// this class read mydic.txt
// add a to z words and sort
// return String[]
public class ReadMyDicFile {

    public static String[] run(File fi) {

        LinkedList<String> list = new LinkedList<String>();

        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fi));

            line = br.readLine();
            if (checkLine(line)) {
                list.add(line.trim());
            }

            while (line != null) {
                line = br.readLine();

                if (checkLine(line)) {
                    list.add(line.trim());
                }
            }

            add_A_to_Z_words(list);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "mydic.txt has problem!");
            System.exit(1);
        }

        // sort ignore case
        Collections.sort(list, new Comparator() {

            public int compare(Object a, Object b) {
                return ((String) a).compareToIgnoreCase((String) b);
            }
        });

        String[] stArr = list.toArray(new String[0]);

        for (int i = 0; i < stArr.length; i++) {
            System.out.println(stArr[i]);
        }


        return stArr;
    }

    // ======== add a to z words ========
    private static void add_A_to_Z_words(LinkedList<String> list) {

        String arrAtoZ[] = getAtoZList();
        String word = "";
        boolean found = false;
        for (int i = 0; i < arrAtoZ.length; i++) {
            word = arrAtoZ[i];
            found = false;

            for (int j = 0; j < list.size(); j++) {

                // compare first letters of two words
                if (word.substring(0, 1).compareToIgnoreCase(list.get(j).substring(0, 1)) == 0) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                list.add(word);
            }

        }

    }

    // ========== Check line ====================
    private static boolean checkLine(String line) {

        if (line != null && !line.trim().equals("") && line.length() > 2) {
            return true;
        } else {
            return false;
        }
    }

    // ====== get a to z list ===============================
    private static String[] getAtoZList() {
        String arrAtoZ[] = new String[]{"average", "butterfly", "custom", "drug", "extreme", "fur", "guitar", "hurt", "issue", "justice", "knife", "lunch", "mutual", "nuclear", "owl", "puppy",
            "quiz", "ruby", "suspect", "turtle", "upset", "vote", "wrap", "x-axis", "yoga", "zebra"};

        return arrAtoZ;
    }

    /*
    public static void main(String[] args) {

    String[] arr = run(new File("mydic.txt"));

    for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
    }

    }
     *
     */
}
