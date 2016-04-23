package com.mainsystem;

import java.util.Scanner;

public class MainSystem {
	SystemManager sm;
	static Scanner scan;
	public MainSystem(){
		sm = new SystemManager();
		scan = new Scanner(System.in);
	}
	public static void main(String[] args) {
		MainSystem ms = new MainSystem();
	}
}
