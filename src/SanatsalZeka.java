
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SanatsalZeka {
	
	public boolean tbool;
	private static SanatsalZeka object;
	private JButton myArr[][];
	private boolean isPlayedOnce = false;
	
	private SanatsalZeka(JButton[][] myArr,boolean oneByOne) {
		
	}
	
	public static SanatsalZeka getSanatsalZeka(JButton[][] myArr,boolean oneByOne) {
		if(object == null) {
			
			return new SanatsalZeka(myArr, oneByOne);
		}else {
			return object;
		}
	}
	
	

	public void move(JButton[][] cell, ImageIcon whiteIcon, ImageIcon whiteKingIcon) {
		
		
		isPlayedOnce = false;
		
		eat(cell, whiteIcon, whiteKingIcon);
		
		senseMoves(cell, whiteIcon, whiteKingIcon);
		
		
		isPlayedOnce = false;
		
	}
	
	private void senseMoves(JButton[][] cell, ImageIcon whiteIcon, ImageIcon whiteKingIcon) {
		
			int asagi = 0;
			int sol = 0;
			int sag = 0;
			for (int myi = 0; myi < 8; myi++) {
				for (int myj = 0; myj < 8; myj++) {
					if(isPlayedOnce == false) {
					asagi = 0;
					sag  = 0;
					sol  = 0;
						
					ArrayList<Integer> iListSenseDown = new ArrayList<Integer>();
					ArrayList<Integer> jListSenseDown = new ArrayList<Integer>();
					
					if(cell[myi][myj].getIcon() == whiteIcon) {
						if(myi+1 < 8) {
							if(myi+2 < 8) {
								if(cell[myi+1][myj].getIcon() == null && (cell[myi+2][myj].getIcon() == null || cell[myi+2][myj].getIcon() == whiteIcon)) {
									asagi++;
									
									
								}
							}
							if(myj+1 < 8) {
								if(cell[myi+1][myj].getIcon() == null && cell[myi+1][myj+1].getIcon() == null) {
									asagi++;
									
									
								}
							}
							if(myj-1 > 0) {
								if(cell[myi+1][myj].getIcon() == null && cell[myi+1][myj-1].getIcon() == null) {
									
									asagi++;
									
								}
							}
						}
						if(asagi == 3 && isPlayedOnce == false && cell[myi+1][myj].getIcon()!=whiteIcon) {
							cell[myi][myj].setIcon(null);
							cell[myi+1][myj].setIcon(whiteIcon);
							isPlayedOnce = true;
							asagi = 0;
							System.out.println("played mouves by the ai : " + myi + "   " + myj);
						}
						
						
						
						if(myj+1 < 8) {
							if(myj+2 < 8) {
								if(cell[myi][myj+1].getIcon() == null && (cell[myi][myj+2].getIcon() == null || cell[myi][myj+2].getIcon() == whiteIcon)) {
									
									
									sag++;
									iListSenseDown.add(myi);
									jListSenseDown.add(myj);
								
								}
							}
							if(myi+1 < 8) { 
								if(cell[myi][myj+1].getIcon() == null && cell[myi+1][myj+1].getIcon() == null) {
									
									
									sag++;
									iListSenseDown.add(myi);
									jListSenseDown.add(myj);
								
								}
							}
						}
							if(sag == 2 && isPlayedOnce == false) {
								cell[myi][myj].setIcon(null);
								cell[myi][myj+1].setIcon(whiteIcon);
								isPlayedOnce = true;
								sag = 0;
								System.out.println("played mouves by the ai : " + myi + "   " + myj);
							}
						
							
							if(myj-1 > 0) {
								if(myj-2 > 0) {
									if(cell[myi][myj-1].getIcon() == null && (cell[myi][myj-2].getIcon() == null || cell[myi][myj-2].getIcon() == whiteIcon)) {
										
										
										sol++;
										iListSenseDown.add(myi);
										jListSenseDown.add(myj);
									
									}
								}
								if(myj-1 > 0) {
									if(cell[myi][myj-1].getIcon() == null && (cell[myi+1][myj-1].getIcon() == null || cell[myi+1][myj-1].getIcon() == whiteIcon)) {
										
									
										sol++;
										iListSenseDown.add(myi);
										jListSenseDown.add(myj);
										
									}
								}
							}
							if(sol == 2 && isPlayedOnce == false) {
								cell[myi][myj].setIcon(null);
								cell[myi][myj-1].setIcon(whiteIcon);
								isPlayedOnce = true;
								sol = 0;
								System.out.println("played moves by the ai : " + myi + "   " + myj);
							}
					}
					
					if(cell[myi][myj].getIcon() == whiteKingIcon) {
						
					}
					
					
					
				}
			}
			
			
		}
		
	}
	

	  public void eat(JButton[][] cell, ImageIcon whiteIcon, ImageIcon whiteKingIcon) {
		
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(cell[i][j].getIcon() == whiteIcon) {
					if(i+2 < 8) { 
						if(cell[i+1][j].getIcon() != null && cell[i+1][j].getIcon() != whiteIcon && cell[i+1][j].getIcon() != whiteKingIcon && cell[i+2][j].getIcon() == null) {
							cell[i][j].setIcon(null);
							cell[i+1][j].setIcon(null);
							cell[i+2][j].setIcon(whiteIcon);
							i = 0;
							j = 0;
							isPlayedOnce = true;
						}
					}if(j+2 < 8) {
						
						if(cell[i][j+1].getIcon() != null && cell[i][j+1].getIcon() != whiteIcon && cell[i][j+1].getIcon() != whiteKingIcon && cell[i][j+2].getIcon() == null) {
							cell[i][j].setIcon(null);
							cell[i][j+1].setIcon(null);
							cell[i][j+2].setIcon(whiteIcon);
							i = 0;
							j = 0;
							isPlayedOnce = true;
						}
					}if(j-2 > 0) {
						if(cell[i][j-1].getIcon() != null && cell[i][j-1].getIcon() != whiteIcon && cell[i][j-1].getIcon() != whiteKingIcon && cell[i][j-2].getIcon() == null) {
							cell[i][j].setIcon(null);
							cell[i][j-1].setIcon(null);
							cell[i][j-2].setIcon(whiteIcon);
							i = 0;
							j = 0;
							isPlayedOnce = true;
						}
					}
					
				}else if(cell[i][j].getIcon() == whiteKingIcon) {
					
				}
			}
		}
	}
	
}
