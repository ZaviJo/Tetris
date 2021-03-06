package Main;

import Grafik.Block;		//Für die Blockerstellung des nächsten Blockes wichtig.
import Logik.Game;			//Wird benötigt, um auf die Instanzvariablen der Klasse Game zugreifen zu können
import Logik.Zustand;		//Wird für die Zustandsabfrage des Games benötigt.
import Logik.Kollision;		//Wird für die Kollisionserkennung verwendet.

public class Spielloop extends Thread {
	/*Spielloop ist eine Erweiterung der Klasse Thread. Threads werden benutzt, um gleichzeitig mehrere Operationen effizient durchführen zu können.
	 * Hier wird das Spiel dauernd aktualisiert.
	 */
	private boolean laufend = true;
	
	public void run() {				
	/*Methode run() wird überschrieben, um unser eigenes Programm einfügen zu können. 
	 */
		while(laufend) {
			try {
			/*Try-Catch wird verwendet, um Fehler während des try auffangen zu können.
			 * 
			 */
				if(Game.zustand == Zustand.ingame) { 						//Wird ausgeführt, wenn der Zustand des Spiels ingame ist. Nur dann werden Sachen aktualisiert.
					if(!Kollision.kollMitWand(Game.aktuellerBlock, 0)&&!Kollision.kollMitBlock(Game.aktuellerBlock, 0)) {
					//Wenn es keine Kollision mit der Wand gibt oder mit einem Block nach unten gibt.
						Game.aktuellerBlock.setY(Game.aktuellerBlock.getY()+1);		//Der Block wird um 1 Zelle nach unten bewegt.
						//Kollision.kollMitWand(Game.aktuellerBlock, 0);		//Prüfen, ob unten eine Wand ist.
					}
					
					
					if(Game.SpawnNeuerBlock) {								//Wenn ein neuer Block erstellt werden muss. Hier: SpawnNeuerBlock = true.
						Kollision.volleReihe(1);
						Game.blocks.add(Game.naechsterBlock);				//naechsterBlock wird der Arraylist hinzugefügt.
						Game.aktuellerBlock = Game.naechsterBlock;			//aktuellerBlock wird überschrieben
						Game.naechsterBlock = new Block();					//ein neuer Block wird erstellt.
						Game.SpawnNeuerBlock = false;
					}
				}
			
				if(!Game.schneller) {		//Wird aufgerufen, wenn man nicht die Pfeiltaste nach unten drückt.
					sleep(Game.warten);			//Es wird 1 Sekunde gewartet, bis die nächste Operation durchgeführt wird.
					if (Game.warten > 100) {
						Game.warten -= 5;
					}
				}
				else {						//Wenn man die Pfeiltaste nach unten drückt.
					sleep(100);				//Es werden 100 ms gewartet.
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
