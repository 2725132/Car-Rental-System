package com.mainsystem.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CustomerRegisterWindow extends JFrame {

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
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(261, 197, 97, 23);
		btnBack.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSave.setBounds(64, 198, 97, 23);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(10, 14, 61, 14);
		
		txtName = new JTextField();
		txtName.setBounds(74, 11, 140, 20);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(212, 14, 61, 14);
		
		txtState = new JTextField();
		txtState.setBounds(74, 37, 140, 20);
		txtState.setHorizontalAlignment(SwingConstants.CENTER);
		txtState.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setBounds(10, 65, 29, 14);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(74, 62, 140, 20);
		txtCPF.setHorizontalAlignment(SwingConstants.CENTER);
		txtCPF.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(283, 11, 140, 20);
		txtLastName.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(SwingConstants.LEFT);
		lblState.setBounds(10, 40, 46, 14);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(245, 40, 40, 14);
		
		txtCity = new JTextField();
		txtCity.setBounds(283, 37, 140, 20);
		txtCity.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setHorizontalAlignment(SwingConstants.LEFT);
		lblStreet.setBounds(239, 65, 46, 14);
		
		txtStreet = new JTextField();
		txtStreet.setBounds(283, 62, 140, 20);
		txtStreet.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 51, 14);
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtEmail = new JTextField();
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
		lblTel.setBounds(10, 135, 29, 14);
		panel.add(lblTel);
		
		txtTel = new JTextField();
		txtTel.setBounds(62, 132, 152, 20);
		panel.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.");
		lblCel.setBounds(241, 136, 32, 14);
		panel.add(lblCel);
		
		txtCel = new JTextField();
		txtCel.setBounds(272, 132, 141, 20);
		panel.add(txtCel);
		txtCel.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
}
