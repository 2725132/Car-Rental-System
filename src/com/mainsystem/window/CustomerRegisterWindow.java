package com.mainsystem.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyleContext.SmallAttributeSet;

import com.mainsystem.identity.manage.CustomerActionListener;

import lombok.Getter;
import lombok.Setter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;
@Getter @Setter
public class CustomerRegisterWindow extends JFrame {

	CustomerActionListener cal;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtState;
	private JTextField txtCPF;
	private JTextField txtLastName;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtEmail;
	private JTextField txtTel;
	private JTextField txtCel;
	
	

	public CustomerRegisterWindow() {
		cal = new CustomerActionListener(this);
		
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerRegisterWindow.class.getResource("/icons/main icon.png")));
		setForeground(SystemColor.windowBorder);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(CustomerRegisterWindow.class.getResource("/icons/back.png")));
		btnBack.setBounds(284, 181, 51, 43);
		btnBack.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon(CustomerRegisterWindow.class.getResource("/icons/savecustomer.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cal.insertNewCustomer();
			}
		});
		btnSave.setBounds(83, 181, 51, 43);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Verdana", Font.BOLD, 11));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(10, 13, 73, 14);
		
		txtName = new JTextField();
		txtName.setBackground(UIManager.getColor("info"));
		txtName.setBounds(83, 11, 119, 20);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Verdana", Font.BOLD, 11));
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(212, 14, 73, 14);
		
		txtState = new JTextField();
		txtState.setBackground(UIManager.getColor("info"));
		txtState.setBounds(83, 37, 119, 20);
		txtState.setHorizontalAlignment(SwingConstants.CENTER);
		txtState.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Verdana", Font.BOLD, 11));
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setBounds(10, 65, 29, 14);
		
		txtCPF = new JTextField();
		txtCPF.setBackground(UIManager.getColor("info"));
		txtCPF.setBounds(83, 62, 119, 20);
		txtCPF.setHorizontalAlignment(SwingConstants.CENTER);
		txtCPF.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBackground(UIManager.getColor("info"));
		txtLastName.setBounds(296, 13, 128, 20);
		txtLastName.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Verdana", Font.BOLD, 11));
		lblState.setHorizontalAlignment(SwingConstants.LEFT);
		lblState.setBounds(10, 40, 46, 14);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Verdana", Font.BOLD, 11));
		lblCity.setBounds(245, 40, 40, 14);
		
		txtCity = new JTextField();
		txtCity.setBackground(UIManager.getColor("info"));
		txtCity.setBounds(296, 39, 128, 20);
		txtCity.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Verdana", Font.BOLD, 11));
		lblStreet.setHorizontalAlignment(SwingConstants.LEFT);
		lblStreet.setBounds(239, 65, 46, 14);
		
		txtStreet = new JTextField();
		txtStreet.setBackground(UIManager.getColor("info"));
		txtStreet.setBounds(296, 64, 128, 20);
		txtStreet.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 11));
		lblEmail.setBounds(10, 104, 51, 14);
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(UIManager.getColor("info"));
		txtEmail.setBounds(62, 101, 349, 20);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setColumns(10);
		panel.setLayout(null);
		panel.add(lblFirstName);
		panel.add(txtName);
		panel.add(lblLastName);
		panel.add(lblCpf);
		panel.add(lblEmail);
		panel.add(txtState);
		panel.add(txtCPF);
		panel.add(btnSave);
		panel.add(txtEmail);
		panel.add(btnBack);
		panel.add(lblStreet);
		panel.add(txtStreet);
		panel.add(lblState);
		panel.add(lblCity);
		panel.add(txtCity);
		panel.add(txtLastName);
		
		JLabel lblTel = new JLabel("Tel.");
		lblTel.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTel.setBounds(10, 135, 29, 14);
		panel.add(lblTel);
		
		txtTel = new JTextField();
		txtTel.setBackground(UIManager.getColor("info"));
		txtTel.setBounds(62, 132, 152, 20);
		panel.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.");
		lblCel.setFont(new Font("Verdana", Font.BOLD, 11));
		lblCel.setBounds(241, 136, 32, 14);
		panel.add(lblCel);
		
		txtCel = new JTextField();
		txtCel.setBackground(UIManager.getColor("info"));
		txtCel.setBounds(272, 132, 141, 20);
		panel.add(txtCel);
		txtCel.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
}
