package com.mainsystem.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.lowagie.text.Image;
import com.mainsystem.identity.manage.CarManager;
import com.mainsystem.window.helper.ImageBuilder;
import com.mainsystem.window.helper.MaskCreator;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class CarRegisterWindow extends JFrame {

	private JPanel contentPane;

	private JTextField txtName;

	private JTextField txtBrand;

	private JTextField txtPlate;

	private JTextField txtModel;

	private JTable table;

	JFormattedTextField txtIdDelete;

	private CarManager cm;

	private JFileChooser fc;

	private ImageBuilder imageBuilder;

	private JLayeredPane photoPane;

	JLabel lblPhoto;

	/**
	 * Create the frame.
	 */

	public void addController(CarManager cm) {
		this.cm = cm;
	}

	public CarRegisterWindow() {
		fc = new JFileChooser(new File("c:\\"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg files", "jpg");
		fc.setFileFilter(filter);
		imageBuilder = new ImageBuilder();

		setResizable(false);
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(10, 11, 771, 450);
		contentPane.add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(25, 25, 112));
		tabbedPane.setBounds(0, 0, 761, 439);
		panel.add(tabbedPane);

		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(SystemColor.textInactiveText);
		tabbedPane.addTab("Search", null, searchPanel, null);
		searchPanel.setLayout(null);

		JLabel label = new JLabel("By what feature?");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(28, 11, 161, 56);
		searchPanel.add(label);

		JRadioButton radioButton = new JRadioButton("Id");
		radioButton.setFont(new Font("Arial", Font.PLAIN, 15));
		radioButton.setBackground(SystemColor.controlDkShadow);
		radioButton.setBounds(195, 14, 49, 50);
		searchPanel.add(radioButton);

		JLabel label_1 = new JLabel("ID");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		label_1.setBounds(26, 55, 51, 48);
		searchPanel.add(label_1);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("");
		formattedTextField.setFont(new Font("Arial", Font.PLAIN, 18));
		formattedTextField.setEditable(false);
		formattedTextField.setColumns(10);
		formattedTextField.setBackground(Color.LIGHT_GRAY);
		formattedTextField.setBounds(28, 114, 49, 37);
		searchPanel.add(formattedTextField);

		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 25));
		button.setEnabled(false);
		button.setBackground(new Color(211, 211, 211));
		button.setBounds(270, 270, 170, 80);
		searchPanel.add(button);

		JPanel deletePanel = new JPanel();
		deletePanel.setBackground(new Color(105, 105, 105));
		tabbedPane.addTab("Delete", null, deletePanel, null);
		deletePanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("By what feature?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 11, 161, 56);
		deletePanel.add(lblNewLabel);

		txtIdDelete = new JFormattedTextField();
		txtIdDelete.setEditable(false);
		txtIdDelete.setText("");
		txtIdDelete.setFont(new Font("Arial", Font.PLAIN, 18));
		txtIdDelete.setColumns(10);
		txtIdDelete.setBackground(new Color(192, 192, 192));
		txtIdDelete.setBounds(28, 114, 49, 37);
		deletePanel.add(txtIdDelete);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(26, 55, 51, 48);
		deletePanel.add(lblNewLabel_1);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAction();
			}
		});
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 25));
		btnDelete.setBackground(new Color(211, 211, 211));
		btnDelete.setBounds(270, 270, 170, 80);
		deletePanel.add(btnDelete);

		JRadioButton rdbtnId = new JRadioButton("Id");
		rdbtnId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnId.isSelected()) {
					txtIdDelete.setEditable(true);
					btnDelete.setEnabled(true);
				} else {
					txtIdDelete.setEditable(false);
					btnDelete.setEnabled(false);
				}
			}
		});
		rdbtnId.setBackground(new Color(105, 105, 105));
		rdbtnId.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnId.setBounds(195, 14, 49, 50);
		deletePanel.add(rdbtnId);

		JPanel insertPanel = new JPanel();
		insertPanel.setBackground(new Color(105, 105, 105));
		tabbedPane.addTab("Insert", null, insertPanel, null);
		insertPanel.setLayout(null);

		txtName = new JFormattedTextField();
		txtName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtName.setBackground(SystemColor.menu);
		txtName.setColumns(10);
		txtName.setBounds(110, 18, 180, 27);
		insertPanel.add(txtName);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblName.setBounds(21, 17, 79, 27);
		insertPanel.add(lblName);

		JLabel lblLastName = new JLabel("Brand");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLastName.setBounds(21, 185, 79, 27);
		insertPanel.add(lblLastName);

		txtBrand = new JFormattedTextField();
		txtBrand.setFont(new Font("Arial", Font.PLAIN, 15));
		txtBrand.setBackground(SystemColor.menu);
		txtBrand.setColumns(10);
		txtBrand.setBounds(110, 185, 180, 27);
		insertPanel.add(txtBrand);

		JLabel lblCpf = new JLabel("License Plate:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf.setBounds(21, 65, 79, 27);
		insertPanel.add(lblCpf);

		txtPlate = new JFormattedTextField(MaskCreator.createFormatter("###.###.###-##"));
		txtPlate.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPlate.setBackground(SystemColor.menu);
		txtPlate.setColumns(10);
		txtPlate.setBounds(110, 69, 180, 27);
		insertPanel.add(txtPlate);

		JLabel lblStreet = new JLabel("Model:");
		lblStreet.setHorizontalAlignment(SwingConstants.LEFT);
		lblStreet.setFont(new Font("Arial", Font.PLAIN, 12));
		lblStreet.setBounds(21, 123, 79, 27);
		insertPanel.add(lblStreet);

		txtModel = new JFormattedTextField();
		txtModel.setBackground(SystemColor.menu);
		txtModel.setFont(new Font("Arial", Font.PLAIN, 15));
		txtModel.setColumns(10);
		txtModel.setBounds(110, 123, 180, 27);
		insertPanel.add(txtModel);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.insertNewCar();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(21, 274, 119, 99);
		insertPanel.add(btnNewButton);

		JButton btnSelectImage = new JButton("Select Image");
		btnSelectImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadImage();
			}
		});
		btnSelectImage.setFont(new Font("Arial", Font.BOLD, 15));
		btnSelectImage.setBounds(503, 361, 144, 36);
		insertPanel.add(btnSelectImage);

		photoPane = new JLayeredPane();
		photoPane.setBounds(445, 18, 270, 270);
		insertPanel.add(photoPane);

		lblPhoto = new JLabel("New label");
		lblPhoto.setSize(270, 270);
		photoPane.add(lblPhoto);

		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(211, 211, 211));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(806, 263, 71, 107);
		contentPane.add(btnBack);
	}

	public void loadImage() {
		fc.setDialogTitle("Select file");
		int returnVal = fc.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			byte[] byteImage = imageBuilder.getByteImage(fc.getSelectedFile());
			BufferedImage readyImage = imageBuilder.getBufferedImage(byteImage);

			lblPhoto.setIcon(new ImageIcon(readyImage.getScaledInstance(270, 270, Image.DEFAULT)));

		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("cancelou");
		}
	}

	public boolean confirm() {
		int reply = JOptionPane.showConfirmDialog(null, "Are you sure?");
		if (reply == JOptionPane.YES_OPTION) {
			return true;
		} else
			return false;
	}

	public void deleteAction() {
		try {
			if (confirm()) {
				int id = Integer.parseInt(txtIdDelete.getText());
				System.out.println(id);
				if (!cm.deleteCar(id))
					JOptionPane.showMessageDialog(null, "Don't exist this id number on database!");
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Invalid Number!!!");
		}

	}
}
