package middleware.library.LibrarySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleware.library.LibrarySystem.entity.Employee;
import middleware.library.LibrarySystem.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Employee addEmployee(Employee employee){
		return employeeRepo.save(employee);
	}
	
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee getEmployeesById(int id){
		return employeeRepo.findById(id).orElse(null);
	}
	
	public Employee getEmployeesByName(String name){
		return employeeRepo.findByName(name);
	}
	
	public String deleteEmployee(int id) {
		employeeRepo.deleteById(id);
		return "Employee removed with id:"+id;
	}
	
	public Employee updateEmployee(Employee employee){
		Employee old_employee = employeeRepo.findById(employee.getEmp_id()).orElse(null);
		old_employee.setName(employee.getName());
		old_employee.setAge(employee.getAge());
		old_employee.setAddress(employee.getAddress());
		return employeeRepo.save(old_employee);
	}

}
