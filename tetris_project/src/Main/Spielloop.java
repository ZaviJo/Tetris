package Main;

import Grafik.Block;		//F�r die Blockerstellung des n�chsten Blockes wichtig.
import Logik.Game;			//Wird ben�tigt, um auf die Instanzvariablen der Klasse Game zugreifen zu k�nnen
import Logik.Zustand;		//Wird f�r die Zustandsabfrage des Games ben�tigt.
import Logik.Kollision;		//Wird f�r die Kollisionserkennung und Spielmechanik verwendet.

public class Spielloop extends Thread {
	/*Spielloop ist eine Erweiterung der Klasse Thread. Threads werden benutzt, um gleichzeitig mehrere Operationen effizient durchf�hren zu k�nnen.
	 *Hier wird das Spiel dauernd aktualisiert: Die erstellten Bl�cke gehen nach unten; neue Spielbl�cke werden aufgerufen, das Spiel wird beschleunigt. 
	 */
	private boolean laufend = true;
	
	public void run() {				
	/*Methode run() wird �berschrieben, um unser eigenes Programm einf�gen zu k�nnen. 
	 */
		while(laufend) {
			try {
			/*Try-Catch wird verwendet, um Fehler w�hrend des try auffangen zu k�nnen.
			 * 
			 */
				if(Game.zustand == Zustand.ingame) { 						//Wird ausgef�hrt, wenn der Zustand des Spiels ingame ist. Nur dann werden Sachen aktualisiert.
					if(!Kollision.kollMitWand(Game.aktuellerBlock, 0)&&!Kollision.kollMitBlock(Game.aktuellerBlock, 0)) {
					//Wenn es keine Kollision mit der Wand gibt oder mit einem Block nach unten gibt.
						Game.aktuellerBlock.setY(Game.aktuellerBlock.getY()+1);		//Der Block wird um 1 Zelle nach unten bewegt.
					}
					
					
					if(Game.SpawnNeuerBlock) {								//Wenn ein neuer Block erstellt werden muss. Hier: SpawnNeuerBlock = true.
						Kollision.volleReihe(1);							//Es wird die Methode volleReihe() aufgerufen und der Wert 1 �bergeben.
						Game.blocks.add(Game.naechsterBlock);				//naechsterBlock wird der Arraylist hinzugef�gt.
						Game.aktuellerBlock = Game.naechsterBlock;			//aktuellerBlock wird �berschrieben
						Game.naechsterBlock = new Block();					//ein neuer Block wird erstellt.
						Game.SpawnNeuerBlock = false;
					}
				}
			
				if(!Game.schneller) {			//Wird aufgerufen, wenn man nicht die Pfeiltaste nach unten dr�ckt.
					sleep(Game.warten);			//Es wird 1 Sekunde gewartet, bis die n�chste Operation durchgef�hrt wird.
					if (Game.warten > 100) {	//Jede Blockbewegung nach unten wird die Geschwindigkeit um 0.5 % erh�ht bis zu einer Wartezeit von 100ms pro Bewegung.
						Game.warten = Game.warten - (Game.warten/200);
					}
				}
				else {						//Wenn man die Pfeiltaste nach unten dr�ckt.
					sleep(100);				//Es werden nur noch 100 ms gewartet.
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
