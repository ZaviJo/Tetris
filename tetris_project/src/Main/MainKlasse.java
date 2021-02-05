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
 * so aufgeteilt, dass es drei Packages gibt: Main, Grafik und Steuerung. Dies wurde gemacht, damit man einen guten
 * Überblick hat. 
 */
package Main;

import Grafik.*; 
/* Die Klassen aus dem Package Grafik werden importiert. Das Package Grafik wird benötigt, um alle grafischen Teile 
 * von Tetris zu importieren. Das sind das Spielfeld, die bewegenden Blöcke und die Anzeige für den nächsten Block.
 * Das Package Steuerung wird zukünftig benötigt, um die Steuerung der Spielelemente zu ermöglichen.
 */

public class MainKlasse {

	public static void main(String[] args) {
		Gui g = new Gui();			//Ein Gui-Objekt wird erstellt, um die Methoden in der Klasse Gui aufrufen zu können.
		g.Fenster();				//Die Methode Fenster wird aus der Klasse Gui im Package Grafik importiert.

	}

}
