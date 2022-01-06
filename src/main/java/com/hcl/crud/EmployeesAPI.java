package com.hcl.crud;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.hcl.models.Employee;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;

import com.hcl.hibernate.util.HibernateUtil;
import com.hcl.log4j.AppLogger;

public class EmployeesAPI {
	public static void insertEmployee(String name, LocalDate dob, int salary) {
		Employee emp = new Employee();
		
		emp.setName(name);
		emp.setDob(dob);
		emp.setSalary(salary);
					
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		int id = emp.getId();
		System.out.println("Employee successfully created");
		AppLogger.log.info("Employee " + id + " created");
	}
	
	public static void getAll() {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		Query emps = session.createQuery("SELECT e FROM employees e");
		
		List<Employee> empList = emps.list();
		
		empList.stream().forEach(e -> e.displayData());
		
		session.close();
		AppLogger.log.info("All Users Retrieved");
	}
	
	public static Employee getEmployee(int id) {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, id);
		e.displayData();
		
		AppLogger.log.info("Employee " + id + " Retrieved");
		
		session.close();
		
		
		return e;
	}
	
	public static void updateName(int id, String name) {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		Employee e = (Employee) session.get(Employee.class, id);
		e.setName(name);
		session.update(e);
		session.getTransaction().commit();
		
		System.out.println("Employee updated successfully!");
		e.displayData();
		AppLogger.log.info("Employee " + id + " updated. Name changed to: " + name);
	}
	
	public static void updateDob(int id, Date dob) {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		Employee e = (Employee) session.get(Employee.class, id);
		
		e.setDob(dob);
		session.update(e);
		session.getTransaction().commit();
		
		System.out.println("Employee updated successfully!");
		e.displayData();
		AppLogger.log.info("Employee " + id + " updated. Date of Birth changed to: " + dob.toString());
	}
	
	public static void updateSalary(int id, int salary) {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		Employee e = (Employee) session.get(Employee.class, id);
		
		e.setSalary(salary);
		session.update(e);
		session.getTransaction().commit();
		
		System.out.println("Employee updated successfully!");
		e.displayData();
		AppLogger.log.info("Employee " + id + " updated. Salary changed to " + salary);
	}
	
	public static void updateAge(int id, int age) {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		Employee e = (Employee) session.get(Employee.class, id);
		
		e.setAge(age);
		session.update(e);
		session.getTransaction().commit();
		
		System.out.println("Employee updated successfully!");
		e.displayData();
		AppLogger.log.info("Employee " + id + " updated. Age Changed to " + age);
	}
	
	public static void delete(int id) {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
				
		Employee e = (Employee) session.get(Employee.class, id);
		
		session.delete(e);
		session.getTransaction().commit();
		
		System.out.println("Employee " + id + " deleted successfully!");
			
		session.close();
		
		AppLogger.log.info("User " + id + " deleted");
	}
}