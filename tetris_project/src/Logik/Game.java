package Logik;

import java.util.ArrayList;		//Wird f�r die Erstellung von ArrayLists ben�tigt. 
import Grafik.Block; 			//Wird ben�tigt, um die vorbereiteten Bl�cke zu verwenden. 

public class Game {
	/*Hier befinden sich die Grundvariablen f�r das Spiel.
	 */
	public static int score = 0;						//Statisch um es �berall aufrufen zu k�nnen.
	public static int highscore = 0;					//ebenso
	public static int scoreToAdd = 0;					//Variable ist f�r die Punkteaddition wichtig.
	public static boolean SpawnNeuerBlock = false;		//Variable ist f�r die Erstellung eines neuen Blockes notwendig, wenn true wird ein neuer erstellt.
	public static boolean schneller = false;			//Wenn man die Pfeiltaste nach unten dr�ckt, beschleunigt sich der Block
	public static int warten = 1000;
	
	public static ArrayList<Block> blocks = new ArrayList<Block>(); 	//ArrayLists haben den Vorteil, dass man sie einfach erweitern und bearbeiten kann.
	public static Block aktuellerBlock, naechsterBlock;					//Der aktuelle Block und der n�chste Block, der in kleinesGrid angezeigt wird.
	public static int [][] map = new int [10][18];						//Zweidimensionales Array f�r das Spielfeld. Bl�cke sollen in diesem Array dargestellt werden.
	
	public static Zustand zustand = Zustand.start;		//Der Zustand zu Beginn des Games ist start.
	
	public static void zur�cksetzen() {
		/*Die Methode setzt die aktuelle Map zur�ck. Wird bei einem Spielneustart verwendet.
		 */
		for(int x =0; x < 10; x++) {    	//wenn nicht gehen bitte x<map.length anstatt 10
			for (int y = 0; y< 18; y++) {	//gleich einf mit y<map[x].length
				map[x][y] =0;			//Diese Schleife setzt alle Felder im Array map wieder auf 0.
			}
		}
		score = 0;						//Score wird auf 0 gesetzt.
		warten = 1000;					//Die Geschwindigkeit des Spiels wird zur�ckgesetzt.
	}



}
