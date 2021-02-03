package Grafik;
import java.awt.Color;

/*In dieser Klasse wird das Fenster erstellt, auf welchem das Spiel Tetris gezeichnet wird.
 * 
 */

import javax.swing.JFrame;  
import javax.swing.JLabel;
/* Das Package javax.swing wird aus dem Modul java.desktop importiert. Die beiden Klassen JLabel und JFrame sind in diesem Package
 * enthalten. JFrame wird benutzt, um ein Fenster für das Spiel zu erstellen. JLabel wird verwendet, um auf dem Fenster Bilder darstellen zu können.
 */

import Steuerung.Keyhandler;

public class Gui {
	public static int breite	= 481;							//Breite: 480 + 1 Pixel Spielfeld. 10*48 Pixel breite Quadrate.
	public static int hoehe		= 865;							//Hoehe: 864 + 1 Pixel Spielfeld. 18*48 Pixel lange Quadrate.
	JFrame frame;												//Referenzvariable frame mit dem Typ JFrame. frame ist hier also das Fenster
	
	public void Fenster() {
		/* Die Methode Fenster erzeugt die GUI, damit beim Aufrufen der Klasse Gui nicht die komplette GUI erzeugt.
		 * Das ist eine der wichtigsten Methoden, da hier das Spielfeld erstellt wird, indem es verschiedene Klassen aufruft.
		 */
		
		frame = new JFrame("Tetris");							//Erstellen des Fensters mit dem Fensternamen "Tetris".
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Wenn man auf das rote X im Fenster drückt, schliesst es sich.
		
		frame.getContentPane().setBackground(Color.black);		//Inhalt des Fensters wird schwarz gefärbt
		
		/*Grösse des Fensters:
		 *Fensterbreite: breite des Spielfeldes + 300 Pixel für eine Vorschau des nächsten Blockes + 17 Pixel Fensterrand
		 *Fensterhoehe: hoehe des Spielfeldes + 39 Pixel Fensterrahmen
		 */
		frame.setSize(breite +300+17, hoehe+39);				
		
		frame.setLocationRelativeTo(null);						//Fenster wird in die Mitte gesetzt.
		frame.setResizable(false);								//Grösse des Fensters darf nicht angepasst werden.
		frame.addKeyListener(new Keyhandler());					//Der KeyListener wird dem Fenster hinzugefügt. Ein neues Objekt der Klasse Keyhandler wird erzeugt.
		//frame.requestFocus(); 								//Fenster fokussieren
		frame.setVisible(true);									//Das Fenster wird sichtbar gemacht.
		
		kleinesGrid kg = new kleinesGrid();
		setupDraw(kg,breite+48, 0, 193, 193);
		Grid dg = new Grid();									//dg -- drawgrid
		setupDraw(dg,0,0,breite,hoehe);							//0,0 sind x,y Werte
		
	}
	
	public void setupDraw(JLabel draw, int x, int y, int breite, int hoehe) {
		/*Die Methode zeichnet im Allgemeinen die grafischen Teile des Spiels. Es wird ein JLabel-Objekt übergeben. In diesem Objekt ist die Zeichnungsweise abgespeichert.
		 *Methode setBounds legt den Startpunkt (x/y) fest und das Objekt hat eine neue Breite mit dem Wert 'breite' und eine neue Hoehe mit dem Wert 'hoehe'.
		 */
		draw.setBounds(x,y,breite,hoehe);
		draw.setVisible(true);
		frame.add(draw);										//Das Objekt wird dem Fenster hinzugefügt.
	}
}
