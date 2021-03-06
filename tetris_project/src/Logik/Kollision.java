package Logik;

import Grafik.Block;			//Wird f�r den import von Bl�cken ben�tigt. Bl�cke werde den Parametern der Methoden weitergegeben.
import Steuerung.Datahandler;	//Wird verwendet, um den Highscore zu speichern. 

public class Kollision {
	/*Die Klasse Kollision besteht aus verschiedenen Methoden, die schauen, ob ein Block mit etwas kollidiert.
	 *Zudem werden in dieser Klasse die wichtigen Methoden f�r das Spiel definiert:
	 *blockdazu(), vollereihe(), reiheweg() und verlieren().
	 *Funktionsweise werden bei den Methoden beschrieben. 
	 */
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
	
	public static boolean kollMitWand(Block b, int direction) {
		/*Diese Methode schaut, ob ein Block mit der Wand kollidiert. Es wird der aktuelle Block und die Bewegungsrichtung mitgegeben.
		 *Je nach Richtung geschieht etwas anderes. Bl�cke k�nnen mit W�nden links (-1), rechts(1) oder unten(0) kollidieren.
		 *Es wird ein boolean Wert zur�ckgegeben.
		*/
		switch(direction) {
		
		case -1:
		//Ist links eine Wand?
			for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	
				for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
					if(b.getGrenzen()[b.getRotation()][i][j]==1) {
					//In den vorigen Schleifen und Verzweigungen wird durchgegangen, wie der aktuelle Block aussieht.
						if(b.getX() + i == 0) {
						//Es wird nun gepr�ft, ob der Block am linken Rand angekommen ist.
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
						//Es wird nun gepr�ft, ob der Block am unteren Rand angekommen ist.
							Game.SpawnNeuerBlock = true;	//Wenn man an einem Block unten angekommen ist, will man einen neuen Block erschaffen k�nnen.
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
						if(b.getX()+(i+2) >= 11) {
						//Es wird nun gepr�ft, ob der Block am rechten Rand angekommen ist.
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
		/*In dieser Methode wird gepr�ft, ob beim Rotieren der aktuelle Block mit etwas kollidiert.
		 * Dazu wird zur Vorsicht die Rotation von 4 auf null gestellt.
		 * Es wird ein neuer lokaler Block erstellt, der die Instanzvariablen des aktuellen Blocks b �bernimmt. Dieser lokale Block sch�tzt vor
		 * �berschreiben des echten Blockes. 
		 */
		int rot = b.getRotation() + 1;
		if(rot == 4) {
			rot = 0;
		}
		/*int rot_next = rot+1;
		if(rot_next==4) {
			rot_next = 0;
		}
		*/
		
		Block block = new Block();
		block.setRotation(rot);
		block.setGrenzen(b.getGrenzen());
		block.setGroesse(b.getGroesse());
		block.setX(b.getX());
		block.setY(b.getY());
		
		
		if(b.getY() > 0) {
			//Es wird geschaut, ob der aktuelle Block mit gesetzten Bl�cken in seiner Rotation kollidieren wird. 
				try {
				//Try-Catch um vor Fehler zu sch�tzen.
					for (int i=0; i<b.getGrenzen()[rot].length; i++) {	
						for (int j=0; j<b.getGrenzen()[rot][i].length; j++) {
							if(b.getGrenzen()[rot][i][j]==1) {
								if(Game.map[b.getX()+i][b.getY()+j]>= 1) {
								//>=1 da gesetzte Bl�cke je nach Blocktyp Werte von 1-7 haben. 
									return true;
								}
							}
						}
					}
				} catch (Exception e) {
				//Standardm�ssig sollen bei Fehler keine Bl�cke rotiert werden.
					return true;
				}
			}
		
		try {
		//Try-Catch um vor Fehler zu sch�tzen.
			//Es wird geschaut, ob der aktuelle Block mit W�nden in seiner Rotation kollidieren wird.
				for (int i=0; i<b.getGrenzen()[rot].length; i++) {	
					for (int j=0; j<b.getGrenzen()[rot][i].length; j++) {
						if(b.getGrenzen()[rot][i][j]== 1) {
							if(b.getX()+(i+1) >= 11 || b.getX()+1 == 0) {
								return true;
							}
						}
					}
				}
			} catch (Exception e) {
			//Standardm�ssig sollen bei Fehler keine Bl�cke rotiert werden.
				return true;
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
			Game.zustand = Zustand.verloren; //Wenn ein Block oben ausserhalb des Spielfeld gesetzt wird, hat man verloren. 
		}
		verlieren();	//Nachdem der Block auf dem Spielfeld gespeichert wurde, wird gepr�ft, ob man am oberen Spielfeldrand angekommen ist. 
	}
	public static void volleReihe(int kombo) {
		/*Der Methode volleReihe wird ein Integer Wert �bergeben. 
		 *Sie �berpr�ft, ob eine Reihe voll ist. Das Spielfeld wird von unten nach oben durchgegangen. 
		 */
		int bloeckeinreihe =0;	//Eine Z�hlvariable
		for(int y = 17; y>0; y-- ) {
			//Das Spielfeld wird von oben nach unten durchlaufen. 
			for(int x = 0; x<10; x++) {
				if(Game.map[x][y]>0) {
				//F�r jeden Block in einer Reihe wird die Z�hlvariable um 1 erh�ht. 
					bloeckeinreihe ++;
				}
			}
			if(bloeckeinreihe ==10) {
				//Wenn eine Reihe voll ist, wird der Score um 10*kombo Punkte erh�ht.
				//Wenn gleichzeitig mehrere Reihen voll werden, gibt jede weitere Reihe 10 Punkte mehr. 
				Game.scoreToAdd += (10*kombo);
				reiheweg(y, kombo);	//Die vollen Reihen werden mit der Methode reiheweg() entfernt. Der Punktemultiplikator kombo wird �bergeben. 
				break;
			}else {
				//Wenn nicht, dann wird die Z�hlvariable zur�ckgesetzt. 
				bloeckeinreihe = 0;
			}
		}
		
		Game.score += Game.scoreToAdd;	//Wenn nun alle Reihen gel�scht wurden, werden die gesammelten Punkte auf dem score gespeichert.
		Game.scoreToAdd = 0;			//Wird wieder zur�ckgesetzt.
		
		if(Game.score > Game.highscore) {
		//Wenn der jetzige Score den Highscore �berbietet, wird es �berschrieben.
			Game.highscore= Game.score;
			Datahandler.safe();				//Die Methode safe() der Klasse Datahandler wird aufgerufen. Sie speichert den Highscore permanent. 
		}
	}
	private static void reiheweg(int reihe, int kombo) {
		//Der Methode werden 2 integer Werte �bergeben. Es ist private, da die Methode nur in dieser Klasse verwendet wird.
		//Die Methode geht das Spielfeld wegen dem Verh�ltnis mit der Methode volleReihe() von unten nach oben durch. 
		//Dies ist so, damit keine Reihen falsch �berschrieben werden.
		for (int i = 0; i < Game.map.length; i++) {
			Game.map[i][reihe] = 0;		//Reihe wird zur�ckgesetzt. 
		}
		for (int y = reihe; y >1; y--) {
			//Ab der aktuellen Reihe wird alles eins nach unten geschoben.
			for (int x = 0; x < Game.map.length; x++) {
				Game.map[x][y]= Game.map[x][y-1];	//y-Position eins nach unten. 
			}
			
		}	
		volleReihe(kombo+1);	//Nun wird geschaut, ob weitere Reihen voll sind. Diese geben mehr Punkte; der Multiplikator wird erh�ht.
	}
	private static void verlieren() {
		//Hier wird geschaut, ob man verloren hat. Man hat verloren, wenn die oberste Spielfeldzeile an irgendeiner Stelle gef�llt ist. 
		for(int i = 0; i<Game.map.length; i++) {
			if (Game.map[i][0] > 0) {
				Game.zustand = Zustand.verloren;
			}
		}
	}
}
