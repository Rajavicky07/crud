package Collection.DAO;
import java.util.ArrayList;
import java.util.List;
import Collection.Model.Employee;

public class EmployeeDAO {

	  List<Employee> list= new ArrayList<>();
	  
	  public void saveEmployeeDetails(Employee employee1) {
		  
	  list.add(employee1);
	  System.out.println("Data saved Sucessfully,total no of employee is : "+list.size());
	}
	public List<Employee> fetchAllRecord() {
		
		return list;
	  }
	public List<Employee> fetchOneRecord() {
		return list;
	}
	public List<Employee> modify() {
		return list;
	}
	public List<Employee> fetchAllRecords() {
		
		return list;
	}
	
	
}

