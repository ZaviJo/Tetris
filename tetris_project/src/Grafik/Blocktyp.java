package Grafik;

import java.util.concurrent.ThreadLocalRandom;

public enum Blocktyp {
	/*Jeder entstehende Block kann von der Form ein I,J,L,O,S,T,Z sein. Daher ist es von Vorteil
	 *Enumerations zu verwenden, da sie eine Spezialklasse ist, die eine Gruppe von Konstanten
	 *repr�sentiert.
	 */
	I,J,L,O,S,T,Z;
	
	public static Blocktyp random() {
		/*Dies ist eine Methode, um einen zuf�lligen Block zu erstellen, der in dieser Klasse ist.
		 *Die Methode gibt ein ... mit dem Datentyp Blocktyp zur�ck.
		 */
		return values()[ThreadLocalRandom.current().nextInt(0,values().length)];
		/*
		 * 
		 */
	}
}
