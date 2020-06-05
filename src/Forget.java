

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Forget extends JavaFrame {   
	
	private static final long serialVersionUID = 220282429717238812L; 
	
	
	private JPanel panel;
	private JTextField answer,username; 
	private JLabel label1,label2;
	private JButton submit;
	
	
	
	
	Forget(){  
	
	panel = new JPanel(new GridLayout(5,1)); 
	label2 = new JLabel();
	label2.setText("Enter your username");
	username = new JTextField(20);
	username.setBackground(Color.LIGHT_GRAY);
	
	label1 = new JLabel();
	label1.setText("what is your security questions answer?"); 
	answer = new JTextField(20);
	answer.setBackground(Color.LIGHT_GRAY);
	
	submit = new JButton("Send");
	panel.add(label2);
	panel.add(username);
	panel.add(label1);
	panel.add(answer); 
	panel.add(submit);
		submit.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) {
			try {
				File file = new File("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\userInfo.txt"); 
				FileReader fr = new FileReader(file);  
				BufferedReader br = new BufferedReader(fr); 
				
				
				String line1;
			
		
			
			while((line1=br.readLine())!=null) {
				String[] uArray = line1.split(","); 
				
					if(uArray[0].equals(username.getText()) && uArray[5].equals(answer.getText())) {
						try {
							File file2 = new File("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\temporaryFile.txt");
							FileWriter fw = new FileWriter(file2);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(uArray[0]);
			
							bw.close();
						    fw.close();
							
						}catch(Exception e2){
							e2.printStackTrace();
						}
						br.close();
						fr.close();
						new NewPassword(); 
						dispose();
						
					}else {
						
			
					}
					
					
				}
			
			br.close();
			fr.close();
			JOptionPane.showMessageDialog(null,"The answer is incorrect","error message",JOptionPane.ERROR_MESSAGE);
			}catch(IOException exception) {
		
			}
			}
		});
	
	this.add(panel); 
	setResizable(false);
	setVisible(true);
	sixe();
	}

}
