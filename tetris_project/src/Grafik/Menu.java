package Grafik;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Logik.Game;
import Logik.Zustand;

public class Menu extends JLabel {
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		 if(Game.zustand == Zustand.start){
			 g.setColor(new Color(134,179,0));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("Drücke Space zum Starten", 170,Gui.hoehe_dg/2 );
			 
		 }else if(Game.zustand == Zustand.pause){
			 g.setColor(new Color(179,179,179));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("Drücke ESC zum Fortfahren", 175,Gui.hoehe_dg/2 );
			 
		 }else if(Game.zustand == Zustand.verloren){
			 g.setColor(new Color(153,0,0));
			 g.fillRect(0,Gui.hoehe_dg / 2 -50, Gui.breite_dg,100);
			 g.setColor(Color.BLACK);
			 g.drawString("You lost, press Space to git gud", 140,Gui.hoehe_dg/2 );
			
			 
		 }
		 repaint();
	}
}
