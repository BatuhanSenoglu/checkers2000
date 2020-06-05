import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JavaFrame implements ActionListener{
	
 private static final long serialVersionUID = 1L;  
 JButton Login,SignUp;   
      JPanel  panel;
      JLabel label1,label2;
      static JTextField username,password;
      private File inputFile;
      private boolean ifgir =false;
     
   
LoginPage(){  
label1 = new JLabel();   
label1.setText("Enter your username");
label1.setBackground(Color.LIGHT_GRAY);
username = new JTextField(20);
username.setBackground(Color.LIGHT_GRAY);
label2 = new JLabel();
label2.setBackground(Color.LIGHT_GRAY);
label2.setText("Enter your password"); 
password = new JPasswordField(20);
password.setBackground(Color.LIGHT_GRAY);



Login = new JButton("Login");
Login.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

File inputFile = new File("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\userInfo.txt"); 
String usernameInfo = username.getText();  
String passwordInfo = password.getText();

try {
FileReader fr = new FileReader("C:\\Users\\hilal\\eclipse-workspace\\Cp2Project\\src\\userInfo.txt");
BufferedReader br = new BufferedReader(fr);
String line;
while((line=br.readLine())!=null) {
 String[] uArray = line.split(","); 

  if(uArray.length >=2) { 
if(usernameInfo.equals(uArray[0]) && passwordInfo.equals(uArray[1])) { 
new Menu(); 
dispose(); 
ifgir = !ifgir; 
   
}

  }
}

fr.close(); 

if(ifgir==false) { 

JDialog.setDefaultLookAndFeelDecorated(true); 
   int response = JOptionPane.showConfirmDialog(null, "Did you forget your password?", "Confirm",
   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
   
   if (response == JOptionPane.NO_OPTION) {/*does mothing...*/} 
   else if (response == JOptionPane.YES_OPTION) { 
   
    new Forget();
   dispose();
} else if (response == JOptionPane.CLOSED_OPTION) { 
     System.out.println("JOptionPane closed");
     dispose();
}

}

}catch(IOException exception) {} 

}
});

   
SignUp = new JButton("Sign up"); 


SignUp.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e) {
new SignupPage(); 
dispose();
}
});



panel = new JPanel(new GridLayout(3,1));
panel.add(label1);
panel.add(label2);
panel.add(username);
panel.add(password);
panel.add(Login);
panel.add(SignUp);


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
setVisible(true);
sixe();
add(panel,BorderLayout.CENTER);
setLocationRelativeTo(null);
Login.addActionListener(this); 
setTitle("Login"); 

}

@Override
public void actionPerformed(ActionEvent e) { 
// TODO Auto-generated method stub

}
}