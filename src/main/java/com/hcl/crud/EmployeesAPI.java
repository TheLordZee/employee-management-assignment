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
					
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}
	
	public static void getAll() {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		Query emps = session.createQuery("SELECT e FROM employees e");
		
		List<Employee> empList = emps.list();
		
		empList.stream().forEach(e -> e.displayData());
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}
	
	public static Employee getEmployee(int id) {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, id);
		e.displayData();
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
		return e;
	}
	
	public static void update(int id, String name, Date dob, int age, int salary) {
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		Employee e = (Employee) session.get(Employee.class, id);
		
		e.setName(name);
		e.setDob(dob);
		e.setSalary(salary);
		e.setAge(age);
		
		session.update(e);
		session.getTransaction().commit();
		
		System.out.println("Employee updated successfully!");
		e.displayData();
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
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
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}
}
