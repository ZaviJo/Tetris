package Logik;

public class Umrechnen {
	/*Diese Klasse rechnet die Zell-Koordinaten der Blöcke in Pixel-Koordinaten um und umgekehrt.
	 * 
	 */
	public static int toKoord(int zelle) {
		//Von Zelle zu Pixelkoordinaten.
		return zelle * 48;
	}
	public static int toZelle(int koord) {
		//Von Pixel zu Zellkoordinaten.
		return koord / 48;
	}
}
