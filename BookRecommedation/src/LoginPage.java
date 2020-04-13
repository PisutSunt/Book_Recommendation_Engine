import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPage implements ActionListener
{
	private static JLabel emailLabel;
	private static JLabel userLabel;
	private static JLabel pwLabel;
	private static JLabel successLabel ;
	private static JLabel failedLabel ;
	private static JLabel registerLabel ;
	private static JTextField emailTextField;
	private static JTextField userTextField;
	private static JPasswordField pwTextField;
	private static JButton buttonLogin;
	private static JButton buttonReg;
	private static JPanel panelLogin;
	private static JPanel panelReg;
	
	public LoginPage()
	{
		JFrame frame = new JFrame("Login page");
		frame.setSize(350, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		createPanelLogin();
		createPanelReg();

		frame.add(panelLogin, BorderLayout.CENTER);
//		frame.add(panelReg, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}

	private void createPanelLogin()
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
		
		registerLabel = new JLabel("<html><a href=''>Register</a></html>");
		registerLabel.setBounds(135, 120, 300, 25);
		panelLogin.add(registerLabel);
		
		successLabel = new JLabel("");
		successLabel.setBounds(115, 140, 300, 25);
		panelLogin.add(successLabel);
		
		failedLabel = new JLabel("");
		failedLabel.setBounds(80, 140, 300, 25);
		panelLogin.add(failedLabel);
	}
	
	private void createPanelReg()
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
		
		buttonReg = new JButton("Register");
		buttonReg.setBounds(120, 120, 100, 25);
		buttonReg.addActionListener(this);
		panelReg.add(buttonReg);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String user = userTextField.getText();
		String password = pwTextField.getText();
		
		if(user.equals("admin") && password.equals("root"))
		{
			failedLabel.setText("");
			successLabel.setText("Login successful!");
			successLabel.setForeground(Color.GREEN);
		}
		else
		{
			successLabel.setText("");
			failedLabel.setText("Username or Password incorrect");
			failedLabel.setForeground(Color.RED);
		}
			
	}

	
}