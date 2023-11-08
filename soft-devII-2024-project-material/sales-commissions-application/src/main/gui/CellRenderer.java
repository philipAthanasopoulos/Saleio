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
import javax.swing.JButton;
import java.awt.Color;



public class CellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setForeground(Color.BLACK);
        label.setIcon(new ImageIcon("path_to_your_icon.png"));
        label.setHorizontalTextPosition(JLabel.RIGHT);

        JButton button = new JButton("Remove");
        button.setBackground(Color.RED);
        button.addActionListener(e -> {
            // code to remove associate goes here
        });

        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
                super.paintComponent(g);
            }
            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(getForeground());
                g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
            }
        };
        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);
        panel.setOpaque(false);
        label.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));        
        return panel;
    }
}