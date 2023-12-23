package com.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import com.DAO.EmployeeDAO;
import com.model.Employee;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException,IOException,ParseException
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
		Scanner sc=new Scanner(System.in);
		do
		 {
			   System.out.println("Menu List");	
			   System.out.println("1.Add Employee");
			   System.out.println("2.Fetch Employee");
			   System.out.println("3.Fitch Single Employee");
			   System.out.println("4.Update Employee");
			   System.out.println("5.Delete Employee1");
			   System.out.println("6.Exit");
			   System.out.println("Enter The Option");
			   switch (Integer.parseInt(br.readLine())) {
			   
			   case 1:
			   Employee empcase1 = new Employee();
			   EmployeeDAO employeedaocase1 = new EmployeeDAO();
			   System.out.println("Enter Employee Name:");
			   empcase1.setEmpName(br.readLine());
			   System.out.println("Enter Employee Designation:");
			   empcase1.setDesignation(br.readLine());
			   System.out.println("Enter Employee Salary:");
			   empcase1.setSalary(Double.parseDouble(br.readLine()));
			   System.out.println("Enter Employee DOJ:");
			   empcase1.setDob(sdf.parse(br.readLine()));
			   employeedaocase1.insert(empcase1);
			   System.out.println("Employee Details Saved Successfully... ");
			   break;

			   case 2:
			   EmployeeDAO employeeDAOcase2 = new EmployeeDAO();
			   List<Employee> elist = employeeDAOcase2.getAllRows();
			   if(elist.size()==0)
			   {
			   System.out.println("Empty List");
			   }else {
			   System.out.printf("%-15s %-15s %-15s %-15s %s\n","Id","EmpName","Designation","Salary","DOJ");
			   for(Employee e:elist) {
			   System.out.printf("%-15s %-15s %-15s %-15s %s\n",e.getId(),e.getEmpName(),e.getDesignation(),e.getSalary(),e.getDob());
			   }
			   }
			   break;

			   case 3:
			   EmployeeDAO employeeDAOcase3 = new EmployeeDAO();
			   System.out.println("Which Employee id related information u r going to change?");
			   int empid=Integer.parseInt(br.readLine());
			   Employee emp=employeeDAOcase3.find(empid);
			   if(emp==null)
			   {
				   System.out.println("Employee Id not exsist");
			   }else
			   {
			   System.out.println("Enter your Salary:");
			   emp.setSalary(Double.parseDouble(br.readLine()));
			   System.out.println("Enter your designationation");
			   emp.setDesignation(br.readLine());
			   employeeDAOcase3.update(emp);
			   System.out.println("Emploee Detail Updated Successfully....");
			   }
			   break;
			   
			   case 4:
			   EmployeeDAO employeeDAOcase4=new EmployeeDAO();
			   System.out.println("Which Employee id related information u r going to delete?");
			   int empid1=Integer.parseInt(br.readLine());
			   Employee emp1=employeeDAOcase4.find(empid1);
			   if(emp1==null)
			   {
			   System.out.println("Employee Id not exist so not able to delete");
			   }else
			   {
			   employeeDAOcase4.delete(emp1);
			   System.out.println("Emploee Detail Deleted Successfully....");
			   }
			   break;
			   
			   case 5:
			   System.out.println("Bye");
			   System.exit(0);
			   default:
			   System.out.println("Invalid Choice..");
			   }
			   }while(true);
	}
}
		
	

		
		
