/* Datum: 05.02.2021; Projektname: Programmierprojekt Neuimplementierung von Tetris;
 * Namen: Sebastian Gavrilas, Marius H�chler, Dani Tanner; 
 * Hauptquellen: VIDEOS,
 * Aufteilung: 	Alle: Klassen Gui, Bl�cke
 * 				Sebastian: 
 * 				Marius:
 * 				Dani:
 */

/* Dies ist das Hauptpackage. Hier liegt die Mainklasse, in welcher die Mainmethode arbeitet. Sie ist f�r das gesamte Spiel verantwortlich. 
 * Sie ruft
 * 
 */
package Main;

import Grafik.*; 
/* Die Klassen aus dem Package Grafik werden importiert. Das Package Grafik wird ben�tigt, um alle grafischen Teile von Tetris zu importieren. Das sind das Spielfeld,
 * die bewegenden Bl�cke und die Anzeige f�r den n�chsten Block.
 */

public class MainKlasse {

	public static void main(String[] args) {
		Gui g = new Gui();
		g.Fenster();

	}

}
