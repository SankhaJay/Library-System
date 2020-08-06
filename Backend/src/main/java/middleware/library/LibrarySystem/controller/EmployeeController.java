package middleware.library.LibrarySystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import middleware.library.LibrarySystem.entity.Employee;
import middleware.library.LibrarySystem.service.EmployeeService;

@RestController()
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeServ;


    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
    	System.out.println("here");
        return employeeServ.addEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeServ.getEmployees();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeesById(@PathVariable int id){
        return employeeServ.getEmployeesById(id);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name){
        return employeeServ.getEmployeesByName(name);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeServ.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeServ.deleteEmployee(id);
    }


}