package com.hcl.management.app;

import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;

public class GetAll {
	public static String input = "";
	
	public static void display() {
		Scanner scan = new Scanner(System.in);
		EmployeesAPI.getAll();
		
		while(!input.equals("RETURN")) {
			System.out.println("\nEnter 'RETURN' to go back or 'QUICK' to exit");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				System.out.println("QUITTING PROGRAM");
				System.exit(0);
			} else if(!input.equals("RETURN")) {
				System.out.println("Invalid Input!");
			}
		}
	}
}
