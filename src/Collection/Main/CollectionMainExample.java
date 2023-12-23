package Collection.Main;
import java.util.List;
import java.util.Scanner;
import Collection.DAO.EmployeeDAO;
import Collection.Model.Employee;

public class CollectionMainExample {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDAO dao=new EmployeeDAO();
		 do {
			System.out.println("Main");
			System.out.println("1. Add");
			System.out.println("2. Fetch All");
			System.out.println("3. Fetch One Record");
			System.out.println("4. Modify");
			System.out.println("5. Delete");
			System.out.println("6. Exit");
			System.out.println("Please enter the Option");
			switch (sc.nextInt()) {
			case 1:
				Employee employee1=new Employee();
				System.out.println("Enter the Employee ID :");
				employee1.setEmpId(sc.nextInt());
				System.out.println("Enter the Employee Name :");
				sc.nextLine();
				employee1.setEmpName(sc.nextLine());
				System.out.println("Enter the Employee Designation :");
				employee1.setEmpDesignation(sc.nextLine());
				System.out.println("Enter the Employee Salary");
				employee1.setEmpSalary(sc.nextDouble());
				dao.saveEmployeeDetails(employee1);
				break;
				
			case 2:
				List<Employee> list = dao.fetchAllRecord();
				if(list.size()>0) 
				  {
				for(Employee e: list)
				System.out.println(e.getEmpId()+"--"+e.getEmpName()+"--"+e.getEmpDesignation()+"--"+e.getEmpSalary()); }
				else { System.out.println("No Data Found"); }
				
			case 3:
				List<Employee> list1=dao.fetchOneRecord();
				if (list1.size() > 0) {
				System.out.println("Enter the employee ID to fetch data:");
			    int empIdToFetch = sc.nextInt();
				Employee foundEmployee = null;
				for (Employee e : list1) {
				if (e.getEmpId() == empIdToFetch) {
				foundEmployee = e;
				break;
				    }
		        }
			    if (foundEmployee != null) {
				System.out.println("Employee found:");
	            System.out.println(foundEmployee.getEmpId() + "--" + foundEmployee.getEmpName() + "--" +foundEmployee.getEmpDesignation() + " " + foundEmployee.getEmpSalary());
			    } else { System.out.println("No employee found with ID: " + empIdToFetch); }
				    } else {
				        System.out.println("No data found");
				    }
				break;
				
			case 4:
			    System.out.println("Enter the employee ID to modify data:");
			    List<Employee> list2=dao.modify();
			    int empIdToModify = sc.nextInt();
			    Employee employeeToModify = null;
			    for (Employee e : list2) {
			        if (e.getEmpId() == empIdToModify) {
			            employeeToModify = e;
			            break;
			        }
			    }
			    if (employeeToModify != null) {
			        System.out.println("Enter the new Employee Name:");
			        sc.nextLine();
			        employeeToModify.setEmpName(sc.nextLine());
			        System.out.println("Enter the new Employee Designation:");
			        employeeToModify.setEmpDesignation(sc.nextLine());
			        System.out.println("Enter the new Employee Salary:");
			        employeeToModify.setEmpSalary(sc.nextDouble());
			        System.out.println("Employee details modified successfully.");
			    } else {
			        System.out.println("No employee found with ID: " + empIdToModify);
			    }
			    break;

			case 5:
				 System.out.println("Enter the Employee Id to Delete: ");
			       int empIdToDelete = sc.nextInt();
			       List<Employee> list3 = dao.fetchAllRecords();
			       boolean isDeleted = false;
			       for (Employee e : list3) {
			           if (e.getEmpId() == empIdToDelete) {
			               isDeleted = list3.remove(e);
			               break;
			           }
			       }

			       if (isDeleted) {
			           System.out.println("Employee with ID " + empIdToDelete + " deleted successfully.");
			       } else {
			           System.out.println("No employee found with ID: " + empIdToDelete);
			       }
			       break;

			case 6:
			    System.out.println("Exiting the program. Goodbye!");
			    System.exit(0);
			    break;
			}
		}
		 while(true); 
	 }
}

