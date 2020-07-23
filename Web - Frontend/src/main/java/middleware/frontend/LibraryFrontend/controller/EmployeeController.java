package middleware.frontend.LibraryFrontend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import middleware.frontend.LibraryFrontend.entity.Employee;

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
	
	@RequestMapping("/employees")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        String URL = "http://localhost:3000/emp/employees";
		Object[] employees = restTemplate.getForObject(URL, Object[].class);
		
//		Arrays.asList(employees);
        mv.addObject("employees", employees);
        mv.setViewName("/home.jsp");
        return mv;
    }

}
