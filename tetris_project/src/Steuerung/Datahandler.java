package Steuerung;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import Logik.Game;

public class Datahandler {
	public static void load() {
		File file = new File("rsc/data/highscore.txt");
		try {
			Scanner sc = new Scanner(file);
			Game.highscore = sc.nextInt();
			sc.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void safe() {
		File file = new File("rsc/data/highscore.txt");
		
		try {
			OutputStream stream = new FileOutputStream(file);
			
			try {
				stream.write(Integer.toString(Game.highscore).getBytes());
				stream.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
