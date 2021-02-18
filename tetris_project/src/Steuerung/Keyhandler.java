package Steuerung;

//Es braucht die 2 imports für das Interface KeyListener.
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Logik.Game;
import Logik.Zustand;

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
		if(Game.zustand == Zustand.start) {
			if(e.getKeyCode()== KeyEvent.VK_SPACE) {
				Game.zustand = Zustand.ingame;
			}
		}
		if(Game.zustand == Zustand.ingame) {
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				Game.aktuellerBlock.rotate();
			}
			if(e.getKeyCode()== KeyEvent.VK_DOWN) {
					Game.schneller = true;
			}
			if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				Game.aktuellerBlock.setX(Game.aktuellerBlock.getX()-1);
			}
				
			if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
				Game.aktuellerBlock.setX(Game.aktuellerBlock.getX()+1);
				
			}
			if(e.getKeyCode()== KeyEvent.VK_ESCAPE) {
				Game.zustand = Zustand.pause;
			}
		}else if(Game.zustand == Zustand.pause) {
			if(e.getKeyCode()== KeyEvent.VK_ESCAPE) {
				Game.zustand = Zustand.ingame;
			}
		}else if(Game.zustand == Zustand.verloren) {
			if(e.getKeyCode()== KeyEvent.VK_SPACE) {
				Game.zustand = Zustand.ingame;
				Game.zurücksetzen();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(Game.zustand == Zustand.ingame) {
			Game.schneller = false;
			
		}
		
	}

}
