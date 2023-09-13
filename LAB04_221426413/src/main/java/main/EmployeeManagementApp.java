package main;

import java.util.List;
import dao.IEmployeeDao;
import dao.EmployeeDao;
import model.Employee;

public class EmployeeManagementApp {
	public static void main(String[] args) {

//		Create a method
		IEmployeeDao employeeDao = new EmployeeDao();

		Employee emp1 = new Employee("W.D. Deshan", "0712345775", "Manager");
		Employee emp2 = new Employee("R.W. Dasuni Kavishka", "0768766530", "Cleaner");

		employeeDao.saveEmployee(emp1);
		employeeDao.saveEmployee(emp2);

		emp2.setName("W.D.D. Silva");
		employeeDao.updateEmployee(emp1);
//
		emp2.setPosition("Kichten Cleaner");
		employeeDao.updateEmployee(emp2);

		Employee emp3 = employeeDao.getEmployeeById(emp1.getId());
		System.out.println(emp3);

		List<Employee> employees = employeeDao.getAllEmployees();

		for (Employee emp : employees) {
			System.out.println(emp);
		}

		employeeDao.deleteEmployee(2);
	}

}
