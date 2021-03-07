package Steuerung;

import java.io.*;		//Das Package wird verwendet, um Files im Code bearbeiten zu k�nnen.
import java.util.Scanner;	//Package wird ben�tigt, um den Scanner f�r das File-Lesen zu verwenden.
import Logik.Game;		//Um auf die Instanzvariable highscore zugreifen zu k�nnen.

public class Datahandler {
	/*Die Klasse speichert und ladet den Highscore dieses Tetris Programms. 
	 */
	public static void load() {
	//Die Methode load() ladet den Highscore-Wert aus einer bestehenden Text-Datei.
		File file = new File("rsc/data/highscore.txt");		//Die Textdatei mit dem Highscore wird aufgerufen und auf eine Variable gespeichert.
		try {
			Scanner sc = new Scanner(file);			//Das File wird gescannt. 
			Game.highscore = sc.nextInt();			//Der n�chste Integer im File wird auf die Variable highscore gespeichert. 
			sc.close();								//Scanner wird beendet.
		}catch(FileNotFoundException e) {			//Fehlermeldungen sollen abgefangen werden. 
			e.printStackTrace();
		}
		
	}
	
	public static void safe() {
	//Die Methode safe() speichert den aktuellen Highscore auf die Text-Datei.
		File file = new File("rsc/data/highscore.txt");		//Die Textdatei mit dem Highscore wird aufgerufen und auf eine Variable gespeichert.
		
		try {
			OutputStream stream = new FileOutputStream(file);	//�ffnet den Datenstrom, um Zahlen in das File aufnehmen zu k�nnen. Der Outputstream will Bytes in die Textdatei schreiben. 
			
			try {
				stream.write(Integer.toString(Game.highscore).getBytes());	//Es wird von Integer in String in Bytes konvertiert. 
				stream.close();									//Der Datenstrom wird geschlossen.
				
			} catch (IOException e) {			//Fehlermeldungen sollen abgefangen werden. 
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {		//Fehlermeldungen sollen abgefangen werden. 
			e.printStackTrace();
		}
	}
	
	
}
