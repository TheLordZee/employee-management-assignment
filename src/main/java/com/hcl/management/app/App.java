package com.hcl.management.app;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import com.hcl.crud.EmployeesAPI;
import com.hcl.hibernate.util.HibernateUtil;
import com.hcl.models.Employee;

import org.apache.log4j.PropertyConfigurator;

public class App {
	
	public static String input = "";
	
	public static void quit() {
		System.out.println("QUITTING PROGRAM");
		HibernateUtil.getSessionFactory().close();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("C:\\Users\\alexander.hampton\\eclipse-workspace\\employee-management-system\\src\\main\\resources\\log4j.properties");
		System.out.println("Welcome to the Employee Management System!");
		
		Scanner scan = new Scanner(System.in);
		while(!input.equals("QUIT")) {
			System.out.println(
					"\n\n---------------------------------------------------\n\n"
					+ "Please enter the number of what you would like to do or 'QUIT' to exit the program:\n"
					+ "1) See All Employee Info\n"
					+ "2) See An Specific Employee's Info\n"
					+ "3) Add An Employee\n"
					+ "4) Update An Employee\n"
					+ "5) Delete An Employee\n"
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
					NewEmployee.display();
					break;
				case("4"):
					UpdateEmployee.display();
					break;
				case("5"):
					DeleteEmployee.display();
					break;
				case("QUIT"):
					quit();
					break;
				default:
					System.out.println("Invalid Input. Please Enter the Number of What You Want To Do");
			}
		}
		quit();
	}

}
