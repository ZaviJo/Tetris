package Logik;

public class Umrechnen {
	public static int toKoord(int zelle) {
		return zelle * 48;
	}
	public static int toZelle(int koord) {
		return koord / 48;
	}
}
