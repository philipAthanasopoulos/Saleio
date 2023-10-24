package main.gui;

import main.domain.Associate;
import main.domain.Entry;
import main.parser.Parser;
import main.parser.TXTParser;
import main.parser.XMLParser;
import main.reporter.Reporter;
import main.reporter.ReporterFactory;

import java.util.List;
import java.util.ArrayList;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DebugGraphics;
import javax.swing.DefaultListModel;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Cursor;

/**
 * The App class is the main class of the application. It is responsible for
 * creating the GUI and handling the user's input.
 * @important The GUI is currently made with WindowBuilder extension for Eclipse.
 * Because of this, the code has autogenerated parts and some names are not
 * very descriptive. Make sure to change them when make changes to the GUI.
 */
public class AppGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String applicationName = "Sales Commissions Application";
	private JPanel sidePanel;
	private JTextField searchTextField;
	private List<Entry> entries; 
	private JList associatesList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI frame = new AppGUI();
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
	public AppGUI() {
		entries = new ArrayList<Entry>();
		final DefaultListModel<String> associateListModel = new DefaultListModel<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1269, 746);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setFocusTraversalKeysEnabled(false);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane receiptsScrollPane = new JScrollPane();
		receiptsScrollPane.setBounds(763, 208, 456, 471);
		contentPane.add(receiptsScrollPane);
		
		final JTextPane receiptsTextPane = new JTextPane();
		receiptsTextPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		receiptsTextPane.setEditable(false);
		receiptsScrollPane.setViewportView(receiptsTextPane);
		receiptsTextPane.setCaretPosition(0);
		
		JLabel associateListLabel = new JLabel("Associates");
		associateListLabel.setIconTextGap(10);
		associateListLabel.setIcon(new ImageIcon(AppGUI.class.getResource("/resources/icons8-account-24.png")));
		associateListLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		associateListLabel.setBounds(448, 172, 148, 25);
		contentPane.add(associateListLabel);
		
		JLabel receiptsListLabel = new JLabel("Receipts");
		receiptsListLabel.setIconTextGap(10);
		receiptsListLabel.setIcon(new ImageIcon(AppGUI.class.getResource("/resources/icons8-receipt-24.png")));
		receiptsListLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		receiptsListLabel.setBounds(926, 172, 163, 25);
		contentPane.add(receiptsListLabel);	
		
		sidePanel = new GradientPanel();
		sidePanel.setBounds(0, 0, 322, 707);
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JPanel actionsButtonsPanel = new JPanel();
		actionsButtonsPanel.setOpaque(false);
		actionsButtonsPanel.setBounds(0, 169, 322, 267);
		sidePanel.add(actionsButtonsPanel);
		actionsButtonsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton importFileButton = new JButton("Import file");
		importFileButton.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		importFileButton.setFocusable(false);
		importFileButton.setFocusPainted(false);
		importFileButton.setFocusTraversalKeysEnabled(false);
		importFileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		importFileButton.setIconTextGap(10);
		importFileButton.setHorizontalTextPosition(SwingConstants.LEFT);
		importFileButton.setIcon(new ImageIcon(AppGUI.class.getResource("/resources/icons8-add-file-24.png")));
		importFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO : use factory pattern
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String fileType = selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".") + 1);
					Parser parser;
					if (fileType.equals("txt")) parser = new TXTParser();
					else if (fileType.equals("xml")) parser = new XMLParser();
					else throw new IllegalArgumentException("Unsupported file type");
					try {
						Entry entry = parser.parseFileEntry(selectedFile);
						entries.add(entry);
						associateListModel.addElement(entry.getAssociate().getName());
					} catch (Exception unsupportedFileTypeException) {
						JOptionPane.showMessageDialog(null, "Invalid file type", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		importFileButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		importFileButton.setBorder(null);
		importFileButton.setForeground(new Color(255, 255, 255));
		importFileButton.setBackground(new Color(0, 128, 128));
		importFileButton.setOpaque(false);
		actionsButtonsPanel.add(importFileButton);
		
		JButton addReceiptButton = new JButton("Add receipt");
		addReceiptButton.setFocusable(false);
		addReceiptButton.setFocusTraversalKeysEnabled(false);
		addReceiptButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addReceiptButton.setIconTextGap(10);
		addReceiptButton.setHorizontalTextPosition(SwingConstants.LEFT);
		addReceiptButton.setIcon(new ImageIcon(AppGUI.class.getResource("/resources/icons8-add-receipt-24.png")));
		addReceiptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entry selectedEntry = entries.get(associatesList.getSelectedIndex());
				ReceiptForm receiptForm = new ReceiptForm(selectedEntry);
				receiptForm.setVisible(true);
				//position to center
				receiptForm.setLocationRelativeTo(null);
			}
		});
		addReceiptButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		addReceiptButton.setBorder(null);
		addReceiptButton.setForeground(new Color(255, 255, 255));
		addReceiptButton.setBackground(new Color(0, 128, 128));
		addReceiptButton.setOpaque(false);
		actionsButtonsPanel.add(addReceiptButton);
		
		JButton exportFileButton = new JButton("Export as");
		exportFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ask user for file type
				//TODO: make dynamic when you have the time :)
				String[] options = {"TXT", "XML"};
				int result = JOptionPane.showOptionDialog(null, "Choose file type", "Export as", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if (result == JOptionPane.CLOSED_OPTION) return;

				ReporterFactory reporterFactory = new ReporterFactory();
				Associate selectedAssociate = entries.get(associatesList.getSelectedIndex()).getAssociate();
				Reporter reporter = reporterFactory.getReporter(
					options[result].toLowerCase(),
					 selectedAssociate
				);
				reporter.saveFile();
			}
		});
		exportFileButton.setFocusable(false);
		exportFileButton.setFocusTraversalKeysEnabled(false);
		exportFileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportFileButton.setIconTextGap(10);
		exportFileButton.setHorizontalTextPosition(SwingConstants.LEFT);
		exportFileButton.setIcon(new ImageIcon(AppGUI.class.getResource("/resources/icons8-export-24.png")));
		exportFileButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		exportFileButton.setBorder(null);
		exportFileButton.setForeground(new Color(255, 255, 255));
		exportFileButton.setBackground(new Color(0, 128, 128));
		exportFileButton.setOpaque(false);
		actionsButtonsPanel.add(exportFileButton);
		
		JLabel appTitleLabel = new JLabel("Sales Management");
		appTitleLabel.setIconTextGap(25);
		appTitleLabel.setIcon(new ImageIcon("C:\\Users\\Philip\\Downloads\\icons8-company-48.png"));
		appTitleLabel.setForeground(new Color(255, 255, 255));
		appTitleLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		appTitleLabel.setBounds(10, 11, 274, 42);
		sidePanel.add(appTitleLabel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(255, 255, 255));
		searchPanel.setBounds(322, 0, 931, 50);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);
		
		JButton searchButton = new JButton("");
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setBorder(null);
		searchButton.setFocusPainted(false);
		searchButton.setFocusTraversalKeysEnabled(false);
		searchButton.setFocusable(false);
		searchButton.setRolloverEnabled(false);
		searchButton.setRequestFocusEnabled(false);
		searchButton.setBackground(new Color(255, 255, 255));
		searchButton.setOpaque(false);
		searchButton.setIcon(new ImageIcon(AppGUI.class.getResource("/resources/icons8-search-24.png")));
		searchButton.setBounds(0, 0, 50, 50);
		searchPanel.add(searchButton);
		
		searchTextField = new JTextField();
		searchTextField.setFocusCycleRoot(true);
		searchTextField.setFocusTraversalPolicyProvider(true);
		searchTextField.setBackground(new Color(225, 225, 225));
		searchTextField.setBorder(null);
		searchTextField.setAutoscrolls(false);
		searchTextField.setToolTipText("");
		searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchTextField.setBounds(50, 0, 881, 50);
		searchPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JScrollPane associatesScrollPane = new JScrollPane();
		associatesScrollPane.setBounds(346, 208, 369, 471);
		contentPane.add(associatesScrollPane);
		
		associatesList = new JList();
		associatesList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		associatesList.setModel(associateListModel);
		associatesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting()) return;
				int index = associatesList.getSelectedIndex();
				if (index == -1) return;
				Entry entry = entries.get(index);
				receiptsTextPane.setText(entry.getFileAsString());
			}
		});

		associatesScrollPane.setViewportView(associatesList);
	}
}