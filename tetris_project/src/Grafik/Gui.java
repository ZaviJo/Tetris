package Grafik;

import java.awt.Color;		//Die Klasse Color wird benötigt, um den Hintergrund des Fenster einzufärben.
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;  
import javax.swing.JLabel;
/* Das Package javax.swing wird aus dem Modul java.desktop importiert. Die beiden Klassen JLabel und JFrame sind in diesem Package
 * enthalten. JFrame wird benutzt, um ein Fenster für das Spiel zu erstellen. JLabel wird verwendet, um auf dem Fenster Bilder darstellen zu können.
 */
import Steuerung.Keyhandler;	//Das Package Steuerung mit der Klasse Keyhandler wird importiert. Keyhandler wird für die zukünftige Tastatursteuerung verwendet.

public class Gui {
	/*In dieser Klasse wird das Fenster erstellt, auf welchem das Spiel Tetris gezeichnet wird. Das Fenster hat einen schwarzen Hintergrund,
	 * das mit einem grossen weissen Raster und einem kleineren belegt ist. Das grosse Raster besteht aus 18*10 Quadraten, das kleine aus 
	 * 4*4 Quadraten.
	 */
	//Grosses Grid
	public static int breite_dg	= 481;							//Breite: 480 + 1 Pixel Spielfeld. 10*48 Pixel breite Quadrate.
	public static int hoehe_dg	= 865;							//Hoehe: 864 + 1 Pixel Spielfeld. 18*48 Pixel lange Quadrate.
	//kleines Grid
	public static int breite_kg = 193;							//Breite: 192 + 1 Pixel Spielfeld. 4*48 Pixel breite Quadrate.
	public static int hoehe_kg 	= 193;							//Hoehe: 192 + 1 Pixel Spielfeld. 4*48 Pixel lange Quadrate.
	
	JFrame frame;												//Referenzvariable frame mit dem Typ JFrame. frame ist hier also das Fenster
	
	public void Fenster() {
		/* Die Methode Fenster erzeugt die GUI, damit beim Aufrufen der Klasse Gui nicht die komplette GUI erzeugt.
		 * Das ist eine der wichtigsten Methoden, da hier das Spielfeld erstellt wird, indem es verschiedene Klassen aufruft.
		 * Es werden die Grösse des Fensters festgelegt. Die Funktionen der einzelnen Methoden werden in den folgenden Zeilen direkt kommentiert.
		 */
		
		frame = new JFrame("Tetris");							//Erstellen des Fensters mit dem Fensternamen "Tetris".
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Wenn man auf das rote X im Fenster drückt, schliesst es sich.
		frame.getContentPane().setBackground(Color.black);		//Inhalt des Fensters wird schwarz gefärbt
		
		/*Grösse des Fensters:
		 *Fensterbreite: breite des Spielfeldes + 300 Pixel für eine Vorschau des nächsten Blockes + 17 Pixel Fensterrand
		 *Fensterhoehe: hoehe des Spielfeldes + 39 Pixel Fensterrahmen
		 */
		frame.setSize(breite_dg +300+17, hoehe_dg+39);				
		
		frame.setLocationRelativeTo(null);						//Fenster wird in die Mitte gesetzt.
		frame.setResizable(false);								//Grösse des Fensters darf nicht angepasst werden.
		frame.addKeyListener(new Keyhandler());					//Der KeyListener wird dem Fenster hinzugefügt. Ein neues Objekt der Klasse Keyhandler wird erzeugt.
		frame.setVisible(true);									//Das Fenster wird sichtbar gemacht.
		
		
		
		Menu me = new Menu();
		setupDraw(me,0, 0, breite_dg, hoehe_dg);
		KleinesGrid kg = new KleinesGrid();						//Referenzvariable der Klasse kleinesGrid. 
		setupDraw(kg,breite_dg+48, 0, breite_kg, hoehe_kg);		//Methode setupDraw wird für das kleineGrid aufgerufen.
		Grid dg = new Grid();									//Referenzvariable der Klasse Grid.
		setupDraw(dg,0,0,breite_dg + 150,hoehe_dg);				//Methode setupDraw wird für das Grid aufgerufen.
		
	}
	
	public void setupDraw(JLabel draw, int x, int y, int breite, int hoehe) {
		/*Die Methode zeichnet im Allgemeinen die grafischen Teile des Spiels. Es wird ein JLabel-Objekt übergeben. In diesem Objekt ist 
		 * die Zeichnungsweise abgespeichert. Methode setBounds legt den Startpunkt (x/y) fest und das Objekt hat eine 
		 * neue Breite mit dem Wert 'breite' und eine neue Hoehe mit dem Wert 'hoehe'.
		 */
		draw.setBounds(x,y,breite,hoehe);
		draw.setVisible(true);
		frame.add(draw);										//Das Objekt wird dem Fenster hinzugefügt.
	}
}
