import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UILogin implements ActionListener
{
	private static JLabel userLabel;
	private static JTextField userTextField;
	private static JLabel pwLabel;
	private static JPasswordField pwTextField;
	private static JButton button;
	private static JLabel success ;
	private static JLabel failed ;
	
	public static void main(String[] args)
	{
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("User");
		userLabel.setBounds(30, 20 , 80, 25);
		panel.add(userLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(100, 20, 165, 25);
		panel.add(userTextField);
		
		pwLabel = new JLabel("Password");
		pwLabel.setBounds(30, 50 , 80, 25);
		panel.add(pwLabel);
		
		pwTextField = new JPasswordField();
		pwTextField.setBounds(100, 50, 165, 25);
		panel.add(pwTextField);
		
		button = new JButton("Login");
		button.setBounds(120, 100, 80, 25);
		button.addActionListener(new UILogin());
		panel.add(button);
		
		success = new JLabel("");
		success.setBounds(115, 130, 300, 25);
		panel.add(success);
		
		failed = new JLabel("");
		failed.setBounds(80, 130, 300, 25);
		panel.add(failed);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String user = userTextField.getText();
		String password = pwTextField.getText();
		
		if(user.equals("admin") && password.equals("root"))
		{
			success.setText("Login successful!");
			success.setForeground(Color.GREEN);
		}
		else
		{
			failed.setText("Username or Password incorrect");
			failed.setForeground(Color.RED);
		}
			
	}

	
}
