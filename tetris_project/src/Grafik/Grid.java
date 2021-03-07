package Grafik;

import java.awt.Color;		//Wird f�r die Farbauswahl des Spielfeldes und des Scores verwendet
import java.awt.Graphics;	//F�r die Erstellung eines Graphics-Objekt ben�tigt. 
import javax.swing.JLabel;	// Das Package javax.swing wird aus dem Modul java.desktop importiert. JLabel wird verwendet, um auf dem Fenster Bilder darstellen zu k�nnen.

import Logik.Game;			//Wird f�r die Instanzvariablen der Klasse importiert.
import Logik.Umrechnen;		//Klasse wird verwendet um von Pixel zu Spielfeldkoordinaten hin- und her zu wechseln.

public class Grid extends JLabel {
	/*Die Klasse Grid zeichnet das grosse Spielfeld, bestehend aus 10*18 Feldern, und auch den Score und den Highscore. Die Klasse ist eine Subklasse
	 *der Klasse JLabel. Die Klasse JLabel erm�glicht es, Bilder und Texte auf einem Fenster darzustellen,
	 *ohne dass der Benutzer etwas auf dem Bildschirm ausw�hlen kann. Die Klassen Color und Graphics werden in der Methode paintComponent benutzt.
	 */
	
	@Override
	protected void paintComponent(Graphics g) {
		/*Die Methode paintComponent() mit einem Graphics-Objekt wird �berschrieben. Die Methode wird benutzt, 
		 *um das Spielfeld zeichnen zu k�nnen. 
		 */
		super.paintComponent(g);
		
		g.setColor(Game.aktuellerBlock.getColor());
		/*Die nachfolgende Schleife geht die Informationen der dreidimensionalen Bl�cke durch. Das erste Element ist die momentane Rotation, da ben�tigt es keine spezifische Schleife.
		 *Das zweite Element ist die x-Spalte, was mit der ersten Schleife angeschaut wird. Das dritte Element (y-Spalte) wird mit der verschachtelten Schleife durchsucht.
		 *Wenn nun ein Element 1 ist, werden die Koordinaten mithilfe der Klasse Umrechnen umgerechnet. Die Methode toKoord() liefert die x-y-Werte in Pixelanzahl.
		 */
		for(int i=0; i< Game.aktuellerBlock.getGrenzen()[Game.aktuellerBlock.getRotation()].length; i++) {
			for(int j=0; j< Game.aktuellerBlock.getGrenzen()[Game.aktuellerBlock.getRotation()][i].length; j++) {
				if(Game.aktuellerBlock.getGrenzen()[Game.aktuellerBlock.getRotation()][i][j]==1) {
					g.fillRect(Umrechnen.toKoord(Game.aktuellerBlock.getX()+i), Umrechnen.toKoord(Game.aktuellerBlock.getY()+j), 48, 48);
					//Mit fillRect() werden die entsprechenden K�stchen des Blockes gef�llt. +i/+j wird ben�tigt, um vom Startpunkt aus die Bl�cke zeichnen zu k�nnen. Breite und H�he der Rasterbl�cke sind 48 Pixel.
				}
			}
		}
		
		for (int i = 0; i<Game.map.length; i++) {
			for (int j = 0; j<Game.map[i].length; j++) {
				if(Game.map[i][j] > 0) {
				//�berall auf dem Spielfeld mit einer Zahl gr�sser als 0, soll der Block gezeichnet werden.
					switch(Game.map[i][j]) {
					case 1: 
					//Block I
						g.setColor(Color.CYAN);
						break;
					case 2: 
					//Block J
						g.setColor(Color.BLUE);
						break;
					case 3: 
					//Block L
						g.setColor(Color.ORANGE);
						break;
					case 4: 
					//Block O
						g.setColor(Color.YELLOW);
						break;
					case 5: 
					//Block S
						g.setColor(Color.GREEN);
						break;
					case 6: 
					//Block T
						g.setColor(Color.MAGENTA);
						break;
					case 7: 
					//Block Z
						g.setColor(Color.RED);
						break;
					}
					
					g.fillRect(Logik.Umrechnen.toKoord(i), Logik.Umrechnen.toKoord(j), 48, 48);
				}
			}
		}
		
		g.setColor(Color.white);						//Die Zeichenfarbe wird auf weiss gesetzt.
		
		for (int i = 0; i < 10; i++) {					//10 Felder in Breite
			for (int j = 0; j < 18; j++) {				//18 Felder in die H�he
				g.drawRect(i*48, j*48, 48, 48);			//Die Methode drawRect() zeichnet ein Rechteck mit einer Ecke an der Stelle (i*48/j*48). Ein Rechteck ist ein Quadrat mit Seitenl�nge = 48.
			}
		}
		
		g.drawString("SCORE: "+Game.score, Gui.breite_dg + 48, Gui.hoehe_kg + 48);			//Der Score wird im Abstand von 48 Pixeln zum kleinenGrid und Grid gezeichnet.
		g.drawString("HIGHSCORE: "+Game.highscore,Gui.breite_dg + 48, Gui.hoehe_kg + 68);	//Der Highscore ist 20 Pixel unter dem Score.
		
		repaint();										//repaint() aktualisiert das Spielfeld, damit es neugezeichnet wird.				
	}
}
