package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String applicationName = "Sales Commissions Application";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setTitle(frame.applicationName);
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 156, 707);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Import File");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 0, 255));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Export as");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(128, 0, 255));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add receipt");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(128, 0, 255));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 0, 255));
		panel.add(btnNewButton);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Nikos Papadopoulos", "Apostolos Nikolaou"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(219, 199, 353, 342);
		contentPane.add(list_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(638, 199, 456, 342);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPane.setEditable(false);
		textPane.setText("Receipt ID: 1\r\n" + //
				"Date: 25/2/2014\r\n" + //
				"Kind: Coats\r\n" + //
				"Sales: 2000\r\n" + //
				"Items: 10\r\n" + //
				"Company: Hand Made Clothes\r\n" + //
				"Country: Greece\r\n" + //
				"City: Ioannina\r\n" + //
				"Street: Kaloudi \r\n" + //
				"Number: 10\r\n" + //
				"\r\n" + //
				"Receipt ID: 2\r\n" + //
				"Date: 25/2/2014\r\n" + //
				"Kind: Coats\r\n" + //
				"Sales: 4000\r\n" + //
				"Items: 10\r\n" + //
				"Company: Hand Made Clothes\r\n" + //
				"Country: Greece\r\n" + //
				"City: Ioannina\r\n" + //
				"Street: Kaloudi \r\n" + //
				"Number: 10\r\n" + //
				"\r\n" + //
				"Receipt ID: 3\r\n" + //
				"Date: 25/2/2014\r\n" + //
				"Kind: Shirts\r\n" + //
				"Sales: 4000\r\n" + //
				"Items: 10\r\n" + //
				"Company: Hand Made Clothes\r\n" + //
				"Country: Greece\r\n" + //
				"City: Ioannina\r\n" + //
				"Street: Kaloudi \r\n" + //
				"Number: 10\r\n" + //
				"\r\n" + //
				"Receipt ID: 4\r\n" + //
				"Date: 25/2/2014\r\n" + //
				"Kind: Skirts\r\n" + //
				"Sales: 1000\r\n" + //
				"Items: 10\r\n" + //
				"Company: Hand Made Clothes\r\n" + //
				"Country: Greece\r\n" + //
				"City: Ioannina\r\n" + //
				"Street: Kaloudi \r\n" + //
				"Number: 10\r\n" + //
				"\r\n" + //
				"Receipt ID: 5\r\n" + //
				"Date: 25/2/2014\r\n" + //
				"Kind: Skirts\r\n" + //
				"Sales: 1000\r\n" + //
				"Items: 10\r\n" + //
				"Company: Hand Made Clothes\r\n" + //
				"Country: Greece\r\n" + //
				"City: Ioannina\r\n" + //
				"Street: Kaloudi \r\n" + //
				"Number: 10\r\n" + //
				"\r\n" + //
				"Receipt ID: 6\r\n" + //
				"Date: 25/2/2014\r\n" + //
				"Kind: Trousers\r\n" + //
				"Sales: 5000\r\n" + //
				"Items: 10\r\n" + //
				"Company: Hand Made Clothes\r\n" + //
				"Country: Greece\r\n" + //
				"City: Ioannina\r\n" + //
				"Street: Kaloudi \r\n" + //
				"Number: 10");
		scrollPane.setViewportView(textPane);
		textPane.setCaretPosition(0);
		
		JLabel lblNewLabel = new JLabel("Associates");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(344, 174, 116, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Receipts");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(834, 163, 103, 25);
		contentPane.add(lblNewLabel_1);
	}
}
