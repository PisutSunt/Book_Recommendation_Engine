import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPane implements ActionListener
{
	private static JLabel emailLabel;
	private static JLabel userLabel;
	private static JLabel pwLabel;
	private static JTextField emailTextField;
	private static JTextField userTextField;
	private static JPasswordField pwTextField;
	private static JButton buttonReg;
	private static JPanel panelReg;
	
	public RegisterPane()
	{
		panelReg = new JPanel();
		
		panelReg.setLayout(null);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(30, 20 , 80, 25);
		panelReg.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(100, 20, 165, 25);
		panelReg.add(emailTextField);
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(30, 50 , 80, 25);
		panelReg.add(userLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(100, 50, 165, 25);
		panelReg.add(userTextField);
		
		pwLabel = new JLabel("Password");
		pwLabel.setBounds(30, 80 , 80, 25);
		panelReg.add(pwLabel);
		
		pwTextField = new JPasswordField();
		pwTextField.setBounds(100, 80, 165, 25);
		panelReg.add(pwTextField);
		
		buttonReg = new JButton("Sign Up");
		buttonReg.setBounds(120, 120, 100, 25);
		buttonReg.addActionListener(this);
		panelReg.add(buttonReg);
	}

	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	public JPanel getPane()
	{
		return panelReg;
	}
}
