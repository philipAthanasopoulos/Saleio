package main.gui;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class analiticAssociateInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JRadioButton totalSalesRadioButton;
	private JRadioButton salesForAllProductsRadioButton;
	private JRadioButton commissionRadioButton;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_2;


	/**
	 * Create the panel.
	 */
	public analiticAssociateInfoPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		totalSalesRadioButton = new JRadioButton("Total sales");
		totalSalesRadioButton.setBackground(new Color(255, 255, 255));
		totalSalesRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		totalSalesRadioButton.setBounds(0, 7, 243, 23);
		add(totalSalesRadioButton);
		
		salesForAllProductsRadioButton = new JRadioButton("Sales for all product types\r\n");
		salesForAllProductsRadioButton.setBackground(new Color(255, 255, 255));
		salesForAllProductsRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		salesForAllProductsRadioButton.setBounds(0, 33, 243, 23);
		add(salesForAllProductsRadioButton);
		salesForAllProductsRadioButton.addChangeListener( new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (salesForAllProductsRadioButton.isSelected()) {
						chckbxNewCheckBox_1.setSelected(true);
						chckbxNewCheckBox_2.setSelected(true);
						chckbxNewCheckBox_3.setSelected(true);
						chckbxNewCheckBox.setSelected(true);
					} else {
						chckbxNewCheckBox_1.setSelected(false);
						chckbxNewCheckBox_2.setSelected(false);
						chckbxNewCheckBox_3.setSelected(false);
						chckbxNewCheckBox.setSelected(false);
					}
				};
			}
		);
		
		commissionRadioButton = new JRadioButton("Commission\r\n");
		commissionRadioButton.setBackground(new Color(255, 255, 255));
		commissionRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		commissionRadioButton.setBounds(271, 7, 243, 23);
		add(commissionRadioButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 201, 196);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		chckbxNewCheckBox_1 = new JCheckBox("Skirts\r\n");
		panel.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		chckbxNewCheckBox_3 = new JCheckBox("Shirts");
		panel.add(chckbxNewCheckBox_3);
		chckbxNewCheckBox_3.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		chckbxNewCheckBox = new JCheckBox("Coats");
		panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		chckbxNewCheckBox_2 = new JCheckBox("Trousers");
		panel.add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.setFont(new Font("SansSerif", Font.BOLD, 15));
	}
}
