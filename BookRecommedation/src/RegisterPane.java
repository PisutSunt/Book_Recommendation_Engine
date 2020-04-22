import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPane implements ActionListener
{
	private static JPanel panelReg;
	private static JTextField emailTextField;
	private static JTextField userTextField;
	private static JPasswordField pwTextField;
	private static JButton buttonReg;
	private static List<String> genreList = Arrays.asList("", "Adventure", "Romance", "History", "Biography", "Comics", "Mystery");
//	private static DefaultComboBoxModel<String> genreBox = new DefaultComboBoxModel<String>(genreList);
	private static JComboBox genre1 = new JComboBox(genreList.toArray());
	private static JComboBox genre2 = new JComboBox(genreList.toArray());
//	private static JComboBox<String> genre3 = new JComboBox<String>(genreBox);
//	private static JComboBox<String> genre4 = new JComboBox<String>(genreBox);
//	private static JComboBox<String> genre5 = new JComboBox<String>(genreBox);
	//private static ArrayList<genre>; //for keep all chosen interested genre
	public RegisterPane()
	{
		panelReg = new JPanel();
		
		panelReg.setLayout(null);
		
		JLabel topicLabel = new JLabel("Create account");
		topicLabel.setBounds(120, 10 , 110, 25);
		topicLabel.setFont(new Font("Serif", Font.BOLD, 16));
		panelReg.add(topicLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(30, 40 , 80, 25);
		panelReg.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(100, 40, 165, 25);
		panelReg.add(emailTextField);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(30, 70 , 80, 25);
		panelReg.add(userLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(100, 70, 165, 25);
		panelReg.add(userTextField);
		
		JLabel pwLabel = new JLabel("Password");
		pwLabel.setBounds(30, 100 , 80, 25);
		panelReg.add(pwLabel);
		
		pwTextField = new JPasswordField();
		pwTextField.setBounds(100, 100, 165, 25);
		panelReg.add(pwTextField);
	
		JLabel genreLabel = new JLabel("Top 5 interested genres");
		genreLabel.setBounds(30, 150 , 150, 25);
		panelReg.add(genreLabel);
		
		JLabel firstGenre = new JLabel("1st genre");
		firstGenre.setBounds(30, 180 , 60, 25);
		panelReg.add(firstGenre);
		
		genre1.setBounds(100, 180, 165, 25);
		panelReg.add(genre1);
		
		JLabel secondGenre = new JLabel("2nd genre");
		secondGenre.setBounds(30, 210 , 60, 25);
		panelReg.add(secondGenre);
		
		genre2 = new JComboBox((genreList.stream()
										.filter(genreList -> 
													!(
														genre1.getSelectedItem().equals(genreList))
													)
												)
										.collect(Collectors.toList()));
		
		genre2.setBounds(100, 210, 165, 25);
		panelReg.add(genre2);
		
		JLabel thirdGenre = new JLabel("3rd genre");
		thirdGenre.setBounds(30, 240 , 60, 25);
		panelReg.add(thirdGenre);
		
//		genre3.setBounds(100, 240, 165, 25);
//		panelReg.add(genre3);
		
		JLabel fourthGenre = new JLabel("4th genre");
		fourthGenre.setBounds(30, 270 , 60, 25);
		panelReg.add(fourthGenre);
		
//		genre4.setBounds(100, 270, 165, 25);
//		panelReg.add(genre4);
		
		JLabel fifthGenre = new JLabel("5th genre");
		fifthGenre.setBounds(30, 300 , 150, 25);
		panelReg.add(fifthGenre);
		
//		genre5.setBounds(100, 300, 165, 25);
//		panelReg.add(genre5);
		
		buttonReg = new JButton("Sign Up");
		buttonReg.setBounds(120, 340, 100, 25);
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
