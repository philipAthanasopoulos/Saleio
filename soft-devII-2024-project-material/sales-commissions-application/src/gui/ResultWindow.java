package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.UIManager;

import output.TXTReport;
import output.XMLReport;
import data.Agent;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel resultWindowPanel = new JPanel();
	private JTextField totalSalesTextField;
	private JTextField totalItemsTextField;
	private JTextField trouserSalesTextField;
	private JTextField shirtSalesTextField;
	private JTextField coatSalesTextField;
	private JTextField skirtSalesTextField;
	private JTextField commissionTextField;
	private SelectionWindow selectionWindow;
	private Agent selectedAgent;
	private double totalSales;
	private int totalItems;
	private float shirtSales;
	private float skirtSales;
	private float trousersSales;
	private float coatsSales;
	private double commission;


	public ResultWindow(final SelectionWindow sw, Agent agent,double tSales,int tItems,
			float shirtS,float skirtS,float trousersS,float coatsS,double com) {
		selectionWindow = sw;
		selectedAgent = agent;
		totalSales = tSales;
		totalItems = tItems;
		shirtSales = shirtS;
		skirtSales = skirtS;
		trousersSales = trousersS;
		coatsSales = coatsS;
		commission = com;
		
		initialise();
	}	
	private void initialise(){
		setBounds(100, 100, 686, 456);
		getContentPane().setLayout(new BorderLayout());
		resultWindowPanel.setBackground(SystemColor.controlHighlight);
		resultWindowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(resultWindowPanel, BorderLayout.CENTER);
		resultWindowPanel.setLayout(null);
		{
			JButton xmlReportButton = new JButton("Εξαγωγή σε XML");
			
			xmlReportButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					outputXMLButtonPressed(evt);
				}
			});
			xmlReportButton.setBackground(UIManager.getColor("Button.light"));
			xmlReportButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			xmlReportButton.setBounds(436, 189, 163, 84);
			resultWindowPanel.add(xmlReportButton);
		}
		{
			JButton txtReportButton = new JButton("Εξαγωγή σε TXT");
			txtReportButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					outputTXTButtonPressed(evt);
				}
			});
			txtReportButton.setBackground(UIManager.getColor("Button.light"));
			txtReportButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			txtReportButton.setBounds(436, 32, 163, 81);
			resultWindowPanel.add(txtReportButton);
		}
		{
			JLabel lblNewLabel = new JLabel("Συνολική αξία");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel.setBounds(60, 41, 84, 43);
			resultWindowPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Σύνολο πωλήσεων");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(60, 95, 124, 14);
			resultWindowPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Πωλήσεις παντελονιών");
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(60, 138, 138, 14);
			resultWindowPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Πωλήσεις μπλουζών");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(60, 178, 124, 14);
			resultWindowPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Πωλήσεις παλτών");
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(60, 220, 124, 14);
			resultWindowPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Πωλήσεις φούστων");
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(60, 255, 124, 14);
			resultWindowPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Προμήθεια");
			lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_6.setBounds(60, 301, 101, 14);
			resultWindowPanel.add(lblNewLabel_6);
		}
		
		totalSalesTextField = new JTextField();
		totalSalesTextField.setEditable(false);
		totalSalesTextField.setBounds(208, 53, 86, 20);
		resultWindowPanel.add(totalSalesTextField);
		totalSalesTextField.setColumns(10);
		
		totalItemsTextField = new JTextField();
		totalItemsTextField.setEditable(false);
		totalItemsTextField.setBounds(208, 93, 86, 20);
		resultWindowPanel.add(totalItemsTextField);
		totalItemsTextField.setColumns(10);
		
		trouserSalesTextField = new JTextField();
		trouserSalesTextField.setEditable(false);
		trouserSalesTextField.setBounds(208, 136, 86, 20);
		resultWindowPanel.add(trouserSalesTextField);
		trouserSalesTextField.setColumns(10);
		
		shirtSalesTextField = new JTextField();
		shirtSalesTextField.setEditable(false);
		shirtSalesTextField.setBounds(208, 176, 86, 20);
		resultWindowPanel.add(shirtSalesTextField);
		shirtSalesTextField.setColumns(10);
		
		coatSalesTextField = new JTextField();
		coatSalesTextField.setEditable(false);
		coatSalesTextField.setBounds(208, 218, 86, 20);
		resultWindowPanel.add(coatSalesTextField);
		coatSalesTextField.setColumns(10);
		
		skirtSalesTextField = new JTextField();
		skirtSalesTextField.setEditable(false);
		skirtSalesTextField.setBounds(208, 253, 86, 20);
		resultWindowPanel.add(skirtSalesTextField);
		skirtSalesTextField.setColumns(10);
		
		commissionTextField = new JTextField();
		commissionTextField.setEditable(false);
		commissionTextField.setBounds(208, 299, 86, 20);
		resultWindowPanel.add(commissionTextField);
		commissionTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u039F\u039A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				okButtonPressed(evt);
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(246, 360, 101, 33);
		resultWindowPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelButtonPressed(evt);
				
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(357, 360, 101, 33);
		resultWindowPanel.add(btnNewButton_1);
		updateResults();
		
	}
	
	private void updateResults() {

		if(totalSales>=0)
			totalSalesTextField.setText(Double.toString(totalSales));
		else 
			totalSalesTextField.setEnabled(false);
		if(totalItems>=0)
			totalItemsTextField.setText(Integer.toString(totalItems));
		else 
			totalItemsTextField.setEnabled(false);
		if(shirtSales>=0)
			shirtSalesTextField.setText(Float.toString(shirtSales));
		else 
			shirtSalesTextField.setEnabled(false);
		if(skirtSales>=0)
			skirtSalesTextField.setText(Float.toString(skirtSales));
		else 
			skirtSalesTextField.setEnabled(false);
		if(coatsSales>=0)
			coatSalesTextField.setText(Float.toString(coatsSales));
		else 
			coatSalesTextField.setEnabled(false);
		if(trousersSales>=0)
			trouserSalesTextField.setText(Float.toString(trousersSales));
		else 
			shirtSalesTextField.setEnabled(false);
		if(commission>=0)
			commissionTextField.setText(Double.toString(commission));
		else 
			commissionTextField.setEnabled(false);
	
				
	}
	private void outputTXTButtonPressed(ActionEvent evt) {
		TXTReport makeTXTFile = new TXTReport(selectedAgent);
		makeTXTFile.saveFile();
		JOptionPane.showMessageDialog(null,"Το αρχείο αποθηκεύτηκε στον φάκελο του προγράμματος");

		
	}
	private void outputXMLButtonPressed(ActionEvent evt) {
		XMLReport makeXMLFile = new XMLReport(selectedAgent);
		makeXMLFile.saveFile();
		JOptionPane.showMessageDialog(null,"Το αρχείο αποθηκεύτηκε στον φάκελο του προγράμματος");	
	}
	private void okButtonPressed(ActionEvent evt) {
		System.exit(0);		
	}
	
	private void cancelButtonPressed(ActionEvent evt) {
		selectionWindow.setVisible(true);
		this.dispose();	
	}
	
}
