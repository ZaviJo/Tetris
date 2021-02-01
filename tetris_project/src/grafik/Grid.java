package grafik;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

public class Grid extends JLabel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(222,0,222));					//RGB Werte
		//g.setColor(Color.black);							//Grid Farbe
		
		for (int i = 0; i < 10; i++) {						//10 Felder in Breite
			for (int j = 0; j < 18; j++) {					//18 Felder in die H�he
				g.drawRect(i*48, j*48, 48, 48);				//48 L�nge
			}
		}
		
		
		repaint();
	}
}
