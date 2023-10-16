package main.gui;

import main.domain.*;
import main.domain.Associate;
import main.domain.ProductType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;


public class SelectionWindow extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel selectionWindowPanel = new JPanel();
	private JTextField dateTextField;
	private JTextField kindTextField;
	private JTextField salesTextField;
	private JTextField itemsTextField;
	private JTextField companyTextField;
	private JTextField countryTextField;
	private JTextField cityTextField;
	private JTextField streetTextField;
	private JTextField receiptIDTextField;
	private JTextField numberTextField;
	private JTextField numOfReceiptsTextField;
	private JTextField agentNameTextField;
	private int numOfReceipts = 0;
	private double totalSales;
	private JCheckBox totalSalesCheckBox;
	private JCheckBox totalItemsCheckBox;
	private JCheckBox commissionCheckBox;
	private JCheckBox categoryCheckBox;
	private JRadioButton skirtRadio;
	private JRadioButton shirtRadio;
	private JRadioButton trousersRadio;
	private JRadioButton coatRadio;
	private int totalItems;
	private double shirtSales;
	private double skirtSales;
	private double coatsSales;
	private double trousersSales;
	private double commission;
	private InputWindow inputDialog;
	private Associate selectedAssociate;
	@SuppressWarnings("unused")
	private String fileType;
	
	public SelectionWindow(InputWindow dialog, Associate associate, String fileTypeFlag) {
		inputDialog = dialog;
		selectedAssociate = associate;
		fileType = fileTypeFlag;
		initialise();
	}
	
	public void initialise(){
		getContentPane().setBackground(SystemColor.controlHighlight);
		setBounds(100, 100, 717, 597);
		getContentPane().setLayout(null);
		selectionWindowPanel.setBounds(0, 0, 701, 1);
		selectionWindowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(selectionWindowPanel);
		selectionWindowPanel.setLayout(null);
		totalSalesCheckBox = new JCheckBox("Συνολική αξία πωλήσεων");
		totalSalesCheckBox.setBackground(SystemColor.controlHighlight);
		totalSalesCheckBox.setBounds(52, 129, 169, 25);
		totalSalesCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(totalSalesCheckBox);
		
		totalItemsCheckBox = new JCheckBox("Συνολικός αριθμός πωλήσεων");
		totalItemsCheckBox.setBackground(SystemColor.controlHighlight);
		totalItemsCheckBox.setBounds(52, 170, 204, 25);
		totalItemsCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(totalItemsCheckBox);
		
		categoryCheckBox = new JCheckBox("Πωλήσεις συγκεκριμένης κατηγορίας");
		categoryCheckBox.setBackground(SystemColor.controlHighlight);
		
		categoryCheckBox.setBounds(52, 214, 257, 25);
		categoryCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(categoryCheckBox);
		
		shirtRadio = new JRadioButton("Μπλούζες");
		shirtRadio.setBackground(SystemColor.controlHighlight);
		shirtRadio.setEnabled(false);
		shirtRadio.setBounds(119, 242, 125, 25);
		shirtRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(shirtRadio);
		
		trousersRadio = new JRadioButton("Παντελόνια");
		trousersRadio.setBackground(SystemColor.controlHighlight);
		trousersRadio.setEnabled(false);
		trousersRadio.setBounds(119, 270, 125, 25);
		trousersRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(trousersRadio);
		
		coatRadio = new JRadioButton("Παλτό");
		coatRadio.setBackground(SystemColor.controlHighlight);
		coatRadio.setEnabled(false);
		coatRadio.setBounds(119, 298, 125, 25);
		coatRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(coatRadio);
		
		skirtRadio = new JRadioButton("Φούστες");
		skirtRadio.setBackground(SystemColor.controlHighlight);
		skirtRadio.setEnabled(false);
		skirtRadio.setBounds(119, 326, 125, 25);
		skirtRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(skirtRadio);
		
		commissionCheckBox = new JCheckBox("Εμφάνιση Προμήθειας");
		commissionCheckBox.setBackground(SystemColor.controlHighlight);
		commissionCheckBox.setBounds(52, 375, 204, 25);
		commissionCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(commissionCheckBox);
		
		final JToggleButton addReceiptToggleButton = new JToggleButton("Προσθήκη νέας απόδειξης");
		addReceiptToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addReceiptToggleButton.setBackground(new Color(135, 206, 235));
		
		addReceiptToggleButton.setBounds(411, 12, 265, 47);
		getContentPane().add(addReceiptToggleButton);

		dateTextField = new JTextField();
		dateTextField.setVisible(false);
		dateTextField.setBounds(543, 120, 133, 20);
		getContentPane().add(dateTextField);
		dateTextField.setColumns(10);
		
		kindTextField = new JTextField();
		kindTextField.setVisible(false);
		kindTextField.setBounds(543, 163, 133, 20);
		getContentPane().add(kindTextField);
		kindTextField.setColumns(10);
		
		salesTextField = new JTextField();
		salesTextField.setVisible(false);
		salesTextField.setBounds(543, 208, 133, 20);
		getContentPane().add(salesTextField);
		salesTextField.setColumns(10);
		
		itemsTextField = new JTextField();
		itemsTextField.setVisible(false);
		itemsTextField.setBounds(543, 250, 133, 20);
		getContentPane().add(itemsTextField);
		itemsTextField.setColumns(10);
		
		companyTextField = new JTextField();
		companyTextField.setVisible(false);
		companyTextField.setBounds(543, 287, 133, 20);
		getContentPane().add(companyTextField);
		companyTextField.setColumns(10);
		
		countryTextField = new JTextField();
		countryTextField.setVisible(false);
		countryTextField.setBounds(543, 329, 133, 20);
		getContentPane().add(countryTextField);
		countryTextField.setColumns(10);
		
		cityTextField = new JTextField();
		cityTextField.setVisible(false);
		cityTextField.setBounds(543, 367, 133, 20);
		getContentPane().add(cityTextField);
		cityTextField.setColumns(10);
		
		streetTextField = new JTextField();
		streetTextField.setVisible(false);
		streetTextField.setBounds(543, 406, 133, 20);
		getContentPane().add(streetTextField);
		streetTextField.setColumns(10);
		
		receiptIDTextField = new JTextField();
		receiptIDTextField.setVisible(false);
		receiptIDTextField.setBounds(543, 81, 133, 20);
		getContentPane().add(receiptIDTextField);
		receiptIDTextField.setColumns(10);
		
		numberTextField = new JTextField();
		numberTextField.setVisible(false);
		numberTextField.setBounds(543, 445, 133, 20);
		getContentPane().add(numberTextField);
		numberTextField.setColumns(10);
		
		final JLabel receiptIDLabel = new JLabel("ReceiptID:");
		receiptIDLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		receiptIDLabel.setVisible(false);
		receiptIDLabel.setBounds(470, 84, 71, 14);
		getContentPane().add(receiptIDLabel);
		
		final JLabel dateLabel = new JLabel("Date:");
		dateLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		dateLabel.setVisible(false);
		dateLabel.setBounds(470, 123, 46, 14);
		getContentPane().add(dateLabel);
		
		final JLabel kindLabel = new JLabel("Kind:");
		kindLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		kindLabel.setVisible(false);
		kindLabel.setBounds(470, 166, 46, 14);
		getContentPane().add(kindLabel);
		
		final JLabel salesLabel = new JLabel("Sales:");
		salesLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		salesLabel.setVisible(false);
		salesLabel.setBounds(470, 214, 46, 14);
		getContentPane().add(salesLabel);
		
		final JLabel itemsLabel = new JLabel("Items:");
		itemsLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		itemsLabel.setVisible(false);
		itemsLabel.setBounds(470, 253, 46, 14);
		getContentPane().add(itemsLabel);
		
		final JLabel companyLabel = new JLabel("Company:");
		companyLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		companyLabel.setVisible(false);
		companyLabel.setBounds(470, 284, 63, 25);
		getContentPane().add(companyLabel);
		
		final JLabel countryLabel = new JLabel("Country:");
		countryLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		countryLabel.setVisible(false);
		countryLabel.setBounds(470, 329, 63, 19);
		getContentPane().add(countryLabel);
		
		final JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		cityLabel.setVisible(false);
		cityLabel.setBounds(470, 364, 46, 25);
		getContentPane().add(cityLabel);
		
		final JLabel streetLabel = new JLabel("Street:");
		streetLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		streetLabel.setVisible(false);
		streetLabel.setBounds(470, 409, 46, 14);
		getContentPane().add(streetLabel);
		
		final JLabel numberLabel = new JLabel("Number:");
		numberLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		numberLabel.setVisible(false);
		numberLabel.setBounds(470, 448, 63, 14);
		getContentPane().add(numberLabel);
		
		final JButton addReceiptButton = new JButton("Προσθήκη");
		addReceiptButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		addReceiptButton.setVisible(false);
		addReceiptButton.setBounds(519, 482, 105, 39);
		getContentPane().add(addReceiptButton);
		
		JLabel lblNewLabel_10 = new JLabel("Αποδείξεις που προσθέθηκαν:");
		lblNewLabel_10.setBounds(469, 532, 157, 14);
		getContentPane().add(lblNewLabel_10);
		
		numOfReceiptsTextField = new JTextField();
		numOfReceiptsTextField.setText("0");
		numOfReceiptsTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		numOfReceiptsTextField.setBounds(636, 528, 40, 20);
		getContentPane().add(numOfReceiptsTextField);
		numOfReceiptsTextField.setColumns(10);
		
		JButton okbutton = new JButton("OK");
		okbutton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				okButtonPressed(evt);
				
			}
		});
		okbutton.setBounds(40, 483, 89, 32);
		getContentPane().add(okbutton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelButtonPressed(evt);
			}
		});
		cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cancelButton.setBounds(147, 483, 94, 32);
		getContentPane().add(cancelButton);

		
		JLabel lblNewLabel_11 = new JLabel("Επιλέξτε πληροφορίες προς εμφάνιση");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(0, 75, 271, 29);
		getContentPane().add(lblNewLabel_11);
		
		JLabel agentNameLabel = new JLabel("Αντιπρόσωπος:");
		agentNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		agentNameLabel.setBounds(0, 8, 129, 25);
		getContentPane().add(agentNameLabel);
		
		agentNameTextField = new JTextField();
		agentNameTextField.setBackground(SystemColor.controlHighlight);
		agentNameTextField.setEditable(false);
		agentNameTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		agentNameTextField.setBounds(135, 4, 174, 32);
		getContentPane().add(agentNameTextField);
		agentNameTextField.setColumns(10);
		
		categoryCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				skirtRadio.setEnabled(true);
				shirtRadio.setEnabled(true);
				coatRadio.setEnabled(true);
				trousersRadio.setEnabled(true);
				if(categoryCheckBox.isSelected()==false){
					if(skirtRadio.isSelected())
						skirtRadio.setSelected(false);
					
					if(shirtRadio.isSelected())
						shirtRadio.setSelected(false);
					
					if(coatRadio.isSelected())
						coatRadio.setSelected(false);
					
					if(trousersRadio.isSelected())
						trousersRadio.setSelected(false);
					
					skirtRadio.setEnabled(false);
					shirtRadio.setEnabled(false);
					coatRadio.setEnabled(false);
					trousersRadio.setEnabled(false);
				}
			}
		});
		
		addReceiptToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				receiptIDLabel.setVisible(true);receiptIDTextField.setVisible(true);
				dateLabel.setVisible(true);dateTextField.setVisible(true);
				kindLabel.setVisible(true);kindTextField.setVisible(true);
				salesLabel.setVisible(true);salesTextField.setVisible(true);
				itemsLabel.setVisible(true);itemsTextField.setVisible(true);
				companyLabel.setVisible(true);companyTextField.setVisible(true);
				countryLabel.setVisible(true);countryTextField.setVisible(true);
				streetLabel.setVisible(true);streetTextField.setVisible(true);
				cityLabel.setVisible(true);cityTextField.setVisible(true);
				numberLabel.setVisible(true);numberTextField.setVisible(true);
				addReceiptButton.setVisible(true);
				if(addReceiptToggleButton.isSelected()==false){
					receiptIDLabel.setVisible(false);receiptIDTextField.setVisible(false);
					dateLabel.setVisible(false);dateTextField.setVisible(false);
					kindLabel.setVisible(false);kindTextField.setVisible(false);
					salesLabel.setVisible(false);salesTextField.setVisible(false);
					itemsLabel.setVisible(false);itemsTextField.setVisible(false);
					companyLabel.setVisible(false);companyTextField.setVisible(false);
					countryLabel.setVisible(false);countryTextField.setVisible(false);
					streetLabel.setVisible(false);streetTextField.setVisible(false);
					cityLabel.setVisible(false);cityTextField.setVisible(false);
					numberLabel.setVisible(false);numberTextField.setVisible(false);
					addReceiptButton.setVisible(false);
				}
			}
		});
		
		addReceiptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			
				addReceiptButtonPressed(evt);
				
			}
		});
		
		try{
			agentNameTextField.setText(selectedAssociate.getName());
		}catch(NullPointerException e){
			
			JOptionPane.showMessageDialog(null,"Δεν έχετε επιλέξει αντιπρόσωπο, παρακαλώ επιλέξτε.");

		}
		
		
	}
	
	
	
	protected void okButtonPressed(ActionEvent evt) {
		if(totalSalesCheckBox.isSelected())
			 totalSales = selectedAssociate.calculateTotalSales();
		else
			totalSales = -1;
		
		if(totalItemsCheckBox.isSelected())
			totalItems = selectedAssociate.calculateTotalItems();
		else
			totalItems = -1;
		
		if(shirtRadio.isSelected())
			shirtSales = selectedAssociate.calculateShirtsSales();
		else
			shirtSales = -1;
		
		if(skirtRadio.isSelected()  )
			skirtSales = selectedAssociate.calculateSkirtsSales();
		else 
			skirtSales = -1;
		
		if(coatRadio.isSelected())
			coatsSales = selectedAssociate.calculateCoatsSales();
		else 
			coatsSales = -1;
		
		if(trousersRadio.isSelected())
			trousersSales = selectedAssociate.calculateTrouserSales();
		else 
			trousersSales = -1;
		
		if(commissionCheckBox.isSelected())
			commission = selectedAssociate.calculateCommission();
		else
			commission = -1;
		ResultWindow rs = new ResultWindow(this, selectedAssociate, totalSales, totalItems, shirtSales, skirtSales, trousersSales, coatsSales, commission);
		rs.setVisible(true);
		this.setVisible(false);		
	}
	
	
	private void addReceiptButtonPressed(ActionEvent evt) {
		if(receiptIDTextField.getText().isEmpty() && dateTextField.getText().isEmpty() 
				&& kindTextField.getText().isEmpty() && salesTextField.getText().isEmpty()
				&& itemsTextField.getText().isEmpty() && companyTextField.getText().isEmpty()
				&& countryTextField.getText().isEmpty() && cityTextField.getText().isEmpty()
				&& streetTextField.getText().isEmpty() && numberTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Δεν έχετε συμπληρώσει κάποιο πεδίο");
			
		}
		/*else if(kindTextField.toString().equalsIgnoreCase("Coats") == false && 
				kindTextField.toString().equalsIgnoreCase("Shirts") == false &&
				kindTextField.toString().equalsIgnoreCase("Skirts") == false &&
				kindTextField.toString().equalsIgnoreCase("Trousers") == false){
			JOptionPane.showMessageDialog(null,"To ����� ��� �������������� ��� ����� ������. �����������"
					+ " ���� �������������� �� ����� kind Coats � Shirts � Skirts � Trousers");

		}*/
			
		else{
			
			addReceipt();
			appendFile();
			
		}
		receiptIDTextField.setText("");	
		dateTextField.setText("");			
		kindTextField.setText("");	
		salesTextField.setText("");
		itemsTextField.setText("");	
		companyTextField.setText("");	
		countryTextField.setText("");	
		cityTextField.setText("");	
		streetTextField.setText("");	
		numberTextField.setText("");	

	}

	private void appendFile(){
		selectedAssociate.getFileAppender().setReceiptID(receiptIDTextField.getText());
		selectedAssociate.getFileAppender().setDate(dateTextField.getText());
		selectedAssociate.getFileAppender().setKind(kindTextField.getText());
		selectedAssociate.getFileAppender().setSales(salesTextField.getText());
		selectedAssociate.getFileAppender().setItems(itemsTextField.getText());
		selectedAssociate.getFileAppender().setCompany(companyTextField.getText());
		selectedAssociate.getFileAppender().setCountry(countryTextField.getText());
		selectedAssociate.getFileAppender().setCity(cityTextField.getText());
		selectedAssociate.getFileAppender().setStreet(streetTextField.getText());
		selectedAssociate.getFileAppender().setNumber(numberTextField.getText());
		selectedAssociate.getFileAppender().appendFile();
	}
	
	private void addReceipt(){

		ProductType productType = ProductType.INVALID; //temporary solution because choosing is not available

		if(kindTextField.equals("Shirts"))		
			productType = ProductType.SHIRT;
		else if (kindTextField.equals("Skirts"))
			productType = ProductType.SKIRT;
		else if (kindTextField.equals("Trousers"))
			productType = ProductType.TROUSERS;
		else if(kindTextField.equals("Coats"))				
			productType = ProductType.COAT;
		try{
			//TODO : SOMEHOW MAKE THIS READABLE PLEASE OH GOD

			Receipt receipt = new Receipt(
								productType,
								Integer.parseInt(receiptIDTextField.getText()),
								dateTextField.getText(),
								Double.parseDouble(salesTextField.getText()),
								Integer.parseInt(itemsTextField.getText()),
								new Company());

			// TODO set company stuff -- later
			receipt.getCompany().setCompanyName(companyTextField.getText());
			receipt.getCompany().getCompanyAddress().setCountry(countryTextField.getText());
			receipt.getCompany().getCompanyAddress().setCity(cityTextField.getText());
			receipt.getCompany().getCompanyAddress().setStreet(streetTextField.getText());
			receipt.getCompany().getCompanyAddress().setStreetNumber(Integer.parseInt(numberTextField.getText()));

			//This is where they add the receipt in the associate repository!!!
			selectedAssociate.getReceipts().add(receipt);
			
			numOfReceipts++;
			numOfReceiptsTextField.setText(Integer.toString(numOfReceipts));
			JOptionPane.showMessageDialog(null,"Η απόδειξη προστέθηκε");

		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Δεν έχετε συμπληρώσει κάποιο πεδίο");
		}
	}
	
	private void cancelButtonPressed(ActionEvent evt) {		
		dispose();
		inputDialog.setVisible(true);		
	}
	
	
}