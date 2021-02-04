package Grafik;

import java.awt.Color;				//Wird f�r die Farbauswahl eines Blockes verwendet

public class Block {
	/*In dieser Klasse werden die Bl�cke gebildet. Jeder Block hat einen Typen, eine Position, Gr�sse
	 *und Rotation. Jeder Block wird auch mit einem dreidimensionalem Array definiert, der als Informationen
	 *die Rotation des Blockes und das Aussehen des Blockes beinhaltet. Jeder Block hat auch eine Farbe.
	 */
	Blocktyp typ;					
	int x,y,groesse,rotation = 0;
	int [][][] grenzen;				
	Color color;
	
	public Block() {
		typ = Blocktyp.zufall();	//Es wird ein zuf�lliger Block ausgew�hlt.
		switch(typ) {
		/*Switch Statements werden oft im Zusammenhang mit Enum-Klassen verwendet. Sie funktionieren �hnlich wie Verzweigungen,
		 *es wird jedoch nur gepr�ft ob Werte gleich sind.
		 *In diesem Konstruktor wird je nach Fall, die Gr�sse und Farbe festgesetzt. Alle Bl�cke werden oberhalb der Mitte des
		 *Spielfelds erstellt. Die Grenzen werden mit der Methode blockBilder() festgesetzt.
		 */
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
		
		x = 4;						
		y = -2;					
		grenzen = blockBilder(typ);
	}
	
	public void rotate() {
		/*Diese Methode wird beim Rotieren der Bl�cke noch wichtig werden, damit die Rotationszahl nicht �ber 4 geht,
		 *da es nur 4 Rotationsarten gibt.
		 */
		rotation++;
		if(rotation == 4) {
			rotation = 0;
		}
	}
	
	public int[][][] blockBilder(Blocktyp typ) {
		/*In dieser Methode werden die Bl�cke je nach Typ mit ihren Grenzen festgesetzt. Alle Grenzen bestehen in der
		 *1. Dimension aus ihrer Anzahl Rotationen, was immer 4 ist. Die 2. und 3. Dimension legen fest, wie der Block
		 *aussieht. Die meisten Bl�cke haben ein 3*3 Raster ausser der I-Block mit 4*4 und der O-Block mit 2*2. Wenn in
		 *diesen Rastern eine 1 steht, ist ein Quadrant gef�llt. 
		 *Die Methode gibt ein dreidimensionales Array mit Datentyp int f�r jeden erstellten Block aus.
		 */
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
	
	/*Folgend sind alle Getters und Setters aufgelistet. Im sp�teren Verlauf k�nnten wir die Eigenschaften der Bl�cke noch ver�ndern.
	 * 
	 */
	public Blocktyp getTyp() {
		return typ;
	}

	public void setTyp(Blocktyp typ) {
		this.typ = typ;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int[][][] getGrenzen() {
		return grenzen;
	}

	public void setGrenzen(int[][][] grenzen) {
		this.grenzen = grenzen;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
		

}
