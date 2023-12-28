package main.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class GradientButton extends JButton {
    private Color startColor;
    private Color endColor;
    private int radius;

    public GradientButton(String text, Color startColor, Color endColor, int radius) {
        super(text);
        this.startColor = startColor;
        this.endColor = endColor;
        this.radius = radius;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, startColor, 0, h, endColor);
        g2.setPaint(gp);
        Shape shape = new RoundRectangle2D.Double(0, 0, w - 1, h - 1, radius, radius);
        g2.fill(shape);
        g2.dispose();
        super.paintComponent(g);
    }
}