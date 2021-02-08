package Logik;

import java.util.ArrayList;

import Grafik.Block; // ??? vllt kei ahnig

public class Game {
	public static int score = 0;
	public static int highscore = 0;
	public static int scoretoAdd = 0;
	public static boolean SpawnNeuerBlock = false;
	public static boolean schneller = false;
	
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
