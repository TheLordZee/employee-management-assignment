package models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="employees", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true, length=11)
	private int id;
	
	@Column(name="NAME", length=64, nullable=false)
	private String name;
	
	@Column(name="dateofbirth", nullable=false)
	private Date dob;
	
	@Column(name="SALARY", nullable=false)
	private int salary;
	
	@Column(name="AGE", nullable=false)
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDOB() {
		return dob;
	}
	public void setDOB(Date date) {
		this.dob = date; 
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int sal) {
		this.salary = sal;
	}
	public int getAge() {
		return age;
	}
}
