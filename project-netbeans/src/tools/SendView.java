package tools;
import java.awt.*;
import javax.swing.*;

public class SendView extends JFrame  {
	
	public  SendView(JScrollPane sa) {
		super("new");
		JScrollPane scrollingArea = sa;
		
		setLayout(new  BorderLayout(7,7));   
		// ---- frame --------------------------------------
		add(scrollingArea,BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setSize(400, 400);
		setVisible(true);
	}
}
