import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UICreateAccount extends JFrame 
						implements ActionListener
{

	public static void main(String[] args)
	{
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 20 , 80, 25);
		panel.add(userLabel);
		
		JTextField userTextField = new JTextField();
		userTextField.setBounds(100, 20, 165, 25);
		panel.add(userTextField);
		
		JLabel pwLabel = new JLabel("Password");
		pwLabel.setBounds(10, 50 , 80, 25);
		panel.add(pwLabel);
		
		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setBounds(100, 50, 165, 25);
		panel.add(pwTextField);
		
		JButton button = new JButton("Login");
		button.setBounds(10, 80, 80, 25);
		panel.add(button);
		
		frame.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e)
	{
		
		
	}

}
