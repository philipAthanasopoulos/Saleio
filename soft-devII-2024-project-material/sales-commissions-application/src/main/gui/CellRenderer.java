package main.gui;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;


public class CellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIcon(new ImageIcon("path_to_your_icon.png"));
        label.setHorizontalTextPosition(JLabel.RIGHT);

        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                if(isSelected){
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(getBackground());
                }
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
                super.paintComponent(g);
            }
            
            // @Override
            // protected void paintBorder(Graphics g) {
            //     g.setColor(getForeground());
            //     g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
            // }
        };
        panel.add(label, BorderLayout.CENTER);
        panel.setOpaque(false);
        label.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));     
        return panel;
    }
}