/* Datum: 05.02.2021; Projektname: Programmierprojekt Neuimplementierung von Tetris;
 * Namen: Sebastian Gavrilas, Marius Hächler, Dani Tanner; 
 * Hauptquellen: https://docs.oracle.com/en/java/javase/14/docs/api/index.html
 * Aufteilung: 	Alle: Gui, Grid, MainKlasse, Keyhandler
 * 				Sebastian: Block
 * 				Marius: Block
 * 				Dani: Blocktyp
 */

/* Dies ist das Hauptpackage. Hier liegt die Mainklasse, in welcher die Mainmethode arbeitet. Sie ist für das gesamte Spiel verantwortlich. 
 * Sie ruft die verschiedenen Methoden auf. 
 * 
 */
package Main;

import Grafik.*; 
/* Die Klassen aus dem Package Grafik werden importiert. Das Package Grafik wird benötigt, um alle grafischen Teile von Tetris zu importieren. Das sind das Spielfeld,
 * die bewegenden Blöcke und die Anzeige für den nächsten Block.
 */

public class MainKlasse {

	public static void main(String[] args) {
		Gui g = new Gui();			//Ein Gui-Objekt wird erstellt, um die Methoden in der Klasse aufrufen zu können.
		g.Fenster();

	}

}
