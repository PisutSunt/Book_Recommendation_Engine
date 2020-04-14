import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage implements MouseListener
{
	private static JFrame frame;
	private static LoginPane loginPane;
	private static RegisterPane regPane;
	
	public WelcomePage() 
	{
		frame = new JFrame("Welcome");
		frame.setSize(350, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		loginPane = new LoginPane();
		regPane = new RegisterPane();
		
		JLabel regLabel = new JLabel("<html><a href=''>Register</a></html>");;
		regLabel.setBounds(135, 120, 300, 25);
		regLabel.addMouseListener(this);
		regLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginPane.getPane().add(regLabel);
		
		frame.add(loginPane.getPane(), BorderLayout.CENTER);
		frame.setVisible(true);
		
	}

	public void mouseClicked(MouseEvent e)
	{
		frame.setContentPane(regPane.getPane());
		frame.revalidate();
	}

	public void mousePressed(MouseEvent e)
	{
		
	}

	public void mouseReleased(MouseEvent e)
	{
		
	}

	public void mouseEntered(MouseEvent e)
	{
		
	}

	public void mouseExited(MouseEvent e)
	{
	}
	
}
