package com.hcl.management.app;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;
import com.hcl.models.Employee;


public class App {
	
	public static String input = "";
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Employee Management System!");
		
		Scanner scan = new Scanner(System.in);
		while(!input.equals("QUIT")) {
			System.out.println(
					"\n\n---------------------------------------------------\n\n"
					+ "Please enter the number of what you would like to do or 'QUIT' to exit the program:\n"
					+ "1) See All Employee Info\n"
					+ "2) See An Specific Employee's Info\n"
					+ "3) Update An Employee\n"
					+ "4) Delete An Employee\n"
			);
			
			input = scan.nextLine();
			switch(input) {
				case("1"):
					GetAll.display();
					break;
				case("2"):
					EmployeeDisplay.display();
					break;
				case("3"):
					System.out.println("Update One");
					break;
				case("4"):
					System.out.println("Delete One");
					break;
				case("QUIT"):
					System.out.println("QUITTING PROGRAM");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Input. Please Enter the Number of What You Want To Do");
			}
		}
		System.out.println("QUITTING PROGRAM");
		System.exit(0);
	}

}
