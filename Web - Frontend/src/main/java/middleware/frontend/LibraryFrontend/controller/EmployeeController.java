package middleware.frontend.LibraryFrontend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

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
    }
	
	@RequestMapping("/add-employee")
    public ModelAndView userAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/employee_add.jsp");
        return modelAndView;
    }
	
	@PostMapping("/create_employee")
    public ModelAndView createUser(Employee employee) {
		 System.out.println("fuck");
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
    }
}
