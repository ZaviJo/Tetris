package Steuerung;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;		//Beide werden für das Interface KeyListener benötigt.
import Logik.Game;						
import Logik.Zustand;					//Braucht man für den Aufruf des aktuellen Blockes und des Zustands des Game.

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
			if(e.getKeyCode()== KeyEvent.VK_UP) {	//Wenn die obere Pfeiltaste gedrückt wird, rotiert sich der aktuelle Block.
				Game.aktuellerBlock.rotate();
			}
			if(e.getKeyCode()== KeyEvent.VK_DOWN) {	//Wenn die untere Pfeiltaste gedrückt wird, beschleunigt sich das Spiel, womit der Block schneller wird.
					Game.schneller = true;			//schneller wird nun auf true gesetzt.
			}
			if(e.getKeyCode()== KeyEvent.VK_LEFT) {	//Wenn man die linke Pfeiltaste drückt, geht der aktuelle Block ein Häuschen nach links.
				Game.aktuellerBlock.setX(Game.aktuellerBlock.getX()-1);
			}
				
			if(e.getKeyCode()== KeyEvent.VK_RIGHT) {	//Wenn man die rechte Pfeiltaste drückt, geht der aktuelle Block ein Häuschen nach rechts.
				Game.aktuellerBlock.setX(Game.aktuellerBlock.getX()+1);
				
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
