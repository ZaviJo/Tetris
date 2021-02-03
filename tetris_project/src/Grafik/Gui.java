package Grafik;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui {
	public static int breite	= 797;							//Breite: 497 Pixel Spielfeld, 300 Pixel extra
	public static int hoehe		= 904;							//Hoehe: 865 Pixel Spielfeld, 39 Pixel für den oberen Balken
	JFrame frame;
	
	public void Fenster () {
		frame = new JFrame("Tetris");							//Name oben im Fenster¨
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X für Fenster dass es sich schliessen lässt
		
		frame.getContentPane().setBackground(Color.black);		//Fenster wird schwarz gefärbt
		
		frame.setSize(breite, hoehe);				
		frame.setResizable(false);
		frame.setVisible(true);									//Fenster ausgeben
		
		Grid dg = new Grid();									//dg -- drawgrid
		setupDraw(dg,0,0,breite,hoehe);							//0,0 sind x,y Werte
		kleinesGrid kg = new kleinesGrid();
		setupDraw(kg, breite+1, 1, breite, hoehe);
	}
	
	private void setupDraw(JLabel draw, int x, int y, int breite, int hoehe) {
		draw.setBounds(x,y,breite,hoehe);
		draw.setVisible(true);
		frame.add(draw);										//um es dem Fenster hinzuzufügen
	}
}
