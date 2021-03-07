package Grafik;

import java.awt.Color;		//Wird f�r die Farbauswahl des Spielfeldes und des Scores verwendet
import java.awt.Graphics;	//F�r die Erstellung eines Graphics-Objekt ben�tigt. 
import javax.swing.JLabel;	// Das Package javax.swing wird aus dem Modul java.desktop importiert. JLabel wird verwendet, um auf dem Fenster Bilder darstellen zu k�nnen.

import Logik.Game;			//Wird f�r die Instanzvariablen der Klasse importiert.
import Logik.Zustand;		//Um auf den Zustand des Spiels zuzugreifen. 

public class Menu extends JLabel {
	/*Die Klasse Menu zeichnet die Querbalken �ber dem Spielfeld. Je nach Spielzustand (start, pause, verloren) wird ein anderes Menu angezeigt. Die Klasse ist eine Subklasse
	 *der Klasse JLabel. Die Klasse JLabel erm�glicht es, Bilder und Texte auf einem Fenster darzustellen,
	 *ohne dass der Benutzer etwas auf dem Bildschirm ausw�hlen kann. Die Klassen Color und Graphics werden in der Methode paintComponent benutzt.
	 */
	
	@Override
	protected void paintComponent(Graphics g) {
		/*Die Methode paintComponent() mit einem Graphics-Objekt wird �berschrieben. Die Methode wird benutzt,
		 *um die verschiedenen Menus zeichnen zu k�nnen. 
		 */
		super.paintComponent(g);
		 if(Game.zustand == Zustand.start){
			 /*Wenn der Spielzustand start ist, wird das Startmen� gezeichnet.
			  *Es hat ein dunkelgr�nes Rechteck, worauf der schwarze Text "Dr�cke Space zum Starten" gezeichnet wird.
			  */
			 g.setColor(new Color(134,179,0));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("Dr�cke Space zum Starten", 170,Gui.hoehe_dg/2 );
			 
		 }else if(Game.zustand == Zustand.pause){
			 /*Wenn der Spielzustand pause ist, wird das Pausenmen� gezeichnet.
			  *Es hat ein graues Rechteck, worauf der schwarze Text "Dr�cke ESC zum Fortfahren" gezeichnet wird.
			  */
			 g.setColor(new Color(179,179,179));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("Dr�cke ESC zum Fortfahren", 175,Gui.hoehe_dg/2 );
			 
		 }else if(Game.zustand == Zustand.verloren){
			 /*Wenn der Spielzustand verloren ist, wird das Endmen� gezeichnet.
			  *Es hat ein rotes Rechteck, worauf der schwarze Text "You lost, press Space to git gud" gezeichnet wird.
			  */
			 g.setColor(new Color(153,0,0));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("You lost, press Space to git gud", 140,Gui.hoehe_dg/2 );
			 //Die x/y Werte f�r die Position des Textes ist �berall ein wenig anders, damit der Text in der Mitte ist. 
	
		 }
		 repaint();
	}
}
