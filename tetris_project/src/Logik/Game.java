package Logik;

import java.util.ArrayList;

import Grafik.Block; // ??? vllt kei ahnig

public class Game {
	/*Hier befinden sich die Grundvariablen für das Spiel. 
	 * 
	 */
	public static int score = 0;						//Statisch um es überall aufrufen zu können.
	public static int highscore = 0;					//ebenso
	public static int scoreToAdd = 0;					//Variable ist für die Punkteaddition wichtig.
	public static boolean SpawnNeuerBlock = false;		//Variable ist für die Erstellung eines neuen Blockes notwendig, wenn true wird ein neuer erstellt.
	public static boolean schneller = false;			//Wenn man die Pfeiltaste nach unten drückt, beschleunigt sich der Block
	
	public static ArrayList<Block> blocks = new ArrayList<Block>(); 
	public static Block aktuellerBlock, naechsterBlock;
	public static int [][] map = new int [10][18];
	
	public static Zustand zustand = Zustand.start;
	
	public static void zurücksetzen() {
		for(int x =0; x < 10; x++) {    //wenn nicht gehen bitte x<map.length anstatt 10
			for (int y = 0; y< 18; y++) {	//gleich einf mit y<map[x].length
				map[x][y] =0;
			}
		}
		score = 0;
	}



}
