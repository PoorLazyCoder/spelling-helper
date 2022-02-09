package image;

// This class accpet images name and create a table
// The table displays every image and image name in their own cell
public class CreateImageTable {

    public static String create(String[] imgNames, int cols, int fontSize, int imgBorder, int tableBorder, String bgcolor, int widthPercent, String title, boolean showFileName) {

        StringBuffer sb = new StringBuffer();

        // ----------- CSS -------------
        sb.append("<html>\n<head>\n<title>::: " + title + " :::</title>\n");
        sb.append("<style>\n");
        sb.append(" td { text-align:center;  vertical-align:bottom;  font-size:" + fontSize + ";   }\n");
        sb.append(" table { width:" + widthPercent + "%; }\n");
        sb.append(" table, td {  border-style:inset;  border-width:" + tableBorder + "; }\n");
        sb.append(" img { border-width:" + imgBorder + "; }\n");
        sb.append(" body {background-color:" + bgcolor + "; }\n");
        sb.append("</style>\n</head>\n");

        boolean tagClose = true;
        int counter = 1;

        sb.append("<body>\n<table    cellpadding=\"2\" cellspacing=\"2\"     >\n"); // table

        for (int i = 0; i < imgNames.length; i++) {

            counter = i + 1;
            String name = imgNames[i];
            // ------- <tr> -----------
            if (tagClose) {
                sb.append("<tr>\n");
                tagClose = false;
            }

            // ------ <td> --------
            sb.append("  <td>\n");
            sb.append("     <img src=\"" + name + ".jpg\" > \n");  // img tags
            if (showFileName) {
                sb.append("     </br>" + name + "\n");
            }
            sb.append("  </td>\n");

            // ------- </tr> -----------
            if (counter % cols == 0 && i < imgNames.length - 1) {
                sb.append("</tr>\n\n");
                tagClose = true;
            }
            //sb.append(counter + "\n");
        }/*for*/

        sb.append("</tr>\n</table>\n</html>");

        return sb.toString();
    }

    // -------- main -------------
    public static void main(String[] args) {

        String[] imgNames = {"gosling", "cube", "crate", "crayon", "diesel", "crew", "crawl", "confront", "confess", "bury", "butcher", "cabinet"};
        String st = CreateImageTable.create(imgNames, 5, 18, 0, 0, "white", 100, "images", true);
        System.out.println(st);

    }
}
