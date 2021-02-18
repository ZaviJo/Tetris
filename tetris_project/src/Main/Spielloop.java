package Main;

import Grafik.Block;		//Wichtig f�r den Zugriff auf 
import Logik.Game;			//Wird ben�tigt, um auf die Instanzvariablen der Klasse Game zugreifen zu k�nnen.
import Logik.Zustand;		//

public class Spielloop extends Thread{
	/*Unsere Spielloop ist eine Erweiterung der Klasse Thread. Threads werden benutzt, um gleichzeitig mehrere Operationen
	 * effizient durchf�hren zu k�nnen. Hier wird das Spiel dauernd aktualisiert.
	 */
	private boolean laufend = true;		//Wird verwendet, wenn man das Programm unterbrechen will. Abbruchbedingung.		
	
	public void run() {				
	/*Methode run() wird �berschrieben, um unser eigenes Programm einf�gen zu k�nnen. 
	 */
		while(laufend) {
			try {
				if(Game.zustand == Zustand.start) {	//Wird ausgef�hrt, wenn der Zustand des Spiels start ist. Nur dann werden Sachen generiert.
					
					Game.aktuellerBlock.setY(Game.aktuellerBlock.getY()+1); 
					
					if(Game.SpawnNeuerBlock) { 							//Wenn ein neuer Block erstellt werden muss. Hier: SpawnNeuerBlock = true.
						Game.blocks.add(Game.naechsterBlock);			//naechsterBlock wird der ArrayList hinzugef�gt.
						Game.aktuellerBlock = Game.naechsterBlock;
						Game.naechsterBlock = new Block();
						Game.SpawnNeuerBlock = false;
					}
				}
			
				
				
				if(!Game.schneller) {
					sleep(1000);
					}
				else {
					sleep(100);
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
