package middleware.frontend.LibraryFrontend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import middleware.frontend.LibraryFrontend.entity.Employee;
import middleware.frontend.LibraryFrontend.entity.User;

@RestController
public class EmployeeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@GetMapping("/employees")
//	public List<Object> getEmployees(){
//		
//		String URL = "http://localhost:8080/emp/employees";
//		Object[] employees = restTemplate.getForObject(URL, Object[].class);
//		
//		return Arrays.asList(employees);
//	}
//	
	@RequestMapping("/employee")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        String URL = "http://localhost:3000/emp/employees";
		Object[] employees = restTemplate.getForObject(URL, Object[].class);
		
		Arrays.asList(employees);
        mv.addObject("employees", employees);
        mv.setViewName("/employee.jsp");
        return mv;
        //ok
    }
	
	@RequestMapping("/add-employee")
    public ModelAndView employeeAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/employee_add.jsp");
        return modelAndView;
        //ok
    }
	
	@PostMapping("/create_employee")
    public ModelAndView createEmployee(Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("here");
        String URL = "http://localhost:3000/emp/addEmployee";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> request = new HttpEntity<Object>(employee, headers);
   
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.postForObject(URL, request, Object.class);
//        modelAndView.setViewName("/employee.jsp");
//        return modelAndView;
        return home();
        //ok
    }
	
	@RequestMapping("/edit_employee/{id}")
    public ModelAndView editEmployee(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/emp/getEmployeeById/"+ id;
        Object employee = restTemplate.getForObject(URL, Object.class);
        System.out.println(employee);
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("/edit_employee.jsp");
        return modelAndView;
        //ok
    }
	
	@PostMapping("/edit_employee_form")
    public ModelAndView editEmployee(Employee employee) {
//        ModelAndView modelAndView = new ModelAndView();
    	System.out.println("--------------------------------Front End");
        System.out.println("ID "+ employee.getEmp_id());
        String URL = "http://localhost:3000/emp/update";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<Object>(employee, headers);
        restTemplate.put(URL, request, Object.class);
//        modelAndView.setViewName("/edit_user.jsp");
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("http://localhost:9090/user");
//        return redirectView;
        return home();
        //ok
    }
	
	@RequestMapping("/deleteEmployee/{id}")
    public RedirectView deleteEmployee(@PathVariable String id) {
        System.out.println(id);
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/emp/delete/" + id;
        try {
            restTemplate.delete(URL);
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            String emp_URL = "http://localhost:3000/emp/employees";
            Object[] users = restTemplate.getForObject(emp_URL, Object[].class);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:9090/employee");
            return redirectView;
        }
    }
	
	@PostMapping("/filter_employee")
    public ModelAndView filterEmployee(String name) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name);
        String URL = "http://localhost:3000/emp/getEmployeeByName/" + name;
        Object[] employees = restTemplate.getForObject(URL, Object[].class);
        modelAndView.addObject("employees", employees);
        modelAndView.setViewName("/employee.jsp");
        return modelAndView;
    }
}
