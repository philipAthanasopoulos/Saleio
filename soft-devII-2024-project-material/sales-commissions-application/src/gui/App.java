package gui;

import javax.swing.*;

public class App {
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("App");
        mainFrame.setContentPane(new App().mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
