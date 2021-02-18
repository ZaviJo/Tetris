package Grafik;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
//Die Klassen Color und Graphics werden in der Methode paintComponent benutzt.

import Logik.Game;
import Logik.Umrechnen;


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
		for(int i=0; i< Game.naechsterBlock.getGrenzen()[Game.naechsterBlock.getRotation()].length; i++) {
			for(int j=0; j< Game.naechsterBlock.getGrenzen()[Game.naechsterBlock.getRotation()][i].length; j++) {
				if(Game.naechsterBlock.getGrenzen()[Game.naechsterBlock.getRotation()][i][j]==1) {
					g.fillRect(Umrechnen.toKoord(1+i), 
							Umrechnen.toKoord(j), 48, 48);
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
