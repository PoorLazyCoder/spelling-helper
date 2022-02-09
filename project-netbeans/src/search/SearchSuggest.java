package search;

import java.net.URL;
import java.util.List;
import com.inet.jortho.Dictionary;
import com.inet.jortho.Suggestion;
import com.inet.jortho.DictionaryFactory;

// change to public: DictionaryFactory, Suggestion, Dictionary

// add customSearchSuggestions method
//  if(word.length() == 0 || exist(word)) return null;

public class SearchSuggest {
	static private SearchSuggest suObj;
	private Dictionary dic;

	// constructor
	private SearchSuggest() {

		DictionaryFactory factory = new DictionaryFactory();
		// load file dictionary_en.ortho
		try {
			factory.loadWordList(new URL(new URL("file", null, ""), "dictionary_en" + "" + ".ortho"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		dic = factory.create();
	}

	// ====== getWords ======
	// pass word return suggestions
	public static String getWords(String word) {

		if (suObj == null)
			suObj = new SearchSuggest();

		String st = "";
		List list = suObj.dic.customSearchSuggestions(word); // search word return list
		// if the word exist in dictionary return null

		int size = 0;
		Suggestion su;

		if (list != null) {
			size = list.size();
			for (int i = 0; i < size; i++) {
				su = (Suggestion) list.get(i);
				st += su.getWord() + "\n";
			}//for//
		}

		if (list == null)
			st = word + " is correct";
		else if (size == 0)
			st = "not match";
		else
			st = size + " match\n" + st;

		return st;
	}


}

