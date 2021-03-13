package Logik;
/*Das Package Logik beinhaltet die Klassen Game, Kollision, Umrechnen und Zustand. Sie alle hängen eng mit der Klasse Block im Package Grafik zusammen.
 *Die Klassen des Package Logik behandeln die Funktionen des Spiels. Sie definieren, wie sich die Blöcke (auch bei Kollision) verhalten und wie die Blöcke auf
 *dem Spielfeld gespeichert werden.
 * 
 */

import java.util.ArrayList;		//Wird für die Erstellung von ArrayLists benötigt. 
import Grafik.Block; 			//Wird benötigt, um die vorbereiteten Blöcke zu verwenden. 

public class Game {
	/*Hier befinden sich die Grundvariablen für das Spiel und die Methode für das Zurücksetzen des Spiels.
	 */
	public static int score = 0;						//Statisch um es überall aufrufen zu können.
	public static int highscore = 0;					//ebenso
	public static int scoreToAdd = 0;					//Variable ist für die Punkteaddition wichtig.
	public static boolean SpawnNeuerBlock = false;		//Variable ist für die Erstellung eines neuen Blockes notwendig, wenn true wird ein neuer erstellt.
	public static boolean schneller = false;			//Wenn man die Pfeiltaste nach unten drückt, beschleunigt sich der Block
	public static int warten = 1000;
	
	public static ArrayList<Block> blocks = new ArrayList<Block>(); 	//ArrayLists haben den Vorteil, dass man sie einfach erweitern und bearbeiten kann.
	public static Block aktuellerBlock, naechsterBlock;					//Der aktuelle Block und der nächste Block, der in kleinesGrid angezeigt wird.
	public static int [][] map = new int [10][18];						//Zweidimensionales Array für das Spielfeld. Blöcke sollen in diesem Array dargestellt werden.
	
	public static Zustand zustand = Zustand.start;		//Der Zustand zu Beginn des Games ist start.
	
	public static void zurücksetzen() {
		/*Die Methode setzt die aktuelle Map zurück. Wird bei einem Spielneustart verwendet.
		 */
		for(int x =0; x < 10; x++) {    	
			for (int y = 0; y< 18; y++) {
				map[x][y] =0;			//Diese Schleife setzt alle Felder im Array map wieder auf 0.
			}
		}
		score = 0;						//Score wird auf 0 gesetzt.
		warten = 1000;					//Die Geschwindigkeit des Spiels wird zurückgesetzt.
	}



}
