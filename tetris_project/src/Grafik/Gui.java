package Grafik;
import java.awt.Color;

/*In dieser Klasse wird das Fenster erstellt, auf welchem das Spiel Tetris gezeichnet wird.
 * 
 */

import javax.swing.JFrame;  
import javax.swing.JLabel;
/* Das Package javax.swing wird aus dem Modul java.desktop importiert. Die beiden Klassen JLabel und JFrame sind in diesem Package
 * enthalten. JFrame wird benutzt, um ein Fenster für das Spiel zu erstellen. JLabel wird verwendet, um
 */

import Steuerung.keyhandler;

public class Gui {
	public static int breite	= 797;							//Breite: 497 Pixel Spielfeld, 300 Pixel extra
	public static int hoehe		= 904;							//Hoehe: 865 Pixel Spielfeld, 39 Pixel für den oberen Fensterrahmen. Beide Variablen sind Instanzvariablen, damit sie nicht mit einem Objekt aufgeruft werden müssen.
	JFrame frame;												//Referenzvariable frame mit dem Typ JFrame. frame ist hier also das Fenster
	
	public void Fenster() {
		//Die Methode Fenster erzeugt die GUI, damit die Klasse Gui nicht die komplette GUI erzeugt.
		frame = new JFrame("Tetris");							//erstellen 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X für Fenster dass es sich schliessen lässt
		
		frame.getContentPane().setBackground(Color.black);		//Fenster wird schwarz gefärbt
		frame.setSize(breite, hoehe);				
		frame.setResizable(false);
		frame.setVisible(true);									//Fenster ausgeben
		frame.addKeyListener(new keyhandler());
		
		kleinesGrid kg = new kleinesGrid();
		setupDraw(kg,534, 0, breite, hoehe);
		Grid dg = new Grid();									//dg -- drawgrid
		setupDraw(dg,0,0,breite,hoehe);							//0,0 sind x,y Werte
		
	}
	
	private void setupDraw(JLabel draw, int x, int y, int breite, int hoehe) {
		draw.setBounds(x,y,breite,hoehe);
		draw.setVisible(true);
		frame.add(draw);										//um es dem Fenster hinzuzufügen
	}
}
