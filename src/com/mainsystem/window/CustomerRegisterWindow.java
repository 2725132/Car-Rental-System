package com.mainsystem.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lowagie.text.Image;
import com.mainsystem.identity.manage.CustomerManager;
import com.mainsystem.window.helper.ImageBuilder;
import com.mainsystem.window.helper.MaskCreator;

import lombok.Getter;
import lombok.Setter;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;

public class CustomerRegisterWindow extends JFrame {

	private JPanel contentPane;
	@Getter
	@Setter
	private JTextField txtFirstName;
	
	@Getter
	@Setter
	private JTextField txtLastName;
	
	@Getter
	@Setter
	private JTextField txtCPF;
	
	@Getter
	@Setter
	private JTextField txtCity;
	
	@Getter
	@Setter
	private JTextField txtStreet;
	
	@Getter
	@Setter
	private JTextField txtNum;
	
	@Getter
	@Setter
	private JTextField txtTel;
	
	@Getter
	@Setter
	private JTextField txtCel;
	
	@Getter
	@Setter
	private JTextField txtEmail;
	private JTable table;
	
	JFormattedTextField txtIdDelete;

	JFileChooser fc;
	
	
	private CustomerManager cm;
	
	@Getter
	@Setter
	JRadioButton idRadioBtn;
	
	
	@Getter
	@Setter
	private JRadioButton allRadioBtn;
	
	@Getter
	@Setter
	JFormattedTextField idSearchTxt;
	
	
	private ImageBuilder imageBuilder;
	private Lab lblPhoto;

	/**
	 * Create the frame.
	 */

	public void addController(CustomerManager cm) {
		this.cm = cm;
	}

	public CustomerRegisterWindow() {
		fc = new JFileChooser(new File("c:\\"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg files", "jpg");
		fc.setFileFilter(filter);
		imageBuilder = new ImageBuilder();
		
		
		setResizable(false);
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 688);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(10, 11, 771, 638);
		contentPane.add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(25, 25, 112));
		tabbedPane.setBounds(0, 0, 761, 627);
		panel.add(tabbedPane);

		JPanel insertPanel = new JPanel();
		insertPanel.setBackground(new Color(105, 105, 105));
		tabbedPane.addTab("Insert", null, insertPanel, null);
		insertPanel.setLayout(null);

		txtFirstName = new JFormattedTextField();
		txtFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFirstName.setBackground(SystemColor.menu);
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(110, 18, 180, 27);
		insertPanel.add(txtFirstName);

		JLabel lblName = new JLabel("First name*");
		lblName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblName.setBounds(21, 17, 79, 27);
		insertPanel.add(lblName);

		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLastName.setBounds(315, 18, 79, 27);
		insertPanel.add(lblLastName);

		txtLastName = new JFormattedTextField();
		txtLastName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLastName.setBackground(SystemColor.menu);
		txtLastName.setColumns(10);
		txtLastName.setBounds(395, 18, 180, 27);
		insertPanel.add(txtLastName);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf.setBounds(21, 65, 79, 27);
		insertPanel.add(lblCpf);

		txtCPF = new JFormattedTextField(MaskCreator.createFormatter("###.###.###-##"));
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCPF.setBackground(SystemColor.menu);
		txtCPF.setColumns(10);
		txtCPF.setBounds(110, 69, 180, 27);
		insertPanel.add(txtCPF);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 126, 736, 15);
		insertPanel.add(separator);

		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setFont(new Font("Arial", Font.BOLD, 16));
		lblAdress.setBounds(21, 138, 68, 27);
		insertPanel.add(lblAdress);

		JLabel lblStreet = new JLabel("City");
		lblStreet.setFont(new Font("Arial", Font.PLAIN, 12));
		lblStreet.setBounds(21, 177, 79, 27);
		insertPanel.add(lblStreet);

		txtCity = new JFormattedTextField();
		txtCity.setBackground(SystemColor.menu);
		txtCity.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCity.setColumns(10);
		txtCity.setBounds(110, 178, 180, 27);
		insertPanel.add(txtCity);

		txtStreet = new JTextField();
		txtStreet.setBackground(SystemColor.menu);
		txtStreet.setFont(new Font("Arial", Font.PLAIN, 15));
		txtStreet.setColumns(10);
		txtStreet.setBounds(395, 178, 180, 27);
		insertPanel.add(txtStreet);

		JLabel lblStreet_1 = new JLabel("Street");
		lblStreet_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblStreet_1.setBounds(315, 177, 79, 27);
		insertPanel.add(lblStreet_1);

		JLabel lblNum = new JLabel("Num.:");
		lblNum.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNum.setBounds(585, 177, 59, 27);
		insertPanel.add(lblNum);

		txtNum = new JFormattedTextField();
		txtNum.setBackground(SystemColor.menu);
		txtNum.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNum.setColumns(10);
		txtNum.setBounds(640, 178, 68, 27);
		insertPanel.add(txtNum);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 249, 736, 15);
		insertPanel.add(separator_1);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Arial", Font.BOLD, 16));
		lblContact.setBounds(21, 262, 68, 27);
		insertPanel.add(lblContact);

		JLabel lblTel = new JLabel("Tel:");
		lblTel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTel.setBounds(21, 300, 68, 27);
		insertPanel.add(lblTel);

		txtTel = new JFormattedTextField(MaskCreator.createFormatter("(##)####-####"));
		txtTel.setBackground(SystemColor.menu);
		txtTel.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTel.setColumns(10);
		txtTel.setBounds(110, 299, 180, 27);
		insertPanel.add(txtTel);

		JLabel lblCel = new JLabel("Cel:");
		lblCel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCel.setBounds(315, 299, 59, 27);
		insertPanel.add(lblCel);

		txtCel = new JFormattedTextField(MaskCreator.createFormatter("(##)####-####"));
		txtCel.setBackground(SystemColor.menu);
		txtCel.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCel.setColumns(10);
		txtCel.setBounds(395, 299, 180, 27);
		insertPanel.add(txtCel);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(21, 349, 79, 27);
		insertPanel.add(lblEmail);

		txtEmail = new JFormattedTextField(MaskCreator.createFormatter("LLLL@LLLL"));
		txtEmail.setBackground(SystemColor.menu);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(110, 349, 470, 27);
		insertPanel.add(txtEmail);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.insertNewCustomer();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(612, 277, 119, 99);
		insertPanel.add(btnNewButton);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 397, 736, 15);
		insertPanel.add(separator_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadImage();
			}
		});
		btnNewButton_1.setBounds(72, 477, 106, 27);
		insertPanel.add(btnNewButton_1);
		
				JPanel searchPanel = new JPanel();
				searchPanel.setBackground(SystemColor.textInactiveText);
				tabbedPane.addTab("Search", null, searchPanel, null);
				searchPanel.setLayout(null);
				
				JLabel label = new JLabel("By what feature?");
				label.setFont(new Font("Arial", Font.BOLD, 14));
				label.setBounds(28, 11, 161, 56);
				searchPanel.add(label);
				
				idRadioBtn = new JRadioButton("Id");
				idRadioBtn.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						if(idRadioBtn.isSelected()){
							//searchByOption();
						}
					
					}
				});
				idRadioBtn.setFont(new Font("Arial", Font.PLAIN, 15));
				idRadioBtn.setBackground(SystemColor.controlDkShadow);
				idRadioBtn.setBounds(195, 14, 49, 50);
				searchPanel.add(idRadioBtn);
				
				JLabel label_1 = new JLabel("ID");
				label_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
				label_1.setBounds(26, 55, 51, 48);
				searchPanel.add(label_1);
				
				idSearchTxt = new JFormattedTextField();
				idSearchTxt.setText("");
				idSearchTxt.setFont(new Font("Arial", Font.PLAIN, 18));
				idSearchTxt.setEditable(false);
				idSearchTxt.setColumns(10);
				idSearchTxt.setBackground(Color.LIGHT_GRAY);
				idSearchTxt.setBounds(28, 114, 49, 37);
				searchPanel.add(idSearchTxt);
				
				JButton button = new JButton("Search");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//search();
					}
				});
				button.setFont(new Font("Arial", Font.PLAIN, 25));
				button.setEnabled(false);
				button.setBackground(new Color(211, 211, 211));
				button.setBounds(270, 270, 170, 80);
				searchPanel.add(button);
				
				JRadioButton allRadioBtn = new JRadioButton("All");
				allRadioBtn.setBounds(267, 12, 59, 55);
				searchPanel.add(allRadioBtn);

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
				if (!cm.deleteCustomer(id))
					JOptionPane.showMessageDialog(null, "Don't exist this id number on database!");
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Invalid Number!!!");
		}

	}

	public void insertAction(){
		try {
			if (confirm()) {
				int id = Integer.parseInt(txtIdDelete.getText());
				if(isNull(txtNum.getText().toString())) throw new NumberFormatException();
				
				System.out.println(id);
				if (!cm.deleteCustomer(id))
					JOptionPane.showMessageDialog(null, "Don't exist this id number on database!");
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Invalid Number!!!");
		}
	}
	
	public boolean isNull(String data) {
		if (!"".equals(data))
			return true;
		return false;
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
	
	public void searchByOption(){
		if(isNull(idSearchTxt.getText())) return;
		int id = Integer.parseInt(idSearchTxt.getText());
		if(idRadioBtn.isSelected()){
			cm.findCustomer(id);
		}
		if(allRadioBtn.isSelected()){
			cm.findAll();
		}
	}
}
