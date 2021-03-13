package Steuerung;
/*Das Package Steuerung beinhaltet die Klassen Datahandler und Keyhandler. In Keyhandler geht es um die Steuerung der wandernden Blöcke.
 * Datahandler ist da, um einen Highscore speichern zu können. Sie greift auf eine Textdatei zu.
 * 
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;		//Beide werden für das Interface KeyListener benötigt.
import Logik.Game;						//Wird für die Instanzvariablen der Klasse Game benötigt (aktuellerBlock, zustand, etc.)
import Logik.Zustand;					//Braucht man für den Aufruf des Zustands des Game.
import Logik.Kollision;					//Braucht man für die Kollisionserkennung.

public class Keyhandler implements KeyListener{
	/*Die Klasse Keyhandler hört die Tastatureingaben ab. Sie implementiert das Interface KeyListener. 
	 *Das Interface beinhaltet die 3 Methoden keyTyped(), keyPressed(), keyReleased().
	 *Diese Methoden werden in dieser Klasse Keyhandler überschrieben.
	 */

	@Override
	public void keyTyped(KeyEvent e) {
		//Die Methode wird aufgerufen, wenn eine Taste gehalten wird. Die Methode wird dann mehrmals durchgeführt.
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Eine Taste muss nach unten gedrückt werden.
		if(Game.zustand == Zustand.start) {
			//Wenn der Spielzustand start ist, muss man die Space-Taste drücken, um das Spiel zu starten.
			if(e.getKeyCode()== KeyEvent.VK_SPACE) {
				Game.zustand = Zustand.ingame;		//Spielzustand wird auf ingame gesetzt.
			}
		}
		if(Game.zustand == Zustand.ingame) {
			//Wenn der Spielzustand nun ingame ist, benutzt man verschiedene Tasten um die Blöcke zu bewegen oder 
			//das Spiel zu pausieren/neuzustarten. 
			if(e.getKeyCode()== KeyEvent.VK_UP) {	//Wenn die obere Pfeiltaste gedrückt wird, rotiert sich der aktuelle Block, wenn es keine Kollision gibt.
				try {
				//In Try-Catch, da es oft Fehlermeldungen gibt.
					if(!Kollision.kollInRot(Game.aktuellerBlock)) {
						Game.aktuellerBlock.rotate();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(e.getKeyCode()== KeyEvent.VK_DOWN) {	//Wenn die untere Pfeiltaste gedrückt wird, beschleunigt sich das Spiel, womit der Block schneller wird.
					Game.schneller = true;			//schneller wird nun auf true gesetzt.
			}
			if(e.getKeyCode()== KeyEvent.VK_LEFT) {	//Wenn man die linke Pfeiltaste drückt, geht der aktuelle Block ein Häuschen nach links, wenn es keine Kollision gibt.
				try {
				//Try-Catch um Spielabbrüche zu vermeiden.
					if(!Kollision.kollMitWand(Game.aktuellerBlock, -1)&&!Kollision.kollMitBlock(Game.aktuellerBlock, -1)) {
						Game.aktuellerBlock.setX(Game.aktuellerBlock.getX()-1);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				
			if(e.getKeyCode()== KeyEvent.VK_RIGHT) {	//Wenn man die rechte Pfeiltaste drückt, geht der aktuelle Block ein Häuschen nach rechts, wenn es keine Kollision gibt
				try {
				//Try-Catch um Spielabbrüche zu vermeiden.
					if(!Kollision.kollMitWand(Game.aktuellerBlock, 1)&&!Kollision.kollMitBlock(Game.aktuellerBlock, 1)) {
						Game.aktuellerBlock.setX(Game.aktuellerBlock.getX()+1);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(e.getKeyCode()== KeyEvent.VK_ESCAPE) {	//Wenn ESC gedrückt wird, pausiert das Spiel. Spielzustand = pause
				Game.zustand = Zustand.pause;
			}
			
		}else if(Game.zustand == Zustand.pause) {		//Wenn das Spiel nun im Zustand pause ist.
			if(e.getKeyCode()== KeyEvent.VK_ESCAPE) {	//Mit der ESC-Taste wird das Spiel fortgesetzt, Zustand = ingame
				Game.zustand = Zustand.ingame;
			}
		}else if(Game.zustand == Zustand.verloren) {	//Wenn das Spiel im Zustand verloren ist, kann man mit der Space-Taste das Spiel direkt neustarten.
			if(e.getKeyCode()== KeyEvent.VK_SPACE) {
				Game.zustand = Zustand.ingame;
				Game.zurücksetzen();					//Methode zurücksetzen in der Klasse Game wird aufgerufen.
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//Diese Methode wird aufgerufen, wenn eine Taste losgelassen wird.
		if(Game.zustand == Zustand.ingame) {	//Wenn das Spiel im ingame Zustand ist, wird beim loslassen einer Taste, das Spiel wieder entschleunigt.
			Game.schneller = false;
			
		}
		
	}

}
