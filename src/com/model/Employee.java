package com.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="Employee_cd")
public class Employee {

	@Id
	@Column(name="emp_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="emp_Name",length=30)
	private String empName;
	@Column(name="designation",length=30)
	private String designation;
	@Column(name="empSalary")
	private double salary;
	@Column(name="dateofjoing")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	public Employee() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}	
}
