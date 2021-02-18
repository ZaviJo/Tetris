package Logik;

import Grafik.Block;

public class Kollision {
	public static boolean kollMitBlock(Block b, int direction) {
		switch(direction) {				//-1 für links, 0 für unten, 1 für rechts
		case -1:
			if(b.getY()>0 && b.getX()>0) {
				for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	//geht durch alle Felder des Block(feld)es durch und sieht ob da der Block auch ist 
					for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
						if(b.getGrenzen()[b.getRotation()][i][j]==1) {
							if(Game.map[b.getX()+i-1][b.getY()+j]>= 1) {
								return true;
							}
						}
					}
				}
			}
				
			break;
		case 0:
			if(b.getY()+b.getGroesse()>1 && b.getY()-b.getGroesse()>17) {
				try {
					for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	//geht durch alle Felder des Block(feld)es durch und sieht ob da der Block auch ist 
						for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
							if(b.getGrenzen()[b.getRotation()][i][j]==1) {
								if(Game.map[b.getX()+i][b.getY()+j+1]>= 1) {
									Game.SpawnNeuerBlock = true;
									blockdazu(b);
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
			if(b.getY()>0 && b.getX()<10) {
				for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	//geht durch alle Felder des Block(feld)es durch und sieht ob da der Block auch ist 
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
		try {
			for (int i=0; i<b.getGrenzen()[b.getRotation()].length; i++) {	//geht durch alle Felder des Block(feld)es durch und sieht ob da der Block auch ist 
				for (int j=0; j<b.getGrenzen()[b.getRotation()][i].length; j++) {
					if(b.getGrenzen()[b.getRotation()][i][j]==1) {
						Game.map[b.getX()+i][b.getY()+j] = b.getTypeValue();
							
						
					}
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
