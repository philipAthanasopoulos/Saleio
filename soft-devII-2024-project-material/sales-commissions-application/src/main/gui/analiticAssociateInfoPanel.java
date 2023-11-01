package main.gui;

import main.domain.ProductType;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

public class analiticAssociateInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JRadioButton totalSalesRadioButton;
	private JRadioButton salesForAllProductsRadioButton;
	private JRadioButton commissionRadioButton;
	private JPanel panel;


	/**
	 * Create the panel.
	 */
	public analiticAssociateInfoPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		
		commissionRadioButton = new JRadioButton("Commission\r\n");
		commissionRadioButton.setBackground(new Color(255, 255, 255));
		commissionRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		commissionRadioButton.setBounds(271, 7, 243, 23);
		add(commissionRadioButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 201, 196);
		add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		for(ProductType productType : ProductType.values()) {
			JCheckBox checkBox = new JCheckBox(productType.toString());
			checkBox.setFont(new Font("SansSerif", Font.BOLD, 15));
			panel.add(checkBox);
		}

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
		salesForAllProductsRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component component : panel.getComponents()) {
					if(component instanceof JCheckBox) {
						JCheckBox checkBox = (JCheckBox) component;
						if (salesForAllProductsRadioButton.isSelected()) checkBox.setSelected(true);
						else checkBox.setSelected(false);
					}
				}
			}
		});
	}
}
