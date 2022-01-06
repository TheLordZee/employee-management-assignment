package com.hcl.management.app;

import java.time.LocalDate;
import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;

public class NewEmployee {

	public static String input = "";
	public static void display() {
		int day = 1;
		int month = 1;
		int year = 2000;
		String name = "";
		int salary = 0;
		
		boolean valid = false;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the employee's name: ");
		name = scan.nextLine();
		
		while(!input.equals("RETURN") && !valid) {
			System.out.println("Please enter the employee's salary: ");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				App.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					salary = Integer.parseInt(input);
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input. Please enter an integer number.");
				}
			}
		}
		
		valid = false;
		
		while(!input.equals("RETURN") && !valid) {
			System.out.println("Please enter the employee's year of birth: ");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				App.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					year = Integer.parseInt(input);
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input. Please enter an integer number.");
				}
			}
		}
		
		valid = false;
		
		while(!input.equals("RETURN") && !valid) {
			System.out.println("Please enter the employee's month of birth as a number: ");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				App.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					month = Integer.parseInt(input);
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input. Please enter an integer number.");
				}
			}
		}
		
		valid = false;
		
		while(!input.equals("RETURN") && !valid) {
			System.out.println("Please enter the employee's day of birth as a number: ");
			input = scan.nextLine();
			if(input.equals("QUIT")) {
				App.quit();
			}
			if(!input.equals("RETURN")) {
				try {
					day = Integer.parseInt(input);
					valid = true;
				} catch(Exception e) {
					System.out.println("Invalid input. Please enter an integer number.");
				}
			}
		}
		
		EmployeesAPI.insertEmployee(name, LocalDate.of(year, month, day), salary);
	}

}
