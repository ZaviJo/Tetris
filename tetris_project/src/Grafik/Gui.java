package Grafik;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui {
	public static int breite	= 797;							//H�he des Fensters
	public static int hoehe		= 904;							//Breite des Fensters
	JFrame frame;
	
	public void Fenster () {
		frame = new JFrame("Tetris");							//Name oben im Fenster�
		frame.setSize(breite, hoehe);				//300 oder 100 f�r Fenster Raum f�r Highscore
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X f�r Fenster dass es sich schliessen l�sst
		//frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		//frame.setLayout(null);
		//frame.requestFocus();
		frame.setVisible(true);									//Fenster ausgeben
		
		Grid dg = new Grid();									//dg -- drawgrid
		setupDraw(dg,0,0,breite,hoehe);						//0,0 sind x,y Werte
	}
	
	private void setupDraw(JLabel draw, int x, int y, int breite, int hoehe) {
		draw.setBounds(x,y,breite,hoehe);
		draw.setVisible(true);
		frame.add(draw);
	}
}
