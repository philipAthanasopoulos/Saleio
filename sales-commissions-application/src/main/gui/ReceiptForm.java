package main.gui;

import main.domain.*;
import main.fileAppender.FileAppender;
import main.fileAppender.FileAppenderFactory;

import java.util.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

public class ReceiptForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField receiptIdTextField;
	private JTextField receiptDateTextField;
	private JTextField productTypeTextField;
	private JTextField receiptSalesTextField;
	private JTextField receiptItemNumberTextFiled;
	private JTextField receiptCompanyNameTextField;
	private JTextField receiptCountryTextField;
	private JTextField receiptCityTextField;
	private JTextField receiptStreetNameTextField;
	private JTextField receiptStreetNumberTextField;
	private JLabel contextTextLabel;
	private JLabel associateNameLabel;
	private JButton addReceiptButton;
	private FileAppender fileAppender;
	private Associate associate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File file = null;
					Associate associate = new Associate("John","1", new ArrayList<Receipt>() , file);
					ReceiptForm frame = new ReceiptForm(associate);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReceiptForm(Associate selectedAssociate) {
		this.associate = selectedAssociate;

		setBounds(100, 100, 468, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel receiptIdLabel = new JLabel("Receipt ID");
		receiptIdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptIdLabel.setBounds(63, 83, 141, 25);
		contentPane.add(receiptIdLabel);
		
		receiptIdTextField = new JTextField();
		receiptIdTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptIdTextField.setBounds(214, 88, 163, 20);
		contentPane.add(receiptIdTextField);
		receiptIdTextField.setColumns(10);
		
		JLabel receiptDateLabel = new JLabel("Date");
		receiptDateLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptDateLabel.setBounds(63, 116, 141, 25);
		contentPane.add(receiptDateLabel);
		
		receiptDateTextField = new JTextField();
		receiptDateTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptDateTextField.setColumns(10);
		receiptDateTextField.setBounds(214, 121, 163, 20);
		contentPane.add(receiptDateTextField);
		
		productTypeTextField = new JTextField();
		productTypeTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productTypeTextField.setColumns(10);
		productTypeTextField.setBounds(214, 154, 163, 20);
		contentPane.add(productTypeTextField);
		
		JLabel receiptProductTypeLabel = new JLabel("Product type");
		receiptProductTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptProductTypeLabel.setBounds(63, 149, 141, 25);
		contentPane.add(receiptProductTypeLabel);
		
		receiptSalesTextField = new JTextField();
		receiptSalesTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptSalesTextField.setColumns(10);
		receiptSalesTextField.setBounds(214, 187, 163, 20);
		contentPane.add(receiptSalesTextField);
		
		JLabel receiptSalesLabel = new JLabel("Sales");
		receiptSalesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptSalesLabel.setBounds(63, 182, 141, 25);
		contentPane.add(receiptSalesLabel);
		
		receiptItemNumberTextFiled = new JTextField();
		receiptItemNumberTextFiled.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptItemNumberTextFiled.setColumns(10);
		receiptItemNumberTextFiled.setBounds(214, 220, 163, 20);
		contentPane.add(receiptItemNumberTextFiled);
		
		JLabel receiptNumberOfItemsLabel = new JLabel("Number of items");
		receiptNumberOfItemsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptNumberOfItemsLabel.setBounds(63, 218, 141, 25);
		contentPane.add(receiptNumberOfItemsLabel);
		
		receiptCompanyNameTextField = new JTextField();
		receiptCompanyNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptCompanyNameTextField.setColumns(10);
		receiptCompanyNameTextField.setBounds(214, 253, 163, 20);
		contentPane.add(receiptCompanyNameTextField);
		
		JLabel receiptCompanyNameLabel = new JLabel("Company name");
		receiptCompanyNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptCompanyNameLabel.setBounds(63, 248, 141, 25);
		contentPane.add(receiptCompanyNameLabel);
		
		receiptCountryTextField = new JTextField();
		receiptCountryTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptCountryTextField.setColumns(10);
		receiptCountryTextField.setBounds(214, 286, 163, 20);
		contentPane.add(receiptCountryTextField);
		
		JLabel receiptCountryLabel = new JLabel("Country");
		receiptCountryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptCountryLabel.setBounds(63, 281, 141, 25);
		contentPane.add(receiptCountryLabel);
		
		receiptCityTextField = new JTextField();
		receiptCityTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptCityTextField.setColumns(10);
		receiptCityTextField.setBounds(214, 319, 163, 20);
		contentPane.add(receiptCityTextField);
		
		JLabel receiptCityLabel = new JLabel("City");
		receiptCityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptCityLabel.setBounds(63, 314, 141, 25);
		contentPane.add(receiptCityLabel);
		
		receiptStreetNameTextField = new JTextField();
		receiptStreetNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptStreetNameTextField.setColumns(10);
		receiptStreetNameTextField.setBounds(214, 352, 163, 20);
		contentPane.add(receiptStreetNameTextField);
		
		JLabel receiptStreetNameLabel = new JLabel("Street");
		receiptStreetNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptStreetNameLabel.setBounds(63, 347, 141, 25);
		contentPane.add(receiptStreetNameLabel);
		
		receiptStreetNumberTextField = new JTextField();
		receiptStreetNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receiptStreetNumberTextField.setColumns(10);
		receiptStreetNumberTextField.setBounds(214, 385, 163, 20);
		contentPane.add(receiptStreetNumberTextField);
		
		JLabel receiptStreetNumberLabel = new JLabel("Street number");
		receiptStreetNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptStreetNumberLabel.setBounds(63, 380, 141, 25);
		contentPane.add(receiptStreetNumberLabel);
		
		contextTextLabel = new JLabel("Create new receipt for:");
		contextTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contextTextLabel.setBounds(10, 26, 156, 25);
		contentPane.add(contextTextLabel);
		
		associateNameLabel = new JLabel("NAME");
		associateNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		associateNameLabel.setBounds(176, 26, 201, 25);
		contentPane.add(associateNameLabel);
		associateNameLabel.setText(associate.getName());
		
		addReceiptButton = new JButton("ADD");
		addReceiptButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		addReceiptButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		addReceiptButton.setIcon(new ImageIcon(ReceiptForm.class.getResource("/resources/icons/icons8-add-35.png")));
		addReceiptButton.setOpaque(true);
		//TODO : FIX ME FIX ME FIX ME , color is not working
		addReceiptButton.setBackground(new Color(255, 255, 255));
		addReceiptButton.repaint();
		addReceiptButton.addActionListener(e -> {
			FileAppenderFactory fileAppenderFactory = new FileAppenderFactory();
			fileAppender = fileAppenderFactory.getFileAppender(associate.getFileType());
			
			Address address = new Address(
				receiptCountryTextField.getText(),
				receiptCityTextField.getText(),
				receiptStreetNameTextField.getText(),
				Integer.parseInt(receiptStreetNumberTextField.getText())
			);
			
			Company company = new Company(
				receiptCompanyNameTextField.getText(),
				address
			);

			Receipt receipt = new Receipt(
				Integer.parseInt(receiptIdTextField.getText()),
				receiptDateTextField.getText(),
				ProductType.valueOf(productTypeTextField.getText()) ,
				Double.parseDouble(receiptSalesTextField.getText()),
				Integer.parseInt(receiptItemNumberTextFiled.getText()),
				company 
			);
			try{
				fileAppender.appendReceipt(receipt, associate);
				dispose();
			} catch (NullPointerException nullPointerException){
				JOptionPane.showMessageDialog(null, "Associate file not found");
			} catch (IllegalArgumentException illegalArgumentException){
				JOptionPane.showMessageDialog(null, "Please fill all the fields correctly");
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		});
		
		addReceiptButton.setBounds(60, 431, 106, 36);
		contentPane.add(addReceiptButton);
	}
}
