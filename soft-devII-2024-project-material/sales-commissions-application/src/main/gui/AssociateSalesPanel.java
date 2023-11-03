package main.gui;

import main.domain.ProductType;
import main.domain.Associate;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;

public class AssociateSalesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JRadioButton totalSalesRadioButton;
	private JRadioButton salesForAllProductsRadioButton;
	private JRadioButton commissionRadioButton;
	private JPanel productTypePanel;
	private JScrollPane productTypeScrollPane;
	private JScrollPane associateReportScrollPane;
	private JPanel associateReportPanel;
	private JLabel associateNameLabel;
	private JLabel associateAfmLabel;
	private JLabel associateNameValueLabel;
	private JLabel associateAfmValueLabel;
	private JLabel totalSalesLabel;
	private JLabel totalSalesValueLabel;
	private JLabel commissionLabel;
	private JLabel commissionValueLabel;
	private Associate associate = new Associate();

	/**
	 * Create the panel.
	 */
	public AssociateSalesPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		commissionRadioButton = new JRadioButton("Commission\r\n");
		commissionRadioButton.setBackground(new Color(255, 255, 255));
		commissionRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		commissionRadioButton.setBounds(271, 7, 243, 23);
		add(commissionRadioButton);
		commissionRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(commissionRadioButton.isSelected()) {
					commissionValueLabel.setText(String.valueOf(associate.calculateCommission()));
				} else {
					commissionValueLabel.setText("");
				}
			}
		});
		
		productTypeScrollPane = new JScrollPane();
		productTypeScrollPane.setBounds(10, 63, 201, 196);
		add(productTypeScrollPane);
		
		productTypePanel = new JPanel();
		productTypeScrollPane.setViewportView(productTypePanel);
		productTypePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		for(ProductType productType : ProductType.values()) {
			JCheckBox checkBox = new JCheckBox(productType.toString());
			checkBox.setFont(new Font("SansSerif", Font.BOLD, 15));
			productTypePanel.add(checkBox);
		}

		totalSalesRadioButton = new JRadioButton("Total sales");
		totalSalesRadioButton.setBackground(new Color(255, 255, 255));
		totalSalesRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		totalSalesRadioButton.setBounds(0, 7, 243, 23);
		add(totalSalesRadioButton);
		totalSalesRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(totalSalesRadioButton.isSelected()) {
					totalSalesValueLabel.setText(String.valueOf(associate.calculateTotalSales()));
				} else {
					totalSalesValueLabel.setText("");
				}
			}
		});
		
		salesForAllProductsRadioButton = new JRadioButton("Sales for all product types\r\n");
		salesForAllProductsRadioButton.setBackground(new Color(255, 255, 255));
		salesForAllProductsRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		salesForAllProductsRadioButton.setBounds(0, 33, 243, 23);
		add(salesForAllProductsRadioButton);
		
		associateReportScrollPane = new JScrollPane();
		associateReportScrollPane.setBounds(10, 310, 541, 306);
		add(associateReportScrollPane);
		
		associateReportPanel = new JPanel();
		associateReportScrollPane.setViewportView(associateReportPanel);
		associateReportPanel.setLayout(null);
		
		associateNameLabel = new JLabel("Name:");
		associateNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		associateNameLabel.setBounds(10, 11, 45, 14);
		associateReportPanel.add(associateNameLabel);
		
		associateAfmLabel = new JLabel("AFM:");
		associateAfmLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		associateAfmLabel.setBounds(10, 36, 45, 14);
		associateReportPanel.add(associateAfmLabel);
		
		associateNameValueLabel = new JLabel("New label");
		associateNameValueLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		associateNameValueLabel.setBounds(65, 11, 422, 14);
		associateReportPanel.add(associateNameValueLabel);
		
		associateAfmValueLabel = new JLabel("New label");
		associateAfmValueLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		associateAfmValueLabel.setBounds(65, 36, 422, 14);
		associateReportPanel.add(associateAfmValueLabel);
		
		totalSalesLabel = new JLabel("Total sales:\r\n\r\n");
		totalSalesLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		totalSalesLabel.setBounds(9, 81, 72, 14);
		associateReportPanel.add(totalSalesLabel);
		
		totalSalesValueLabel = new JLabel("New label");
		totalSalesValueLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		totalSalesValueLabel.setBounds(91, 82, 422, 14);
		associateReportPanel.add(totalSalesValueLabel);
		
		commissionLabel = new JLabel("Commission:");
		commissionLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		commissionLabel.setBounds(9, 106, 84, 14);
		associateReportPanel.add(commissionLabel);
		
		commissionValueLabel = new JLabel("New label");
		commissionValueLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		commissionValueLabel.setBounds(91, 107, 422, 14);
		associateReportPanel.add(commissionValueLabel);
		salesForAllProductsRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component component : productTypePanel.getComponents()) {
					if(component instanceof JCheckBox) {
						JCheckBox checkBox = (JCheckBox) component;
						if (salesForAllProductsRadioButton.isSelected()) checkBox.setSelected(true);
						else checkBox.setSelected(false);
					}
				}
			}
		});
	}

	public void setAssociate(Associate associate) {
		this.associate = associate;
		associateNameValueLabel.setText(associate.getName());
		associateAfmValueLabel.setText(associate.getAfm());
		fireActionListeners(this);
	}

	private void fireActionListeners(Component component) {
		if (component instanceof AbstractButton) {
			ActionListener[] listeners = ((AbstractButton) component).getActionListeners();
			for (ActionListener listener : listeners) {
				ActionEvent event = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "");
				listener.actionPerformed(event);
			}
		}
		if (component instanceof Container) {
			for (Component child : ((Container) component).getComponents()) {
				fireActionListeners(child);
			}
		}
	}
}
