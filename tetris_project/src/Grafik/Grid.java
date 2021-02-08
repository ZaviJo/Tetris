package Grafik;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

import Logik.Game;
import Logik.Umrechnen;

public class Grid extends JLabel {
	/*Die Klasse Grid zeichnet das grosse Spielfeld, bestehend aus 10*18 Feldern. Die Klasse ist eine Subklasse
	 *der Klasse JLabel. Die Klasse JLabel ermöglicht es, Bilder und Texte auf einem Fenster darzustellen,
	 *ohne dass der Benutzer etwas auf dem Bildschirm auswählen kann. Die Klassen Color und Graphics werden in der Methode paintComponent benutzt.
	 */
	
	@Override
	protected void paintComponent(Graphics g) {
		/*Die Methode paintComponent() mit einem Graphics-Objekt wird überschrieben. Die Methode wird benutzt, 
		 *um das Spielfeld zeichnen zu können. 
		 */
		super.paintComponent(g);
		
		
		g.setColor(Game.aktuellerBlock.getColor());
		for(int i=0; i< Game.aktuellerBlock.getGrenzen()[Game.aktuellerBlock.getRotation()].length; i++) {
			for(int j=0; j< Game.aktuellerBlock.getGrenzen()[Game.aktuellerBlock.getRotation()][i].length; j++) {
				if(Game.aktuellerBlock.getGrenzen()[Game.aktuellerBlock.getRotation()][i][j]==1) {
					g.fillRect(Umrechnen.toKoord(Game.aktuellerBlock.getX()+i), 
							Umrechnen.toKoord(Game.aktuellerBlock.getY()+j), 48, 48);
				}
			}
		}
		
		g.setColor(Color.white);						//Die Zeichenfarbe wird auf weiss gesetzt.
		
		for (int i = 0; i < 10; i++) {					//10 Felder in Breite
			for (int j = 0; j < 18; j++) {				//18 Felder in die Höhe
				g.drawRect(i*48, j*48, 48, 48);			//Die Methode drawRect() zeichnet ein Rechteck mit einer Ecke an der Stelle (i*48/j*48). Ein Rechteck ist ein Quadrat mit Seitenlänge = 48.
			}
		}
		repaint();										//repaint() aktualisiert das Spielfeld, damit es neugezeichnet wird.				
	}
}
