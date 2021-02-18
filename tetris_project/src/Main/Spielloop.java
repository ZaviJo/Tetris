package Main;

import Grafik.Block;		//Für die Blockerstellung des nächsten Blockes wichtig.
import Logik.Game;			//Wird benötigt, um auf die Instanzvariablen der Klasse Game zugreifen zu können
import Logik.Zustand;		//Wird für die Zustandsabfrage des Games benötigt.

public class Spielloop extends Thread {
	/*Spielloop ist eine Erweiterung der Klasse Thread. Threads werden benutzt, um gleichzeitig mehrere Operationen effizient durchführen zu können.
	 * Hier wird das Spiel dauernd aktualisiert.
	 */
	private boolean laufend = true;			
	/*Methode run() wird überschrieben, um unser eigenes Programm einfügen zu können. 
	 */
	public void run() {				
		
		while(laufend) {
			try {
				if(Game.zustand == Zustand.ingame) { 						//Wird ausgeführt, wenn der Zustand des Spiels ingame ist. Nur dann werden Sachen aktualisiert.
					
					Game.aktuellerBlock.setY(Game.aktuellerBlock.getY()+1);
					
					if(Game.SpawnNeuerBlock) {								//Wenn ein neuer Block erstellt werden muss. Hier: SpawnNeuerBlock = true.
						Game.blocks.add(Game.naechsterBlock);				//naechsterBlock wird der Arraylist hinzugefügt.
						Game.aktuellerBlock = Game.naechsterBlock;			//aktuellerBlock wird überschrieben
						Game.naechsterBlock = new Block();					//ein neuer Block wird erstellt.
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
