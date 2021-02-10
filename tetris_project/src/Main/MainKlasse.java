/* Datum: 05.02.2021; Projektname: Programmierprojekt Neuimplementierung von Tetris;
 * Namen: Dani Tanner, Marius H�chler, Sebastian Gavrilas; 
 * Hauptquellen:	https://docs.oracle.com/en/java/javase/14/docs/api/index.html
 * 					https://stackoverflow.com/
 * Aufteilung: 	Alle: Gui, Grid, MainKlasse, Keyhandler
 * 				Dani: Blocktyp
 * 				Marius: Block
 * 				Sebastian: Block
 */

/* Dies ist das Hauptpackage. Hier liegt die Mainklasse, in welcher die Mainmethode arbeitet. Sie ist f�r das gesamte 
 * Spiel verantwortlich. Sie ruft die verschiedenen Methoden der anderen Packages und Klassen auf. Das Projekt wurde
 * so aufgeteilt, dass es drei Packages gibt: Main, Grafik und Steuerung. Dies wurde gemacht, damit man einen guten
 * �berblick hat. 
 */
package Main;

import Grafik.*;
import Logik.Game; 
/* Die Klassen aus dem Package Grafik werden importiert. Das Package Grafik wird ben�tigt, um alle grafischen Teile 
 * von Tetris zu importieren. Das sind das Spielfeld, die bewegenden Bl�cke und die Anzeige f�r den n�chsten Block.
 * Das Package Steuerung wird zuk�nftig ben�tigt, um die Steuerung der Spielelemente zu erm�glichen.
 */

public class MainKlasse {

	public static void main(String[] args) {
		
		Game.aktuellerBlock = new Block();
		Game.blocks.add(Game.aktuellerBlock);
		Game.naechsterBlock = new Block();
		Gui g = new Gui();			//Ein Gui-Objekt wird erstellt, um die Methoden in der Klasse Gui aufrufen zu k�nnen.
		g.Fenster();				//Die Methode Fenster wird aus der Klasse Gui im Package Grafik importiert.
		
		startLoop();
		
	}
	
	public static void startLoop() {
		Spielloop loop = new Spielloop();
		loop.start();
	
	}

}
