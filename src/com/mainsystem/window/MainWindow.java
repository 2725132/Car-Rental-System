package com.mainsystem.window;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mainsystem.SystemManager;
import com.mainsystem.identity.manage.CustomerActionListener;

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
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {
	private static SystemManager sm;
	private static RentWindow rw;
	private JPanel contentPane;
	private CustomerActionListener cal;

	public static void main(String[] args) {
		FileSystemXmlApplicationContext spring = new FileSystemXmlApplicationContext("application-context.xml");
		MainWindow frame = new MainWindow();
	}
	/**
	 * Create the frame.
	 */
	
	public void init(){
		cal = new CustomerActionListener();
		//cal.setVisible(true);
				
	}
	public MainWindow() {
		init();
		
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
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setForeground(new Color(0, 0, 0));
		btnCustomer.setFont(new Font("Verdana", Font.BOLD, 15));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.setVisible(true);
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
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEmployee.setFont(new Font("Verdana", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnRent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCustomer, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(50)
					.addComponent(btnEmployee)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCustomer)
						.addComponent(btnEmployee))
					.addGap(32)
					.addComponent(btnRent)
					.addContainerGap(153, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.add(panel);
		setVisible(true);
	}
}
