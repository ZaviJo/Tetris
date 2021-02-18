/* Datum: 05.02.2021; Projektname: Programmierprojekt Neuimplementierung von Tetris;
 * Namen: Dani Tanner, Marius Hächler, Sebastian Gavrilas; 
 * Hauptquellen:	https://docs.oracle.com/en/java/javase/14/docs/api/index.html
 * 					https://stackoverflow.com/
 * Aufteilung: 	Alle: Gui, Grid, MainKlasse, Keyhandler
 * 				Dani: Blocktyp
 * 				Marius: Block
 * 				Sebastian: Block
 */

/* Dies ist das Hauptpackage. Hier liegt die Mainklasse, in welcher die Mainmethode arbeitet. Sie ist für das gesamte 
 * Spiel verantwortlich. Sie ruft die verschiedenen Methoden der anderen Packages und Klassen auf. Das Projekt wurde
 * so aufgeteilt, dass es vier Packages gibt: Main, Grafik, Steuerung und Logik. Dies wurde gemacht, damit man einen guten
 * Überblick hat. 
 */
package Main;

import Grafik.*;
import Logik.Game; 
/* Die Klassen aus dem Package Grafik werden importiert. Das Package Grafik wird benötigt, um alle grafischen Teile 
 * von Tetris zu importieren. Das sind das Spielfeld, die bewegenden Blöcke und die Anzeige für den nächsten Block.
 * Logik.Game wird importiert, um auf die Instanzvariablen der Klasse zugreifen zu können.
 */

public class MainKlasse {

	public static void main(String[] args) {
		
		Game.aktuellerBlock = new Block();		//Der Anfangsblock wird erstellt.
		Game.blocks.add(Game.aktuellerBlock);	//aktuellerBlock wird der ArrayList der Klasse Game hinzugefügt.
		Game.naechsterBlock = new Block();		//Der zweite Block wird erstellt.
		
		Gui g = new Gui();			//Ein Gui-Objekt wird erstellt, um die Methoden in der Klasse Gui aufrufen zu können.
		g.Fenster();				//Die Methode Fenster wird aus der Klasse Gui im Package Grafik importiert.
		
		startLoop();				//Die Methode startLoop() wird aufgerufen.
		
	}
	
	public static void startLoop() {
		/*Die Methode startLoop() erstellt einen neuen Spielloop loop und startet den Thread auch.
		 */
		Spielloop loop = new Spielloop();
		loop.start();
	
	}

}
