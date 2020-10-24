package middleware.frontend.LibraryFrontend.controller;

import middleware.frontend.LibraryFrontend.entity.Admin;
import middleware.frontend.LibraryFrontend.entity.Employee;
import middleware.frontend.LibraryFrontend.entity.Login;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class AdminController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/admin")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        String URL = "http://localhost:3000/admin/admins";
		Object[] admins = restTemplate.getForObject(URL, Object[].class);
		
		Arrays.asList(admins);
        mv.addObject("admins", admins);
        mv.setViewName("/admin.jsp");
        return mv;
    }
	
	@RequestMapping("/add-admin")
    public ModelAndView adminAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin_add.jsp");
        return modelAndView;
    }
	
	@PostMapping("/create_admin")
    public ModelAndView createAdmin(Admin admin) {
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/admin/addAdmin";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> request = new HttpEntity<Object>(admin, headers);
   
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.postForObject(URL, request, Object.class);
        return home();
    }
	
	@RequestMapping("/edit_admin/{id}")
    public ModelAndView editAdmin(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/admin/getAdminById/"+ id;
        Object admin = restTemplate.getForObject(URL, Object.class);
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("/edit_admin.jsp");
        return modelAndView;
    }
	
	@PostMapping("/edit_admin_form")
    public ModelAndView editAdmin(Admin admin) {
        System.out.println("ID "+ admin.getaId());
        String URL = "http://localhost:3000/admin/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<Object>(admin, headers);
        restTemplate.put(URL, request, Object.class);
        return home();
    }
	
	@RequestMapping("/deleteAdmin/{id}")
    public RedirectView deleteAdmin(@PathVariable String id) {
        System.out.println(id);
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/admin/delete/" + id;
        try {
            restTemplate.delete(URL);
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            String emp_URL = "http://localhost:3000/admin/admins";
            Object[] users = restTemplate.getForObject(emp_URL, Object[].class);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:9090/admin");
            return redirectView;
        }
    }
	
	@PostMapping("/filter_admin")
    public ModelAndView filterEmployee(String name) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name);
        String URL = "http://localhost:3000/admin/getAdminByName/" + name;
        Object[] admins = restTemplate.getForObject(URL, Object[].class);
        modelAndView.addObject("admins", admins);
        modelAndView.setViewName("/admin.jsp");
        return modelAndView;
    }
	
	@PostMapping("/home")
    public ModelAndView Login(Login user){	
		String login_URL = "http://localhost:3000/admin/login";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> request = new HttpEntity<Object>(user, headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        Boolean isLoggedIn = restTemplate.postForObject(login_URL, request, Boolean.class);
		if(isLoggedIn) {
			System.out.println("success");
			ModelAndView mv = new ModelAndView();
	        String URL = "http://localhost:3000/emp/employees";
			Object[] employees = restTemplate.getForObject(URL, Object[].class);
			Arrays.asList(employees);
	        mv.addObject("employees", employees);
	        mv.setViewName("/employee.jsp");
	        return mv;
		}
		ModelAndView mv = new ModelAndView();
        String URL = "http://localhost:3000/emp/employees";
		Object[] employees = restTemplate.getForObject(URL, Object[].class);
		Arrays.asList(employees);
        mv.addObject("employees", employees);
        mv.setViewName("/employee.jsp");
        return mv;
    }

}
