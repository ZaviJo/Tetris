package Grafik;

import java.awt.Color;				//Wird für die Farbauswahl eines Blockes verwendet

public class Block {
	/*In dieser Klasse werden die Blöcke gebildet. Jeder Block hat einen Typen, eine Position, Grösse
	 *und Rotation. Jeder Block wird auch mit einem dreidimensionalem Array definiert, der als Informationen
	 *die Rotation des Blockes und das Aussehen des Blockes beinhaltet. Jeder Block hat auch eine Farbe.
	 * 
	 */
	Blocktyp typ;					
	int x,y,groesse,rotation = 0;
	int [][][] grenzen;				
	Color color;
	//boolean beweglich = true;
	
	public Block() {
		typ = Blocktyp.zufall();
		switch(typ) {
		case I:
			groesse = 4;
			color = Color.magenta;
			break;
		case J:
			groesse = 3;
			color = Color.orange;
			break;
		case L:
			groesse = 3;
			color = Color.red;
			break;
		case O:
			groesse = 2;
			color = Color.yellow;
			break;
		case S:
			groesse = 3;
			color = Color.cyan;
			break;
		case T:
			groesse = 3;
			color = Color.green;
			break;
		case Z:
			groesse = 3;
			color = Color.blue;
			break;
		}
		
		x = 4;						//Mitte des Spielfeldes
		y = -2;						//Block soll oberhalb des Spielfeldes starten.
	}
	
	public void rotate() {
		rotation++;
	}
	
	public int[][][] blockBilder(Blocktyp typ) {
		int [][][] grenzen = null;
		switch (typ) {
		case I:
			int[][][] grenzen_I = { { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
					{ { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 } },
					{ { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 } },
					{ { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 0, 0 } } };
			grenzen = grenzen_I;
			break;
		case J:
			int[][][] grenzen_J = { { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } },
					{ { 0, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 } }, 
					{ { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 } },
					{ { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 0 } } };
			grenzen = grenzen_J;
			break;
		case L:
			int[][][] grenzen_L = { { { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } },
					{ { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 } }, 
					{ { 0, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 } },
					{ { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } } };
			grenzen = grenzen_L;
			break;
		case O:
			int[][][] grenzen_O = { { { 1, 1 }, { 1, 1 } },
					{ { 1, 1 }, { 1, 1 } }, 
					{ { 1, 1 }, { 1, 1 } },
					{ { 1, 1 }, { 1, 1 } } } ;
			grenzen = grenzen_O;
			break;
		case S:
			int[][][] grenzen_S = { { { 0, 1, 1 }, { 1, 1, 0 }, { 0, 0, 0 } },
					{ { 0, 1, 0 }, { 0, 1, 1 }, { 0, 0, 1 } }, 
					{ { 0, 0, 0 }, { 0, 1, 1 }, { 1, 1, 0 } },
					{ { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 } } };
			grenzen = grenzen_S;
			break;
		case T:
			int[][][] grenzen_T = { { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 0, 0 } },
					{ { 0, 1, 0 }, { 0, 1, 1 }, { 0, 1, 0 } }, 
					{ { 0, 0, 0 }, { 1, 1, 1 }, { 0, 1, 0 } },
					{ { 0, 1, 0 }, { 1, 1, 0 }, { 0, 1, 0 } } };
			grenzen = grenzen_T;
			break;
		case Z:
			int[][][] grenzen_Z = { { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 0 } },
					{ { 0, 0, 1 }, { 0, 1, 1 }, { 0, 1, 0 } }, 
					{ { 0, 0, 0 }, { 1, 1, 0 }, { 0, 1, 1 } },
					{ { 0, 1, 0 }, { 1, 1, 0 }, { 1, 0, 0 } } };
			grenzen = grenzen_Z;
			break;
		}
		
		return grenzen;
	}
	
		

}
