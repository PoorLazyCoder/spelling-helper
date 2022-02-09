package search;

// split with |
public class Split {

	static String[] or(String st) {

		if (st.contains("|")) {
			String[] endWords = st.split("\\|");
			for (int i = 0; i < endWords.length; i++)
				endWords[i] = endWords[i].trim();

			return endWords;
		} else
			return null;
	}
}