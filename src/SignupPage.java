

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignupPage extends JavaFrame {  
	
	private static final long serialVersionUID = 9051332923404772454L;
	
	private JButton SignUp;
	private JPanel  panel;
	private JLabel label1,label3,label4,label5,label6,label7;
	private static JTextField name,username,password,email,forgetQ,forgetA; 
	    
	 SignupPage(){ 
		
		label1 = new JLabel();  
		label1.setText("enter your full name");
		name = new JTextField(20);
		name.setBackground(Color.LIGHT_GRAY);
		
		label3 = new JLabel();
		label3.setText("choose yourself a username");
		username = new JTextField(20);
		username.setBackground(Color.LIGHT_GRAY);
		
		label4 = new JLabel();
		label4.setText("choose yourself a password");
		password = new JTextField(20);
		password.setBackground(Color.LIGHT_GRAY);
		
		label5 = new JLabel();
		label5.setText("enter your e-mail address");
		email = new JTextField(20);
		email.setBackground(Color.LIGHT_GRAY);
		
		label6 = new JLabel();
		label6.setText("determine a security question.");
		forgetQ = new JTextField(20);
		forgetQ.setBackground(Color.LIGHT_GRAY);
		
		label7 = new JLabel();
		label7.setText("Answer of the question");
		forgetA = new JTextField(20);
		forgetA.setBackground(Color.LIGHT_GRAY);
		
		
		SignUp = new JButton("Sign up");
		panel = new JPanel(new GridLayout(7,2)); 
		panel.add(label3);
		panel.add(username);
		panel.add(label4);
		panel.add(password);
		panel.add(label1);
		panel.add(name);
		panel.add(label5);
		panel.add(email);
		panel.add(label6);
		panel.add(forgetQ);
		panel.add(label7);
		panel.add(forgetA);
		panel.add(SignUp);
		
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setTitle("Sign up page");
		sixe();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel,BorderLayout.CENTER);
		setTitle("SignUp");
		
		SignUp.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
			 String Pusername = username.getText();
			 String Ppassword = password.getText();  
			 String Pname = name.getText();
			 String Pemail = email.getText();
			 String PforgetQ = forgetQ.getText();
			 String PforgetA = forgetA.getText();
			
				try { 
				File file = new File("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\userInfo.txt");
				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(Pusername + ",");
				bw.write(Ppassword + ","); 
				bw.write(Pname + ",");
				bw.write(Pemail + ",");
				bw.write(PforgetQ + ",");
				bw.write(PforgetA);
				bw.newLine();
				
				bw.close();
				
				JOptionPane.showMessageDialog(null,"Sign up successful","success",JOptionPane.INFORMATION_MESSAGE); 	
				new LoginPage();
				}catch(IOException exception) {
					exception.printStackTrace(); 
				}
			}
		});
	 }
}