package Grafik;

import java.util.concurrent.ThreadLocalRandom; //Wird f�r die Auswahl eines zuf�lligen Blockes verwendet.

public enum Blocktyp {
	/*Jeder entstehende Block kann von der Form ein I,J,L,O,S,T,Z sein. Daher ist es von Vorteil
	 *Enumerations zu verwenden, da sie eine Spezialklasse ist, die eine Gruppe von Konstanten
	 *repr�sentiert.
	 *In dieser Klasse werden die Blocktypen definiert und ein zuf�lliger Blocktyp gew�hlt.
	 */
	I,J,L,O,S,T,Z;
	
	public static Blocktyp zufall() {
		/*Dies ist eine Methode, um einen zuf�lligen Block zu erstellen, der in dieser Klasse ist.
		 *Die Methode gibt ein Array mit dem Datentyp Blocktyp zur�ck.
		 */
		return values()[ThreadLocalRandom.current().nextInt(0,values().length)];
		/*Die Methode values() liefert ein Array, bestehend aus den 7 Konstanten der Klasse Blocktyp.
		 * ThreadLocalRandom.current() kreiert eine Zufallszahl zwischen 0 bis values.length-1. 
		 * In unserer Klasse Blocktyp k�nnen diese Zahlen 0,1,2,3,4,5,6 sein, da wir 7 Elemente haben.
		 */
	}
}
