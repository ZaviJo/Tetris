package Grafik;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class kleinesGrid extends JLabel{
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//g.setColor(new Color(222,0,222));					//RGB Werte
		g.setColor(Color.WHITE);							//Grid Farbe
		
		for (int i = 0; i < 4; i++) {						//10 Felder in Breite
			for (int j = 0; j < 4; j++) {					//18 Felder in die Höhe
				g.drawRect(i*48 + 540, j*48, 48, 48);				//48 Länge
			}
		}
		repaint();
	}
}
