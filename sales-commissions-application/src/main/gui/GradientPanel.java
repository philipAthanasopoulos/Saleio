package main.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GradientPanel extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int width = getWidth();
		int height = getHeight();
		//black color rgb
		Color color1 = new Color(0, 0, 0);
		Color color2 = new Color(45, 45, 117);
		GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, width, height);
	}
}
