package Logik;

import Grafik.Block;		//Wird f�r den import von Bl�cken ben�tigt. Bl�cke werde den Parametern der Methoden weitergegeben.

public class Kollision {
	//Die Klasse Kollision besteht aus verschiedenen Methoden, die schauen, ob ein Block mit etwas kollidiert.
	public static boolean kollMitBlock(Block b, int direction) {
		/*Diese Methode schaut, ob ein Block mit einem anderen stehenden Block kollidiert. Es wird der aktuelle Block und die Bewegungsrichtung mitgegeben.
		 *Je nach Richtung geschieht etwas anderes. Bl�cke k�nnen mit anderen Bl�cken links (-1), rechts(1) oder unten(0) kollidieren.
		*/
		switch(direction) {	
		case -1:
			//Wenn der aktuelle Block nach links geht.
			if(b.getY()>0 && b.getX()>0) {	
			//Block muss im Spielfeld sein.
				for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	
					//Da die Bl�cke meistens in einem 3x3 Raster sind, muss dies durchgegangen werden, um zu schauen, wie der Block gerade aussieht.
					//Wenn ein H�uschen 1 ist, wird dies in diesen Schleifen erkannt.
					for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
						if(b.getGrenzen()[b.getRotation()][i][j]==1) {
						//Wenn nun ein H�uschen gefunden wurde, das gef�llt ist, wird dies fortgesetzt.
							if(Game.map[b.getX()+i-1][b.getY()+j]>= 1) {
							//Hier wird nun gepr�ft, ob die angehende Richtung (Hier: links) schon von einem sitzenden Block (>= 1) besetzt ist.
							//Wenn nicht, kann der akutelle Block nach links.
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
			 *Das Ganze ist auch in einem Try-Catch, damit das Programm nicht abst�rzt, wenn ein Array einmal outofbounds ist.
			 *
			 */
				try {
					for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) { 
						for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
							if(b.getGrenzen()[b.getRotation()][i][j]==1) {
								if(Game.map[b.getX()+i][b.getY()+j+1]>= 1) {
									Game.SpawnNeuerBlock = true;		//Wenn man an einem Block unten angekommen ist, will man einen neuen Block erschaffen k�nnen.
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
	}
}
