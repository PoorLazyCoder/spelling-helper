package ui;

public class Help {

    public static String getHelpString() {
        String st = " dic has 29,000 words\n"
                + " wiki has 150,000 words\n"
                + " use color highlight to show matched letters\n"
                + " \n"
                + " S is start letter\n"
                + " M is letters at middle, and follow order\n"
                + " L is letters at middle, but not follow order\n"
                + " E is end letter\n"
                + " \n"
               + " Read the help.html for more information\n";

        return st;
    }

    public static String getRegexString() {
        String st = "regular expression\nhttps://en.wikipedia.org/wiki/Regular_expression\n\n"
                + "[abc]	a, b, or c\n"
                + "[^abc]	Any character except a, b, or c\n"
                + "[a-z]	a through z\n\n"
                + "^	The beginning of a line\n"
                + "$	The end of a line\n"
                + "\\b	A word boundary \n"
                + "\\B	A non-word boundary \n"
                + "\\s	A whitespace character\n"
                + "\\S	A non-whitespace character\n"
                + "\\w	A word character: [a-zA-Z_0-9] \n"
                + "\\W	A non-word character: [^\\w]\n\n"
                + "X?	X, once or not at all \n"
                + "X*	X, zero or more times \n"
                + "X+	X, one or more times \n"
                + "X{n}	X, exactly n times \n"
                + "X{n,}	X, at least n times \n"
                + "X{n,m}	X, at least n but not more than m times \n\n"
                + "X|Y	or\n"
                + "(X)	group\n";

        return st;
    }
}
