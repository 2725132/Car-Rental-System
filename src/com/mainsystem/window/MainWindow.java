package com.mainsystem.window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mainsystem.SystemManager;
import com.mainsystem.identity.manage.CarManager;
import com.mainsystem.identity.manage.CustomerManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;


public class MainWindow extends JFrame {
	private static SystemManager sm;
	private static RentWindow rw;
	private JPanel contentPane;
	
	private CustomerManager customerManager;
	private CarManager carManager;

	public void init(){	
	}
	
	public void addController(CustomerManager customerManager){
		this.customerManager = customerManager;
	}
	
	public void addControler(CarManager carManager){
		this.carManager = carManager;
	}
	/**
	 * Create the frame.
	 */

	public MainWindow() {
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
		btnCustomer.setBounds(24, 28, 147, 29);
		btnCustomer.setForeground(new Color(0, 0, 0));
		btnCustomer.setFont(new Font("Verdana", Font.BOLD, 15));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerManager.setVisible(true);
			}
		});
		
		JButton btnRent = new JButton("Rent");
		btnRent.setBounds(24, 89, 147, 29);
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rw.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnRent.setForeground(Color.BLACK);
		btnRent.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setBounds(187, 28, 147, 29);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEmployee.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(btnRent);
		panel.add(btnCustomer);
		panel.add(btnEmployee);
		
		JButton btnNewButton = new JButton("Car");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carManager.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.setBounds(187, 89, 147, 29);
		panel.add(btnNewButton);
		setVisible(true);
	}
}
