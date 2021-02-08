package Main;

import Grafik.Block;
import Logik.Game;
import Logik.Zustand;

public class Spielloop extends Thread{
	private boolean laufend = true;
	
	//@Override //vllt ka
	public void lauf() {
		
		while(laufend) {
			try {
				if(Game.zustand == Zustand.start) {
					
					Game.aktuellerBlock.setY(Game.aktuellerBlock.getY()+1);
					
					if(Game.SpawnNeuerBlock) {
						Game.blocks.add(Game.naechsterBlock);
						Game.aktuellerBlock = Game.naechsterBlock;
						Game.naechsterBlock = new Block();
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
