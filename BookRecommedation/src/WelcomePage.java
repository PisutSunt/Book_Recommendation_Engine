import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage
{
	private static JFrame frame;
	
	public WelcomePage() 
	{
		frame = new JFrame("Welcome");
		frame.setSize(350, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		LoginPane loginPane = new LoginPane();
		RegisterPane regPane = new RegisterPane();
		
		JLabel regLabel = new JLabel("<html><a href=''>Create&nbsp;account?</a></html>");;
		regLabel.setBounds(115, 125, 95, 15);
		regLabel.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent me)
					{
						frame.setContentPane(regPane.getPane());
						frame.setSize(350, 420);
						frame.revalidate();
						frame.setLocationRelativeTo(null);			
					}
				});
		regLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginPane.getPane().add(regLabel);
		
		frame.add(loginPane.getPane(), BorderLayout.CENTER);
		frame.setVisible(true);
		
	}

}
