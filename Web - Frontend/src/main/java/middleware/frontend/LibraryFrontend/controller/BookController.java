package middleware.frontend.LibraryFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/GetAllBooks")
	public List<Object> getEmployees(){
		
		String URL = "http://localhost:8080/emp/employees";
		Object[] employees = restTemplate.getForObject(URL, Object[].class);
		
		return Arrays.asList(employees);
	}
	
}
