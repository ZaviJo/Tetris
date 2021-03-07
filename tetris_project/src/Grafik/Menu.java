package Grafik;

import java.awt.Color;		//Wird für die Farbauswahl des Spielfeldes und des Scores verwendet
import java.awt.Graphics;	//Für die Erstellung eines Graphics-Objekt benötigt. 
import javax.swing.JLabel;	// Das Package javax.swing wird aus dem Modul java.desktop importiert. JLabel wird verwendet, um auf dem Fenster Bilder darstellen zu können.

import Logik.Game;			//Wird für die Instanzvariablen der Klasse importiert.
import Logik.Zustand;		//Um auf den Zustand des Spiels zuzugreifen. 

public class Menu extends JLabel {
	/*Die Klasse Menu zeichnet die Querbalken über dem Spielfeld. Je nach Spielzustand (start, pause, verloren) wird ein anderes Menu angezeigt. Die Klasse ist eine Subklasse
	 *der Klasse JLabel. Die Klasse JLabel ermöglicht es, Bilder und Texte auf einem Fenster darzustellen,
	 *ohne dass der Benutzer etwas auf dem Bildschirm auswählen kann. Die Klassen Color und Graphics werden in der Methode paintComponent benutzt.
	 */
	
	@Override
	protected void paintComponent(Graphics g) {
		/*Die Methode paintComponent() mit einem Graphics-Objekt wird überschrieben. Die Methode wird benutzt,
		 *um die verschiedenen Menus zeichnen zu können. 
		 */
		super.paintComponent(g);
		 if(Game.zustand == Zustand.start){
			 /*Wenn der Spielzustand start ist, wird das Startmenü gezeichnet.
			  *Es hat ein dunkelgrünes Rechteck, worauf der schwarze Text "Drücke Space zum Starten" gezeichnet wird.
			  */
			 g.setColor(new Color(134,179,0));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("Drücke Space zum Starten", 170,Gui.hoehe_dg/2 );
			 
		 }else if(Game.zustand == Zustand.pause){
			 /*Wenn der Spielzustand pause ist, wird das Pausenmenü gezeichnet.
			  *Es hat ein graues Rechteck, worauf der schwarze Text "Drücke ESC zum Fortfahren" gezeichnet wird.
			  */
			 g.setColor(new Color(179,179,179));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("Drücke ESC zum Fortfahren", 175,Gui.hoehe_dg/2 );
			 
		 }else if(Game.zustand == Zustand.verloren){
			 /*Wenn der Spielzustand verloren ist, wird das Endmenü gezeichnet.
			  *Es hat ein rotes Rechteck, worauf der schwarze Text "You lost, press Space to git gud" gezeichnet wird.
			  */
			 g.setColor(new Color(153,0,0));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("You lost, press Space to git gud", 140,Gui.hoehe_dg/2 );
			 //Die x/y Werte für die Position des Textes ist überall ein wenig anders, damit der Text in der Mitte ist. 
	
		 }
		 repaint();
	}
}
