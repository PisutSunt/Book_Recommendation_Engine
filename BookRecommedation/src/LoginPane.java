import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPane implements ActionListener
{
	
	private static JPanel panelLogin;
	private static JLabel userLabel;
	private static JLabel pwLabel;
	private static JLabel successLabel;
	private static JLabel failedLabel;
	private static JTextField userTextField;
	private static JPasswordField pwTextField;
	private static JButton buttonLogin;
	
	public LoginPane()
	{
		
		panelLogin = new JPanel();
		
		panelLogin.setLayout(null);
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(30, 20 , 80, 25);
		panelLogin.add(userLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(100, 20, 165, 25);
		panelLogin.add(userTextField);
		
		pwLabel = new JLabel("Password");
		pwLabel.setBounds(30, 50 , 80, 25);
		panelLogin.add(pwLabel);
		
		pwTextField = new JPasswordField();
		pwTextField.setBounds(100, 50, 165, 25);
		panelLogin.add(pwTextField);
		
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(120, 90, 80, 25);
		buttonLogin.addActionListener(this);
		panelLogin.add(buttonLogin);
			
		successLabel = new JLabel("");
		successLabel.setBounds(115, 140, 300, 25);
		panelLogin.add(successLabel);
		
		failedLabel = new JLabel("");
		failedLabel.setBounds(80, 140, 300, 25);
		panelLogin.add(failedLabel);
	}

	
	public void actionPerformed(ActionEvent e)
	{
		String user = userTextField.getText();
		String password = pwTextField.getText();
		
		if(user.equals(""))
		{
			successLabel.setText("");
			failedLabel.setText("");
			failedLabel.setText("Please fill Username! ");
			failedLabel.setForeground(Color.RED);
		}
		else if(password.equals(""))
		{
			successLabel.setText("");
			failedLabel.setText("");
			failedLabel.setText("Please fill Password! ");
			failedLabel.setForeground(Color.RED);
		}
		else if(user.equals("admin") && password.equals("root"))
		{
			successLabel.setText("");
			failedLabel.setText("");
			successLabel.setText("Login successful!");
			successLabel.setForeground(Color.GREEN);
		}
		else
		{
			successLabel.setText("");
			failedLabel.setText("");
			failedLabel.setText("Username or Password incorrect");
			failedLabel.setForeground(Color.RED);
		}
	}
	
	public JPanel getPane()
	{
		return panelLogin;
	}
}
