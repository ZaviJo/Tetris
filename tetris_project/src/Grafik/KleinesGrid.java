package Grafik;

import java.awt.Color;		//Wird f�r die Farbauswahl des Spielfeldes und des Scores verwendet
import java.awt.Graphics;	//F�r die Erstellung eines Graphics-Objekt ben�tigt. 
import javax.swing.JLabel;	// Das Package javax.swing wird aus dem Modul java.desktop importiert. JLabel wird verwendet, um auf dem Fenster Bilder darstellen zu k�nnen.

import Logik.Game;			//Wird f�r die Instanzvariablen der Klasse importiert.
import Logik.Umrechnen;		//Klasse wird verwendet um von Pixel zu Spielfeldkoordinaten hin- und her zu wechseln.


public class KleinesGrid extends JLabel{
	/*Die Klasse kleinesGrid zeichnet die kleine Anzeige rechts im Fenster, bestehend aus 4*4 Feldern. Die Klasse ist eine Subklasse
	 *der Klasse JLabel. Die Klasse JLabel erm�glicht es, Bilder und Texte auf einem Fenster darzustellen,
	 *ohne dass der Benutzer etwas auf dem Bildschirm ausw�hlen kann. Die Klassen Color und Graphics werden in der Methode paintComponent benutzt.
	 */
	
	@Override
	protected void paintComponent(Graphics g) {
		/*Die Methode paintComponent() mit einem Graphics-Objekt wird �berschrieben. Die Methode wird benutzt, 
		 *um das Spielfeld zeichnen zu k�nnen. 
		 */
		super.paintComponent(g);
		
		g.setColor(Game.naechsterBlock.getColor());
		/*Die nachfolgende Schleife geht die Informationen der dreidimensionalen Bl�cke durch. Das erste Element ist die momentane Rotation, da ben�tigt es keine spezifische Schleife.
		 *Das zweite Element ist die x-Spalte, was mit der ersten Schleife angeschaut wird. Das dritte Element (y-Spalte) wird mit der verschachtelten Schleife durchsucht.
		 *Wenn nun ein Element 1 ist, werden die Koordinaten mithilfe der Klasse Umrechnen umgerechnet. Die Methode toKoord() liefert die x-y-Werte in Pixelanzahl.
		 *Es wird naechster Block im kleinen Grid dargestellt.
		 */
		for(int i=0; i< Game.naechsterBlock.getGrenzen()[Game.naechsterBlock.getRotation()].length; i++) {
			for(int j=0; j< Game.naechsterBlock.getGrenzen()[Game.naechsterBlock.getRotation()][i].length; j++) {
				if(Game.naechsterBlock.getGrenzen()[Game.naechsterBlock.getRotation()][i][j]==1) {
					g.fillRect(Umrechnen.toKoord(i), Umrechnen.toKoord(j), 48, 48);
					//Mit fillRect() werden die entsprechenden K�stchen des Blockes gef�llt. Die Bl�cke werden an der linken oberen Ecke gerichtet. Breite und H�he der Rasterbl�cke sind 48 Pixel.
				}
			}
		}
		
		g.setColor(Color.white);							//Die Zeichenfarbe wird auf weiss gesetzt.
		
		for (int i = 0; i < 4; i++) {						//4 Felder in Breite
			for (int j = 0; j < 4; j++) {					//4 Felder in die H�he
				g.drawRect(i*48, j*48, 48, 48);				//Die Methode drawRect() zeichnet ein Rechteck mit einer Ecke an der Stelle (i*48/j*48). Ein Rechteck ist ein Quadrat mit Seitenl�nge = 48.
			}
		}
		repaint();											//repaint() aktualisiert das Spielfeld, damit es neugezeichnet wird.
	}
}
