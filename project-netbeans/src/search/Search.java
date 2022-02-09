package search;

import ui.*;

public class Search extends RegexSearch {

    // ............. normalSearch() ...................
    public String normalSearch(Info iObj) {

        // assign to variables
        String dataType = iObj.datatype;
        String start = iObj.start;
        String mid = iObj.mid;
        String midOrder = iObj.midOrder;
        String end = iObj.end;

        int startLen = start.length();
        int midLen = mid.length();
        int midOrderLen = midOrder.length();
        int endLen = end.length();

        // or "|" character, the all end words must be same length
        String[] endWords = Split.or(end);
        boolean matchEnd = false;
        if(endWords!=null) // if use or, assign first to end length
            endLen=endWords[0].length();


        int totalLen = startLen + midLen + midOrderLen + endLen;

        // check if the lenght combox is check

        exactLen = iObj.exactLen;
        greatLen = iObj.greatLen;
        lessLen = iObj.lessLen;

        boolean isCheck = isCheckLenght(iObj);

        boolean containChar = true;
        String word;
        int wordLen;

        StringBuffer sb = new StringBuffer();  // for return string
        int matchCount = 0;

        assignDataType(dataType);

        String[] wordsArr = requestData.words;
        String[] contentsArr = requestData.contents;


        // ============ get range ==============
        int startIndex = 0, endIndex = wordsArr.length;

        
        if (startLen != 0  ) {
            char firstLetter = Character.toUpperCase(start.charAt(0));
            startIndex = requestData.getIndex(firstLetter);

            if (firstLetter < 'Z') {
                endIndex = requestData.getIndex((char) (firstLetter + 1)) + 1;
            }
        }

        // ................ start loop array ...................
        for (int i = startIndex; i < endIndex; i++) {

            word = wordsArr[i];
            wordLen = word.length();

            // ======= check lenght ===========
            if (!(totalLen <= wordLen)) {
                continue;
            }


            // ========== check string lenght ==============
            if (isCheck) {
                if (!checkLenght(word)) {
                    continue;
                }
            }


            // ===== start with ==================
            if (startLen != 0) {
                if (!word.startsWith(start)) {
                    continue;
                }
            }




            // ====== middle ===================================
            if (midLen != 0 || midOrderLen != 0) {

                String midSt = word.substring(startLen, wordLen - endLen);

                // middle with order
                if (midOrderLen != 0) {
                    if (!midSt.contains(midOrder)) {
                        continue;
                    }
                }

                // middle no order, means letters
                if (midLen != 0) {

                    containChar = true;
                    for (int j = 0; j < mid.length(); j++) {
                        if (!midSt.contains(String.valueOf(mid.charAt(j)))) {
                            containChar = false;
                            break;
                        }//for//
                    }
                    if (containChar == false) {
                        continue;
                    }
                }
            }

            // ===== end with =================================
            if (endLen != 0) {
                if (endWords != null) { // if end textfield has "|"
                    matchEnd = false;

                    for (String endWord : endWords) {
                        if (word.endsWith(endWord)) {
                            matchEnd = true;
                            break;
                        }
                    }//for//
                    
                    if (matchEnd == false) {
                        continue;
                    }
                } else if (!word.endsWith(end)) {
                    continue;
                }
            }


            // ----------- append on string buffer -------------------
            matchCount++;
            sb.append(contentsArr[i]);
            sb.append("\n");
            

        }//for//

        if (matchCount > 0) // add match count
        {
            sb.insert(0, matchCount + " match\n");
        } else {
            sb.insert(0, "not match");
        }

        return sb.toString();
    }// normalSearch()//
}




