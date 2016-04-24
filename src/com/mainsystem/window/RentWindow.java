package com.mainsystem.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RentWindow extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public RentWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setIcon(new ImageIcon(RentWindow.class.getResource("/icons/back.png")));
		btnBack.setBounds(302, 192, 51, 43);
		panel.add(btnBack);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, panel, btnBack}));
	}
}
