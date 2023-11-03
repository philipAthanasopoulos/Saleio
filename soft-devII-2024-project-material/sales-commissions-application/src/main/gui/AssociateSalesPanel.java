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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FontMetrics;

public class AssociateSalesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JRadioButton totalSalesRadioButton;
	private JRadioButton salesForAllProductsRadioButton;
	private JRadioButton commissionRadioButton;
	private JPanel productTypePanel;
	private JScrollPane productTypeScrollPane;
	private JScrollPane associateReportScrollPane;
	private Associate associate = new Associate();
	private JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel();

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
					tableModel.addRow(new Object[] {"Commission", String.format("%.2f", associate.calculateCommission())});
				} else {
					removeRowFromTable("Commission");
				}
			}
		});
		
		productTypeScrollPane = new JScrollPane();
		productTypeScrollPane.setBounds(10, 63, 201, 196);
		add(productTypeScrollPane);
		
		productTypePanel = new JPanel();
		productTypeScrollPane.setViewportView(productTypePanel);
		productTypePanel.setLayout(new GridLayout(0, 1, 0, 0));
		addProductTypeCheckBoxes();
		
		
		
		totalSalesRadioButton = new JRadioButton("Total sales");
		totalSalesRadioButton.setBackground(new Color(255, 255, 255));
		totalSalesRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		totalSalesRadioButton.setBounds(0, 7, 243, 23);
		add(totalSalesRadioButton);
		totalSalesRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(totalSalesRadioButton.isSelected()) {
					tableModel.addRow(new Object[] {"Total sales", String.format("%.2f", associate.calculateTotalSales())});
				} else {
					removeRowFromTable("Total sales");
				}
			}
		});
		
		salesForAllProductsRadioButton = new JRadioButton("Sales for all product types\r\n");
		salesForAllProductsRadioButton.setBackground(new Color(255, 255, 255));
		salesForAllProductsRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		salesForAllProductsRadioButton.setBounds(0, 33, 243, 23);
		add(salesForAllProductsRadioButton);
		salesForAllProductsRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component component : productTypePanel.getComponents()) {
					if(component instanceof JCheckBox) {
						JCheckBox checkBox = (JCheckBox) component;
						if (salesForAllProductsRadioButton.isSelected()) {
							checkBox.setSelected(true);
							checkBox.getActionListeners()[0].actionPerformed(e); // refactor me
						} else {
							checkBox.setSelected(false);
							checkBox.getActionListeners()[0].actionPerformed(e); // refactor me
						}
						
					}
				}
			}
		});
		
		associateReportScrollPane = new JScrollPane();
		associateReportScrollPane.setBounds(10, 310, 356, 306);
		add(associateReportScrollPane);
		
		table = new JTable();
		table.setTableHeader(null);
		table.setShowGrid(false);
		table.setRowHeight(20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFont(new Font("SansSerif", Font.PLAIN, 17));
		associateReportScrollPane.setViewportView(table);
		table.setModel(tableModel);
		tableModel.addColumn("objectName");
		tableModel.addColumn("objectValue");
	}
	
	public void setAssociate(Associate associate) {
		this.associate = associate;
		//clear table model
		tableModel.setRowCount(0);
		tableModel.addRow(new Object[] {"Name", associate.getName()});
		tableModel.addRow(new Object[] {"AFM", associate.getAfm()});
		//clear product type panel
		productTypePanel.removeAll();
		addProductTypeCheckBoxes();
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
	
	private void removeRowFromTable(String objectName) {
		for(int i = 0; i < tableModel.getRowCount(); i++) {
			if(tableModel.getValueAt(i, 0).equals(objectName)) {
				tableModel.removeRow(i);
				break;
			}
		}
	}
	private void addProductTypeCheckBoxes() {
		for(final ProductType productType : associate.getAssociateProductTypes()) {
			final JCheckBox checkBox = new JCheckBox(productType.toString());
			checkBox.setFont(new Font("SansSerif", Font.BOLD, 15));
			productTypePanel.add(checkBox);
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(checkBox.isSelected()) {
						tableModel.addRow(new Object[] {productType.toString(), String.format("%.2f", associate.getSalesOfItem(productType))});
					} else {
						removeRowFromTable(productType.toString());
					}
				}
			});
		}
	}
}
