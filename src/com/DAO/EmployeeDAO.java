	package com.DAO;
	
	import java.util.List;
	import org.hibernate.Session;
	import com.dbconfig.Hibernateutil;
	import com.model.Employee;
	
	public class EmployeeDAO {
	
	public void insert(Employee emp) {
	Session session = Hibernateutil.getSessionFactory().openSession();
	try {
	session.beginTransaction();
	session.save(emp);
	session.getTransaction().commit();
	   }
	catch(Exception e)
	{
	session.getTransaction().rollback();
	e.printStackTrace();
	}
	session.close();
	
	}
	
	public List<Employee> getAllRows()
	{
	Session session=Hibernateutil.getSessionFactory().openSession();
	List<Employee> empList=session.createCriteria(Employee.class).list();
	return empList;
	
	}
	
	
	
	public Employee find(int id)
	{
	Session session=Hibernateutil.getSessionFactory().openSession();
	Employee employee=(Employee) session.get(Employee.class, id);
	return employee;
	
	}
	public void update(Employee emp)
	{
	Session session=Hibernateutil.getSessionFactory().openSession();
	try
	{
	session.beginTransaction();
	session.update(emp);
	session.getTransaction().commit();
	
	}catch(Exception e)
	{
	session.getTransaction().rollback();
	e.printStackTrace();
	}
	session.close();
	
	}
	public void delete(Employee emp) {
	Session session= Hibernateutil.getSessionFactory().openSession();
	
	
	try
	{
	session.beginTransaction();
	session.delete(emp);
	session.getTransaction().commit();
	
	}catch(Exception e)
	{
	session.getTransaction().rollback();
	e.printStackTrace();
	}
	session.close();
	
	}
	
	}
	
