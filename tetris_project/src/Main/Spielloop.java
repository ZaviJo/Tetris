package Main;

import Grafik.Block;		//F�r die Blockerstellung des n�chsten Blockes wichtig.
import Logik.Game;			//Wird ben�tigt, um auf die Instanzvariablen der Klasse Game zugreifen zu k�nnen
import Logik.Zustand;		//Wird f�r die Zustandsabfrage des Games ben�tigt.

public class Spielloop extends Thread {
	/*Spielloop ist eine Erweiterung der Klasse Thread. Threads werden benutzt, um gleichzeitig mehrere Operationen effizient durchf�hren zu k�nnen.
	 * Hier wird das Spiel dauernd aktualisiert.
	 */
	private boolean laufend = true;			
	/*Methode run() wird �berschrieben, um unser eigenes Programm einf�gen zu k�nnen. 
	 */
	public void run() {				
		
		while(laufend) {
			try {
			/*Try-Catch wird verwendet, um Fehler w�hrend des try auffangen zu k�nnen.
			 * 
			 */
				if(Game.zustand == Zustand.ingame) { 						//Wird ausgef�hrt, wenn der Zustand des Spiels ingame ist. Nur dann werden Sachen aktualisiert.
					
					Game.aktuellerBlock.setY(Game.aktuellerBlock.getY()+1);	//Der Block wird um 1 Zelle nach unten bewegt.
					
					if(Game.SpawnNeuerBlock) {								//Wenn ein neuer Block erstellt werden muss. Hier: SpawnNeuerBlock = true.
						Game.blocks.add(Game.naechsterBlock);				//naechsterBlock wird der Arraylist hinzugef�gt.
						Game.aktuellerBlock = Game.naechsterBlock;			//aktuellerBlock wird �berschrieben
						Game.naechsterBlock = new Block();					//ein neuer Block wird erstellt.
						Game.SpawnNeuerBlock = false;
					}
				}
			
				if(!Game.schneller) {		//Wird aufgerufen, wenn man nicht die Pfeiltaste nach unten dr�ckt.
					sleep(1000);			//Es wird 1 Sekunde gewartet, bis die n�chste Operation durchgef�hrt wird.
					}
				else {						//Wenn man die Pfeiltaste nach unten dr�ckt.
					sleep(100);				//Es werden 100 ms gewartet.
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
