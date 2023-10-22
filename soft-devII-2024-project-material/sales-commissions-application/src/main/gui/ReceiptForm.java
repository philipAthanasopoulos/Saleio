package main.gui;

import main.domain.Entry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JLabel lblNewLabel_2;
	private JLabel associateNameLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entry entry = null;
					ReceiptForm frame = new ReceiptForm(entry);
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
	public ReceiptForm(Entry entry) {
		setBounds(100, 100, 468, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Receipt ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(63, 83, 141, 25);
		contentPane.add(lblNewLabel);
		
		receiptIdTextField = new JTextField();
		receiptIdTextField.setBounds(214, 88, 163, 20);
		contentPane.add(receiptIdTextField);
		receiptIdTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(63, 116, 141, 25);
		contentPane.add(lblNewLabel_1);
		
		receiptDateTextField = new JTextField();
		receiptDateTextField.setColumns(10);
		receiptDateTextField.setBounds(214, 121, 163, 20);
		contentPane.add(receiptDateTextField);
		
		productTypeTextField = new JTextField();
		productTypeTextField.setColumns(10);
		productTypeTextField.setBounds(214, 154, 163, 20);
		contentPane.add(productTypeTextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product type");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(63, 149, 141, 25);
		contentPane.add(lblNewLabel_1_1);
		
		receiptSalesTextField = new JTextField();
		receiptSalesTextField.setColumns(10);
		receiptSalesTextField.setBounds(214, 187, 163, 20);
		contentPane.add(receiptSalesTextField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sales");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(63, 182, 141, 25);
		contentPane.add(lblNewLabel_1_2);
		
		receiptItemNumberTextFiled = new JTextField();
		receiptItemNumberTextFiled.setColumns(10);
		receiptItemNumberTextFiled.setBounds(214, 220, 163, 20);
		contentPane.add(receiptItemNumberTextFiled);
		
		JLabel lblNewLabel_1_3 = new JLabel("Number of items");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(63, 218, 141, 25);
		contentPane.add(lblNewLabel_1_3);
		
		receiptCompanyNameTextField = new JTextField();
		receiptCompanyNameTextField.setColumns(10);
		receiptCompanyNameTextField.setBounds(214, 253, 163, 20);
		contentPane.add(receiptCompanyNameTextField);
		
		JLabel lblNewLabel_1_4 = new JLabel("Company name");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(63, 248, 141, 25);
		contentPane.add(lblNewLabel_1_4);
		
		receiptCountryTextField = new JTextField();
		receiptCountryTextField.setColumns(10);
		receiptCountryTextField.setBounds(214, 286, 163, 20);
		contentPane.add(receiptCountryTextField);
		
		JLabel lblNewLabel_1_5 = new JLabel("Country");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(63, 281, 141, 25);
		contentPane.add(lblNewLabel_1_5);
		
		receiptCityTextField = new JTextField();
		receiptCityTextField.setColumns(10);
		receiptCityTextField.setBounds(214, 319, 163, 20);
		contentPane.add(receiptCityTextField);
		
		JLabel lblNewLabel_1_6 = new JLabel("City");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(63, 314, 141, 25);
		contentPane.add(lblNewLabel_1_6);
		
		receiptStreetNameTextField = new JTextField();
		receiptStreetNameTextField.setColumns(10);
		receiptStreetNameTextField.setBounds(214, 352, 163, 20);
		contentPane.add(receiptStreetNameTextField);
		
		JLabel lblNewLabel_1_7 = new JLabel("Street");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(63, 347, 141, 25);
		contentPane.add(lblNewLabel_1_7);
		
		receiptStreetNumberTextField = new JTextField();
		receiptStreetNumberTextField.setColumns(10);
		receiptStreetNumberTextField.setBounds(214, 385, 163, 20);
		contentPane.add(receiptStreetNumberTextField);
		
		JLabel lblNewLabel_1_8 = new JLabel("Street number");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_8.setBounds(63, 380, 141, 25);
		contentPane.add(lblNewLabel_1_8);
		
		lblNewLabel_2 = new JLabel("Create new receipt for:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 26, 156, 25);
		contentPane.add(lblNewLabel_2);
		
		associateNameLabel = new JLabel("NAME");
		associateNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		associateNameLabel.setBounds(176, 26, 201, 25);
		contentPane.add(associateNameLabel);
		associateNameLabel.setText(entry.getAssociate().getName());
		
		btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(51, 443, 89, 23);
		contentPane.add(btnNewButton);
	}
}
