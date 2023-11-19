package main.gui;

import main.domain.ProductType;
import main.domain.Associate;

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;

public class AssociateSalesPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JRadioButton totalSalesRadioButton = new JRadioButton("Total sales");
	private JRadioButton salesForAllProductsRadioButton = new JRadioButton("Sales for all product types\r\n");
	private JRadioButton commissionRadioButton = new JRadioButton("Commission\r\n");
	private JPanel productTypePanel = new JPanel();
	private JScrollPane productTypeScrollPane = new JScrollPane();
	private JScrollPane associateReportScrollPane = new JScrollPane();
	private Associate associate = new Associate();
	private JTable table;
	private DefaultTableModel tableModel;
	private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
	private static final int TIME_DELAY = 0;
	
	public AssociateSalesPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		tableModel = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tableModel.addColumn("objectName");
		tableModel.addColumn("objectValue");
		
		table = new JTable(tableModel);
		table.setTableHeader(null);
		table.setShowGrid(false);
		table.setRowHeight(20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFont(new Font("SansSerif", Font.PLAIN, 24));

        commissionRadioButton.setBackground(new Color(255, 255, 255));
		commissionRadioButton.setFont(new Font("SansSerif", Font.BOLD, 17));
		commissionRadioButton.setBounds(234, 0, 243, 23);
		add(commissionRadioButton);
		commissionRadioButton.addActionListener(e -> {
			if(commissionRadioButton.isSelected()) {
				tableModel.addRow(new Object[] {"Commission", String.format("%.2f", associate.calculateCommission())});
			} else removeRowFromTable("Commission");
		});

        productTypeScrollPane.setBounds(0, 63, 261, 196);
		add(productTypeScrollPane);

        productTypeScrollPane.setViewportView(productTypePanel);
		productTypePanel.setLayout(new GridLayout(0, 1, 0, 0));
		addButtonsAndCheckBoxes();

        totalSalesRadioButton.setBackground(new Color(255, 255, 255));
		totalSalesRadioButton.setFont(new Font("SansSerif", Font.BOLD, 17));
		totalSalesRadioButton.setBounds(0, 0, 232, 23);
		add(totalSalesRadioButton);
		totalSalesRadioButton.addActionListener(e -> {
			if(totalSalesRadioButton.isSelected()) {
				tableModel.addRow(new Object[] {"Total sales", String.format("%.2f", associate.calculateTotalSales())});
			} else removeRowFromTable("Total sales");
		});

        salesForAllProductsRadioButton.setBackground(new Color(255, 255, 255));
		salesForAllProductsRadioButton.setFont(new Font("SansSerif", Font.BOLD, 17));
		salesForAllProductsRadioButton.setBounds(0, 33, 232, 23);
		add(salesForAllProductsRadioButton);

		salesForAllProductsRadioButton.addActionListener(e -> {
			for(JCheckBox checkBox : checkBoxes) 
				if(salesForAllProductsRadioButton.isSelected() && !checkBox.isSelected())
					checkBox.doClick(TIME_DELAY);
				else if(!salesForAllProductsRadioButton.isSelected() && checkBox.isSelected()) 
					checkBox.doClick(TIME_DELAY);
		});

        associateReportScrollPane.setBounds(0, 281, 586, 373);
		associateReportScrollPane.setViewportView(table);
		add(associateReportScrollPane);
	}
	
	public void setAssociate(Associate associate) {
		this.associate = associate;
		tableModel.setRowCount(0);
		tableModel.addRow(new Object[] {"Name", associate.getName()});
		tableModel.addRow(new Object[] {"AFM", associate.getAfm()});
		addButtonsAndCheckBoxes();
	}
	
	private void removeRowFromTable(String objectName) {
		for(int i = 0; i < tableModel.getRowCount(); i++) {
			if(tableModel.getValueAt(i, 0).equals(objectName)) {
				tableModel.removeRow(i);
				break;
			}
		}
	}
	
	/**
	 * The addProductTypeCheckBoxes method adds a checkbox for each product type that the associate sells.
	 * In the case that a new selected associate has common product types with the previous selected associate,
	 * the checkboxes that were selected before will be selected again.
	 */
	private void addButtonsAndCheckBoxes() {
		ArrayList<String> selectedCheckBoxes = new ArrayList<>();
		for(JCheckBox checkBox : checkBoxes) if(checkBox.isSelected()) selectedCheckBoxes.add(checkBox.getText());
		checkBoxes.clear();
		productTypePanel.removeAll();

		for(ProductType productType : associate.getAssociateProductTypes()) {
			JCheckBox checkBox = new JCheckBox(productType.toString());
			checkBox.setFont(new Font("SansSerif", Font.BOLD, 15));
			productTypePanel.add(checkBox);
			checkBoxes.add(checkBox);
			checkBox.addActionListener(e -> {
				if (checkBox.isSelected()) 	tableModel.addRow(new Object[]{
					productType.toString(), String.format("%.2f", associate.getSalesOfItem(productType))
				});
				else {
					removeRowFromTable(productType.toString());
					salesForAllProductsRadioButton.setSelected(false);
				}
			});
		}

		//check boxes should be checked after the radio button refresh
		//otherwise the salesForAllProductsRadioButton may remove previous common product types choices
		refreshComponent(salesForAllProductsRadioButton);

		for(JCheckBox checkBox : checkBoxes) 
			if(selectedCheckBoxes.contains(checkBox.getText()) && !checkBox.isSelected())
				checkBox.doClick(TIME_DELAY);

		refreshComponent(totalSalesRadioButton);
		refreshComponent(commissionRadioButton);
	}

	public void refreshComponent(AbstractButton component) {
		ActionListener[] actionListeners = component.getActionListeners();
		for(ActionListener actionListener : actionListeners)
			actionListener.actionPerformed(null);
	}

	public ArrayList<String> getTableTags() {
		ArrayList<String> tableTags = new ArrayList<>();
		for(int i = 0; i < tableModel.getRowCount(); i++) tableTags.add((String) tableModel.getValueAt(i, 0));
		return tableTags;
	}

	public ArrayList<String> getTableValues() {
		ArrayList<String> tableValues = new ArrayList<>();
		for(int i = 0; i < tableModel.getRowCount(); i++) tableValues.add((String) tableModel.getValueAt(i, 1));
		return tableValues;
	}
}
