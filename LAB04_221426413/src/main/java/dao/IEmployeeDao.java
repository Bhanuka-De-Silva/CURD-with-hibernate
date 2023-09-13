package dao;

import java.util.List;
import model.Employee;

public interface IEmployeeDao {
	

	void saveEmployee(Employee employee);
	

	void updateEmployee(Employee employee);
	

	void deleteEmployee(int id);
	

	Employee getEmployeeById(int id);
	

	List<Employee> getAllEmployees();
	

	Employee getEmployeeByPosition(String position);
	
}
