package verbforms;

import java.util.LinkedList;

// This class search word's other form
// ie. ride rode ridden
public class VerbForms {

    LinkedList<String[]> words = VerbWords.getWords();

    // ---------- search ------------
    public String search(String text) {

        // ------ search verb forms from linked list ----------
        String st = "";
        String[] forms = null;
        for (int i = 0; i < words.size(); i++) {
            forms = words.get(i);

            for (int j = 0; j < 3; j++)
                if (forms[j].matches(text)) {
                    st+= forms[0] + "\t" + forms[1] + "\t" + forms[2]+"\n";
                    break;
                }

        }

        if(st.isEmpty())
            st = text + " not found";

        return st;
    }

    // ------- testing -------
    public static void main(String[] args) {

        VerbForms vf = new VerbForms();
        System.out.println(vf.search("rode"));
    }
}
