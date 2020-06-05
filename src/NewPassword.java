

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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewPassword extends JavaFrame implements InputOutput{   
	
	private static final long serialVersionUID = 1L; 
	JPanel panel;
	JTextField newPass,confirmPass,username;
	JLabel label1,label2,label3;
	JButton button;  
	
	private String linex;
	
	NewPassword() throws IOException{
	panel = new JPanel(new GridLayout(4,5));
	label3 = new JLabel();
	label3.setText("Please enter your username");
	username = new JTextField(20);
	username.setBackground(Color.LIGHT_GRAY);
	
	label1 = new JLabel();
	label1.setText("Please choose a new password");
	newPass = new JTextField(20);
	newPass.setBackground(Color.LIGHT_GRAY);
	
	label2 = new JLabel();
	label2.setText("Please confirm new password");
	confirmPass = new JTextField(20);
	confirmPass.setBackground(Color.LIGHT_GRAY);
	
	button = new JButton("Submit");
	panel.add(label3);
	panel.add(username);
	panel.add(label1);
	panel.add(newPass);
	panel.add(label2);
	panel.add(confirmPass);
	panel.add(button);
	
	
	button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String NnewPass = newPass.getText();
			String NconfirmPass = confirmPass.getText();
			
			
			
			
			
			String myStr = null;
			try {
				File file2 = new File("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\temporaryFile.txt");
				FileReader fr2 = new FileReader(file2);
				BufferedReader br2 = new BufferedReader(fr2);
				
				while((myStr = br2.readLine())!= null) {
					
				}
				
				
			}catch(Exception ex){
				
			}
			try {
				
				
				File file2 = new File("C:\\\\Users\\\\hilal\\\\eclipse-workspace\\\\Cp2Project\\\\src\\\\userInfo.txt");
				FileReader reader = new FileReader(file2);
				BufferedReader reader2 = new BufferedReader(reader);
				
				String asd = new String();
				
				ArrayList<String> arrayList = new ArrayList<String>();
				
				while((asd = reader2.readLine())!=null) {
					arrayList.add(asd);
				}
				reader.close();
				reader2.close();
				
				
				File file = new File("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\userInfo.txt");
				FileWriter writer = new FileWriter(file,false);
				BufferedWriter bw = new BufferedWriter(writer);
				
				
			
			
			if(NconfirmPass.equals(NnewPass)) {
				
				for (int i = 0; i < arrayList.size(); i++) {
					
					
					
					System.out.println(arrayList.get(i));
					
					String[]  strArra = new String[arrayList.size()];
					
					strArra[i] = arrayList.get(i);
					
					String[] strArr = strArra[i].split(",");
					for (int j = 0; j < strArr.length; j++) {
						System.out.println(strArr[j]);
					}
					if(strArr[0].equals(username.getText())) {
						strArr[1] = newPass.getText();
						String complate = strArr[0] + "," + newPass.getText() + "," + strArr[2] + "," + strArr[3] + "," + strArr[4] + "," + strArr[5];
						System.out.println(complate + "dsadas");
						
						bw.write(complate);
						bw.newLine();
					}else {
						
						bw.write(arrayList.get(i));
						bw.newLine();
					}
				}
				
				bw.close();
				writer.close();
				dispose();
				new LoginPage();
				
				
				
			}else {
				/*JOptionPane.showMessageDialog(null,"The passwords does not match","error message",JOptionPane.ERROR_MESSAGE);*/
				bw.close();
				writer.close();
				dispose();
				new LoginPage();
			}
			}catch (Exception e2) {e2.fillInStackTrace();}
			
		}

	});
		this.add(panel);
		
		sixe();
		setVisible(true);
	}

	@Override
	public ArrayList<String> Read(String str) {
		ArrayList <String> arrList = new ArrayList<String>();
		try {
			
			File file = new File("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\userInfo.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while((str=br.readLine())!=null) {
				
				arrList.add(str);
			}
			br.close();
			fr.close();
		}catch (Exception e) {e.printStackTrace();}
		return arrList;
	}

	@Override
	public void Write(ArrayList<String> arrList) {
		try {
			File file  = new File("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\userInfo.txt");
			FileWriter fw = new FileWriter(file,false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i=0; i<arrList.size(); i++) {
			
				bw.write(arrList.get(i));
				bw.newLine();
			}
			bw.close();
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}