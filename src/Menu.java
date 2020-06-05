import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JavaFrame {
	
	private static final long serialVersionUID = 7351916095196544457L;
	private JPanel panel;
	private JButton pvp, pvai;
	private JLabel image;

	
	Menu(){
		image = new JLabel();
		image.setIcon(new ImageIcon("C:\\Users\\hilal\\OneDrive\\Masaüstü\\checkersL.jpg"));
		image.setHorizontalAlignment(JLabel.CENTER);
		image.setVerticalAlignment(JLabel.CENTER);
		pvp = new JButton("Play with a player");
		pvai = new JButton("Play with computer");
		panel = new JPanel(new GridLayout(3,1));
		panel.add(image);
		panel.add(pvp);
		panel.add(pvai);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menu");
		sixe();
		add(panel,BorderLayout.CENTER);
		
		
		
		pvai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Arayuz(true);
				
			}
			
		});
		pvp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Arayuz(false);
				
			}
			
		});
		

			
		
		
	
	}
}
