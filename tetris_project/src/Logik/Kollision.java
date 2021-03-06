package Logik;

import java.util.Iterator;

import Grafik.Block;		//Wird für den import von Blöcken benötigt. Blöcke werde den Parametern der Methoden weitergegeben.
import Steuerung.Datahandler;

public class Kollision {
	//Die Klasse Kollision besteht aus verschiedenen Methoden, die schauen, ob ein Block mit etwas kollidiert.
	public static boolean kollMitBlock(Block b, int direction) {
		/*Diese Methode schaut, ob ein Block mit einem anderen stehenden Block kollidiert. Es wird der aktuelle Block und die Bewegungsrichtung mitgegeben.
		 *Je nach Richtung geschieht etwas anderes. Blöcke können mit anderen Blöcken links (-1), rechts(1) oder unten(0) kollidieren.
		*/
		switch(direction) {	
		case -1:
			//Wenn der aktuelle Block nach links geht.
			if(b.getY()>0 && b.getX()>0) {	
			//Block muss im Spielfeld sein.
				for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	
					//Da die Blöcke meistens in einem 3x3 Raster sind, muss dies durchgegangen werden, um zu schauen, wie der Block gerade aussieht.
					//Wenn ein Häuschen 1 ist, wird dies in diesen Schleifen erkannt.
					for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
						if(b.getGrenzen()[b.getRotation()][i][j]==1) {
						//Wenn nun ein Häuschen gefunden wurde, das gefüllt ist, wird dies fortgesetzt.
							if(Game.map[b.getX()+i-1][b.getY()+j]>= 1) {
							//Hier wird nun geprüft, ob die angehende Richtung (Hier: links) schon von einem sitzenden Block (>= 1) besetzt ist.
							//Wenn nicht, kann der aktuelle Block nach links.
								return true;
								//Es gibt nun eine Kollision, wenn links ein Block ist.
							}
						}
					}
				}
			}
			break;
			
		case 0:
			//Wenn der aktuelle Block nach unten geht.
			if(b.getY()+b.getGroesse()>1 && b.getY()-b.getGroesse() < 17) {
			/*Man muss innerhalb des Spielfelds sein. X-Richtung ist hier nicht wichtig.
			 *Die Funktionsweise der Schleife ist gleich wie case -1, jedoch wird geschaut ob unten schon ein platzierter Block ist. 
			 *Das Ganze ist auch in einem Try-Catch, damit das Programm nicht abstürzt, wenn ein Array einmal outofbounds ist.
			 *
			 */
				try {
					for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) { 
						for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
							if(b.getGrenzen()[b.getRotation()][i][j]==1) {
								if(Game.map[b.getX()+i][b.getY()+j+1]>= 1) {
									Game.SpawnNeuerBlock = true;		//Wenn man an einem Block unten angekommen ist, will man einen neuen Block erschaffen können.
									blockdazu(b);						
									//Die Methode blockdazu() wird aufgerufen, um den aktuellen Block auf dem Spielfeld zu speichern.
									//Dies ist nur in diesem Case der Fall, da wenn ein platzierter Block links oder rechts ist, kann man immer noch nach unten.
									return true;
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
			
		case 1:
			//Wenn der aktuelle Block nach rechts geht.
			//Dies funktioniert gleich wie case -1, jedoch wird geschaut, ob rechts schon ein platzierter Block ist.
			if(b.getY()>0 && b.getX()<10) {
				for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	
					for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
						if(b.getGrenzen()[b.getRotation()][i][j]==1) {
							if(Game.map[b.getX()+i+1][b.getY()+j]>= 1) {
								return true;
							}
						}
					}
				}
			}
			break;
		}
		
		return false;
	}
	
	public static boolean kollMitWand(Block b, int direction) {
		/*Diese Methode schaut, ob ein Block mit der Wand kollidiert. Es wird der aktuelle Block und die Bewegungsrichtung mitgegeben.
		 *Je nach Richtung geschieht etwas anderes. Blöcke können mit Wänden links (-1), rechts(1) oder unten(0) kollidieren.
		 *Es wird ein boolean Wert zurückgegeben.
		*/
		switch(direction) {
		
		case -1:
		//Ist links eine Wand?
			for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	
				for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
					if(b.getGrenzen()[b.getRotation()][i][j]==1) {
					//In den vorigen Schleifen und Verzweigungen wird durchgegangen, wie der aktuelle Block aussieht.
						if(b.getX() + i == 0) {
						//Es wird nun geprüft, ob der Block am linken Rand angekommen ist.
							return true;
						}	
					}
				}
			}
			break;
			
		case 0:
		//Ist unten eine Wand?
			for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	
				for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
					if(b.getGrenzen()[b.getRotation()][i][j]==1) {
					//In den vorigen Schleifen und Verzweigungen wird durchgegangen, wie der aktuelle Block aussieht.
						if(b.getY() + j == 17) {
						//Es wird nun geprüft, ob der Block am unteren Rand angekommen ist.
							Game.SpawnNeuerBlock = true;	//Wenn man an einem Block unten angekommen ist, will man einen neuen Block erschaffen können.
							blockdazu(b);
							//Die Methode blockdazu() wird aufgerufen, um den aktuellen Block auf dem Spielfeld zu speichern.
							//Dies ist nur in diesem Case der Fall, da wenn ein platzierter Block links oder rechts ist, kann man immer noch nach unten.
							return true;
						}	
					}
				}
			}
			break;
			
		case 1:
		//Ist rechts eine Wand?
			for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	
				for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
					if(b.getGrenzen()[b.getRotation()][i][j]==1) {
					//In den vorigen Schleifen und Verzweigungen wird durchgegangen, wie der aktuelle Block aussieht.
						if(b.getX() + (i+2) >= 11) { //i == 9????
						//Es wird nun geprüft, ob der Block am rechten Rand angekommen ist.
						//Es ist (i+2), ?????????
							return true;
						}	
					}
				}
			}
			break;
		}
		
		return false;
	}
	
	public static boolean kollInRot(Block b) {
		/*In dieser Methode wird geprüft, ob beim Rotieren der aktuelle Block mit etwas kollidiert.
		 * Dazu wird zur Vorsicht die Rotation von 4 auf null gestellt.
		 * Es wird ein neuer lokaler Block erstellt, der die Instanzvariablen des aktuellen Blocks b übernimmt. Dieser lokale Block schützt vor
		 * Überschreiben des echten Blockes. 
		 */
		int rot = b.getRotation();
		if(rot == 4) {
			rot = 0;
		}
		
		Block block = new Block();
		block.setRotation(rot);
		block.setGrenzen(b.getGrenzen());
		block.setGroesse(b.getGroesse());
		block.setX(b.getX());
		block.setY(b.getY());
		
		if(kollMitWand(block, 1)) {
			//Wenn man an der rechten Wand ist, soll man nicht rotieren.
			return true;
		}
		
		block.setX(b.getX()+2);		//+2, damit man den Block ein wenig nach rechts setzt.
		if(kollMitWand(block, -1)) {
			//Wenn man an der linken Wand ist, soll man nicht rotieren.
			return true;
		}
		
		if(b.getY() > 0) {
		//Es wird geschaut, ob der aktuelle Block mit gesetzten Blöcken kollidiert.
			try {
			//Try-Catch um vor Fehler zu schützen.
				for (int i=0; i<b.getGrenzen()[rot].length; i++) {	
					for (int j=0; j<b.getGrenzen()[rot][i].length; j++) {
						if(b.getGrenzen()[rot][i][j]==1) {
							if(Game.map[b.getX()+i-1][b.getY()+j]>= 1) {
								return true;
							}
						}
					}
				}
			} catch (Exception e) {
			//Standardmässig sollen bei Fehler keine Blöcke rotiert werden.
				return true;
			}
		}
		
		
		return false;
	}
	
	private static void blockdazu(Block b) {
		//Diese Methode speichert den aktuellen Block b auf dem Spielfeld mit seiner entsprechenden Zahl (I = 1, J = 2, L = 3, usw.)
		try {
			for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	
				//geht durch alle Felder des Block(feld)es durch und sieht ob da der Block auch ist. Gleiche Schleife wie case -1.
				for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
					if(b.getGrenzen()[b.getRotation()][i][j]==1) {
						Game.map[b.getX()+i][b.getY()+j] = b.getTypWert();	//Der Blocktyp wird mit seiner entsprechenden Nummer auf dem Spielfeld gespeichert.
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		verlieren();
	}
	public static void volleReihe(int kombo) {
		int bloekeinreihe =0;
		for(int y = Game.map[0].length-1; y >0; y-- ) {
			for(int x = 0; x<Game.map.length; x++) {
				if(Game.map[x][y]>0) {
					bloekeinreihe ++;
				}
			}
			if(bloekeinreihe ==10) {
				Game.scoreToAdd += (10*kombo);
				reiheweg(y, kombo);
				break;
			}else {
				bloekeinreihe = 0;
			}
		}
		
		Game.score += Game.scoreToAdd;
		Game.scoreToAdd = 0;
		
		if(Game.score > Game.highscore) {
			Game.highscore= Game.score;
			Datahandler.safe();
		}
	}
	private static void reiheweg(int reihe, int kombo) {
		for (int i = 0; i < Game.map.length; i++) {
			Game.map[i][reihe] = 0;
		}
		for (int y = reihe; y >1; y--) {
			for (int x = 0; x < Game.map.length; x++) {
				Game.map[x][y]= Game.map[x][y-1];
			}
			
		}	
		volleReihe(kombo+1);
	}
	private static void verlieren() {
		for(int i = 0; i<Game.map.length; i++) {
			if (Game.map[i][0] > 0) {
				Game.zustand = Zustand.verloren;
			}
		}
	}
}
