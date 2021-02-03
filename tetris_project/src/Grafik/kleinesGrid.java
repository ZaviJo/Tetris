package Grafik;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class kleinesGrid extends JLabel{
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.white);							//Grid Farbe
		
		for (int i = 0; i < 4; i++) {						//10 Felder in Breite
			for (int j = 0; j < 4; j++) {					//18 Felder in die Höhe
				g.drawRect(i*48, j*48, 48, 48);				//48 Länge
			}
		}
		repaint();
	}
}
