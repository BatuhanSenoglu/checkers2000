
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Arayuz extends JFrame implements MouseListener{

private static final long serialVersionUID = 1L;
private JPanel mainPanel;
private JPanel panel;
private JButton cell[][];
private JButton cross;
private boolean iter=false;
public static boolean test= false;

private String blackStr="img/tavla.jpg";
private String whiteStr="img/tavla1.jpg";
private String blackStr4king = "img/kral.png";
private String whiteStr4king = "";

private SanatsalZeka AI;

private ImageIcon blackIcon;
private ImageIcon whiteIcon;
private ImageIcon blackKingIcon;
private ImageIcon WhiteKingIcon;

private int tempi;
private int tempj;

private Color colorHolder;

private boolean turnBool = false;

private boolean AiOn = true;



public Arayuz(boolean dsaasd) {
	
	AiOn = dsaasd;
	
	setSize(543,590);
	setResizable(false);
	setUndecorated(true);
	
	mainPanel = new JPanel();
	mainPanel.setBackground(Color.DARK_GRAY);
	mainPanel.setLayout(null);
	getContentPane().add(mainPanel);
	
	cross= new JButton("X");
	cross.setForeground(Color.white);
	cross.setBackground(Color.darkGray);
	cross.setBounds(500, -5, 50, 50);
	cross.setBorderPainted(false);
	cross.addMouseListener(this);
	
	panel = new JPanel();
	panel.setBackground(Color.black);
	panel.setLayout(new GridLayout(8,8));
	panel.setBounds(20, 50, 500, 500);
	
	mainPanel.add(cross);
	mainPanel.add(panel);
	
	blackIcon = new ImageIcon(blackStr);
	whiteIcon = new ImageIcon(whiteStr);
	blackKingIcon = new ImageIcon(blackStr4king);
	WhiteKingIcon = new ImageIcon(whiteStr4king);
	
	
	cell= new JButton[8][8];
	
	System.out.println("ai done");
	
	if(AiOn == true) {
		AI = SanatsalZeka.getSanatsalZeka(cell, AiOn);
	}
	
	for(int i=0; i<8; i++) {
		for(int j=0; j<8; j++) {
			cell[i][j]= new JButton();
			cell[i][j].addMouseListener(this);
		}
	}
	
	
	for(int i=0; i<8; i++) {
		for(int j=0; j<8; j++) {
			iter = !iter;
			if(iter==false) {
				cell[i][j].setBackground(Color.white);
			}
			if(iter==true) {
				cell[i][j].setBackground(Color.black);
			}
			if(i == 1 || i == 2) {
				cell[i][j].setIcon(whiteIcon);
			}
			if(i == 5 || i == 6) {
				cell[i][j].setIcon(blackIcon);
			}
			
			panel.add(cell[i][j]);
		}
		
		iter =!iter;
		
	}
	
	
	
	
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	
	
	private void drawTaBoard() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				iter = !iter;
				if(iter==false) {
					cell[i][j].setBackground(Color.white);
				}
				if(iter==true) {
					cell[i][j].setBackground(Color.black);
				}
				
				panel.add(cell[i][j]);
			}
			
			iter =!iter;
			
		}
	
	}
	
	


	@Override
	public void mouseClicked(MouseEvent e) {
		Object o= e.getSource();
		for(int i= 0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(o==cell[i][j] && (cell[i][j].getBackground()==Color.black || cell[i][j].getBackground()==Color.white)) {
					
					
					
					
					
					
					if(AiOn == false) {
						
						if(cell[i][j].getIcon()==whiteIcon || cell[i][j].getIcon()==WhiteKingIcon && turnBool && i+1 < 8) {
							setTempi(i);
							setTempj(j);
							
							
							
							
							colorHolder = cell[i+1][j].getBackground();
							
							
							
							
							possibableMoves(cell, i, j,turnBool);
							
							
						}
					}
					
					if(cell[i][j].getIcon()==blackIcon || cell[i][j].getIcon()==blackKingIcon && !turnBool) {
						setTempi(i);
						setTempj(j);
						
						
						possibableMoves2(cell, i, j,turnBool);
						
						
					}
					
					
					
				}if(o==cell[i][j] && cell[i][j].getBackground()==Color.gray) {
					
					
					
					
					
					drawTaBoard();
					
					
					
					
					if(turnBool) {
						if(AiOn == false){
							if(cell[getTempi()][getTempj()].getIcon()==WhiteKingIcon) {
								cell[i][j].setBackground(colorHolder); 
								cell[getTempi()][getTempj()].setIcon(null);
								cell[i][j].setIcon(WhiteKingIcon);
							}else if(cell[getTempi()][getTempj()].getIcon()==whiteIcon) {
	
								cell[i][j].setBackground(colorHolder); 
								if(i == 7) {//ve icon beyazsa
									cell[getTempi()][getTempj()].setIcon(null);
									cell[i][j].setIcon(WhiteKingIcon);
								}else {
									cell[getTempi()][getTempj()].setIcon(null);
									cell[i][j].setIcon(whiteIcon);
								}
							}
							
							cell[getTempi()][getTempj()].setIcon(null);
							
							ifEatenEat(cell, i, j);
							
						}
						
					}else {
							
							
							if(cell[getTempi()][getTempj()].getIcon()==blackKingIcon) {
								cell[i][j].setBackground(colorHolder);
								cell[getTempi()][getTempj()].setIcon(null);
								cell[i][j].setIcon(blackKingIcon);
							}else if(cell[getTempi()][getTempj()].getIcon()==blackIcon) {
								
								cell[i][j].setBackground(colorHolder); 
								if(i == 0) {
									cell[getTempi()][getTempj()].setIcon(null);
									cell[i][j].setIcon(blackKingIcon);
								}else {
									cell[getTempi()][getTempj()].setIcon(null);
									cell[i][j].setIcon(blackIcon);
								}
							}
							ifEatenEat(cell, i, j);
							
					}
					turnBool = !turnBool;
					
					
					
					if(AiOn == true && turnBool) {
						turnBool = !turnBool;
						
						AI.move(cell, whiteIcon, WhiteKingIcon);
						
						
						
					}
				}
			}
		}
		if(o == cross) {
			dispose();
		}
		
	}
	


	@Override
	public void mouseEntered(MouseEvent e) {/* do nothing...*/}
	@Override
	public void mouseExited(MouseEvent e) {/* do nothing...*/}
	@Override
	public void mousePressed(MouseEvent e) {/* do nothing...*/}
	@Override
	public void mouseReleased(MouseEvent e) {/* do nothing...*/}
	
	public int getTempi() {
		return tempi;
	}	
	public int getTempj() {
		return tempj;
	}
	public void setTempi(int newTempi) {
		tempi = newTempi;
	}
	public void setTempj(int newTempj) {
		tempj = newTempj;
	}

	public void possibableMoves(JButton butArr[][],int i,int j,boolean turnbool){
		drawTaBoard();
		if(turnbool) {
			if(i+1 < 8) {
				if(butArr[i+1][j].getIcon() == null) {
					cell[i+1][j].setBackground(Color.gray);
				}
			}
			if(i+2 < 8) {
				if(butArr[i+1][j].getIcon() == blackIcon || butArr[i+1][j].getIcon() == blackKingIcon) {
					if(butArr[i+2][j].getIcon() == null) {
						cell[i+2][j].setBackground(Color.gray);
					}
				}
			}
			
			
			if(j-1 >= 0) {
				if(butArr[i][j-1].getIcon() == null) {
					cell[i][j-1].setBackground(Color.gray);
				}
			}
			
			if(j-2 >= 0) { 
				if(butArr[i][j-1].getIcon() == blackIcon || butArr[i][j-1].getIcon() == blackKingIcon) {
					if(butArr[i][j-2].getIcon() == null) {
						cell[i][j-2].setBackground(Color.gray);
					}
				}
			}
			
			if(j+1 < 8) {
				if(butArr[i][j+1].getIcon() == null) {
					cell[i][j+1].setBackground(Color.gray);
				}
			}
			
			
			if(j+2 < 8) {
				if(butArr[i][j+1].getIcon() == blackIcon || butArr[i][j+1].getIcon() == blackKingIcon) {
					if(butArr[i][j+2].getIcon() == null) {
						cell[i][j+2].setBackground(Color.gray);
					}
				}
			}
			
			
			
			
	
			int mytemp;
			
			if(cell[i][j].getIcon() == WhiteKingIcon) {
				
				for(mytemp  = (i-1); mytemp >= 0; mytemp--) {
					
					if(mytemp-1 >= 0) {
						if(butArr[mytemp][j].getIcon() != null) {
							if(butArr[mytemp-1][j].getIcon() != null) {
								break;
							}
						}
					}
					
					if(butArr[mytemp][j].getIcon() == null) {
						cell[mytemp][j].setBackground(Color.gray);
					}
					System.out.println(mytemp);
				}
				
				
				for(mytemp  = (i+1); mytemp <= 7; mytemp++) {
					
					if(mytemp+1 <= 7) {
						if(butArr[mytemp][j].getIcon() != null) {
							if(butArr[mytemp+1][j].getIcon() != null) {
								break;
							}
						}
					}
					
					if(butArr[mytemp][j].getIcon() == null) {
						cell[mytemp][j].setBackground(Color.gray);
					}
					System.out.println(mytemp);
				}
				
				
				
				for(mytemp  = (j+1); mytemp <= 7; mytemp++) {
					
					if(mytemp+1 <= 7) {
						if(butArr[i][mytemp].getIcon() != null) {
							if(butArr[i][mytemp+1].getIcon() != null) {
								break;
							}
						}
					}
					
					if(butArr[i][mytemp].getIcon() == null) {
						cell[i][mytemp].setBackground(Color.gray);
					}
					System.out.println(mytemp);
				}
				
				
				
				
				for(mytemp  = (j-1); mytemp >= 0; mytemp--) {
					
					if(mytemp-1 >= 0) {
						if(butArr[i][mytemp].getIcon() != null) {
							if(butArr[i][mytemp-1].getIcon() != null) {
								break;
							}
						}
					}
					
					if(butArr[i][mytemp].getIcon() == null) {
						cell[i][mytemp].setBackground(Color.gray);
					}
					System.out.println(mytemp);
				}
			}
		}
	}
	
	private void possibableMoves2(JButton[][] butArr, int i, int j,boolean turnbool) {
		drawTaBoard();
		if(!turnbool) {
			if(i-1 >= 0) {
				if(butArr[i-1][j].getIcon() == null) {
					cell[i-1][j].setBackground(Color.gray);
				}
			}
			if(i-2 >= 0) {
				if(butArr[i-1][j].getIcon() == whiteIcon  || butArr[i-1][j].getIcon() == WhiteKingIcon) {
					if(butArr[i-2][j].getIcon() == null) {
						cell[i-2][j].setBackground(Color.gray);
					}
				}
			}
			
			
			if(j-1 >= 0) {
				if(butArr[i][j-1].getIcon() == null || butArr[i][j-1].getIcon() == WhiteKingIcon) {
					cell[i][j-1].setBackground(Color.gray);
				}
			}
			
			if(j-2 >= 0) { 
				if(butArr[i][j-1].getIcon() == whiteIcon || butArr[i][j-1].getIcon() == WhiteKingIcon) {
					if(butArr[i][j-2].getIcon() == null) {
						cell[i][j-2].setBackground(Color.gray);
					}
				}
			}
			
			if(j+1 < 8) {
				if(butArr[i][j+1].getIcon() == null || butArr[i][j+1].getIcon() == WhiteKingIcon) {
					cell[i][j+1].setBackground(Color.gray);
				}
			}
			
			
			if(j+2 < 8) {
				if(butArr[i][j+1].getIcon() == whiteIcon || butArr[i][j+1].getIcon() == WhiteKingIcon) {
					if(butArr[i][j+2].getIcon() == null) {
						cell[i][j+2].setBackground(Color.gray);
					}
				}
			}
			System.out.println(i + "    " + j);
			
			
			
			int mytemp;
			
			if(butArr[i][j].getIcon() == blackKingIcon) {
				
				for(mytemp  = (i-1); mytemp >= 0; mytemp--) {
					
					if(mytemp-1 >= 0) {
						if(butArr[mytemp][j].getIcon() != null) {
							if(butArr[mytemp-1][j].getIcon() != null) {
								break;
							}
						}
					}
					
					if(butArr[mytemp][j].getIcon() == null) {
						cell[mytemp][j].setBackground(Color.gray);
					}
					System.out.println(mytemp);
				}
				
				
				for(mytemp  = (i+1); mytemp <= 7; mytemp++) {
					
					if(mytemp+1 <= 7) {
						if(butArr[mytemp][j].getIcon() != null) {
							if(butArr[mytemp+1][j].getIcon() != null) {
								break;
							}
						}
					}
					
					if(butArr[mytemp][j].getIcon() == null) {
						cell[mytemp][j].setBackground(Color.gray);
					}
					System.out.println(mytemp);
				}
				
				
				
				for(mytemp  = (j+1); mytemp <= 7; mytemp++) {
					
					if(mytemp+1 <= 7) {
						if(butArr[i][mytemp].getIcon() != null) {
							if(butArr[i][mytemp+1].getIcon() != null) {
								break;
							}
						}
					}
					
					if(butArr[i][mytemp].getIcon() == null) {
						cell[i][mytemp].setBackground(Color.gray);
					}
					System.out.println(mytemp);
				}
				
				
				
				
				for(mytemp  = (j-1); mytemp >= 0; mytemp--) {
					
					if(mytemp-1 >= 0) {
						if(butArr[i][mytemp].getIcon() != null) {
							if(butArr[i][mytemp-1].getIcon() != null) {
								break;
							}
						}
					}
					
					if(butArr[i][mytemp].getIcon() == null) {
						cell[i][mytemp].setBackground(Color.gray);
					}
					System.out.println(mytemp);
				}
			}
		}
	}
		
	public void ifEatenEat(JButton[][] butArr, int i, int j){
		if(i - getTempi() == 2) {
			if(butArr[i-1][j].getIcon() != null) {
				butArr[i-1][j].setIcon(null);
				turnBool = !turnBool;
			}
		}else if(i - getTempi() == -2) {
			if(butArr[i+1][j].getIcon() != null) {
				butArr[i+1][j].setIcon(null);
				turnBool = !turnBool;
			}
		}else if(j - getTempj() == 2) {
			if(butArr[i][j-1].getIcon() != null) {
				butArr[i][j-1].setIcon(null);
				turnBool = !turnBool;
			}
		}else if(j-getTempj() == -2) {
			if(butArr[i][j+1].getIcon() != null) {
				butArr[i][j+1].setIcon(null);
				turnBool = !turnBool;
			}
		}
		
		
		
		boolean whileTrue = true;
		int exhantrick = 0;
		
		int tempii = getTempi();
		int tempjj = getTempj();
		
		while(whileTrue) {
			if(i<tempii) {
				if(cell[tempii][j].getIcon()!=null && exhantrick == 0) {
					exhantrick++;
					turnBool = !turnBool;
				}
				cell[tempii][j].setIcon(null);
				tempii--;
			}else {
				whileTrue=false;
			}
		}
		
		whileTrue = true;
		
		while(whileTrue) {
			if(i>tempii) {
				if(cell[tempii][j].getIcon()!=null && exhantrick == 0) {
					exhantrick++;
					turnBool = !turnBool;
				}
				cell[tempii][j].setIcon(null);
				tempii++;
			}else {
				whileTrue=false;
			}
		}
		
		whileTrue = true;
		
		while(whileTrue) {
			if(j<tempjj) {
				if(cell[i][tempjj].getIcon()!=null && exhantrick == 0) {
					exhantrick++;
					turnBool = !turnBool;
				}
				cell[i][tempjj].setIcon(null);
				tempjj--;
			}else {
				whileTrue=false;
			}
		}
		
		whileTrue = true;
		
		while(whileTrue) {
			if(j>tempjj) {
				if(cell[i][tempjj].getIcon()!=null && exhantrick == 0) {
					exhantrick++;
					turnBool = !turnBool;
				}
				cell[i][tempjj].setIcon(null);
				tempjj++;
			}else {
				whileTrue=false;
			}
		}
		
		
		whileTrue = true;
		
		
	}
	
}