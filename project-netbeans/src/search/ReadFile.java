package search;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;


public class ReadFile {

	public static String[] run(File fi) {
		LinkedList<String> list = new LinkedList<String>();

		String st;

		try {
			FileReader Reader = new FileReader(fi);
			BufferedReader br = new BufferedReader(Reader);

			st = br.readLine();
			if (st != null && !st.equals("")&& st.length()>2 )
				list.add(st.trim());

			while (st != null) {
				st = br.readLine();

				if (st != null && !st.equals("")&& st.length()>2 )
					list.add(st.trim());
			}

		} catch (IOException e) {
			System.out.println("file error");
                        JOptionPane.showMessageDialog(null, "file error!!");
			System.exit(1);
		}

		String[] stArr=list.toArray(new String[0]);

		return stArr;
	}

}
