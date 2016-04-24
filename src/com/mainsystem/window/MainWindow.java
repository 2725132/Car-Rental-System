package com.mainsystem.window;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mainsystem.SystemManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.Component;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainWindow extends JFrame {
	private static SystemManager sm;
	private static CustomerRegisterWindow crw;
	private static RentWindow rw;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MainWindow() {
		
		crw = new CustomerRegisterWindow();
		rw = new RentWindow();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/icons/main icon.png")));
		setForeground(Color.DARK_GRAY);
		setFont(new Font("Verdana", Font.BOLD, 12));
		setTitle("Car Rental System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 444, 271);
		
		JButton btnNewClient = new JButton("New Customer");
		btnNewClient.setForeground(new Color(0, 0, 0));
		btnNewClient.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crw.setVisible(true);
			}
		});
		
		JButton btnRent = new JButton("Rent");
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rw.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnRent.setForeground(Color.BLACK);
		btnRent.setFont(new Font("Verdana", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRent, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewClient))
					.addContainerGap(243, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(btnNewClient)
					.addGap(18)
					.addComponent(btnRent, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.add(panel);
		setVisible(true);
	}
}
